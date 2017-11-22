using System;
using Gtk;
using System.Data;

namespace Serpis.Ad
{
    public class ComboBoxHelper
    {
        public const string NullLabel = "<sin asignar>";
        public static void Fill(ComboBox comboBox, string selectSql, object id)
        {
            CellRendererText cellRendererText = new CellRendererText();
            comboBox.PackStart(cellRendererText, false);
            comboBox.AddAttribute(cellRendererText, "text", 1);



            IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
            dbCommand.CommandText = selectSql;
            IDataReader dataReader = dbCommand.ExecuteReader();
            ListStore listStore = new ListStore(typeof(string), typeof(string));
            comboBox.Model = listStore;
            TreeIter initialTreeIter = listStore.AppendValues("0", NullLabel);
            while (dataReader.Read())
            {
                TreeIter treeIter = listStore.AppendValues(dataReader[0].ToString(), dataReader[1].ToString());
                if (id.Equals(dataReader[0]))
                    initialTreeIter = treeIter;
            }
            dataReader.Close();
            comboBox.SetActiveIter(initialTreeIter);
        }
    }
}
