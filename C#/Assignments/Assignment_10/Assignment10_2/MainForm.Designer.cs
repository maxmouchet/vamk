namespace Assignment10_2
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
            this.videoShop1 = new Assignment10_2.VideoShop();
            this.SuspendLayout();
            // 
            // videoShop1
            // 
            this.videoShop1.Location = new System.Drawing.Point(12, 12);
            this.videoShop1.Name = "videoShop1";
            this.videoShop1.Size = new System.Drawing.Size(333, 141);
            this.videoShop1.TabIndex = 0;
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(355, 163);
            this.Controls.Add(this.videoShop1);
            this.Name = "MainForm";
            this.Text = "Assignment 10.2";
            this.ResumeLayout(false);

        }

        #endregion

        private VideoShop videoShop1;
    }
}

