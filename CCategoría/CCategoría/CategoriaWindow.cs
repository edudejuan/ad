using System;
using System.Data

namespace CCategoría
{
	public partial class CategoriaWindow : Gtk.Window
	{
		public CategoriaWindow () :
			base (Gtk.WindowType.Toplevel)
		{
			this.Build ();
			saveAction.Activated += delegate 
			{
				
				IDbConnection connection;
				IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
				dbCommand.CommandText = " insert into categoria (nombre) values (@nombre)";
				IDbDataParameter dbDataParameter = dbCommand.CreateParameter();
				dbDataParameter.ParameterName = "nombre";
				dbDataParameter.Value=Nombre;
				dbCommand.Parameters.Add(dbDataParameter);
				dbCommand.ExecuteNonQuery();
				Destroy();
			};
		}
	}
}
