using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Assignment9_3
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (alarmDateTimePicker.Value.Date.Equals(DateTime.Now.Date) && alarmDateTimePicker.Value.Hour.Equals(DateTime.Now.Hour) && alarmDateTimePicker.Value.Minute.Equals(DateTime.Now.Minute))
            {
                timer1.Enabled = false;
                System.Media.SoundPlayer reminderSound = new System.Media.SoundPlayer(Properties.Resources.alarmclock);
                reminderSound.Play();
                MessageBox.Show(alarmTextBox.Text);
            }
        }

        private void alarmTextBox_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char) Keys.Enter)
            {
                alarmTextBox.Visible = false;
                this.WindowState = FormWindowState.Minimized;
            }
        }

        private void alarmDateTimePicker_ValueChanged(object sender, EventArgs e)
        {
            timer1.Enabled = true;
            alarmTextBox.Visible = true;
        }
    }
}
