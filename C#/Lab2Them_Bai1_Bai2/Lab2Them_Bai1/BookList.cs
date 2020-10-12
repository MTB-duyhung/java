using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace Lab2Them_Bai1_Bai2
{
    class BookList
    {
        private ArrayList list = new ArrayList();
        public void AddBook()
        {
            Book b = new Book();
            b.Input();
            list.Add(b);
        }
        public void ShowList()
        {
            foreach (Book b in list)
                b.Show();
        }
        public void InputList()
        {
            int n;
            Console.Write("Amount of books: ");
            n = int.Parse(Console.ReadLine());
            while (n > 0)
            {
                AddBook();
                n--;
            }
        }
        public void SortBook()
        {
            SortTitle s = new SortTitle();
            list.Sort(s);
        }
    }
}
