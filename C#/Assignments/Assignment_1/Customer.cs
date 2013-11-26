using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_1
{
    class Customer
    {
        static private int customerCount = 0;

        static public int CustomerCount
        {
            get { return customerCount; }
        }

        private int id, flightId;
        private string name;

        public Customer(int flightId, string name)
        {
            this.id = customerCount;
            this.flightId = flightId;
            this.name = name;

            customerCount++;
        }

        public string GetCustomerInfo(ref Flight[] flights)
        {
            string output = "";

            output += "Customer " + id + ": " + name + "\n";
            output += "Flight infos:\n";

            foreach (Flight flight in flights)
            {
                output += flight.GetFlightInfo(this.flightId);
            }

            return output;
        }

    }
}
