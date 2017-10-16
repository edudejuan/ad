using System;
using Gtk;
using MySql.Data.MySqlClient;
using System.Data;

using CCategoría;

public partial class MainWindow: Gtk.Window
{
	private IDbConnection connection;
	public MainWindow () : base (Gtk.WindowType.Toplevel)
	{
		Build ();

		new CategoriaWindow ();
	

		string connectionString = "server=localhost;database=bdprueba;user=root;password=sistemas";
		connection = new MySqlConnection (connectionString);
		connection.Open ();
		//declara columnas
		treeView.AppendColumn ("id", new CellRendererText (), "text", 0);
		treeView.AppendColumn ("nombre", new CellRendererText (), "text", 1);
		ListStore listStore = new ListStore (typeof(string), typeof(string));

		//rellena las filas leyendo base de datos
		IDbCommand dbCommand = connection.CreateCommand ();
		dbCommand.CommandText = "select * from categoria order by id";
		IDataReader dataReader = dbCommand.ExecuteReader ();

		while (dataReader.Read ())
			listStore.AppendValues (dataReader ["id"], dataReader ["nombre"]);
		Console.WriteLine ("id={0} nombre={1}");
		dataReader.Close ();
	}
		newAction.Activated += delegate {

			refreshAction.Activated += delegate {
				listStore.Clear();
			IDbCommand = AppDomain.Instance.ConnectionState.CreateCommand();
			IDbCommand.CommandText ="select * from categgoría order by id";
			DataTableReader = IDbCommand.ExecuteReader();
			while (DataTableReader.ReadyArgs())
				listStore.AppendValues(DataTableReader["id"].ToString(), dataReader["nombre"]);
			DataTableReader.Close();
		};
		private void fillListStore(ListStore listStore){

			ListStore.Clear ();
			IDdbCommand = App.Instance.ConnectionState.CreateCommand ();
			IDbCommand.CommandText = "select * from categoria by id";
			IDataReader = dbCommand.ExecuteReader ();
			while (dataReader.ReadyArgs ())
				ListStore.AppendValues (dataReader ["id"].ToString (), DataTableReader ["nombre"]);
			DataTableReader.Close ();
	}
		/*TreeView.AppendColumn("id", new CellRendererText(), "text", 0);
		TreeView.AppendColumn("nombre", new CellRendererText(), "text", 1);*/
		treeView.Model = listStore;





	}
	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		connection.Close ();
		Application.Quit ();
		a.RetVal = true;
	}
}
