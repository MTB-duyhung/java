using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Text;

namespace SortList
{
    class Student : IComparable<Student>
    {
        private int ma;
        private string ten;
        private float diemTB;

        public Student(int ma, string ten, float diemTB)
        {
            this.ma = ma;
            this.ten = ten;
            this.diemTB = diemTB;
        }

        public int Ma { get => ma; set => ma = value; }
        public string Ten { get => ten; set => ten = value; }
        public float DiemTB { get => diemTB; set => diemTB = value; }

        public int CompareTo([AllowNull] Student other)
        {
            if (DiemTB > other.DiemTB) return -1;
            else if (DiemTB < other.DiemTB) return 1;
            else return 0;
        }

        public void ToString()
        {
            Console.WriteLine(Ma + "\t" + Ten + "\t" + DiemTB);
        }
    }
    class SortTen : IComparer<Student>
    {
        public SortTen() { }
        public int Compare(Student x, Student y)
        {
            if (x == null || y == null)
                throw new NotImplementedException();
            else
            {
                if (x.Ten.CompareTo(y.Ten) == 1) return -1;
                else if (x.Ten.CompareTo(y.Ten) == -1) return 1;
                else return 0;
            }
        }
    }
}
