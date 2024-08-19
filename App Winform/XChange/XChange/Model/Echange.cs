using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace XChange.Model
{
    internal class Echange
    {
        public int Id { get; set; }
        public Utilisateur Proposant { get; set; }
        public Utilisateur Destinataire { get; set; }
        public string DateProposition { get; set; }
        public double Latitude { get; set; }
        public double Longitude { get; set; }
        public string Etat { get; set; }
        public List<Objet> ObjetsEchanges { get; set; }
    }
}
