namespace Assignment9
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
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.seButton = new System.Windows.Forms.Button();
            this.fiButton = new System.Windows.Forms.Button();
            this.frButton = new System.Windows.Forms.Button();
            this.shapesListBox = new System.Windows.Forms.ListBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // timer1
            // 
            this.timer1.Enabled = true;
            this.timer1.Interval = 500;
            this.timer1.Tick += new System.EventHandler(this.updateTitle);
            // 
            // seButton
            // 
            this.seButton.Image = global::Assignment9.Properties.Resources.se;
            this.seButton.Location = new System.Drawing.Point(47, 12);
            this.seButton.Name = "seButton";
            this.seButton.Size = new System.Drawing.Size(29, 23);
            this.seButton.TabIndex = 2;
            this.seButton.UseVisualStyleBackColor = true;
            this.seButton.Click += new System.EventHandler(this.seButton_Click);
            // 
            // fiButton
            // 
            this.fiButton.Image = global::Assignment9.Properties.Resources.fi;
            this.fiButton.Location = new System.Drawing.Point(12, 12);
            this.fiButton.Name = "fiButton";
            this.fiButton.Size = new System.Drawing.Size(29, 23);
            this.fiButton.TabIndex = 1;
            this.fiButton.UseVisualStyleBackColor = true;
            this.fiButton.Click += new System.EventHandler(this.fiButton_Click);
            // 
            // frButton
            // 
            this.frButton.Image = global::Assignment9.Properties.Resources.fr;
            this.frButton.Location = new System.Drawing.Point(82, 12);
            this.frButton.Name = "frButton";
            this.frButton.Size = new System.Drawing.Size(29, 23);
            this.frButton.TabIndex = 3;
            this.frButton.UseVisualStyleBackColor = true;
            this.frButton.Click += new System.EventHandler(this.frButton_Click);
            // 
            // shapesListBox
            // 
            this.shapesListBox.FormattingEnabled = true;
            this.shapesListBox.Items.AddRange(new object[] {
            "Circle",
            "Square",
            "Line"});
            this.shapesListBox.Location = new System.Drawing.Point(12, 41);
            this.shapesListBox.Name = "shapesListBox";
            this.shapesListBox.Size = new System.Drawing.Size(121, 121);
            this.shapesListBox.TabIndex = 4;
            this.shapesListBox.SelectedIndexChanged += new System.EventHandler(this.shapesListBox_SelectedIndexChanged);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Location = new System.Drawing.Point(151, 44);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(115, 115);
            this.pictureBox1.TabIndex = 5;
            this.pictureBox1.TabStop = false;
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(289, 175);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.shapesListBox);
            this.Controls.Add(this.frButton);
            this.Controls.Add(this.seButton);
            this.Controls.Add(this.fiButton);
            this.Name = "MainForm";
            this.Text = "Assignment9_1";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Button fiButton;
        private System.Windows.Forms.Button seButton;
        private System.Windows.Forms.Button frButton;
        private System.Windows.Forms.ListBox shapesListBox;
        private System.Windows.Forms.PictureBox pictureBox1;
    }
}

