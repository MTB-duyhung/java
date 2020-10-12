using System;
using System.Collections.Generic;

namespace SortList
{
    class Program
    {

        static void Main(string[] args)
        {
            List<Student> LStudent = new List<Student>();
            LStudent.Add(new Student(1, "Binh", 8.6f));
            LStudent.Add(new Student(2, "An", 8.3f));
            LStudent.Add(new Student(3, "Nam", 9.6f));
            Console.WriteLine("sort diem");
            LStudent.Sort();
            foreach (var item in LStudent)
                item.ToString();
            Console.WriteLine("sort ma");
            LStudent.Sort(new SortMa());
            foreach (var item in LStudent)
                item.ToString();
            Console.WriteLine("sort name");
            LStudent.Sort(new SortTen());
            foreach (var item in LStudent)
                item.ToString();
        }
    }
}
