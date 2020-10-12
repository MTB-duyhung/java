using System;

class MainClass
{
    int a, b, c;
    public void input()
    {
        Console.Write("Input a=");
        a = int.Parse(Console.ReadLine());
        Console.Write("Input b=");
        b = int.Parse(Console.ReadLine());
        Console.Write("Input c=");
        c = int.Parse(Console.ReadLine());
    }
    public void output()
    {
        if (a == 0)
        {
            Console.WriteLine($"PT: {b}x+{c}=0");
            if (b == 0)
            {
                if (c == 0) Console.WriteLine("PTVSN");
                else Console.WriteLine("PTVN");
            }
            else
            {
                float x = -c / (float)b;
                Console.WriteLine($"pt co nghiem x={x}");
            }
        }
        else
        {
            Console.WriteLine($"PT: {a}x^2+{b}x+{c}=0");
            float delta = b * b - 4 * a * c;
            if (delta < 0) Console.WriteLine("PTVN");
            else if (delta == 0) Console.WriteLine($"PT co nghiem kep x1=x2={(-b / (float)(2 * a))}");
            else Console.WriteLine($"PT co 2 nghiem x1={((-b - Math.Sqrt(delta)) / (float)(2 * a))} va x2={((-b + Math.Sqrt(delta)) / (float)(2 * a))}");
        }
    }
    public static void Main(string[] args)
    {
        MainClass m = new MainClass();
        m.input();
        m.output();
        Console.ReadLine();

    }
}