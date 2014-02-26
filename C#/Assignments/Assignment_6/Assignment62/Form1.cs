using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace Assignment62
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (!richTextBox1.Text.Trim().Equals(String.Empty))
            {
                if (MessageBox.Show("Do you want to save ?", "Save", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == System.Windows.Forms.DialogResult.Yes)
                {
                    if (saveFileDialog1.ShowDialog() == System.Windows.Forms.DialogResult.OK)
                    {
                        StreamWriter sw = File.CreateText(saveFileDialog1.FileName);
                        sw.WriteLine(richTextBox1.Rtf);
                        sw.Close();
                    }
                }
            }
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            richTextBox1.Undo();
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            if (fontDialog1.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                richTextBox1.SelectionColor = fontDialog1.Color;
                richTextBox1.SelectionFont = fontDialog1.Font;
            }
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {
            toolStripTextBox1.AutoCompleteCustomSource.Clear();

            foreach (var item in richTextBox1.Text.Split(' '))
	        {
                toolStripTextBox1.AutoCompleteCustomSource.Add(item);
	        }
        }

        private void toolStripTextBox1_TextChanged(object sender, EventArgs e)
        {
            richTextBox1.Find(toolStripTextBox1.Text);
        }

        private void toolStripTextBox2_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar.Equals('\r'))
            {
                richTextBox1.Rtf = richTextBox1.Rtf.Replace(toolStripTextBox1.Text, toolStripTextBox2.Text);
            }
        }
    }
}
