using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace Lab2Them_Bai1_Bai2
{
    class Book : IBook
    {
        #region
        private string isbn, title, author, publisher;
        private int year;
        private ArrayList chapter = new ArrayList();
        #endregion
        public string this[int index]
        {
            get
            {
                if (index >= 0 && index < chapter.Count)
                    return (string)chapter[index];
                else
                    throw new NotImplementedException();
            }
            set
            {
                if (index >= 0 && index < chapter.Count)
                    chapter[index] = value;
                else if (index == chapter.Count)
                    chapter.Add(value);
                else
                    throw new NotImplementedException();
            }
        }

        public string Title { get => title; set => title = value; }
        public string Author { get => author; set => author = value; }
        public string Publisher { get => publisher; set => publisher = value; }
        public string ISBN { get => isbn; set => isbn = value; }
        public int Year { get => year; set => year = value; }

        public void Show()
        {
            Console.WriteLine("-------------------");
            Console.WriteLine("Title: " + title);
            Console.WriteLine("Author: " + author);
            Console.WriteLine("Publisher: " + publisher);
            Console.WriteLine("Year: " + year);
            Console.WriteLine("ISBN: " + isbn);
            Console.WriteLine("Chapter: ");
            for (int i = 0; i < chapter.Count; i++)
            {
                Console.WriteLine($"\t{i + 1}: {chapter[i]}");
            }
            Console.WriteLine("-------------------");
        }
        public void Input()
        {
            Console.Write("Title: ");
            title = Console.ReadLine();
            Console.Write("Author: ");
            author = Console.ReadLine();
            Console.Write("Publisher: ");
            publisher = Console.ReadLine();
            Console.Write("Year: ");
            year = int.Parse(Console.ReadLine());
            Console.WriteLine("Input chapter (finished with empty string)");
            string str;
            do
            {
                str = Console.ReadLine();
                if (str.Length > 0)
                    chapter.Add(str);
            } while (str.Length > 0);
        }
    }
}