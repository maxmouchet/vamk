using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace Assignment11_2
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void showButton_Click(object sender, EventArgs e)
        {
            fsTreeView.Nodes.Clear();
            string rootDir = dirTextBox.Text;
            fsTreeView.Nodes.Add(BuildTree(rootDir, new TreeNode()));
        }

        private TreeNode BuildTree(string path, TreeNode tree)
        {
            string[] dirs = Directory.GetDirectories(path);
            string[] files;

            //Here we add each directory to the root node of the treeview.
            foreach (string dir in dirs)
            {
                TreeNode childNode = tree.Nodes.Add(dir);

                //In the following we get the file list of each
                //subdirectory and add each file to its parent directory
                //on the treeview.
                files = Directory.GetFiles(dir);
                foreach (string file in files)
                    childNode.Nodes.Add(file);

                BuildTree(dir, childNode);
            }

            return tree;
        }
    }
}
