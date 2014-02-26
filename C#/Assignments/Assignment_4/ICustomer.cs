using System;

namespace Assignment3
{
	public interface ICustomer
	{
		String FirstName
		{
			get;
			set;
		}

		String LastName
		{
			get;
			set;
		}

		DateTime ArrivalDate
		{
			get;
			set;
		}

		DateTime ExitDate
		{
			get;
			set;
		}

		IRoom GetRoom();

		int GetNumberOfNights ();

		void WriteToFile (String filePath);
	}
}

