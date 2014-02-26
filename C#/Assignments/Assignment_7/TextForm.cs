using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assign7
{
    public partial class TextForm : Form
    {
        private String filePathName;

        public TextForm(String filePath)
        {
            InitializeComponent();
            this.filePathName = filePath;
            LoadFile();
        }

        private void LoadFile(){
            try
            {
                StreamReader sr = File.OpenText(filePathName);
                fileContentTextbox.Text = sr.ReadToEnd();
                sr.Close();
            }
            catch
            {
                // Do nothing.
            }
        }

        private void SaveFile(){
            StreamWriter sw = File.CreateText(filePathName);
            sw.WriteLine(fileContentTextbox.Text);
            sw.Close();
        }

        private void saveToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SaveFile();
        }

    }
}