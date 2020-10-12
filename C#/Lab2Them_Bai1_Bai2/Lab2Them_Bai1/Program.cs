using System;

namespace Lab2Them_Bai1_Bai2
{
    class Program
    {
        static void Main(string[] args)
        {
            BookList bl = new BookList();
            bl.InputList();
            bl.SortBook();
            bl.ShowList();
            Console.ReadLine();
        }
    }
}
