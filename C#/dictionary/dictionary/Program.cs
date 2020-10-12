using System;
using System.Collections.Generic;
using System.Linq;

namespace dictionary
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, double> letter = new Dictionary<string, double>();
            Console.Write("Nhap list: ");
            List<string> list = Console.ReadLine().Split().ToList();
            foreach (var item in list)
            {
                if (letter.ContainsKey(item) == true) letter[item]++;
                else letter[item] = 1;
            }
            foreach (var item in letter)
            {
                Console.WriteLine(item.Key + "\t" + item.Value);
            }
        }
    }
}
