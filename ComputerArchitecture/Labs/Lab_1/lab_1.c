/***********************************************************************************
FILE NAME  	:	main.c
DESCRIPTION :	Empty proejct set up for RSKM16C62P


Copyright   : 2005 Renesas Technology Europe Ltd.
Copyright   : 2005 Renesas Technology Corporation.
All Rights Reserved

***********************************************************************************/

/***********************************************************************************
Revision History
DD.MM.YYYY OSO-UID Description
21.01.2006 RTA-MGF First Release
***********************************************************************************/

/**********************************************************************************
System Includes
***********************************************************************************/

/**********************************************************************************
User Includes
***********************************************************************************/
#include "sfr62p.h"
/* rskM16C62p_def.h defines some common definitions */
#include "rskM16C62Pdef.h"
#include "lcd.h"
#include "main.h"
#pragma INTERRUPT timer_a0_interrupt
#pragma INTERRUPT timer_a1_interrupt
#pragma INTERRUPT sw1 // int0
#pragma INTERRUPT sw2 // int1
#define ON  1
#define OFF 0

/**********************************************************************************
Global variables
***********************************************************************************/
unsigned int hour;
unsigned int minute;
unsigned int second;
unsigned int msecond;
unsigned char counter_state;

/**********************************************************************************
User Program Code
***********************************************************************************/

void LCD_display_time(unsigned int second, unsigned int minute, unsigned int hour) {
	unsigned char string[8] = { (hour/10)+48, (hour%10)+48, ':', (minute/10)+48, (minute%10)+48, ':', (second/10)+48, (second%10)+48 };
	DisplayString(LCD_LINE1, string);
}

void update_count_timer(void) {
	if (counter_state == ON) {
		tabsr |= (1 << 0);
	} else {
		tabsr &= ~(1 << 0);
	}
}

void sw1(void) {
	hour = 0;
	minute = 0;
	second = 55;
	msecond = 0;
}

void sw2(void) {
	counter_state ^= ON;
	update_count_timer();
}

void timer_a0_interrupt(void) {
	if (++msecond == 100) {
		msecond = 0;
		if (++second == 60)	{
			second = 0;
			if (++minute == 60) {
				minute = 0;
				hour++;
			}
		}
	}
}

void timer_a1_interrupt(void) {
	LCD_display_time(second, minute, hour);
}

/**********************************************************************************
Function Name: 	Main
Description:	Main function
Parameters: 	none
Return value: 	none
***********************************************************************************/
void main(void)
{
	InitialiseDisplay();

	hour = 0;
	minute = 0;
	second = 55;
	msecond = 0;
	counter_state = OFF;

	ta0mr = 0x40;
	ta1mr = 0x40;

	ta0 = 29999;
	ta1 = 29999;

	asm("FSET I");

	ta0ic = 0x01;
	ta1ic = 0x01;

	int0ic = 0x02;
	int1ic = 0x02;

	tabsr |= (1 << 1);

	while(1) {}
}
/**********************************************************************************
End of function main
***********************************************************************************/

