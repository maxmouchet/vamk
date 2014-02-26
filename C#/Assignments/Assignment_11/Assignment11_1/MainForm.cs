using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Assignment11_1
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void PictureBox_MousDown(object sender, MouseEventArgs e)
        {
            ((PictureBox)sender).DoDragDrop(new Bitmap(((PictureBox)sender).Image), DragDropEffects.Copy);
        }

        private void MainForm_DragEnter(object sender, DragEventArgs e)
        {
            if (e.Data.GetDataPresent(DataFormats.Bitmap))
            {
                e.Effect = DragDropEffects.Copy;
            }
            else
            {
                e.Effect = DragDropEffects.None;
            }
        }

        private void MainForm_DragDrop(object sender, DragEventArgs e)
        {
            ((MainForm)sender).BackgroundImage = ((Bitmap)e.Data.GetData(DataFormats.Bitmap));
        }
    }
}
