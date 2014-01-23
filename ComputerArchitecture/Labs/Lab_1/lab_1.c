#include "sfr_3062.h"

#pragma INTERRUPT timer_a0_interrupt
#pragma INTERRUPT timer_a1_interrupt
#pragma INTERRUPT sw1
#pragma INTERRUPT sw2
#define ON  1
#define OFF 1

unsigned int second;
unsigned int msecond;
unsigned char toggle;
unsigned char counter_state;

void update_count_timer(void) {
  if (counter_state == ON) {
    TABSR |= (1 << 0);
  } else {
    TABSR &= ~(1 << 0);
  }
}

void sw1(void) {
  second = 0;
  msecond = 0;
}

void sw2(void) {
  counter_state ^= ON;
  update_count_timer();
}

void timer_a0_interrupt(void) {
  if(++msecond == 100) {
    msecond = 0;
    if (++second == 60) second = 0;
  }
}

void timer_a1_interrupt(void) {
  // TODO: Update LCD.
}

void main(void) {
  P0 = 0xFF;
  P1 = 0xFF;

  PD0 = 0xFF;
  PD1 = 0xFF;

  second  = 0;
  msecond = 0;
  counter_state = OFF;

  TA0MR = 0x40;
  TA1MR = 0x40;

  TA0 = 12499;
  TA1 = 12499;

  asm("FSET I");

  TA0IC = 0x01;
  TA1IC = 0x01;

  INT0IC = 0x02;
  INT1IC = 0x02;

  TABSR |= (1 << 1);

  while (1) {}
}
