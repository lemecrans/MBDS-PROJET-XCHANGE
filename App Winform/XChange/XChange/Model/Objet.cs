using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace XChange.Model
{
    internal class Objet
    {
        public int Id { get; set; }
        public string nom { get; set; }
        public string description { get; set; }
        public int valeur { get; set; }
        public Utilisateur proprietaire { get; set; }
        public bool disponible { get; set; }
    }
}
