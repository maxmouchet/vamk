using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Assignment8_final
{
    class Article : IComparable
    {

        private string title;
        private int id;
        private double price;

        public Article(string title, int id, double price)
        {

            this.title = title;

            this.id = id;
            this.price = price;

        }

        public string Title
        {

            get
            {

                return title;

            }

        }

        public int ID
        {

            get
            {

                return id;

            }
        }


        public double Price
        {

            get
            {

                return price;

            }

        }


        public override string ToString()
        {

            return title + " " + id;

            //return base.ToString();

        }

        public int CompareTo(object o)
        {
            if (o is Article)
            {
                Article article = (Article)o;
                return this.Title.CompareTo(article.Title);
            }

            return 0;
        }

    }
}
