using System;

namespace xuLyChuoi
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Nhap chuoi: ");
            String s = Console.ReadLine();
            int hoa=0, thuong=0, so=0, khoang=0;
            for (int i = 0; i < s.Length; i++)
            {
                if (s[i] >= 'A' && s[i] <= 'Z') hoa++;
                if (s[i] >= 'a' && s[i] <= 'z') thuong++;
                if (s[i] >= '0' && s[i] <= '9') so++;
                if (s[i] ==' ') khoang++;
            }
            Console.Write($"Co {hoa} ky tu Hoa\n" +
                $"Co {thuong} ky tu thuong\n" +
                $"Co {so} ky tu so\n" +
                $"Co {khoang} ky tu khoang trang");
            Console.ReadLine();
        }
    }
}
