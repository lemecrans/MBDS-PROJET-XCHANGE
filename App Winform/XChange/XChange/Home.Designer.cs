using System.Windows.Forms.DataVisualization.Charting;

namespace XChange
{
    partial class Home
    {
        private System.ComponentModel.IContainer components = null;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Home));
            panel1 = new Panel();
            label7 = new Label();
            pictureBox2 = new PictureBox();
            pictureBox1 = new PictureBox();
            panel2 = new Panel();
            label2 = new Label();
            tableLayoutPanel1 = new TableLayoutPanel();
            groupBox1 = new GroupBox();
            label12 = new Label();
            label13 = new Label();
            label10 = new Label();
            label11 = new Label();
            label9 = new Label();
            label8 = new Label();
            groupBox2 = new GroupBox();
            ListeObjet = new ListBox();
            groupBox3 = new GroupBox();
            ListeEchange = new ListBox();
            groupBox4 = new GroupBox();
            ListeUtilisateur = new ListBox();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)pictureBox2).BeginInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            panel2.SuspendLayout();
            tableLayoutPanel1.SuspendLayout();
            groupBox1.SuspendLayout();
            groupBox2.SuspendLayout();
            groupBox3.SuspendLayout();
            groupBox4.SuspendLayout();
            SuspendLayout();
            // 
            // panel1
            // 
            panel1.BackColor = SystemColors.ButtonHighlight;
            panel1.Controls.Add(label7);
            panel1.Controls.Add(pictureBox2);
            panel1.Controls.Add(pictureBox1);
            panel1.Location = new Point(12, 0);
            panel1.Name = "panel1";
            panel1.Size = new Size(905, 43);
            panel1.TabIndex = 0;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.ForeColor = Color.Teal;
            label7.Location = new Point(803, 14);
            label7.Name = "label7";
            label7.Size = new Size(88, 15);
            label7.TabIndex = 3;
            label7.Text = "Se deconnecter";
            label7.Click += label7_Click;
            // 
            // pictureBox2
            // 
            pictureBox2.Image = (Image)resources.GetObject("pictureBox2.Image");
            pictureBox2.Location = new Point(764, 0);
            pictureBox2.Name = "pictureBox2";
            pictureBox2.Size = new Size(33, 30);
            pictureBox2.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox2.TabIndex = 1;
            pictureBox2.TabStop = false;
            // 
            // pictureBox1
            // 
            pictureBox1.Image = (Image)resources.GetObject("pictureBox1.Image");
            pictureBox1.Location = new Point(3, 3);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(138, 39);
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox1.TabIndex = 0;
            pictureBox1.TabStop = false;
            // 
            // panel2
            // 
            panel2.BackColor = SystemColors.ButtonHighlight;
            panel2.Controls.Add(label2);
            panel2.Controls.Add(tableLayoutPanel1);
            panel2.Location = new Point(12, 49);
            panel2.Name = "panel2";
            panel2.Size = new Size(905, 478);
            panel2.TabIndex = 1;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 18F, FontStyle.Bold);
            label2.Location = new Point(283, 11);
            label2.Name = "label2";
            label2.Size = new Size(199, 32);
            label2.TabIndex = 1;
            label2.Text = "Tableau de Bord";
            // 
            // tableLayoutPanel1
            // 
            tableLayoutPanel1.CellBorderStyle = TableLayoutPanelCellBorderStyle.InsetDouble;
            tableLayoutPanel1.ColumnCount = 2;
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel1.Controls.Add(groupBox1, 0, 0);
            tableLayoutPanel1.Controls.Add(groupBox2, 1, 0);
            tableLayoutPanel1.Controls.Add(groupBox3, 0, 1);
            tableLayoutPanel1.Controls.Add(groupBox4, 1, 1);
            tableLayoutPanel1.Location = new Point(0, 46);
            tableLayoutPanel1.Name = "tableLayoutPanel1";
            tableLayoutPanel1.RowCount = 2;
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Absolute, 20F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Absolute, 20F));
            tableLayoutPanel1.Size = new Size(905, 428);
            tableLayoutPanel1.TabIndex = 0;
            // 
            // groupBox1
            // 
            groupBox1.Controls.Add(label12);
            groupBox1.Controls.Add(label13);
            groupBox1.Controls.Add(label10);
            groupBox1.Controls.Add(label11);
            groupBox1.Controls.Add(label9);
            groupBox1.Controls.Add(label8);
            groupBox1.Font = new Font("Segoe UI", 12F);
            groupBox1.Location = new Point(6, 6);
            groupBox1.Name = "groupBox1";
            groupBox1.Size = new Size(442, 193);
            groupBox1.TabIndex = 8;
            groupBox1.TabStop = false;
            groupBox1.Text = "Statistique";
            // 
            // label12
            // 
            label12.AutoSize = true;
            label12.Location = new Point(306, 124);
            label12.Name = "label12";
            label12.Size = new Size(89, 21);
            label12.TabIndex = 5;
            label12.Text = "Transaction";
            // 
            // label13
            // 
            label13.AutoSize = true;
            label13.Font = new Font("Segoe UI", 35F);
            label13.ForeColor = Color.Green;
            label13.Location = new Point(318, 72);
            label13.Name = "label13";
            label13.Size = new Size(0, 62);
            label13.TabIndex = 4;
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(165, 124);
            label10.Name = "label10";
            label10.Size = new Size(88, 21);
            label10.TabIndex = 3;
            label10.Text = "Utilisateurs";
            // 
            // label11
            // 
            label11.AutoSize = true;
            label11.Font = new Font("Segoe UI", 35F);
            label11.ForeColor = Color.FromArgb(0, 64, 64);
            label11.Location = new Point(191, 72);
            label11.Name = "label11";
            label11.Size = new Size(0, 62);
            label11.TabIndex = 2;
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Location = new Point(6, 124);
            label9.Name = "label9";
            label9.Size = new Size(118, 21);
            label9.TabIndex = 1;
            label9.Text = "Objets en cours";
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Font = new Font("Segoe UI", 35F);
            label8.ForeColor = Color.FromArgb(0, 192, 192);
            label8.Location = new Point(31, 72);
            label8.Name = "label8";
            label8.Size = new Size(0, 62);
            label8.TabIndex = 0;
            // 
            // groupBox2
            // 
            groupBox2.Controls.Add(ListeObjet);
            groupBox2.Font = new Font("Segoe UI", 12F);
            groupBox2.Location = new Point(457, 6);
            groupBox2.Name = "groupBox2";
            groupBox2.Size = new Size(442, 203);
            groupBox2.TabIndex = 9;
            groupBox2.TabStop = false;
            groupBox2.Text = "Liste Objet";
            // 
            // ListeObjet
            // 
            ListeObjet.Font = new Font("Segoe UI", 12F);
            ListeObjet.ItemHeight = 21;
            ListeObjet.Location = new Point(19, 28);
            ListeObjet.Name = "ListeObjet";
            ListeObjet.Size = new Size(415, 172);
            ListeObjet.TabIndex = 5;
            ListeObjet.SelectedIndexChanged += listBox2_SelectedIndexChanged;
            // 
            // groupBox3
            // 
            groupBox3.Controls.Add(ListeEchange);
            groupBox3.Font = new Font("Segoe UI", 12F);
            groupBox3.Location = new Point(6, 218);
            groupBox3.Name = "groupBox3";
            groupBox3.Size = new Size(442, 201);
            groupBox3.TabIndex = 10;
            groupBox3.TabStop = false;
            groupBox3.Text = "Liste D'échange";
            // 
            // ListeEchange
            // 
            ListeEchange.Font = new Font("Segoe UI", 12F);
            ListeEchange.ItemHeight = 21;
            ListeEchange.Location = new Point(19, 23);
            ListeEchange.Name = "ListeEchange";
            ListeEchange.Size = new Size(417, 172);
            ListeEchange.TabIndex = 7;
            ListeEchange.SelectedIndexChanged += ListeEchange_SelectedIndexChanged;
            // 
            // groupBox4
            // 
            groupBox4.Controls.Add(ListeUtilisateur);
            groupBox4.Font = new Font("Segoe UI", 12F);
            groupBox4.Location = new Point(457, 218);
            groupBox4.Name = "groupBox4";
            groupBox4.Size = new Size(434, 201);
            groupBox4.TabIndex = 11;
            groupBox4.TabStop = false;
            groupBox4.Text = "Liste des Utilisateurs";
            // 
            // ListeUtilisateur
            // 
            ListeUtilisateur.Font = new Font("Segoe UI", 12F);
            ListeUtilisateur.ItemHeight = 21;
            ListeUtilisateur.Location = new Point(19, 23);
            ListeUtilisateur.Name = "ListeUtilisateur";
            ListeUtilisateur.Size = new Size(409, 172);
            ListeUtilisateur.TabIndex = 6;
            ListeUtilisateur.SelectedIndexChanged += ListeUtilisateur_SelectedIndexChanged;
            // 
            // label3
            // 
            label3.Location = new Point(0, 0);
            label3.Name = "label3";
            label3.Size = new Size(100, 23);
            label3.TabIndex = 0;
            // 
            // label4
            // 
            label4.Location = new Point(0, 0);
            label4.Name = "label4";
            label4.Size = new Size(100, 23);
            label4.TabIndex = 0;
            // 
            // label5
            // 
            label5.Location = new Point(0, 0);
            label5.Name = "label5";
            label5.Size = new Size(100, 23);
            label5.TabIndex = 0;
            // 
            // label6
            // 
            label6.Location = new Point(0, 0);
            label6.Name = "label6";
            label6.Size = new Size(100, 23);
            label6.TabIndex = 0;
            // 
            // Home
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(929, 526);
            Controls.Add(panel2);
            Controls.Add(panel1);
            Name = "Home";
            Text = "Form2";
            panel1.ResumeLayout(false);
            panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)pictureBox2).EndInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            panel2.ResumeLayout(false);
            panel2.PerformLayout();
            tableLayoutPanel1.ResumeLayout(false);
            groupBox1.ResumeLayout(false);
            groupBox1.PerformLayout();
            groupBox2.ResumeLayout(false);
            groupBox3.ResumeLayout(false);
            groupBox4.ResumeLayout(false);
            ResumeLayout(false);
        }

        #endregion

        private Panel panel1;
        private PictureBox pictureBox2;
        private PictureBox pictureBox1;
        private Panel panel2;
        private Label label2;
        private TableLayoutPanel tableLayoutPanel1;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private ListBox ListeObjet;
        private ListBox ListeUtilisateur;
        private ListBox ListeEchange;
        private Form dialog;
        private System.Windows.Forms.Button oui;
        private System.Windows.Forms.Button non;
        private Label label7;
        private GroupBox groupBox1;
        private Label label10;
        private Label label11;
        private Label label9;
        private Label label8;
        private GroupBox groupBox2;
        private Label label12;
        private Label label13;
        private GroupBox groupBox3;
        private GroupBox groupBox4;
    }
}