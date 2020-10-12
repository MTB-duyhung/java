using System;
using System.Collections;

namespace Lab1Them_bai3
{
    class People
    {
        protected int SID;
        protected string TenSV;

        public People()
        {
        }

        public People(int sID, string tenSV)
        {
            SID = sID;
            TenSV = tenSV;
        }

        public int SID1 { get => SID; set => SID = value; }
        public string TenSV1 { get => TenSV; set => TenSV = value; }
    }
    class Student : People
    {
        protected string Khoa;
        protected float DiemTB;

        public Student()
        {
        }

        public Student(int id, string ten, string kh, float dtb)
        {
            this.SID = id;
            this.TenSV = ten;
            this.Khoa = kh;
            this.DiemTB = dtb;
        }

        public string Khoa1 { get => Khoa; set => Khoa = value; }
        public float DiemTB1 { get => DiemTB; set => DiemTB = value; }
        public void Show()
        {
            Console.WriteLine("MSSV:{0}", this.SID);
            Console.WriteLine("Ten SV:{0}", this.TenSV);
            Console.WriteLine("Khoa:{0}", this.Khoa);
            Console.WriteLine("Diem TB:{0}", this.DiemTB);
        }
    }
    class Tester
    {
        public static void Main()
        {
            ArrayList DSSV=new ArrayList();
            int n;
            Console.Write("Nhap so luong SV:");
            n = int.Parse(Console.ReadLine());
            Console.WriteLine("\n ====NHAP DS SINH VIEN====");
            for (int i = 0; i < n; i++)
            {
                Console.Write("Nhap MaSV {0}:", i + 1);
                int studentID = int.Parse(Console.ReadLine());
                Console.Write("Ho ten SV:");
                String name = Console.ReadLine();
                Console.Write("Nhap khoa:");
               String faculty = Console.ReadLine();
                Console.Write("Nhap Diem TB:");
                float mark = float.Parse(Console.ReadLine());
                DSSV.Add(new Student(studentID, name, faculty, mark));
            }
            Console.WriteLine("\n ====XUAT DS SINH VIEN====");
            foreach (Student sv in DSSV)
                sv.Show();
            Console.ReadLine();
        }
    }
}

