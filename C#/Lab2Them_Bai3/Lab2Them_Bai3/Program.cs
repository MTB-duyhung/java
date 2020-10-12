using System;

namespace Lab2Them_Bai3
{
    class Program
    {
        static void Main(string[] args)
        {
            AccountList list = new AccountList();
            int choice;
            do
            {
                
                Console.WriteLine("-------------");
                Console.WriteLine("1. Add");
                Console.WriteLine("2. Save");
                Console.WriteLine("3. Load");
                Console.WriteLine("4. Report");
                Console.WriteLine("5. Exit");
                Console.Write("Enter your choice: ");

                choice = int.Parse(Console.ReadLine());
                switch (choice)
                {
                    case 1:
                        list.NewAccount();//add
                        break;
                    case 2:
                        list.SaveFile();//save
                        break;
                    case 3:
                        list.LoadFile();//load
                        break;
                    case 4:
                        list.Report();//report
                        break;
                }
            } while (choice < 5 && choice > 0);
            Console.ReadLine();
        }
    }
}
