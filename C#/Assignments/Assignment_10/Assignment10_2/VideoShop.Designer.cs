namespace Assignment10_2
{
    partial class VideoShop
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

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.videoListBox = new System.Windows.Forms.ListBox();
            this.videoNameTextBox = new System.Windows.Forms.TextBox();
            this.addButton = new System.Windows.Forms.Button();
            this.reserveButton = new System.Windows.Forms.Button();
            this.searchButton = new System.Windows.Forms.Button();
            this.removeButton = new System.Windows.Forms.Button();
            this.videoNameLabel = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // videoListBox
            // 
            this.videoListBox.FormattingEnabled = true;
            this.videoListBox.Location = new System.Drawing.Point(3, 3);
            this.videoListBox.Name = "videoListBox";
            this.videoListBox.Size = new System.Drawing.Size(120, 95);
            this.videoListBox.TabIndex = 0;
            // 
            // videoNameTextBox
            // 
            this.videoNameTextBox.Location = new System.Drawing.Point(211, 43);
            this.videoNameTextBox.Name = "videoNameTextBox";
            this.videoNameTextBox.Size = new System.Drawing.Size(100, 20);
            this.videoNameTextBox.TabIndex = 1;
            // 
            // addButton
            // 
            this.addButton.Location = new System.Drawing.Point(3, 113);
            this.addButton.Name = "addButton";
            this.addButton.Size = new System.Drawing.Size(75, 23);
            this.addButton.TabIndex = 2;
            this.addButton.Text = "Add";
            this.addButton.UseVisualStyleBackColor = true;
            this.addButton.Click += new System.EventHandler(this.addButton_Click);
            // 
            // reserveButton
            // 
            this.reserveButton.Location = new System.Drawing.Point(84, 113);
            this.reserveButton.Name = "reserveButton";
            this.reserveButton.Size = new System.Drawing.Size(75, 23);
            this.reserveButton.TabIndex = 3;
            this.reserveButton.Text = "Reserve";
            this.reserveButton.UseVisualStyleBackColor = true;
            this.reserveButton.Click += new System.EventHandler(this.reserveButton_Click);
            // 
            // searchButton
            // 
            this.searchButton.Location = new System.Drawing.Point(165, 113);
            this.searchButton.Name = "searchButton";
            this.searchButton.Size = new System.Drawing.Size(75, 23);
            this.searchButton.TabIndex = 4;
            this.searchButton.Text = "Search";
            this.searchButton.UseVisualStyleBackColor = true;
            this.searchButton.Click += new System.EventHandler(this.searchButton_Click);
            // 
            // removeButton
            // 
            this.removeButton.Location = new System.Drawing.Point(246, 113);
            this.removeButton.Name = "removeButton";
            this.removeButton.Size = new System.Drawing.Size(75, 23);
            this.removeButton.TabIndex = 5;
            this.removeButton.Text = "Remove";
            this.removeButton.UseVisualStyleBackColor = true;
            this.removeButton.Click += new System.EventHandler(this.removeButton_Click);
            // 
            // videoNameLabel
            // 
            this.videoNameLabel.AutoSize = true;
            this.videoNameLabel.Location = new System.Drawing.Point(139, 46);
            this.videoNameLabel.Name = "videoNameLabel";
            this.videoNameLabel.Size = new System.Drawing.Size(66, 13);
            this.videoNameLabel.TabIndex = 6;
            this.videoNameLabel.Text = "Video name:";
            // 
            // VideoShop
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.videoNameLabel);
            this.Controls.Add(this.removeButton);
            this.Controls.Add(this.searchButton);
            this.Controls.Add(this.reserveButton);
            this.Controls.Add(this.addButton);
            this.Controls.Add(this.videoNameTextBox);
            this.Controls.Add(this.videoListBox);
            this.Name = "VideoShop";
            this.Size = new System.Drawing.Size(333, 154);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox videoListBox;
        private System.Windows.Forms.TextBox videoNameTextBox;
        private System.Windows.Forms.Button addButton;
        private System.Windows.Forms.Button reserveButton;
        private System.Windows.Forms.Button searchButton;
        private System.Windows.Forms.Button removeButton;
        private System.Windows.Forms.Label videoNameLabel;
    }
}
