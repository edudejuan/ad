using System;
using Gtk;
using MySql.Data.MySqlClient;

using Serpis.Ad;

public partial class MainWindow : Gtk.Window
{
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        Build();
        /*
        CellRendererText idCellRendererText = new CellRendererText();
        comboBox.PackStart(idCellRendererText, false);
        comboBox.AddAttribute(idCellRendererText,"text",0);


        CellRendererText labelCellRendererText = new CellRendererText();
        comboBox.PackStart(labelCellRendererText, false);
        comboBox.AddAttribute(labelCellRendererText, "text", 1);




        ListStore listStore = new ListStore(typeof(string), typeof(string));
        comboBox.Model = listStore;
        TreeIter treeIter = listStore.AppendValues("0", "<sin asignar>");
        listStore.AppendValues("1", "cat 1");
        listStore.AppendValues("2 ","cat 2");
        listStore.AppendValues("3", "cat 3");

        comboBox.SetActiveIter(treeIter);*/

        App.Instance.Connection = new MySqlConnection("server=localhost;database=bdprueba;user=root;password=sistemas");
        App.Instance.Connection.Open();
        ComboBoxHelper.Fill(comboBox," select id, nombre from categoria order by nombre", 0);
    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Application.Quit();
        a.RetVal = true;
    }
}
