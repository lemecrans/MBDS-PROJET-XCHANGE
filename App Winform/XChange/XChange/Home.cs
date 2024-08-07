using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace XChange
{
    public partial class Home : Form
    {
        public Home()
        {
            InitializeComponent();
        }

        private void listBox2_SelectedIndexChanged(object sender, EventArgs e)
        {
            Detail form3 = new Detail(ListeObjet.SelectedItem.ToString());
            form3.Show();
            this.Hide();
        }
    }
}
