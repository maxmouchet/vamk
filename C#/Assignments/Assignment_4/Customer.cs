using System;
using System.IO;

namespace Assignment3
{
	[Serializable()]
	public class Customer : ICustomer
	{
		private String firstName, lastName;
		private IRoom room;
		private DateTime arrivalDate, exitDate;

		public Customer (String firstName, String lastName, IRoom room, DateTime arrivalDate, DateTime exitDate)
		{
			this.firstName = firstName;
			this.lastName = lastName;

			this.room = room;

			this.arrivalDate = arrivalDate;
			this.exitDate = exitDate;

			this.room.AddCustomer (this);
		}

		public String FirstName
		{
			get {
				return this.firstName;
			}
			set {
				this.firstName = value;
			}
		}

		public String LastName
		{
			get {
				return this.lastName;
			}
			set {
				this.lastName = value;
			}
		}

		public DateTime ArrivalDate
		{
			get {
				return this.arrivalDate;
			}
			set {
				this.arrivalDate = value;
			}
		}

		public DateTime ExitDate
		{
			get {
				return this.exitDate;
			}
			set {
				this.exitDate = value;
			}
		}

		public IRoom GetRoom ()
		{
			return this.room;
		}

		public int GetNumberOfNights ()
		{
			TimeSpan difference = exitDate - arrivalDate;
			return difference.Days;
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

			binaryWriter.Write (firstName);
			binaryWriter.Write (lastName);
			binaryWriter.Write (room.GetRoomNumber());
			binaryWriter.Write (arrivalDate.ToLongDateString());
			binaryWriter.Write (exitDate.ToLongDateString());
			binaryWriter.Close ();
		}

		public override string ToString ()
		{
			return string.Format ("[Customer: FirstName={0}, LastName={1}, ArrivalDate={2}, ExitDate={3}, Room={4}, NumberOfNights={5}]", FirstName, LastName, ArrivalDate, ExitDate, GetRoom().GetRoomNumber(), GetNumberOfNights());
		}
	}
}

