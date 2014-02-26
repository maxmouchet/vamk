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
    public partial class InputForm : Form
    {
        public InputForm()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void InputForm_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (saveFileDialog1.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                String filePath = saveFileDialog1.FileName;

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

                Product product = new Product(comboBox1.Text, textBox1.Text, Convert.ToInt32(textBox2.Text), textBox3.Text);

                products.Add(product);

                fileStream.Flush();
                fileStream.Close();

                fileStream = new FileStream(filePath, FileMode.Truncate);

                binaryFormatter.Serialize(fileStream, products);

                fileStream.Flush();
                fileStream.Close();
            }
        }
    }
}
