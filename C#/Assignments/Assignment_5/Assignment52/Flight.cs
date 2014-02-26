using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Assignment52
{
    class Flight
    {
        private String flightId, origin, destination;
        private DateTime date;

        public Flight(String flightId, String origin, String destination, DateTime date)
        {
            this.flightId = flightId;
            this.origin = origin;
            this.destination = destination;
            this.date = date;
        }

        public String FlightId { get { return this.flightId; } }
        public String Origin { get { return this.origin; } }
        public String Destination { get { return this.destination; } }
        public DateTime Date { get { return this.date; } }
    }
}
