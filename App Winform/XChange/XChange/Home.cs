using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Microsoft.VisualBasic.ApplicationServices;
using Newtonsoft.Json;
using XChange.Model;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace XChange
{
    public partial class Home : Form
    {
        public Home()
        {
            try
            {
                string apiUrl = "http://referentiel.intranet.oma/api/objet";
                InitializeComponent();
                using (HttpClient client = new HttpClient())
                {
                    HttpResponseMessage response = client.GetAsync(apiUrl).Result;

                    if (response.IsSuccessStatusCode)
                    {
                        string apiResponse = response.Content.ReadAsStringAsync().Result;
                        List<Objet> objets = JsonConvert.DeserializeObject<List<Objet>>(apiResponse);
                        for (int i = 0; i < objets.Count; i++)
                        {
                            ListeObjet.Items.Add(objets[i].Id+" | "+ objets[i].nom) ;
                        }
                    }
                    else
                    {
                        InitializeComponent();
                        ListeObjet.Items.Add(response.StatusCode);
                        Console.WriteLine($"Erreur de l'API : {response.StatusCode}");
                    }
                }
                apiUrl = "http://referentiel.intranet.oma/api/user";
                using (HttpClient client = new HttpClient())
                {
                    HttpResponseMessage response = client.GetAsync(apiUrl).Result;

                    if (response.IsSuccessStatusCode)
                    {
                        string apiResponse = response.Content.ReadAsStringAsync().Result;
                        List<Utilisateur> users = JsonConvert.DeserializeObject<List<Utilisateur>>(apiResponse);
                        for (int i = 0; i < users.Count; i++)
                        {
                            ListeUtilisateur.Items.Add(users[i].Id + " | " + users[i].Username);
                        }
                    }
                    else
                    {
                        InitializeComponent();
                        ListeObjet.Items.Add(response.StatusCode);
                        Console.WriteLine($"Erreur de l'API : {response.StatusCode}");
                    }
                }

            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erreur : {ex.Message}");
            }
            
        }

        private void listBox2_SelectedIndexChanged(object sender, EventArgs e)
        {
            Detail form3 = new Detail(ListeObjet.SelectedItem.ToString().Split("|")[0]);
            form3.Show();
            this.Hide();
        }
    }
}
