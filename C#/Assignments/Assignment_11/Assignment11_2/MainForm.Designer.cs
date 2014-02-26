namespace Assignment11_2
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
            this.dirTextBox = new System.Windows.Forms.TextBox();
            this.fsTreeView = new System.Windows.Forms.TreeView();
            this.dirLabel = new System.Windows.Forms.Label();
            this.showButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // dirTextBox
            // 
            this.dirTextBox.Location = new System.Drawing.Point(223, 29);
            this.dirTextBox.Name = "dirTextBox";
            this.dirTextBox.Size = new System.Drawing.Size(100, 20);
            this.dirTextBox.TabIndex = 0;
            this.dirTextBox.Text = "U:\\VHDL";
            // 
            // fsTreeView
            // 
            this.fsTreeView.Location = new System.Drawing.Point(12, 12);
            this.fsTreeView.Name = "fsTreeView";
            this.fsTreeView.Size = new System.Drawing.Size(201, 280);
            this.fsTreeView.TabIndex = 1;
            // 
            // dirLabel
            // 
            this.dirLabel.AutoSize = true;
            this.dirLabel.Location = new System.Drawing.Point(220, 13);
            this.dirLabel.Name = "dirLabel";
            this.dirLabel.Size = new System.Drawing.Size(52, 13);
            this.dirLabel.TabIndex = 2;
            this.dirLabel.Text = "Directory:";
            // 
            // showButton
            // 
            this.showButton.Location = new System.Drawing.Point(223, 56);
            this.showButton.Name = "showButton";
            this.showButton.Size = new System.Drawing.Size(100, 23);
            this.showButton.TabIndex = 3;
            this.showButton.Text = "Show";
            this.showButton.UseVisualStyleBackColor = true;
            this.showButton.Click += new System.EventHandler(this.showButton_Click);
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(336, 304);
            this.Controls.Add(this.showButton);
            this.Controls.Add(this.dirLabel);
            this.Controls.Add(this.fsTreeView);
            this.Controls.Add(this.dirTextBox);
            this.Name = "MainForm";
            this.Text = "Assignment 11.2";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox dirTextBox;
        private System.Windows.Forms.TreeView fsTreeView;
        private System.Windows.Forms.Label dirLabel;
        private System.Windows.Forms.Button showButton;
    }
}

