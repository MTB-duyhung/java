using System;

namespace tong
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Input n=");
            int n = int.Parse(Console.ReadLine());
            float s=1;
            for (int i = 2; i <= n; i++)
            {
                s += 1 / (float)i;
            }
            Console.WriteLine($"tong = {s}");
            Console.ReadLine();
        }
    }
}
