namespace XChange
{
    partial class Detail
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Detail));
            pictureBox1 = new PictureBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            label7 = new Label();
            label8 = new Label();
            label9 = new Label();
            button1 = new Button();
            panel1 = new Panel();
            label11 = new Label();
            label10 = new Label();
            pictureBox2 = new PictureBox();
            pictureBox3 = new PictureBox();
            panel2 = new Panel();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)pictureBox2).BeginInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox3).BeginInit();
            SuspendLayout();
            // 
            // pictureBox1
            // 
            pictureBox1.BackColor = SystemColors.Window;
            pictureBox1.Image = (Image)resources.GetObject("pictureBox1.Image");
            pictureBox1.Location = new Point(458, 140);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(315, 215);
            pictureBox1.TabIndex = 0;
            pictureBox1.TabStop = false;
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.BackColor = SystemColors.Window;
            label1.Font = new Font("Segoe UI", 18F);
            label1.Location = new Point(25, 140);
            label1.Name = "label1";
            label1.Size = new Size(84, 32);
            label1.TabIndex = 1;
            label1.Text = "TITRE :";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.BackColor = SystemColors.Window;
            label2.Font = new Font("Segoe UI", 18F);
            label2.Location = new Point(25, 181);
            label2.Name = "label2";
            label2.Size = new Size(149, 32);
            label2.TabIndex = 2;
            label2.Text = "Propriétaire :";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.BackColor = SystemColors.Window;
            label3.Font = new Font("Segoe UI", 18F);
            label3.Location = new Point(25, 222);
            label3.Name = "label3";
            label3.Size = new Size(88, 32);
            label3.TabIndex = 3;
            label3.Text = "Client :";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI", 14F);
            label4.Location = new Point(180, 147);
            label4.MinimumSize = new Size(180, 0);
            label4.Name = "label4";
            label4.Size = new Size(180, 25);
            label4.TabIndex = 4;
            label4.Text = "Appartement Ambatobe";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Segoe UI", 14F);
            label5.Location = new Point(180, 190);
            label5.MinimumSize = new Size(180, 0);
            label5.Name = "label5";
            label5.Size = new Size(180, 25);
            label5.TabIndex = 5;
            label5.Text = "Rakoto";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Font = new Font("Segoe UI", 14F);
            label6.Location = new Point(180, 231);
            label6.MinimumSize = new Size(180, 0);
            label6.Name = "label6";
            label6.Size = new Size(180, 25);
            label6.TabIndex = 6;
            label6.Text = "Mathieu";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.BackColor = SystemColors.Window;
            label7.Font = new Font("Segoe UI", 20F);
            label7.Location = new Point(297, 79);
            label7.Name = "label7";
            label7.Size = new Size(227, 37);
            label7.TabIndex = 7;
            label7.Text = "Détails d'échange";
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.BackColor = SystemColors.Window;
            label8.Font = new Font("Segoe UI", 18F);
            label8.Location = new Point(25, 287);
            label8.Name = "label8";
            label8.Size = new Size(147, 32);
            label8.TabIndex = 8;
            label8.Text = "Proposition :";
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Font = new Font("Segoe UI", 12F);
            label9.Location = new Point(180, 296);
            label9.MinimumSize = new Size(180, 100);
            label9.Name = "label9";
            label9.Size = new Size(180, 100);
            label9.TabIndex = 9;
            label9.Text = "BMW CR5";
            // 
            // button1
            // 
            button1.Location = new Point(25, 87);
            button1.Name = "button1";
            button1.Size = new Size(75, 23);
            button1.TabIndex = 10;
            button1.Text = "< Retour";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // panel1
            // 
            panel1.BackColor = SystemColors.Window;
            panel1.Controls.Add(label11);
            panel1.Controls.Add(label10);
            panel1.Controls.Add(pictureBox2);
            panel1.Controls.Add(pictureBox3);
            panel1.Location = new Point(9, 2);
            panel1.Name = "panel1";
            panel1.Size = new Size(779, 57);
            panel1.TabIndex = 11;
            // 
            // label11
            // 
            label11.AutoSize = true;
            label11.ForeColor = Color.Teal;
            label11.Location = new Point(688, 24);
            label11.Name = "label11";
            label11.Size = new Size(88, 15);
            label11.TabIndex = 4;
            label11.Text = "Se deconnecter";
            label11.Click += label11_Click;
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Font = new Font("Segoe UI", 12F);
            label10.Location = new Point(565, 18);
            label10.Name = "label10";
            label10.Size = new Size(121, 21);
            label10.TabIndex = 3;
            label10.Text = "vali@gmail.com";
            label10.Click += label10_Click;
            // 
            // pictureBox2
            // 
            pictureBox2.Image = (Image)resources.GetObject("pictureBox2.Image");
            pictureBox2.Location = new Point(526, 10);
            pictureBox2.Name = "pictureBox2";
            pictureBox2.Size = new Size(33, 30);
            pictureBox2.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox2.TabIndex = 2;
            pictureBox2.TabStop = false;
            // 
            // pictureBox3
            // 
            pictureBox3.Image = (Image)resources.GetObject("pictureBox3.Image");
            pictureBox3.Location = new Point(9, 10);
            pictureBox3.Name = "pictureBox3";
            pictureBox3.Size = new Size(138, 39);
            pictureBox3.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox3.TabIndex = 1;
            pictureBox3.TabStop = false;
            // 
            // panel2
            // 
            panel2.BackColor = SystemColors.Window;
            panel2.Location = new Point(9, 73);
            panel2.Name = "panel2";
            panel2.Size = new Size(779, 365);
            panel2.TabIndex = 12;
            // 
            // Detail
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(panel1);
            Controls.Add(button1);
            Controls.Add(label9);
            Controls.Add(label8);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(pictureBox1);
            Controls.Add(panel2);
            Name = "Detail";
            Text = "Det";
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            panel1.ResumeLayout(false);
            panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)pictureBox2).EndInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox3).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private PictureBox pictureBox1;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private Label label7;
        private Label label8;
        private Label label9;
        private Button button1;
        private Panel panel1;
        private Label label10;
        private PictureBox pictureBox2;
        private PictureBox pictureBox3;
        private Panel panel2;
        private Label label11;
        private Form dialog;
        private System.Windows.Forms.Button oui;
        private System.Windows.Forms.Button non;
        private Label label22;
    }
}