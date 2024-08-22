namespace XChange
{
    partial class FormObjet
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormObjet));
            panel1 = new Panel();
            label11 = new Label();
            label1 = new Label();
            pictureBox2 = new PictureBox();
            pictureBox1 = new PictureBox();
            panel2 = new Panel();
            button3 = new Button();
            button2 = new Button();
            label8 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            button1 = new Button();
            textBox4 = new TextBox();
            textBox3 = new TextBox();
            textBox2 = new TextBox();
            textBox1 = new TextBox();
            label2 = new Label();
            panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)pictureBox2).BeginInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            panel2.SuspendLayout();
            SuspendLayout();
            // 
            // panel1
            // 
            panel1.BackColor = SystemColors.Window;
            panel1.Controls.Add(label11);
            panel1.Controls.Add(label1);
            panel1.Controls.Add(pictureBox2);
            panel1.Controls.Add(pictureBox1);
            panel1.Location = new Point(3, 2);
            panel1.Name = "panel1";
            panel1.Size = new Size(779, 57);
            panel1.TabIndex = 0;
            // 
            // label11
            // 
            label11.AutoSize = true;
            label11.ForeColor = Color.Teal;
            label11.Location = new Point(677, 24);
            label11.Name = "label11";
            label11.Size = new Size(88, 15);
            label11.TabIndex = 5;
            label11.Text = "Se deconnecter";
            label11.Click += label11_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 12F);
            label1.Location = new Point(612, 19);
            label1.Name = "label1";
            label1.Size = new Size(59, 21);
            label1.TabIndex = 3;
            label1.Text = "Rakoto";
            // 
            // pictureBox2
            // 
            pictureBox2.Image = (Image)resources.GetObject("pictureBox2.Image");
            pictureBox2.Location = new Point(573, 10);
            pictureBox2.Name = "pictureBox2";
            pictureBox2.Size = new Size(33, 30);
            pictureBox2.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox2.TabIndex = 2;
            pictureBox2.TabStop = false;
            // 
            // pictureBox1
            // 
            pictureBox1.Image = (Image)resources.GetObject("pictureBox1.Image");
            pictureBox1.Location = new Point(9, 10);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(138, 39);
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox1.TabIndex = 1;
            pictureBox1.TabStop = false;
            // 
            // panel2
            // 
            panel2.BackColor = SystemColors.Window;
            panel2.Controls.Add(button3);
            panel2.Controls.Add(button2);
            panel2.Controls.Add(label8);
            panel2.Controls.Add(label3);
            panel2.Controls.Add(label4);
            panel2.Controls.Add(label5);
            panel2.Controls.Add(button1);
            panel2.Controls.Add(textBox4);
            panel2.Controls.Add(textBox3);
            panel2.Controls.Add(textBox2);
            panel2.Controls.Add(textBox1);
            panel2.Controls.Add(label2);
            panel2.Location = new Point(52, 80);
            panel2.Name = "panel2";
            panel2.Size = new Size(677, 358);
            panel2.TabIndex = 1;
            // 
            // button3
            // 
            button3.Location = new Point(33, 17);
            button3.Name = "button3";
            button3.Size = new Size(75, 23);
            button3.TabIndex = 14;
            button3.Text = "< Retour";
            button3.UseVisualStyleBackColor = true;
            button3.Click += button3_Click;
            // 
            // button2
            // 
            button2.BackColor = Color.LightSeaGreen;
            button2.Location = new Point(359, 299);
            button2.Name = "button2";
            button2.Size = new Size(134, 43);
            button2.TabIndex = 13;
            button2.Text = "Modifier";
            button2.UseVisualStyleBackColor = false;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Font = new Font("Segoe UI", 18F);
            label8.Location = new Point(128, 227);
            label8.Name = "label8";
            label8.Size = new Size(147, 32);
            label8.TabIndex = 12;
            label8.Text = "Description :";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 18F);
            label3.Location = new Point(128, 185);
            label3.Name = "label3";
            label3.Size = new Size(92, 32);
            label3.TabIndex = 11;
            label3.Text = "Valeur :";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI", 18F);
            label4.Location = new Point(128, 141);
            label4.Name = "label4";
            label4.Size = new Size(149, 32);
            label4.TabIndex = 10;
            label4.Text = "Propriétaire :";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Segoe UI", 18F);
            label5.Location = new Point(128, 103);
            label5.Name = "label5";
            label5.Size = new Size(84, 32);
            label5.TabIndex = 9;
            label5.Text = "TITRE :";
            // 
            // button1
            // 
            button1.BackColor = Color.Red;
            button1.Location = new Point(141, 299);
            button1.Name = "button1";
            button1.Size = new Size(134, 43);
            button1.TabIndex = 6;
            button1.Text = "Suprimer";
            button1.UseVisualStyleBackColor = false;
            // 
            // textBox4
            // 
            textBox4.Font = new Font("Segoe UI", 11F);
            textBox4.Location = new Point(314, 232);
            textBox4.Name = "textBox4";
            textBox4.Size = new Size(201, 27);
            textBox4.TabIndex = 4;
            textBox4.Text = "-";
            // 
            // textBox3
            // 
            textBox3.Font = new Font("Segoe UI", 11F);
            textBox3.Location = new Point(314, 190);
            textBox3.Name = "textBox3";
            textBox3.Size = new Size(201, 27);
            textBox3.TabIndex = 3;
            textBox3.Text = "-";
            // 
            // textBox2
            // 
            textBox2.Font = new Font("Segoe UI", 11F);
            textBox2.Location = new Point(314, 146);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(201, 27);
            textBox2.TabIndex = 2;
            textBox2.Text = "-";
            // 
            // textBox1
            // 
            textBox1.Font = new Font("Segoe UI", 11F);
            textBox1.Location = new Point(314, 103);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(201, 27);
            textBox1.TabIndex = 1;
            textBox1.Text = "-";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 14F);
            label2.Location = new Point(260, 13);
            label2.Name = "label2";
            label2.Size = new Size(170, 25);
            label2.TabIndex = 0;
            label2.Text = "Modification Objet";
            // 
            // FormObjet
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(785, 450);
            Controls.Add(panel2);
            Controls.Add(panel1);
            Name = "FormObjet";
            Text = "FormUtilisateur";
            panel1.ResumeLayout(false);
            panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)pictureBox2).EndInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            panel2.ResumeLayout(false);
            panel2.PerformLayout();
            ResumeLayout(false);
        }

        #endregion

        private Panel panel1;
        private PictureBox pictureBox1;
        private PictureBox pictureBox2;
        private Label label1;
        private Panel panel2;
        private Label label2;
        private Button button1;
        private TextBox textBox4;
        private TextBox textBox3;
        private TextBox textBox2;
        private TextBox textBox1;
        private Label label8;
        private Label label3;
        private Label label4;
        private Label label5;
        private Button button2;
        private Button button3;
        private Form dialog;
        private System.Windows.Forms.Button oui;
        private System.Windows.Forms.Button non;
        private Label label7;
        private Label label11;
    }
}