using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assign7
{
    public partial class ImageForm : Form
    {
        private Bitmap drawingSurface;
        private Rectangle tmpRect;
        private Color tmpColor;

        private String filePathName;

        Random rnd;

        Hashtable shapes;

        public ImageForm(String filePath)
        {
            InitializeComponent();

            rnd = new Random();

            this.shapes = new Hashtable();
            this.tmpRect = new Rectangle(0, 0, 100, 100);
            this.tmpColor = GetRandomColor();

            filePathName = filePath;

            LoadFile();
        }

        private void LoadFile() {
            FileStream fs = new FileStream(filePathName, FileMode.OpenOrCreate);

            try
            {
                BinaryFormatter binaryFormatter = new BinaryFormatter();
                object obj = binaryFormatter.Deserialize(fs);

                shapes = (Hashtable)obj;
            }
            catch
            {
                // Do nothing.
            }
            finally
            {
                fs.Close();
            }
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

        private void InitializeDrawing()
        {
            Graphics g;

            g = Graphics.FromImage(drawingSurface);
            g.Clear(SystemColors.Control);

            Draw(ref g, shapes);

            g.Dispose();
        }

        private void Draw(ref Graphics g, Hashtable shapes)
        {
            foreach (DictionaryEntry entry in shapes)
            {
                switch ((ShapeType) entry.Value)
                {
                    case ShapeType.Ellipse:
                        EllipseStruct ellipse = (EllipseStruct)entry.Key;
                        g.DrawEllipse(ellipse.pen, ellipse.rect);
                        break;
                    case ShapeType.Rectangle:
                        RectangleStruct rectangle = (RectangleStruct)entry.Key;
                        g.DrawRectangle(rectangle.pen, rectangle.rect);
                        break;
                    case ShapeType.Line:
                        LineStruct line = (LineStruct)entry.Key;
                        g.DrawLine(line.pen, line.pt1, line.pt2);
                        break;
                    default:
                        break;
                }
            }
            
        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            drawingSurface = new Bitmap(this.ClientRectangle.Width, this.ClientRectangle.Height,
            System.Drawing.Imaging.PixelFormat.Format24bppRgb);
            InitializeDrawing();
        }

        private void MainForm_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            g.DrawImage(drawingSurface, this.ClientRectangle.Left, this.ClientRectangle.Top);
        }

        private void MainForm_Resize(object sender, EventArgs e)
        {
            //Here we set the size of the BitMap again and initailize the drawing surface.
            //This is used to resize the drawing according to the new size of the window! 
            drawingSurface = new Bitmap(this.ClientRectangle.Width, this.ClientRectangle.Height,
            System.Drawing.Imaging.PixelFormat.Format24bppRgb);

            InitializeDrawing();
            Refresh();
        }

        private void elipseToolStripMenuItem_Click(object sender, EventArgs e)
        {
            EllipseStruct ellipse = new EllipseStruct();
            ellipse.pen = new Pen(tmpColor, 5);
            ellipse.rect = tmpRect;

            shapes[ellipse] = ShapeType.Ellipse;

            InitializeDrawing();
            Refresh();
        }

        private void rectangleToolStripMenuItem_Click(object sender, EventArgs e)
        {
            RectangleStruct rectangle = new RectangleStruct();
            rectangle.pen = new Pen(tmpColor, 5);
            rectangle.rect = tmpRect;

            shapes[rectangle] = ShapeType.Rectangle;

            InitializeDrawing();
            Refresh();
        }

        private void lineToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LineStruct line = new LineStruct();
            line.pen = new Pen(tmpColor, 5);
            line.pt1 = new Point(tmpRect.X, tmpRect.Right);
            line.pt2 = new Point(tmpRect.Y, tmpRect.Bottom);

            shapes[line] = ShapeType.Line;

            InitializeDrawing();
            Refresh();
        }

        private void manualToolStripMenuItem_Click(object sender, EventArgs e)
        {
            randomToolStripMenuItem.Checked = false;
            manualToolStripMenuItem.Checked = true;

            tmpRect.X = Convert.ToInt32(toolStripTextBox1.Text);
            tmpRect.Y = Convert.ToInt32(toolStripTextBox2.Text);
            tmpRect.Width = tmpRect.X + Convert.ToInt32(toolStripTextBox3.Text);
            tmpRect.Height = tmpRect.Y + Convert.ToInt32(toolStripTextBox4.Text);
        }

        private void randomToolStripMenuItem_Click(object sender, EventArgs e)
        {
            randomToolStripMenuItem.Checked = true;
            manualToolStripMenuItem.Checked = false;

            Random rnd = new Random();

            tmpRect.X = rnd.Next(drawingSurface.Width - 10);
            tmpRect.Y = rnd.Next(drawingSurface.Height - 10);
        }

        private void randomToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            manualToolStripMenuItem1.Checked = false;
            randomToolStripMenuItem1.Checked = true;

            tmpColor = GetRandomColor();
        }

        private void manualToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            manualToolStripMenuItem1.Checked = true;
            randomToolStripMenuItem1.Checked = false;

            tmpColor = Color.FromName(toolStripComboBox1.Text);
        }

        private void saveToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FileStream fs = new FileStream(filePathName, FileMode.Create);

            try
            {
                BinaryFormatter binaryFormatter = new BinaryFormatter();
                binaryFormatter.Serialize(fs, shapes);

                fs.Flush();
                fs.Close();
            }
            catch
            {
                // Do nothing.
            }
            finally
            {
                fs.Flush();
                fs.Close();
            }
        }
    }
}
