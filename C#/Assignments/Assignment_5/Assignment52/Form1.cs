using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Assignment52
{
    public partial class Form1 : Form
    {
        private List<Flight> flights;

        public Form1()
        {
            InitializeComponent();
            flights = new List<Flight>(); 
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Flight flight = new Flight(textBoxFlightId.Text, textBoxOrigin.Text, textBoxDestination.Text, dateTimePicker1.Value);
            flights.Add(flight);

            String message = "";

            foreach (Flight fl in flights)
            {
                message += "Flight id: " + fl.FlightId + "\n";
                message += "Origin: " + fl.Origin + "\n";
                message += "Destination: " + fl.Destination+ "\n";
                message += "Date: " + fl.Date + "\n";
                message += "-----\n\n";
            }

            MessageBox.Show(message, "Flight infos", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
    }
}
