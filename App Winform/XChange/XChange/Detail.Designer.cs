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
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            SuspendLayout();
            // 
            // pictureBox1
            // 
            pictureBox1.Image = (Image)resources.GetObject("pictureBox1.Image");
            pictureBox1.Location = new Point(458, 87);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(315, 215);
            pictureBox1.TabIndex = 0;
            pictureBox1.TabStop = false;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 18F);
            label1.Location = new Point(25, 87);
            label1.Name = "label1";
            label1.Size = new Size(84, 32);
            label1.TabIndex = 1;
            label1.Text = "TITRE :";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 18F);
            label2.Location = new Point(25, 128);
            label2.Name = "label2";
            label2.Size = new Size(149, 32);
            label2.TabIndex = 2;
            label2.Text = "Propriétaire :";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 18F);
            label3.Location = new Point(25, 169);
            label3.Name = "label3";
            label3.Size = new Size(92, 32);
            label3.TabIndex = 3;
            label3.Text = "Valeur :";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI", 14F);
            label4.Location = new Point(180, 94);
            label4.MinimumSize = new Size(180, 0);
            label4.Name = "label4";
            label4.Size = new Size(180, 25);
            label4.TabIndex = 4;
            label4.Text = " ";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Segoe UI", 14F);
            label5.Location = new Point(180, 137);
            label5.MinimumSize = new Size(180, 0);
            label5.Name = "label5";
            label5.Size = new Size(180, 25);
            label5.TabIndex = 5;
            label5.Text = " ";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Font = new Font("Segoe UI", 14F);
            label6.Location = new Point(180, 178);
            label6.MinimumSize = new Size(180, 0);
            label6.Name = "label6";
            label6.Size = new Size(180, 25);
            label6.TabIndex = 6;
            label6.Text = " ";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Font = new Font("Segoe UI", 20F);
            label7.Location = new Point(319, 20);
            label7.Name = "label7";
            label7.Size = new Size(98, 37);
            label7.TabIndex = 7;
            label7.Text = "Détails";
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Font = new Font("Segoe UI", 18F);
            label8.Location = new Point(25, 234);
            label8.Name = "label8";
            label8.Size = new Size(147, 32);
            label8.TabIndex = 8;
            label8.Text = "Description :";
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Font = new Font("Segoe UI", 12F);
            label9.Location = new Point(180, 243);
            label9.MinimumSize = new Size(180, 100);
            label9.Name = "label9";
            label9.Size = new Size(180, 100);
            label9.TabIndex = 9;
            label9.Text = " ";
            // 
            // button1
            // 
            button1.Location = new Point(25, 34);
            button1.Name = "button1";
            button1.Size = new Size(75, 23);
            button1.TabIndex = 10;
            button1.Text = "< Retour";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // Detail
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
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
            Name = "Detail";
            Text = "Det";
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
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
    }
}