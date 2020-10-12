using System;

namespace gameDoanSo
{
    
    class Program
    {
        static void Main(string[] args)
        {
            Random r = new Random();
            char check;
            do
            {
                int num = r.Next(0, 100);
                int gNum, count = 0;
                do
                {
                    Console.Write("Input guess num: ");
                    gNum = int.Parse(Console.ReadLine());
                    count++;
                    if (gNum > num) Console.WriteLine("guess smaller");
                    if (gNum < num) Console.WriteLine("guess bigger");
                } while (gNum != num && count < 7);
                if (gNum == num) Console.WriteLine("success");
                else Console.WriteLine("fail");
                
                Console.Write("Do you want to try again(y/n)? ");
                check = char.Parse(Console.ReadLine());
            } while (check=='y'||check=='Y');
            Console.Write("Bye");
            Console.ReadLine();
        }
    }
}
