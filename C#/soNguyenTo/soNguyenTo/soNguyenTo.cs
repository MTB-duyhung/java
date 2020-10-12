using System;

namespace soNguyenTo
{
    class Program
    {
        static void Main(string[] args)
        {
            int n, flag=0;
            do
            {
                Console.Write("n=");
                n = int.Parse(Console.ReadLine());
            } while (n < 2);
            for (int i = 2; i <= Math.Sqrt(n); i++)
            {
                if ((n % i) == 0)
                {
                    Console.WriteLine("Khong phai so nguyen to");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) Console.WriteLine("so nguyen to");
            Console.ReadLine();
        }
    }
}
