using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Collections;

namespace Assignment8_final
{
    public partial class Form1 : Form
    {
        private ArrayList originalList;

        public Form1()
        {
            InitializeComponent();
            originalList = new ArrayList();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            articleListBox.DataSource = null;

            originalList.Add(new Article("On Gas", 34567, 2.34));
            originalList.Add(new Article("Evolutionary Computation", 80567, 15.89));
            originalList.Add(new Article("Fuzzy Logic", 91567, 23.56));

            articleListBox.DisplayMember = "Title";
            articleListBox.ValueMember = "ID";

            articleListBox.Items.Clear();
            articleListBox.DataSource = (ArrayList)originalList.Clone();
        }

        private void updateSort(object sender, EventArgs e)
        {
            ArrayList newList = (ArrayList)originalList.Clone();

            if (sortAscRadioButton.Checked)
            {
                newList.Sort();
            }
            else if (sortDscRadioButton.Checked)
            {
                newList.Sort();
                newList.Reverse();
            }

            articleListBox.DataSource = null;
            articleListBox.DataSource = newList;

            articleListBox.DisplayMember = "Title";
            articleListBox.ValueMember = "ID";

            updateDetailList(sender, e);
        }

        private void updateDetailList(object sender, EventArgs e)
        {
            ArrayList detailList = new ArrayList();

            foreach (Article article in (ArrayList)articleListBox.DataSource)
            {
                String detail = "";

                if (articleNameCheckBox.Checked) {
                    detail += article.Title; 
                }
                if (articleIDCheckBox.Checked)
                {
                    detail += " " +  article.ID;
                }
                if (articlePriceCheckBox.Checked)
                {
                    detail += " " + article.Price;
                }

                detailList.Add(detail);
            }

            detailListBox.DataSource = detailList;
        }
    }
}
