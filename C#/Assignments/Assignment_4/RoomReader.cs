using System;
using System.IO;

namespace Assignment3
{
	public class RoomReader
	{
		String filePath;

		public RoomReader (String filePath)
		{
			this.filePath = filePath;
		}

		public String RoomInfo ()
		{
			BinaryReader binaryReader;
			int number = 0, numberOfBeds = 0;
			String customers = "";

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

				number = binaryReader.ReadInt32();
				numberOfBeds = binaryReader.ReadInt32();
				while (true) {
					customers = customers + binaryReader.ReadString();
				}
			}
			catch (EndOfStreamException) { }
			catch (IOException e)
			{
				throw new Exception("Read error." + e.Message);
			}

			return "Number: " + number + " Beds: " + numberOfBeds + " Customers: " + customers;
		}
	}
}

