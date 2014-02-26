using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment63
{
    [Serializable()]
    class Product
    {
        private string category, name, price;
        private int quantity;

        public Product(string category, string name, int quantity, string price)
        {
            this.category = category;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public string Category { get { return this.category; } }
        public string Name { get { return this.name; } }
        public int Quantity { get { return this.quantity; } }
        public string Price { get { return this.price; } }
    }
}
