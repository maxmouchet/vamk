using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Collections;

namespace Assignment10
{
    public partial class TrafficLight : UserControl
    {
        Graphics g;

        List<Color> lights;
        Color activeLight;
        Timer lightTimer;

        public TrafficLight()
        {
            InitializeComponent();

            lights = new List<Color>();
            
            // Define the lights
            lights.Add(Color.Red);
            lights.Add(Color.Yellow);
            lights.Add(Color.Green);

            // Shutdown the lights
            activeLight = Color.Empty;

            // Setup the timer
            lightTimer = new Timer();
            lightTimer.Enabled = false;
            lightTimer.Interval = 2 * 1000;
            lightTimer.Tick += new EventHandler(lightTimer_Tick);
        }

        void lightTimer_Tick(object sender, EventArgs e)
        {
            bool nextLightFound = false;

            for (int i = 0; i < lights.Count; i++)
            {
                if (!nextLightFound && lights[i] == activeLight)
                {
                    if (i + 1 < lights.Count)
                    {
                        activeLight = lights[i + 1];
                    }
                    else
                    {
                        activeLight = lights[0];
                    }
                    nextLightFound = true;
                }
            }

            Invalidate();
        }

        public void Start()
        {
            activeLight = Color.Red;
            Invalidate();

            lightTimer.Start();
        }

        public void Stop()
        {
            lightTimer.Stop();

            activeLight = Color.Empty;
            Invalidate();
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            g = e.Graphics;

            int startX = this.ClientRectangle.Left + 4;
            int startY = this.ClientRectangle.Top + 4;
            int lightRadius = this.ClientRectangle.Width - 10;
            int gap = 5;

            int count = 0;
            foreach (Color light in lights)
            {
                Color lightColor = Color.Black;
                if (activeLight == light) { lightColor = light; }

                g.FillEllipse(new SolidBrush(lightColor), startX, startY + (lightRadius + gap) * count, lightRadius, lightRadius);
                
                count++;
            }

            base.OnPaint(e);
        }
    }
}
