using System;
using System.Collections.Generic;

namespace GaussTrick
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Nhap list: ");
            string[] chuoi = Console.ReadLine().Split();
            List<int> listInt = new List<int>();
            for (int i = 0; i < chuoi.Length; i++)
            {
                listInt.Add(int.Parse(chuoi[i]));
            }
            int length = listInt.Count;
            for (int i = 0; i < length / 2; i++)
            {
                /*Console.WriteLine($"---i={i} and count={listInt.Count}");*/
                listInt[i] += listInt[listInt.Count - 1];
                listInt.RemoveAt(listInt.Count - 1);
                /* Console.WriteLine(string.Join(",", listInt));*/
            }
            Console.WriteLine("List after sum");
            Console.WriteLine(string.Join(",", listInt));
        }
    }
}
