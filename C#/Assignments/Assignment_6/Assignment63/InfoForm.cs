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
using System.Runtime.Serialization.Formatters.Binary;

namespace Assignment63
{
    public partial class InfoForm : Form
    {
        public InfoForm()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (openFileDialog1.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                String filePath = openFileDialog1.FileName;

                FileStream fileStream = new FileStream(filePath, FileMode.OpenOrCreate);

                BinaryFormatter binaryFormatter = new BinaryFormatter();

                List<Product> products;

                try
                {
                    products = (List<Product>)binaryFormatter.Deserialize(fileStream);
                }
                catch (Exception)
                {
                    products = new List<Product>();
                }

                fileStream.Close();

                try
                {
                    Product product = products.ElementAt(Convert.ToInt32(textBox1.Text));
                    textBox5.Text = product.Category;
                    textBox2.Text = product.Name;
                    textBox3.Text = product.Price;
                    textBox4.Text = product.Quantity.ToString();
                }
                catch (Exception)
                {
                    MessageBox.Show("Product not found", "Not found", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                
            }
        }
    }
}
