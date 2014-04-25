#include "sfr62p.h"
/* rskM16C62p_def.h defines some common definitions */
#include "rskM16C62Pdef.h"  
#include "main.h"
#include "lcd.h"

#pragma INTERRUPT timer_a0_interrupt
#pragma INTERRUPT sw1 // int0
#pragma INTERRUPT sw2 // int1

/**********************************************************************************
Global variables
***********************************************************************************/
unsigned int ad_value;
unsigned int da_value;

float vref;
float output_voltage[] = {1, 2, 3, 4, 5};
int choosen_voltage = 0;

unsigned char lcd_line1[8];
unsigned char lcd_line2[6];

/**********************************************************************************
User Program Code
***********************************************************************************/
void adc_update(void)
{
  ad_value = ad0;
}

void dac_update (void) {
  if (output_voltage[choosen_voltage] == 1) {
    da_value = 51;
  } else if (output_voltage[choosen_voltage] == 2) {
     da_value = 102;
  } else if (output_voltage[choosen_voltage] == 3) {
     da_value = 153;
  } else if (output_voltage[choosen_voltage] == 4) {
     da_value = 204;
  } else if (output_voltage[choosen_voltage] == 5) {
     da_value = 255;
  }
  
  da0 = da_value;
}

void LCD_Display (void) {
  int vref = (5*ad_value/1024)*10;
  
  lcd_line1[0] = 'A';
  lcd_line1[1] = 'D';
  lcd_line1[2] = 'C';
  lcd_line1[3] = ':';
  lcd_line1[4] = ((vref%100)/10)+48;
  lcd_line1[5] = '.';
  lcd_line1[6] = (vref%10)+48;
  lcd_line1[7] = 'V';
  
  lcd_line2[0] = 'O';
  lcd_line2[1] = 'U';
  lcd_line2[2] = 'T';
  lcd_line2[3] = ':';
  lcd_line2[4] = output_voltage[choosen_voltage]+48;
  lcd_line2[5] = 'V';
  
  DisplayString(LCD_LINE1, lcd_line2);
  DisplayString(LCD_LINE2, lcd_line1);
}

void sw1 (void) {
  if (--choosen_voltage == -1)
    choosen_voltage = 0;
}

void sw2 (void) {
  if (++choosen_voltage == 5)
    choosen_voltage = 4;
}

void timer_a0_interrupt (void) {
  adc_update();
  dac_update();
  LCD_Display();
}


void main(void)       
{
  /* Reset the LCD module */
  InitialiseDisplay();
  
  pd0 = 0xFF;
  pd1 = 0x00;
  
  pd8 = 0;
  
  adcon0 = 0x08;
  adcon1 = 0x28;
  adcon2 = 0x00;
  
  adcon0 |= (1 << 6);
  
  ta0mr = 0x00;
  ta0 = 29999;
  
  prc2 = 1;
  pd9_3 = 0;
  pd9_4 = 0;
  
  da0e = 1;
  da1e = 1;
  
  asm("FSET I");
  
  ta0ic = 0x01;
 
  int0ic = 0x02;
  int1ic = 0x02;
  
  tabsr |= (1 << 0);
  
  while(1);
}
