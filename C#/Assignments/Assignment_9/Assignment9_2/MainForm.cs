using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Assignment9_2
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void addButton_Click(object sender, EventArgs e)
        {
            moveSelectedItem(listBox1, listBox2);
        }

        private void removeButton_Click(object sender, EventArgs e)
        {
            moveSelectedItem(listBox2, listBox1);
        }

        private void moveSelectedItem(ListBox src, ListBox dst)
        {
            object[] items = new object[src.SelectedItems.Count];
            src.SelectedItems.CopyTo(items, 0);

            if (items.Length > 0)
            {
                foreach (object item in items)
                {
                    src.Items.Remove(item);
                    dst.Items.Add(item);
                }
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            highlightItems(searchTextBox.Text, listBox1);
            highlightItems(searchTextBox.Text, listBox2);
        }

        private void highlightItems(String text, ListBox listBox)
        {
            object[] items = new object[listBox.Items.Count];
            listBox.Items.CopyTo(items, 0);

            foreach (object item in items)
            {
                var value = (String)item;
                if (value.Contains(text) && text != String.Empty)
                {
                    listBox.SelectedItems.Add(item);
                }
                else
                {
                    listBox.SelectedItems.Remove(item);
                }
            }
        }
    }
}
