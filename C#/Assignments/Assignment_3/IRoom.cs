using System;

namespace Assignment3
{
	public interface IRoom
	{
		int NumberOfBeds {
			get;
			set;
		}

		int GetRoomNumber ();

		RoomStatus GetRoomStatus ();

		ICustomer[] GetCustomers ();

		void AddCustomer (Customer customer);

		void WriteToFile (String filePath);
	}
}

