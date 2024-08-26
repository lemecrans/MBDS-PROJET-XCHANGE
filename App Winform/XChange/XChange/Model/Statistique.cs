using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace XChange.Model
{
    internal class Statistique
    {
        public String label;
        public int value;

        public int getValue()
        {
            return value;
        }
        public String getLabel()
        {
            return label;
        }
    }
}
