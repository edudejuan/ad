using System;

namespace CCategoría
{
	public partial class DbCommandHelper : Gtk.Window
	{
		public DbCommandHelper () :
			base (Gtk.WindowType.Toplevel)
		{
			this.Build ();
		}
	}
}

