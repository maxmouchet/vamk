namespace Assignment8_final
{
    partial class Form1
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
            this.articleListBox = new System.Windows.Forms.ListBox();
            this.detailListBox = new System.Windows.Forms.ListBox();
            this.noSortRadioButton = new System.Windows.Forms.RadioButton();
            this.sortAscRadioButton = new System.Windows.Forms.RadioButton();
            this.sortDscRadioButton = new System.Windows.Forms.RadioButton();
            this.articleNameCheckBox = new System.Windows.Forms.CheckBox();
            this.articleIDCheckBox = new System.Windows.Forms.CheckBox();
            this.articlePriceCheckBox = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // articleListBox
            // 
            this.articleListBox.FormattingEnabled = true;
            this.articleListBox.Location = new System.Drawing.Point(12, 35);
            this.articleListBox.Name = "articleListBox";
            this.articleListBox.Size = new System.Drawing.Size(274, 238);
            this.articleListBox.TabIndex = 0;
            // 
            // detailListBox
            // 
            this.detailListBox.FormattingEnabled = true;
            this.detailListBox.Location = new System.Drawing.Point(306, 35);
            this.detailListBox.Name = "detailListBox";
            this.detailListBox.Size = new System.Drawing.Size(339, 238);
            this.detailListBox.TabIndex = 1;
            // 
            // noSortRadioButton
            // 
            this.noSortRadioButton.AutoSize = true;
            this.noSortRadioButton.Checked = true;
            this.noSortRadioButton.Location = new System.Drawing.Point(12, 12);
            this.noSortRadioButton.Name = "noSortRadioButton";
            this.noSortRadioButton.Size = new System.Drawing.Size(61, 17);
            this.noSortRadioButton.TabIndex = 2;
            this.noSortRadioButton.TabStop = true;
            this.noSortRadioButton.Text = "No Sort";
            this.noSortRadioButton.UseVisualStyleBackColor = true;
            this.noSortRadioButton.CheckedChanged += new System.EventHandler(this.updateSort);
            // 
            // sortAscRadioButton
            // 
            this.sortAscRadioButton.AutoSize = true;
            this.sortAscRadioButton.Location = new System.Drawing.Point(79, 12);
            this.sortAscRadioButton.Name = "sortAscRadioButton";
            this.sortAscRadioButton.Size = new System.Drawing.Size(97, 17);
            this.sortAscRadioButton.TabIndex = 3;
            this.sortAscRadioButton.TabStop = true;
            this.sortAscRadioButton.Text = "Sort Ascending";
            this.sortAscRadioButton.UseVisualStyleBackColor = true;
            this.sortAscRadioButton.CheckedChanged += new System.EventHandler(this.updateSort);
            // 
            // sortDscRadioButton
            // 
            this.sortDscRadioButton.AutoSize = true;
            this.sortDscRadioButton.Location = new System.Drawing.Point(182, 12);
            this.sortDscRadioButton.Name = "sortDscRadioButton";
            this.sortDscRadioButton.Size = new System.Drawing.Size(104, 17);
            this.sortDscRadioButton.TabIndex = 4;
            this.sortDscRadioButton.TabStop = true;
            this.sortDscRadioButton.Text = "Sort Descending";
            this.sortDscRadioButton.UseVisualStyleBackColor = true;
            this.sortDscRadioButton.CheckedChanged += new System.EventHandler(this.updateSort);
            // 
            // articleNameCheckBox
            // 
            this.articleNameCheckBox.AutoSize = true;
            this.articleNameCheckBox.Location = new System.Drawing.Point(306, 12);
            this.articleNameCheckBox.Name = "articleNameCheckBox";
            this.articleNameCheckBox.Size = new System.Drawing.Size(116, 17);
            this.articleNameCheckBox.TabIndex = 5;
            this.articleNameCheckBox.Text = "Show Article Name";
            this.articleNameCheckBox.UseVisualStyleBackColor = true;
            this.articleNameCheckBox.CheckedChanged += new System.EventHandler(this.updateDetailList);
            // 
            // articleIDCheckBox
            // 
            this.articleIDCheckBox.AutoSize = true;
            this.articleIDCheckBox.Location = new System.Drawing.Point(428, 12);
            this.articleIDCheckBox.Name = "articleIDCheckBox";
            this.articleIDCheckBox.Size = new System.Drawing.Size(99, 17);
            this.articleIDCheckBox.TabIndex = 6;
            this.articleIDCheckBox.Text = "Show Article ID";
            this.articleIDCheckBox.UseVisualStyleBackColor = true;
            this.articleIDCheckBox.CheckedChanged += new System.EventHandler(this.updateDetailList);
            // 
            // articlePriceCheckBox
            // 
            this.articlePriceCheckBox.AutoSize = true;
            this.articlePriceCheckBox.Location = new System.Drawing.Point(533, 13);
            this.articlePriceCheckBox.Name = "articlePriceCheckBox";
            this.articlePriceCheckBox.Size = new System.Drawing.Size(112, 17);
            this.articlePriceCheckBox.TabIndex = 7;
            this.articlePriceCheckBox.Text = "Show Article Price";
            this.articlePriceCheckBox.UseVisualStyleBackColor = true;
            this.articlePriceCheckBox.CheckedChanged += new System.EventHandler(this.updateDetailList);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(670, 293);
            this.Controls.Add(this.articlePriceCheckBox);
            this.Controls.Add(this.articleIDCheckBox);
            this.Controls.Add(this.articleNameCheckBox);
            this.Controls.Add(this.sortDscRadioButton);
            this.Controls.Add(this.sortAscRadioButton);
            this.Controls.Add(this.noSortRadioButton);
            this.Controls.Add(this.detailListBox);
            this.Controls.Add(this.articleListBox);
            this.Name = "Form1";
            this.Text = "Assignment8";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox articleListBox;
        private System.Windows.Forms.ListBox detailListBox;
        private System.Windows.Forms.RadioButton noSortRadioButton;
        private System.Windows.Forms.RadioButton sortAscRadioButton;
        private System.Windows.Forms.RadioButton sortDscRadioButton;
        private System.Windows.Forms.CheckBox articleNameCheckBox;
        private System.Windows.Forms.CheckBox articleIDCheckBox;
        private System.Windows.Forms.CheckBox articlePriceCheckBox;
    }
}

