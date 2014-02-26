using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_2
{
    class EconomyPassenger : PersonalInfo
    {
        private int luggageWeight;

        public EconomyPassenger(string firstName, string lastName, string phoneNumber, int luggageWeight) : base (firstName, lastName, phoneNumber)
        {
            this.luggageWeight = luggageWeight;
        }
    }
}
