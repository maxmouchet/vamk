using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Assignment10_2
{
    public partial class VideoShop : UserControl
    {
        private string searchString;
        private List<string> reservedVideos;

        public VideoShop()
        {
            InitializeComponent();

            searchString = "";
            reservedVideos = new List<string>();

            videoListBox.DrawMode = DrawMode.OwnerDrawFixed;
            videoListBox.DrawItem += new DrawItemEventHandler(videoListBox_DrawItem);
        }

        void videoListBox_DrawItem(object sender, DrawItemEventArgs e)
        {
            e.DrawBackground();
            bool selected = ((e.State & DrawItemState.Selected) == DrawItemState.Selected);

            int index = e.Index;
            if (index >= 0 && index < videoListBox.Items.Count)
            {
                Video video = (Video) videoListBox.Items[index];
                string text = video.Name;

                Graphics g = e.Graphics;

                SolidBrush backgroundBrush;
                if (selected)
                {
                    backgroundBrush = new SolidBrush(Color.Blue);
                }
                else if (text.Equals(searchString))
                {
                    backgroundBrush = new SolidBrush(Color.Yellow);
                }
                else
                {
                    backgroundBrush = new SolidBrush(Color.White);
                }

                foreach (string videoName in reservedVideos)
                {
                    if (text.Equals(videoName))
                    {
                        backgroundBrush = new SolidBrush(Color.Red);
                    }
                }

                g.FillRectangle(backgroundBrush, e.Bounds);

                SolidBrush foregroundBrush = (selected) ? new SolidBrush(Color.White) : new SolidBrush(Color.Black);
                g.DrawString(text, e.Font, foregroundBrush, videoListBox.GetItemRectangle(index).Location);
            }

            e.DrawFocusRectangle();
        }

        private void addButton_Click(object sender, EventArgs e)
        {
            searchString = "";
            
            string name = videoNameTextBox.Text;
            float price = 1.00f;

            Video video = new Video(name, price);

            videoListBox.Items.Add(video);
        }

        private void removeButton_Click(object sender, EventArgs e)
        {
            for (int i = videoListBox.Items.Count - 1; i >= 0 ; i--)
            {
                Video video = (Video) videoListBox.Items[i];
                if(video.Name.Equals(videoNameTextBox.Text)) {
                    videoListBox.Items.RemoveAt(i);
                }
            }
        }

        private void searchButton_Click(object sender, EventArgs e)
        {
            searchString = videoNameTextBox.Text;

            bool videoFound = false;
            foreach (Object obj in videoListBox.Items)
            {
                Video video = (Video)obj;
                if (video.Name.Equals(searchString))
                {
                    videoFound = true;
                }
            }

            if (!videoFound) {
                MessageBox.Show("Video not found", "Search", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            videoListBox.Refresh();
        }

        private void reserveButton_Click(object sender, EventArgs e)
        {
            string videoName = videoNameTextBox.Text;

            bool videoAvailable = false;
            foreach (Object obj in videoListBox.Items)
            {
                Video video = (Video)obj;
                if (video.Name.Equals(videoName) && !reservedVideos.Contains(videoName))
                {
                    videoAvailable = true;
                }
            }

            if (!videoAvailable)
            {
                MessageBox.Show("Video not available", "Reservation", MessageBoxButtons.OK, MessageBoxIcon.Asterisk);
            }
            else
            {
                reservedVideos.Add(videoName);
            }

            videoListBox.Refresh();
        }
    }
}
