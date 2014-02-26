namespace Assignment53
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
            this.components = new System.ComponentModel.Container();
            this.button1 = new System.Windows.Forms.Button();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.randomSizeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.randomColorToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.contextMenuStrip2 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.duplicateFormToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.addControlToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.buttonToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.textBoxToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.contextMenuStrip1.SuspendLayout();
            this.contextMenuStrip2.SuspendLayout();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.ContextMenuStrip = this.contextMenuStrip1;
            this.button1.Location = new System.Drawing.Point(13, 13);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(115, 23);
            this.button1.TabIndex = 0;
            this.button1.Text = "Don\'t click here !";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.randomSizeToolStripMenuItem,
            this.randomColorToolStripMenuItem});
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(152, 48);
            // 
            // randomSizeToolStripMenuItem
            // 
            this.randomSizeToolStripMenuItem.Name = "randomSizeToolStripMenuItem";
            this.randomSizeToolStripMenuItem.Size = new System.Drawing.Size(151, 22);
            this.randomSizeToolStripMenuItem.Text = "Random Size";
            this.randomSizeToolStripMenuItem.Click += new System.EventHandler(this.randomSizeToolStripMenuItem_Click);
            // 
            // randomColorToolStripMenuItem
            // 
            this.randomColorToolStripMenuItem.Name = "randomColorToolStripMenuItem";
            this.randomColorToolStripMenuItem.Size = new System.Drawing.Size(151, 22);
            this.randomColorToolStripMenuItem.Text = "Random Color";
            this.randomColorToolStripMenuItem.Click += new System.EventHandler(this.randomColorToolStripMenuItem_Click);
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(13, 43);
            this.textBox1.Name = "textBox1";
            this.textBox1.ReadOnly = true;
            this.textBox1.Size = new System.Drawing.Size(115, 20);
            this.textBox1.TabIndex = 1;
            // 
            // contextMenuStrip2
            // 
            this.contextMenuStrip2.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.duplicateFormToolStripMenuItem,
            this.addControlToolStripMenuItem});
            this.contextMenuStrip2.Name = "contextMenuStrip2";
            this.contextMenuStrip2.Size = new System.Drawing.Size(153, 70);
            // 
            // duplicateFormToolStripMenuItem
            // 
            this.duplicateFormToolStripMenuItem.Name = "duplicateFormToolStripMenuItem";
            this.duplicateFormToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.duplicateFormToolStripMenuItem.Text = "Duplicate";
            this.duplicateFormToolStripMenuItem.Click += new System.EventHandler(this.duplicateFormToolStripMenuItem_Click);
            // 
            // addControlToolStripMenuItem
            // 
            this.addControlToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.buttonToolStripMenuItem,
            this.textBoxToolStripMenuItem});
            this.addControlToolStripMenuItem.Name = "addControlToolStripMenuItem";
            this.addControlToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.addControlToolStripMenuItem.Text = "Add Control";
            // 
            // buttonToolStripMenuItem
            // 
            this.buttonToolStripMenuItem.Name = "buttonToolStripMenuItem";
            this.buttonToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.buttonToolStripMenuItem.Text = "Button";
            this.buttonToolStripMenuItem.Click += new System.EventHandler(this.buttonToolStripMenuItem_Click);
            // 
            // textBoxToolStripMenuItem
            // 
            this.textBoxToolStripMenuItem.Name = "textBoxToolStripMenuItem";
            this.textBoxToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.textBoxToolStripMenuItem.Text = "TextBox";
            this.textBoxToolStripMenuItem.Click += new System.EventHandler(this.textBoxToolStripMenuItem_Click);
            // 
            // timer1
            // 
            this.timer1.Interval = 2000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(380, 264);
            this.ContextMenuStrip = this.contextMenuStrip2;
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.button1);
            this.Name = "Form1";
            this.Text = "Assignment 5.3";
            this.LocationChanged += new System.EventHandler(this.Form1_LocationChanged);
            this.contextMenuStrip1.ResumeLayout(false);
            this.contextMenuStrip2.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ToolStripMenuItem randomSizeToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem randomColorToolStripMenuItem;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip2;
        private System.Windows.Forms.ToolStripMenuItem duplicateFormToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem addControlToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem buttonToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem textBoxToolStripMenuItem;
        private System.Windows.Forms.Timer timer1;
    }
}

