using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assignment63
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            menuStrip1.MdiWindowListItem = wINDOWToolStripMenuItem;
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            InputForm inputForm = new InputForm();
            inputForm.MdiParent = this;
            inputForm.Show();
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            InfoForm infoForm = new InfoForm();
            infoForm.MdiParent = this;
            infoForm.Show();
        }
    }
}
