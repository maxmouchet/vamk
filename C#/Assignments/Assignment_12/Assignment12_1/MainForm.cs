using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.OleDb;

namespace Assignment12_1
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            this.customersTableAdapter.Fill(this.northwindDataSet.Customers);
            UpdateFields();
        }

        private void UpdateFields()
        {
            recordNumberTextBox.Text = bindingSource.Position.ToString();
            customerIdTextBox.Text = (String)((DataRowView)bindingSource.Current).Row["CustomerID"];
            companyNameTextBox.Text = (String)((DataRowView)bindingSource.Current).Row["CompanyName"];
            contactNameTextBox.Text = (String)((DataRowView)bindingSource.Current).Row["ContactName"];
        }

        private void previousButton_Click(object sender, EventArgs e)
        {
            bindingSource.MovePrevious();
            UpdateFields();
        }

        private void nextButton_Click(object sender, EventArgs e)
        {
            bindingSource.MoveNext();
            UpdateFields();
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
