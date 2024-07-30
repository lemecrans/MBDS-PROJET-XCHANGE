namespace XChange

{
    using System;
    using System.Net.Http;
    using System.Text;
    using System.Threading.Tasks;
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void tableLayoutPanel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private async void button1_Click(object sender, EventArgs e)
        {
            try
            {
                string apiUrl = "http://referentiel.intranet.oma/api/auth/login";
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
                        Form2 form2 = new Form2();
                        form2.Show();
                        this.Hide();
                    }
                    else
                    {
                        label4.Text = "Identifiant ou Mot de passse incorrecte.";
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
