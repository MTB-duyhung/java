using System;

namespace SwitchCase
{
    class Program
    {
        static void Main(string[] args)
        {
            float result=0;
            Console.Write("Input a= ");
            int a = int.Parse(Console.ReadLine());
            Console.Write("Input b= ");
            int b = int.Parse(Console.ReadLine());
            Console.Write("Input op= ");
            char op = char.Parse(Console.ReadLine());
            switch(op){
                case '+': result = a + b;
                    break;
                case '-': result = a - b;
                    break;
                case '*':
                case 'x': result = a * b;
                    break;
                case '/':
                case ':':
                    if (b == 0) Console.WriteLine("b=0 fail");
                    else result = ((float)a / b);
                    break;
            }
            Console.WriteLine($"Result={result}");
            Console.ReadLine();
        }
    }
}
