using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;

namespace Lab2Them_Bai4
{
    class AccountList
    {
        ArrayList al = new ArrayList();

        public void NewAccount()
        {
            Account a = new Account();
            a = a.FillInfo();
            al.Add(a);
            Console.WriteLine("Add success");
        }
        public void SaveFile()
        {
            Console.Write("Input file name to save: ");
            string filename = Console.ReadLine();
            using (FileStream str = File.Create(filename))
            {
                BinaryFormatter bf = new BinaryFormatter();
                bf.Serialize(str, al);
            }
        }
        public void LoadFile()
        {
            Console.Write("Input file name to load: ");
            string filename = Console.ReadLine();
            al.Clear();
            using (FileStream str = File.OpenRead(filename))
            {
                BinaryFormatter bf = new BinaryFormatter();
                al = (ArrayList)bf.Deserialize(str);
            }
        }
        public void Report()
        {
            Console.WriteLine("- Original:");
            foreach(Account a in al)
                a.Query();
            Console.WriteLine("- Sort By Account ID:");
            al.Sort(new SortById());
            foreach (Account a in al)
                a.Query();
            Console.WriteLine("- Sort By First Name:");
            al.Sort(new SortByFirstName());
            foreach (Account a in al)
                a.Query();
            Console.WriteLine("- Sort By Balamce:");
            al.Sort(new SortByBalance());
            foreach (Account a in al)
                a.Query();
        }
        public Account GetAccountById(string id)
        {
            foreach(Account a in al)
            {
                if (a.AccountID.Equals(id))
                    return a;
            }
            return null;
        }
        public void Remove()
        {
            Console.Write("Input id of remove account: ");
            string id = Console.ReadLine();
            Account acc = GetAccountById(id);
            al.Remove(acc);
            Console.WriteLine("Remove success");
        }
    }

}
