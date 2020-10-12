using System;
using System.Collections;
using System.Collections.Generic;
using System.Dynamic;

namespace Lab1Them_Bai4
{
    class People
    {
        protected string chucVu;
        protected string hoten;
        protected string namSinh;
        protected string bangCap;

        public People()
        {
        }

        public People(string chucVu, string hoten, string namSinh, string bangCap)
        {
            this.chucVu = chucVu;
            this.hoten = hoten;
            this.namSinh = namSinh;
            this.bangCap = bangCap;
        }

        protected string Hoten { get => hoten; set => hoten = value; }
        protected string NamSinh { get => namSinh; set => namSinh = value; }
        protected string BangCap { get => bangCap; set => bangCap = value; }
        protected string ChucVu { get => chucVu; set => chucVu = value; }
        public void display()
        {
            Console.WriteLine($" Ho ten: {Hoten}\n" +
                $" Nam sinh: {NamSinh}\n" +
                $" Bang cap: {BangCap}\n" +
                $" Chuc vu: {ChucVu}\n");
        }
    }
    class NhaKhoaHoc : People
    {
        protected int bacLuong;
        protected int baiBao;
        protected int ngayCong;

        public NhaKhoaHoc()
        {
        }

        public NhaKhoaHoc(string chucVu, string hoten, string namSinh, string bangCap, int baiBao, int ngayCong, int bacLuong)
        {
            this.chucVu = chucVu;
            this.hoten = hoten;
            this.namSinh = namSinh;
            this.bangCap = bangCap;
            this.BaiBao = baiBao;
            this.NgayCong = ngayCong;
            this.BacLuong = bacLuong;
        }

        public int BaiBao { get => baiBao; set => baiBao = value; }
        public int NgayCong { get => ngayCong; set => ngayCong = value; }
        public int BacLuong { get => bacLuong; set => bacLuong = value; }
        
        public void display()
        {
            Console.WriteLine($"NhaKhoaHoc\n");
            base.display();
            Console.WriteLine($" So bai bao: {BaiBao}\n" +
            $" So ngay cong: {NgayCong}\n" +
            $" Bac luong: {BacLuong}\n");
        }

    }

    class NhaQuanLy : People
    {
        protected int ngayCong, bacLuong;

        public NhaQuanLy()
        {
        }

        public NhaQuanLy(string chucVu, string hoten, string namSinh, string bangCap, int ngayCong, int bacLuong)
        {
            this.chucVu = chucVu;
            this.hoten = hoten;
            this.namSinh = namSinh;
            this.bangCap = bangCap;
            this.NgayCong = ngayCong;
            this.BacLuong = bacLuong;
        }

        public int NgayCong { get => ngayCong; set => ngayCong = value; }
        public int BacLuong { get => bacLuong; set => bacLuong = value; }
        public void display()
        {
            Console.WriteLine($"NhaQuanLy\n");
            base.display();
            Console.WriteLine($" So ngay cong: {NgayCong}\n" +
                $" Bac luong: {BacLuong}\n");

        }
    }
    class NVPTN : People
    {
        protected int luong;

        public NVPTN(string chucVu, string hoten, string namSinh, string bangCap, int luong)
        {
            this.chucVu = chucVu;
            this.hoten = hoten;
            this.namSinh = namSinh;
            this.bangCap = bangCap;
            this.Luong = luong;
        }

        public int Luong { get => luong; set => luong = value; }
        public void display()
        {
            Console.WriteLine($"NVPTN\n");
            base.display();
            Console.WriteLine($" Luong: {Luong}\n");
                
        }
    }
    class Program
    {
        List<NhaKhoaHoc> NhaKhoaHoc = new List<NhaKhoaHoc>();
        List<NhaQuanLy> NhaQuanLy = new List<NhaQuanLy>();
        List<NVPTN> NVPTN = new List<NVPTN>();
        public void nhapNV(int nv)
        {


            Console.Write("Nhap ho ten :");
            string hoTen = Console.ReadLine();
            Console.Write("Nhap nam sinh:");
            string namSinh = Console.ReadLine();
            Console.Write("Nhap bang cap:");
            string bangCap = Console.ReadLine();
            string chucVu;
            if (nv == 3)
            {
                chucVu = "NVPTN";
                Console.Write("Nhap Luong: ");
                int luong = int.Parse(Console.ReadLine());
                NVPTN.Add(new NVPTN(chucVu, hoTen, namSinh, bangCap, luong));

            }
            else
            {

                Console.Write("Nhap so ngay cong:");
                int soNgayCong = int.Parse(Console.ReadLine());
                Console.Write("Nhap bac luong:");
                int bacLuong = int.Parse(Console.ReadLine());
                if (nv == 1)
                {
                    chucVu = "NhaKhoaHoc";
                    Console.Write("Nhap so bai bao da cong bo:");
                    int baiBao = int.Parse(Console.ReadLine());
                    NhaKhoaHoc.Add(new NhaKhoaHoc(chucVu, hoTen, namSinh, bangCap, baiBao, soNgayCong, bacLuong));
                }
                else
                {
                    chucVu = "NhaQuanLy";
                    NhaQuanLy.Add(new NhaQuanLy(chucVu, hoTen, namSinh, bangCap, soNgayCong, bacLuong));
                }
            }

        }
        public void input()
        {
            Console.Write("Nhap so nhan vien: ");
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                Console.Write("1. NhaKhoaHoc\n" +
                    "2. NhaQuanLy\n" +
                    "3. NVPTN\n" +
                    "Chon loai nv: ");
                int nv = int.Parse(Console.ReadLine());
                switch (nv)
                {
                    case 1:
                        nhapNV(1);
                        break;
                    case 2:
                        nhapNV(2);
                        break;
                    case 3:
                        nhapNV(3);
                        break;
                }
            }
        }
        public void output()
        {
            Console.WriteLine("------------------------");
            Console.WriteLine("Xuat");
            int luongNKH = 0, luongNQL = 0, luongNVPTN = 0;
            foreach (NhaKhoaHoc a in NhaKhoaHoc)
            {
                a.display();
                luongNKH += a.NgayCong * a.BacLuong;
            }
            Console.WriteLine($"Tong luong nha khoa hoc: {luongNKH}");
            foreach (NhaQuanLy b in NhaQuanLy)
            {
                b.display();
                luongNQL += b.NgayCong * b.BacLuong;
            }
            Console.WriteLine($"Tong luong nha quan ly: {luongNQL}");
            foreach (NVPTN c in NVPTN)
            {
                c.display();
                luongNVPTN += c.Luong;
            }
            Console.WriteLine($"Tong luong nha khoa hoc: {luongNVPTN}");
        }
        static void Main(string[] args)
        {
            Program p = new Program();
            p.input();
            p.output();
        }
    }
}
