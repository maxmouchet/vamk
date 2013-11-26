using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_1
{
    class Program
    {
        const int MAX_FLIGHTS = 2;
        const int MAX_CUSTOMERS = 2;

        private static Flight[] flights;
        private static Customer[] customers;

        static void Main(string[] args)
        {
            Console.WriteLine("Flight Management");

            flights = new Flight[MAX_FLIGHTS];
            customers = new Customer[MAX_CUSTOMERS];

            for (int i = 0; i < MAX_FLIGHTS; i++)
            {
                flights[i] = CreateFlight();
            }

            for (int i = 0; i < MAX_CUSTOMERS; i++)
            {
                customers[i] = CreateCustomer();
            }

            // Loop through the menu
            int choice = 0;
            while (choice != 2)
            {
                choice = AskMenu();
                switch (choice)
                {
                    case 1:
                        ShowCustomersInfo();
                        break;

                    default:
                        break;
                }
            }
        }

        private static int AskMenu()
        {
            Console.WriteLine();
            Console.WriteLine("1. Customer Informations");
            Console.WriteLine("2. Exit");

            Console.Write("=> ");
            ConsoleKeyInfo input = Console.ReadKey();

            int result;
            try
            {
                result = Convert.ToInt32(input.KeyChar.ToString());
            }
            catch (Exception)
            {
                result = -1;
            }

            return result;
        }

        private static Customer CreateCustomer()
        {
            int flightId;
            string name;

            Console.WriteLine();
            Console.WriteLine("Creating customer " + Customer.CustomerCount + "\n");

            Console.Write("Flight id: ");
            flightId = Convert.ToInt32(Console.ReadLine());

            Console.Write("Customer name: ");
            name = Console.ReadLine();

            return new Customer(flightId, name);
        }

        private static Flight CreateFlight()
        {
            string origin, destination;
            int year, month, day;
            DateTime date;

            Console.WriteLine();
            Console.WriteLine("Creating flight " + Flight.FlightCount + "\n");

            Console.Write("Flight origin: ");
            origin = Console.ReadLine();

            Console.Write("Flight destination: ");
            destination = Console.ReadLine();

            Console.Write("Year: ");
            year = Convert.ToInt32(Console.ReadLine());

            Console.Write("Month: ");
            month = Convert.ToInt32(Console.ReadLine());

            Console.Write("Day: ");
            day = Convert.ToInt32(Console.ReadLine());

            date = new DateTime(year, month, day);

            return new Flight(origin, destination, date);
        }

        private static void ShowCustomersInfo()
        {
            Console.Write("\n\n");

            foreach (Customer customer in customers)
            {
                Console.WriteLine(customer.GetCustomerInfo(ref flights));
                Console.WriteLine();
            }
        }
    }
}
