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
using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;

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
                        ListeObjet.Items.Add("Id\t| Nom\t| Proprietaire\t| Disponibilité");
                        for (int i = 0; i < objets.Count; i++)
                        {
                            string id = objets[i].Id.ToString();
                            string nom = objets[i].nom;
                            string proprietaire = objets[i].proprietaire.Username;
                            string disponible = objets[i].disponible.ToString();

                            ListeObjet.Items.Add($"{id}\t| {nom}\t| {proprietaire}\t| {disponible}");
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

                        ListeUtilisateur.Items.Add("Id\t| Nom\t| Role\t| Note");
                        for (int i = 0; i < users.Count; i++)
                        {
                            string id = users[i].Id.ToString();
                            string username = users[i].Username;
                            string role = users[i].Role;
                            string note = users[i].NoteMoyenne.ToString();

                            ListeUtilisateur.Items.Add($"{id}\t| {username}\t| {role}\t| {note}");
                        }
                    }
                    else
                    {
                        InitializeComponent();
                        ListeObjet.Items.Add(response.StatusCode);
                        Console.WriteLine($"Erreur de l'API : {response.StatusCode}");
                    }
                }
                apiUrl = "http://referentiel.intranet.oma/api/echange";
                using (HttpClient client = new HttpClient())
                {
                    HttpResponseMessage response = client.GetAsync(apiUrl).Result;

                    if (response.IsSuccessStatusCode)
                    {
                        string apiResponse = response.Content.ReadAsStringAsync().Result;
                        List<Echange> change = JsonConvert.DeserializeObject<List<Echange>>(apiResponse);
                        ListeEchange.Items.Add("Id\t| Transaction");
                        for (int i = 0; i < change.Count; i++)
                        {
                            string id = change[i].Id.ToString();
                            string proposant = change[i].Proposant.Username;
                            string destinataire = change[i].Destinataire.Username;

                            ListeEchange.Items.Add($"{id}\t| {proposant} vers {destinataire}");

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
            FormObjet form3 = new FormObjet(ListeObjet.SelectedItem.ToString().Split("|")[0]);
            form3.Show();
            this.Hide();
        }


        private void ListeUtilisateur_SelectedIndexChanged(object sender, EventArgs e)
        {
            dialog = new Form();
            dialog.Text = "Confirmation suppression";
            dialog.Size = new Size(300, 150);

            Label label = new Label();
            label.Text = "Voulez-vous vraiment supprimer cette utilisateur?";
            label.AutoSize = true;
            label.Location = new Point(10, 10);
            dialog.Controls.Add(label);

            oui = new System.Windows.Forms.Button();
            oui.BackColor = Color.LightSteelBlue;
            oui.Location = new Point(10, 50);
            oui.Name = "oui_btn";
            oui.Size = new Size(93, 29);
            oui.TabIndex = 5;
            oui.Text = "Oui";
            oui.UseVisualStyleBackColor = false;
            oui.Click += (s, e) => { dialog.DialogResult = DialogResult.OK; dialog.Close(); };
            dialog.Controls.Add(oui);

            non = new System.Windows.Forms.Button();
            non.BackColor = Color.LightSteelBlue;
            non.Location = new Point(100, 50);
            non.Name = "non_btn";
            non.Size = new Size(93, 29);
            non.TabIndex = 5;
            non.Text = "Non";
            non.UseVisualStyleBackColor = false;
            non.Click += (s, e) => { dialog.DialogResult = DialogResult.Cancel; dialog.Close(); };
            dialog.Controls.Add(non);

            DialogResult result = dialog.ShowDialog();

            if (result == DialogResult.OK)
            {
                String apiUrl = "http://referentiel.intranet.oma/api/user/" + ListeUtilisateur.SelectedItem.ToString().Split("|")[0];
                using (HttpClient client = new HttpClient())
                {
                    HttpResponseMessage response = client.DeleteAsync(apiUrl).Result;

                    if (response.IsSuccessStatusCode)
                    {
                        ListeUtilisateur.Items.Clear();
                        apiUrl = "http://referentiel.intranet.oma/api/user";
                        using (HttpClient client2 = new HttpClient())
                        {
                            HttpResponseMessage response2 = client2.GetAsync(apiUrl).Result;

                            if (response2.IsSuccessStatusCode)
                            {
                                string apiResponse = response2.Content.ReadAsStringAsync().Result;
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
                    else
                    {
                        InitializeComponent();
                        ListeObjet.Items.Add(response.StatusCode);
                        Console.WriteLine($"Erreur de l'API : {response.StatusCode}");
                    }
                }
            }
        }

        private void ListeEchange_SelectedIndexChanged(object sender, EventArgs e)
        {
            Detail form3 = new Detail(ListeObjet.SelectedItem.ToString().Split("|")[0]);
            form3.Show();
            this.Hide();
        }

        private void label7_Click(object sender, EventArgs e)
        {
            dialog = new Form();
            dialog.Text = "Confirmation deconnexion";
            dialog.Size = new Size(300, 150);

            Label label = new Label();
            label.Text = "Voulez-vous vraiment vous deconnecter?";
            label.AutoSize = true;
            label.Location = new Point(10, 10);
            dialog.Controls.Add(label);
            oui = new System.Windows.Forms.Button();
            oui.BackColor = Color.LightSteelBlue;
            oui.Location = new Point(10, 50);
            oui.Name = "oui_btn";
            oui.Size = new Size(93, 29);
            oui.TabIndex = 5;
            oui.Text = "Oui";
            oui.UseVisualStyleBackColor = false;
            oui.Click += (s, e) => { dialog.DialogResult = DialogResult.OK; dialog.Close(); };
            dialog.Controls.Add(oui);

            non = new System.Windows.Forms.Button();
            non.BackColor = Color.LightSteelBlue;
            non.Location = new Point(100, 50);
            non.Name = "non_btn";
            non.Size = new Size(93, 29);
            non.TabIndex = 5;
            non.Text = "Non";
            non.UseVisualStyleBackColor = false;
            non.Click += (s, e) => { dialog.DialogResult = DialogResult.Cancel; dialog.Close(); };
            dialog.Controls.Add(non);

            DialogResult result = dialog.ShowDialog();

            if (result == DialogResult.OK)
            {
                Connexion form3 = new Connexion();
                form3.Show();
                this.Hide();
            }

        }
    }
}
