#include "sfr62p.h"
#include "rskM16C62Pdef.h"  
#include "main.h"
#include "lcd.h"
#pragma INTERRUPT timer_a0_interrupt

/**********************************************************************************
Global variables
***********************************************************************************/
unsigned int ad_value;
unsigned char lcd_line1[8];
unsigned char lcd_line2[8];

unsigned int f1 = 24000;
unsigned int f8 = 3000;
unsigned int f32 = 750;
float fi = 24000;

unsigned int m = 0;
unsigned int n = 0;

unsigned int tp, th;

/**********************************************************************************
User Program Code
***********************************************************************************/
void ADC_update(void)
{
  ad_value=ad0;
  tp = (0.2*ad_value)+100;
  th = tp / 2; // DC = 50%
}

void LCD_display_digits(void)
{
  int real_tp = ((255 * (m + 1))/fi);
  int frequency = 1000/real_tp;
  
  lcd_line1[0] = 'T';
  lcd_line1[1] = 'P';
  lcd_line1[2] = ':';
  lcd_line1[3] = (real_tp/100)+48;
  lcd_line1[4] = ((real_tp/10)%10)+48;
  lcd_line1[5] = (real_tp%10)+48;
  lcd_line1[6] = 'm';
  lcd_line1[7] = 's';
  
  lcd_line2[0] = 'F';
  lcd_line2[1] = 'Q';
  lcd_line2[2] = ':';
  lcd_line2[3] = (frequency/100)+48;
  lcd_line2[4] = ((frequency/10)%10)+48;
  lcd_line2[5] = (frequency%10)+48;
  lcd_line2[6] = 'H';
  lcd_line2[7] = 'z';
  
  DisplayString(LCD_LINE1, lcd_line1);
  DisplayString(LCD_LINE2, lcd_line2);
}


void calculate_n (void) {
  n = (255 * th) / tp;  
}

void calculate_m (void) {
  fi = f1;
  
  m = ((tp * fi) / 255) - 1;
  if (m > 255) {
    fi = f8;
    m = ((tp * fi) / 255) - 1;
    if (m > 255) {
      fi = f32;
      m = ((tp * fi) / 255) - 1;
    }
  }
}

void PWM_update(void)
{ 
  calculate_n();
  calculate_m();
  
  ta4 = n * 256 + m;
}

void timer_a0_interrupt(void)
{
  ADC_update();
  LCD_display_digits();
  PWM_update(); 
}


void main(void)       
{
  /* Reset the LCD module */
  InitialiseDisplay();
  
  p0=0xff;
  p1=0xff;
  
  pd0=0xff;
  pd1=0xff;
  
  pd8=0;
  
  adcon0=0x08;
  adcon1=0x20;
  adcon2=0x00;
  adcon0|=(1<<6);
  
  ta0mr=0x40;
  ta0=29999;
  
  asm("FSET I");
  
  ta0ic=0x07;
  tabsr|=(1<<0);
  
  //ta4mr = 0x9f; 16-bit mode
  ta4mr = 0xbf; // 8-bit mode
  ta4ic &= (0 << 4);
  
  trgsr &= (0 << 7);
  trgsr |= (1 << 6);
  
  tb2mr = 0x82;
  
  tabsr |= (1 << 4);
  tabsr |= (1 << 7); 
  while (1) {}
} 

In hwsetup.c
  /* configure direction registers as outputs*/
  pd0=pd1=pd2=pd3=pd4=pd5=pd7 = 0xff;
  pd10 = 0x00;

  /* to set port9 direction register must first unprotect register do not step or set breakpoints
  between unprotecting register and modifying the direction register */
  prc2=1;
  pd9=0x00;
  prc2 =0;

In setc30.inc
208 .glb  _timer_a0_interrupt
209 .lword  _timer_a0_interrupt   ; timer A0(for user)(vector 21)
