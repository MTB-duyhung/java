using System;

namespace namNhuan
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Nhap nam: ");
            int year = int.Parse(Console.ReadLine());
            if ((year % 400) == 0)
                Console.WriteLine($"{year} la nam nhuan.\n", year);
            else if ((year % 100) == 0)
                Console.WriteLine($"{year} khong phai la nam nhuan.\n", year);
            else if ((year % 4) == 0)
                Console.WriteLine($"{year} la nam nhuan.\n", year);
            else
                Console.WriteLine($"{year} khong phai la nam nhuan.\n", year);

            Console.ReadKey();
        }
    }
}
