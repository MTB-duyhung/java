using System;
using System.Collections.Generic;
using System.Linq;

namespace List_ArrayList
{
    class Program
    {
        List<int> listInt = new List<int>();
        private int n;


        public int N { get => n; set => n = value; }
        public List<int> ListInt { get => listInt; set => listInt = value; }

        public void input()
        {
            Console.Write("Nhap list: ");
            string[] chuoi = Console.ReadLine().Split();
            for (int i = 0; i < chuoi.Length; i++)
            {
                listInt.Add(int.Parse(chuoi[i]));
            }
        }
        public void sum()
        {
            for (int i = 0; i < ListInt.Count-1; i++)
            {
                if (ListInt[i] == ListInt[i + 1])
                {
                    ListInt[i] *= 2;
                    ListInt.RemoveAt(i + 1);
                    i = -1;
                }
            }
        }
        public void output()
        {
            Console.WriteLine(string.Join(",", ListInt));
        }
        static void Main(string[] args)
        {
            Program p = new Program();
            p.input();
            p.sum();
            Console.WriteLine("List after sum");
            p.output();
            Console.ReadLine();
        }
    }
}
