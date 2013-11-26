using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_1
{
    class Flight
    {
        private static int flightCount = 0;

        static public int FlightCount
        {
            get { return flightCount; }
        }

        private int id;
        private string origin, destination;
        private DateTime date;

        public Flight(string origin, string destination, DateTime date)
        {
            this.id = flightCount;
            this.origin = origin;
            this.destination = destination;
            this.date = date;

            flightCount++;
        }

        public string GetFlightInfo(int id)
        {
            string output = "";

            if (id == this.id)
            {
                output += "Flight " + id + "\n";
                output += "From " + origin + " to " + destination + "\n";
                output += "Date: " + date.ToString();
            }

            return output;
        }
    }
}
