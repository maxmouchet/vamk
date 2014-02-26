using System;
using System.IO;
using System.Collections.Generic;
using System.Runtime.Serialization.Formatters.Soap;

namespace Assignment3
{
	class Program
	{
		public static void Main (string[] args)
		{
			List<Room> rooms = new List<Room> ();
			String filePath;

			Console.WriteLine ("Creating Room 1 with 2 beds");
			Room room1 = new Room (1, 2);

			rooms.Add (room1);

			Console.WriteLine ("Creating Room 2 with 1 beds");
			Room room2 = new Room (2, 1);

			rooms.Add (room2);

			Console.WriteLine ("\nCreating Customer Jean Dupont in Room 1 from 10/12/2013 to 12/12/2013");
			Customer customer1 = new Customer("Jean", "Dupont", room1, new DateTime(2013, 12, 10), new DateTime(2013, 12, 12));

			Console.WriteLine ("Creating Customer Marc Anna in Room 1 from 10/12/2013 to 12/12/2013");
			Customer customer2 = new Customer("Marc", "Anna", room1, new DateTime(2013, 12, 10), new DateTime(2013, 12, 12));

			Console.WriteLine ("\nGetting customers in Room 1");
			foreach (Customer customer in room1.GetCustomers()) {
				Console.WriteLine (customer.ToString ());
			}

			Console.WriteLine ("\nGetting room list\n");
			foreach (Room room in rooms) {
				Console.WriteLine ("Room number: " + room.GetRoomNumber ());
				Console.WriteLine ("Number of beds: " + room.NumberOfBeds);
				Console.WriteLine ("Status: " + room.GetRoomStatus ());

				Console.WriteLine ("---");
			}

			Console.WriteLine ("\nWriting Room 1 to file");
			filePath = @"room1.bin";
			room1.WriteToFile (filePath);

			Console.WriteLine ("\nReading Room 1 infos from file");
			RoomReader roomReader = new RoomReader (filePath);
			Console.WriteLine (roomReader.RoomInfo ());

			Console.WriteLine ("\nWriting Customer 2 1 to file");
			filePath = @"customer2.bin";
			customer2.WriteToFile (filePath);

			Console.WriteLine ("\nReading Customer 2 infos from file");
			CustomerReader customerReader = new CustomerReader (filePath);
			Console.WriteLine (customerReader.CustomerInfo ());

			Console.WriteLine ("\nSerializing Hotel");
			filePath = @"hotel.xml";

			FileStream fileStream = new FileStream(filePath, FileMode.OpenOrCreate);

			SoapFormatter soapFormatter = new SoapFormatter();

			soapFormatter.Serialize (fileStream, rooms);

			fileStream.Flush();
			fileStream.Close();

			Console.WriteLine ("Hotel serialized. Reseting rooms");
			rooms = new List<Room> ();

			Console.WriteLine ("rooms.Count = " + rooms.Count);

			Console.WriteLine ("\nReloading Hotel");
			fileStream = new FileStream(filePath, FileMode.OpenOrCreate);
			rooms = (List<Room>)soapFormatter.Deserialize (fileStream);
			fileStream.Close();

			Console.WriteLine ("rooms.Count = " + rooms.Count);


		}
	}
}
