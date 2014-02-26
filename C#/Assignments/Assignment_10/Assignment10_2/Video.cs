using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Assignment10_2
{
    class Video
    {
        private static int count = 0;

        private int id;
        private string name;
        private float price;

        public string Name { get { return name; } }
        public float Price { get { return price; } }

        public Video(string name, float price)
        {
            this.id = count;
            this.name = name;
            this.price = price;

            count++;
        }
    }
}
