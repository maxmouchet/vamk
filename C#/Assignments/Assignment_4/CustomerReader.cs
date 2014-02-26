using System;
using System.IO;

namespace Assignment3
{
	public class CustomerReader
	{
		String filePath;

		public CustomerReader (String filePath)
		{
			this.filePath = filePath;
		}

		public String CustomerInfo ()
		{
			BinaryReader binaryReader;
			String firstName = "", lastName = "", arrivalDate = "", exitDate = "";
			int roomNumber = 0;

			try
			{
				binaryReader = new BinaryReader(new FileStream(filePath, FileMode.Open));
			}
			catch (FileNotFoundException e)
			{
				throw new Exception(e.Message + "\nCannot open " + filePath);
			}

			try
			{

				firstName = binaryReader.ReadString();
				lastName  = binaryReader.ReadString();
				roomNumber = binaryReader.ReadInt32();
				arrivalDate = binaryReader.ReadString();
				exitDate = binaryReader.ReadString();
			}
			catch (EndOfStreamException) { }
			catch (IOException e)
			{
				throw new Exception("Read error." + e.Message);
			}

			return "First Name: " + firstName + " Last Name: " + lastName + " Room Number: " + roomNumber + " Arrival Date: " + arrivalDate + " Exit Date: " + exitDate;
		}
	}
}

