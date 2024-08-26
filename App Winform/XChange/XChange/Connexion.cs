namespace XChange

{
    using System;
    using System.Net.Http;
    using System.Text;
    using System.Threading.Tasks;
    public partial class Connexion : Form
    {
        public Connexion()
        {
            InitializeComponent();
        }

        private async void button1_Click(object sender, EventArgs e)
        {
            try
            {
                string apiUrl = "https://xchange-server-rep-latest.onrender.com/api/auth/login";
                //string apiUrl = "http://referentiel.intranet.oma/api/auth/login";
                string email = textBox1.Text; 
                string password = textBox2.Text;

                using (HttpClient client = new HttpClient())
                {
                    var data = "{ \"email\" :\""+ email+"\", \"password\" :\""+password+"\" }";
                    var content = new StringContent(data, Encoding.UTF8, "application/json");

                    HttpResponseMessage response = await client.PostAsync(apiUrl, content);

                    if (response.IsSuccessStatusCode)
                    {
                        string apiResponse = await response.Content.ReadAsStringAsync();
                        Home form2 = new Home(apiResponse.Split("\"token\":")[1].Split("\"")[0]);
                        form2.Show();
                        this.Hide();
                    }
                    else
                    {
                        label4.Text = $"Identifiant ou Mot de passse incorrecte.{response.StatusCode}";
                        label4.ForeColor = Color.Red;
                        Console.WriteLine($"Erreur de l'API : {response.StatusCode}");
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erreur : {ex.Message}");
            }
        }
    }
}
