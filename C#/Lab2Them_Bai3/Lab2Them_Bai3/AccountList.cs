using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace Lab2Them_Bai3
{
    class AccountList
    {
        ArrayList al = new ArrayList();

        public void NewAccount()
        {
            Account a = new Account();
            a = a.FillInfo();
            al.Add(a);
            
        }
        public void SaveFile()
        {
            Console.Write("Input file name to save: ");
            string filename = Console.ReadLine();
            try
            {
                FileStream output = new FileStream(filename, FileMode.CreateNew, FileAccess.Write);
                StreamWriter write = new StreamWriter(output);
                foreach (Account a in al)
                {
                    write.WriteLine("{0},{1},{2},{3}",a.AccountID,a.FirstName,a.LastName,a.Balance);
                }
                write.Close();
                output.Close();
            }catch(IOException e)
            {
                Console.WriteLine(e.Message);
            }
        }
        public void LoadFile()
        {
            Console.Write("Input file name to load: ");
            string filename = Console.ReadLine();
            al.Clear();
            try
            {
                FileStream input = new FileStream(filename, FileMode.Open, FileAccess.Read);
                StreamReader reader = new StreamReader(input);
                string str;
                while((str=reader.ReadLine())!=null)
                {
                    string[] list = str.Split(',');
                    Account a = new Account(list[0], list[1], list[2], float.Parse(list[3]));
                    al.Add(a);
                }
                
                reader.Close();
                input.Close();
            }
            catch (IOException e)
            {
                Console.WriteLine(e.Message);
            }
        }
        public void Report()
        {
            foreach(Account a in al)
            {
                a.Query();
            }
        }
    }

}
