using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using XChange.Model;

namespace XChange
{
    public partial class Detail : Form
    {
        public Detail(string data)
        {
            InitializeComponent();
            try
            {
                string apiUrl = "http://referentiel.intranet.oma/api/objet/" + data;

                using (HttpClient client = new HttpClient())
                {
                    HttpResponseMessage response = client.GetAsync(apiUrl).Result;

                    if (response.IsSuccessStatusCode)
                    {
                        InitializeComponent();
                        string apiResponse = response.Content.ReadAsStringAsync().Result;

                        List<Objet> objets = JsonConvert.DeserializeObject<List<Objet>>(apiResponse);
                        label4.Text = objets[0].nom;
                        label6.Text = objets[0].valeur.ToString();
                        label5.Text = objets[0].proprietaire.Username;
                        label9.Text = objets[0].description;
                    }
                    else
                    {
                        Console.WriteLine($"Erreur de l'API : {response.StatusCode}");
                    }
                }

            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erreur : {ex.Message}");
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Home form2 = new Home();
            form2.Show();
            this.Hide();
        }
    }
}
