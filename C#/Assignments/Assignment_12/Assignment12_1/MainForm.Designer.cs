namespace Assignment12_1
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
            this.recordNumberLabel = new System.Windows.Forms.Label();
            this.customerIdLabel = new System.Windows.Forms.Label();
            this.companyNameLabel = new System.Windows.Forms.Label();
            this.contactNameLabel = new System.Windows.Forms.Label();
            this.recordNumberTextBox = new System.Windows.Forms.TextBox();
            this.customerIdTextBox = new System.Windows.Forms.TextBox();
            this.companyNameTextBox = new System.Windows.Forms.TextBox();
            this.contactNameTextBox = new System.Windows.Forms.TextBox();
            this.nextButton = new System.Windows.Forms.Button();
            this.previousButton = new System.Windows.Forms.Button();
            this.exitButton = new System.Windows.Forms.Button();
            this.bindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.northwindDataSet = new Assignment12_1.NorthwindDataSet();
            this.customersTableAdapter = new Assignment12_1.NorthwindDataSetTableAdapters.CustomersTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.northwindDataSet)).BeginInit();
            this.SuspendLayout();
            // 
            // recordNumberLabel
            // 
            this.recordNumberLabel.AutoSize = true;
            this.recordNumberLabel.Location = new System.Drawing.Point(13, 13);
            this.recordNumberLabel.Name = "recordNumberLabel";
            this.recordNumberLabel.Size = new System.Drawing.Size(83, 13);
            this.recordNumberLabel.TabIndex = 0;
            this.recordNumberLabel.Text = "Record number:";
            // 
            // customerIdLabel
            // 
            this.customerIdLabel.AutoSize = true;
            this.customerIdLabel.Location = new System.Drawing.Point(13, 39);
            this.customerIdLabel.Name = "customerIdLabel";
            this.customerIdLabel.Size = new System.Drawing.Size(65, 13);
            this.customerIdLabel.TabIndex = 1;
            this.customerIdLabel.Text = "Customer id:";
            // 
            // companyNameLabel
            // 
            this.companyNameLabel.AutoSize = true;
            this.companyNameLabel.Location = new System.Drawing.Point(13, 65);
            this.companyNameLabel.Name = "companyNameLabel";
            this.companyNameLabel.Size = new System.Drawing.Size(83, 13);
            this.companyNameLabel.TabIndex = 2;
            this.companyNameLabel.Text = "Company name:";
            // 
            // contactNameLabel
            // 
            this.contactNameLabel.AutoSize = true;
            this.contactNameLabel.Location = new System.Drawing.Point(13, 91);
            this.contactNameLabel.Name = "contactNameLabel";
            this.contactNameLabel.Size = new System.Drawing.Size(76, 13);
            this.contactNameLabel.TabIndex = 3;
            this.contactNameLabel.Text = "Contact name:";
            // 
            // recordNumberTextBox
            // 
            this.recordNumberTextBox.Location = new System.Drawing.Point(102, 10);
            this.recordNumberTextBox.Name = "recordNumberTextBox";
            this.recordNumberTextBox.Size = new System.Drawing.Size(151, 20);
            this.recordNumberTextBox.TabIndex = 4;
            // 
            // customerIdTextBox
            // 
            this.customerIdTextBox.Location = new System.Drawing.Point(102, 36);
            this.customerIdTextBox.Name = "customerIdTextBox";
            this.customerIdTextBox.Size = new System.Drawing.Size(151, 20);
            this.customerIdTextBox.TabIndex = 5;
            // 
            // companyNameTextBox
            // 
            this.companyNameTextBox.Location = new System.Drawing.Point(102, 62);
            this.companyNameTextBox.Name = "companyNameTextBox";
            this.companyNameTextBox.Size = new System.Drawing.Size(151, 20);
            this.companyNameTextBox.TabIndex = 6;
            // 
            // contactNameTextBox
            // 
            this.contactNameTextBox.Location = new System.Drawing.Point(102, 88);
            this.contactNameTextBox.Name = "contactNameTextBox";
            this.contactNameTextBox.Size = new System.Drawing.Size(151, 20);
            this.contactNameTextBox.TabIndex = 7;
            // 
            // nextButton
            // 
            this.nextButton.Location = new System.Drawing.Point(93, 115);
            this.nextButton.Name = "nextButton";
            this.nextButton.Size = new System.Drawing.Size(75, 23);
            this.nextButton.TabIndex = 8;
            this.nextButton.Text = "Next";
            this.nextButton.UseVisualStyleBackColor = true;
            this.nextButton.Click += new System.EventHandler(this.nextButton_Click);
            // 
            // previousButton
            // 
            this.previousButton.Location = new System.Drawing.Point(12, 115);
            this.previousButton.Name = "previousButton";
            this.previousButton.Size = new System.Drawing.Size(75, 23);
            this.previousButton.TabIndex = 9;
            this.previousButton.Text = "Previous";
            this.previousButton.UseVisualStyleBackColor = true;
            this.previousButton.Click += new System.EventHandler(this.previousButton_Click);
            // 
            // exitButton
            // 
            this.exitButton.Location = new System.Drawing.Point(174, 114);
            this.exitButton.Name = "exitButton";
            this.exitButton.Size = new System.Drawing.Size(75, 23);
            this.exitButton.TabIndex = 10;
            this.exitButton.Text = "Exit";
            this.exitButton.UseVisualStyleBackColor = true;
            this.exitButton.Click += new System.EventHandler(this.exitButton_Click);
            // 
            // bindingSource
            // 
            this.bindingSource.DataMember = "Customers";
            this.bindingSource.DataSource = this.northwindDataSet;
            // 
            // northwindDataSet
            // 
            this.northwindDataSet.DataSetName = "NorthwindDataSet";
            this.northwindDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // customersTableAdapter
            // 
            this.customersTableAdapter.ClearBeforeFill = true;
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(268, 150);
            this.Controls.Add(this.exitButton);
            this.Controls.Add(this.previousButton);
            this.Controls.Add(this.nextButton);
            this.Controls.Add(this.contactNameTextBox);
            this.Controls.Add(this.companyNameTextBox);
            this.Controls.Add(this.customerIdTextBox);
            this.Controls.Add(this.recordNumberTextBox);
            this.Controls.Add(this.contactNameLabel);
            this.Controls.Add(this.companyNameLabel);
            this.Controls.Add(this.customerIdLabel);
            this.Controls.Add(this.recordNumberLabel);
            this.Name = "MainForm";
            this.Text = "Assignment 12.1";
            this.Load += new System.EventHandler(this.MainForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.northwindDataSet)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label recordNumberLabel;
        private System.Windows.Forms.Label customerIdLabel;
        private System.Windows.Forms.Label companyNameLabel;
        private System.Windows.Forms.Label contactNameLabel;
        private System.Windows.Forms.TextBox recordNumberTextBox;
        private System.Windows.Forms.TextBox customerIdTextBox;
        private System.Windows.Forms.TextBox companyNameTextBox;
        private System.Windows.Forms.TextBox contactNameTextBox;
        private System.Windows.Forms.Button nextButton;
        private System.Windows.Forms.Button previousButton;
        private System.Windows.Forms.Button exitButton;
        private System.Windows.Forms.BindingSource bindingSource;
        private NorthwindDataSet northwindDataSet;
        private NorthwindDataSetTableAdapters.CustomersTableAdapter customersTableAdapter;

    }
}

