using System;
using System.Collections.Generic;

namespace MergingList
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Nhap list 1: ");
            string[] chuoi1 = Console.ReadLine().Split();
            Console.Write("Nhap list 2: ");
            string[] chuoi2 = Console.ReadLine().Split();
            List<int> list = new List<int>();
            if (chuoi1.Length > chuoi2.Length)
            {
                int i;
                for (i = 0; i < chuoi1.Length; i++)
                {
                    list.Add(int.Parse(chuoi1[i]));
                    if (i < chuoi2.Length)
                        list.Add(int.Parse(chuoi2[i]));
                }
            }
            else
            {
                int i;
                for (i = 0; i < chuoi2.Length; i++)
                {
                    list.Add(int.Parse(chuoi2[i]));
                    if (i < chuoi1.Length)
                        list.Add(int.Parse(chuoi1[i]));
                }
            }

            Console.WriteLine("List after sum");
            Console.WriteLine(string.Join(",", list));
        }
    }
}
