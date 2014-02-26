namespace Assignment9_3
{
    partial class MainForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.alarmDateTimePicker = new System.Windows.Forms.DateTimePicker();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.alarmTextBox = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // alarmDateTimePicker
            // 
            this.alarmDateTimePicker.Checked = false;
            this.alarmDateTimePicker.CustomFormat = "dd.MM.yyyy HH:mm";
            this.alarmDateTimePicker.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.alarmDateTimePicker.Location = new System.Drawing.Point(12, 12);
            this.alarmDateTimePicker.Name = "alarmDateTimePicker";
            this.alarmDateTimePicker.Size = new System.Drawing.Size(125, 20);
            this.alarmDateTimePicker.TabIndex = 0;
            this.alarmDateTimePicker.Value = new System.DateTime(2013, 11, 15, 14, 0, 0, 0);
            this.alarmDateTimePicker.ValueChanged += new System.EventHandler(this.alarmDateTimePicker_ValueChanged);
            // 
            // timer1
            // 
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // alarmTextBox
            // 
            this.alarmTextBox.Location = new System.Drawing.Point(143, 12);
            this.alarmTextBox.Name = "alarmTextBox";
            this.alarmTextBox.Size = new System.Drawing.Size(100, 20);
            this.alarmTextBox.TabIndex = 1;
            this.alarmTextBox.Text = "Reminder !!!";
            this.alarmTextBox.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.alarmTextBox_KeyPress);
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(258, 44);
            this.Controls.Add(this.alarmTextBox);
            this.Controls.Add(this.alarmDateTimePicker);
            this.Name = "MainForm";
            this.Text = "Assignment9_3";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DateTimePicker alarmDateTimePicker;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.TextBox alarmTextBox;
    }
}

