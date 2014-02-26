using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Globalization;

namespace Assignment9
{
    public partial class MainForm : Form
    {
        CultureInfo cultureInfo;

        public MainForm()
        {
            InitializeComponent();
            cultureInfo = new CultureInfo("fi-FI");
        }

        private void updateTitle(object sender, EventArgs e)
        {
            this.Text = DateTime.Now.ToString(cultureInfo.DateTimeFormat);
        }

        private void fiButton_Click(object sender, EventArgs e)
        {
            cultureInfo = new CultureInfo("fi-FI");
            updateTitle(sender, e);
        }

        private void seButton_Click(object sender, EventArgs e)
        {
            cultureInfo = new CultureInfo("se-SE");
            updateTitle(sender, e);
        }

        private void frButton_Click(object sender, EventArgs e)
        {
            cultureInfo = new CultureInfo("fr-FR");
            updateTitle(sender, e);
        }

        private void shapesListBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            var bmp = new System.Drawing.Bitmap(pictureBox1.Width, pictureBox1.Height);
            
            using (var g = Graphics.FromImage(bmp))
            {
                g.Clear(Color.White);
                switch ((String) shapesListBox.SelectedItem)
                {
                    case "Circle":
                        g.DrawEllipse(new Pen(Color.Aquamarine), new Rectangle(5, 5, pictureBox1.Width - 10, pictureBox1.Height - 10));
                        break;
                    case "Square":
                        g.DrawRectangle(new Pen(Color.Aquamarine), new Rectangle(5, 5, pictureBox1.Width - 10, pictureBox1.Height - 10));
                        break;
                    case "Line":
                        g.DrawLine(new Pen(Color.Aquamarine), 5, 5, pictureBox1.Width - 10, pictureBox1.Height - 10);
                        break;
                    default:
                        break;
                }
            }

            pictureBox1.Image = bmp;
            pictureBox1.Invalidate();
        }
    }
}
