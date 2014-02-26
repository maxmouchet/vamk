using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Assignment53
{
    public partial class Form1 : Form
    {
        private Random rnd;
        public static int copyNumber;

        public Form1()
        {
            InitializeComponent();

            rnd = new Random();
            copyNumber = 0;
        }

        public Form1(Boolean copy)
        {
            InitializeComponent();

            rnd = new Random();
            Form1.copyNumber = copyNumber + 1;

            this.Text += " (Copy " + copyNumber.ToString() + ")";
        }

        private Color GetRandomColor()
        {
            KnownColor[] names = (KnownColor[])Enum.GetValues(typeof(KnownColor));

            KnownColor randomColorName;

            do
            {
                randomColorName = names[rnd.Next(names.Length)];
            } while (Color.FromKnownColor(randomColorName) == Color.Transparent);

            return Color.FromKnownColor(randomColorName);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int xLoc = rnd.Next(Screen.GetBounds(this).X, Screen.GetBounds(this).X + Screen.GetBounds(this).Size.Width - this.Width);
            int yLoc = rnd.Next(Screen.GetBounds(this).Y, Screen.GetBounds(this).Y + Screen.GetBounds(this).Size.Height - this.Height);

            this.SetDesktopLocation(xLoc, yLoc);

            this.BackColor = GetRandomColor();
        }

        private void Form1_LocationChanged(object sender, EventArgs e)
        {
            textBox1.Text = this.Location.ToString();
        }

        private void randomSizeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            button1.Size = new Size(rnd.Next(10, this.Width), rnd.Next(10, this.Height));
        }

        private void randomColorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            button1.BackColor = GetRandomColor();
        }

        private void duplicateFormToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form newForm = new Form1();
            newForm.Show();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            duplicateFormToolStripMenuItem_Click(null, null);
            randomColorToolStripMenuItem_Click(null, null);
            randomSizeToolStripMenuItem_Click(null, null);
            button1_Click(null, null);
        }

        private void buttonToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Button btn = new Button();

            int xLoc = rnd.Next(0, this.Size.Width - btn.Size.Width);
            int yLoc = rnd.Next(0, this.Size.Height - btn.Size.Height);

            btn.Text = "Me neither !";
            btn.Location = new Point(xLoc, yLoc);
            btn.Click += button1_Click;

            btn.Parent = this;
        }

        private void textBoxToolStripMenuItem_Click(object sender, EventArgs e)
        {
            TextBox tb = new TextBox();

            int xLoc = rnd.Next(0, this.Size.Width - tb.Size.Width);
            int yLoc = rnd.Next(0, this.Size.Height - tb.Size.Height);

            tb.Text = "Hi";
            tb.Location = new Point(xLoc, yLoc);

            tb.Parent = this;
        }
    }
}
