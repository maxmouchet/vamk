using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assign7
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            menuStrip1.MdiWindowListItem = windowToolStripMenuItem;
        }
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {

            Application.Exit();

        }
        private void newToolStripMenuItem_Click(object sender, EventArgs e)
        {
            openFileDialog.DefaultExt = "txt";
            openFileDialog.ShowDialog();
        }

        private void openFileDialog1_FileOk(object sender, CancelEventArgs e)
        {
            Regex testExtTXT = new Regex(@"^(.+\.txt)$");
            Regex testExtIMG = new Regex(@"^(.+\.isav)$");

            if (testExtTXT.IsMatch(openFileDialog.FileName)){
                TextForm NewMDIChild = new TextForm(openFileDialog.FileName);
                NewMDIChild.Text = openFileDialog.FileName;
                NewMDIChild.MdiParent = this;

                NewMDIChild.Show();
            }
            else if (testExtIMG.IsMatch(openFileDialog.FileName))
            {
                ImageForm NewMIDChild = new ImageForm(openFileDialog.FileName);
                NewMIDChild.Text = openFileDialog.FileName;
                NewMIDChild.MdiParent = this;

                NewMIDChild.Show();
            }
            else
            {
                System.Console.Write("Can't open file, type unknown");
            }
        }
    }
}
