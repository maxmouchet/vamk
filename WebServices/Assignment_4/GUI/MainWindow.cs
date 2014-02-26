using System;
using Gtk;
using CookComputing.XmlRpc;
using GUI;

public partial class MainWindow: Gtk.Window
{	
	IOService proxy;

	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();
		proxy = XmlRpcProxyGen.Create<IOService>();
		object ret = proxy.listFiles();
		foreach (String file in (Array) ret){
			comboboxentry1.AppendText (file);
		}
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}

	protected void OnButton2Clicked (object sender, EventArgs e)
	{
		object ret = proxy.downloadFile(comboboxentry1.Entry.Text);
		try {
			image1.Pixbuf = new Gdk.Pixbuf ((byte[])ret);
		} catch (Exception ex) {
			new MessageDialog (this, DialogFlags.DestroyWithParent, MessageType.Error, ButtonsType.Ok, "The picture can't be found");
		}

	}

}
