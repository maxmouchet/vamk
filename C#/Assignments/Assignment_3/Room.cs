using System;
using System.IO;
using System.Collections.Generic;

namespace Assignment3
{
	[Serializable()]
	public class Room : IRoom
	{
		private int number, numberOfBeds;
		private List<Customer> customers;

		public Room (int number, int numberOfBeds)
		{
			this.number = number;
			this.numberOfBeds = numberOfBeds;

			this.customers = new List<Customer> (this.NumberOfBeds);
		}

		public int NumberOfBeds
		{
			get {
				return this.numberOfBeds;
			}
			set {
				this.numberOfBeds = value;
			}
		}

		public int GetRoomNumber ()
		{
			return this.number;
		}

		public RoomStatus GetRoomStatus ()
		{
			var roomStatus = RoomStatus.Free;

			if (this.customers.Count == this.numberOfBeds) {
				roomStatus = RoomStatus.Occupied;
			}

			return roomStatus;
		}

		public ICustomer[] GetCustomers ()
		{
			return this.customers.ToArray();
		}

		public void AddCustomer (Customer customer)
		{
			if (this.customers.Count < this.numberOfBeds) {
				customers.Add (customer);
			} else {
				throw new Exception ("Room is full");
			}
		}

		public void WriteToFile (String filePath)
		{
			BinaryWriter binaryWriter;

			try
			{
				binaryWriter = new BinaryWriter(new FileStream(filePath, FileMode.OpenOrCreate));
			}
			catch (IOException e)
			{
				throw new Exception(e.Message + "\nCannot open " + filePath);
			}

			binaryWriter.Write (number);
			binaryWriter.Write (numberOfBeds);
			foreach (Customer customer in customers) {
				binaryWriter.Write (customer.ToString());	
			}
			binaryWriter.Close ();
		}
	}
}

