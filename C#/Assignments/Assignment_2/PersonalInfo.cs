using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_2
{
    class PersonalInfo
    {
        static private int count = 0;

        static public int Count
        {
            get { return count; }
        }

        private int id;
        private string firstName, lastName;
        private string phoneNumber;

        public PersonalInfo(string firstName, string lastName, string phoneNumber)
        {
            this.id = count;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;

            count++;
        }

        public string GetInfo(int id)
        {
            string output = "";

            if (id == this.id)
            {
                output += "PersonalInfo " + id + "\n";
                output += "Name: " + firstName + " " + lastName + "\n";
                output += "Phone: " + phoneNumber + "\n";
            }

            return output;
        }
    }
}
