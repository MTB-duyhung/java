using System;
using System.Collections.Generic;
using System.Text;

namespace Lab2Them_Bai3
{
    class Account
    {
        private string accountID, firstName, lastName;
        private float balance;
        public Account() { }
        public Account(string accountID, string firstName, string lastName, float balance)
        {
            this.accountID = accountID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.balance = balance;
        }

        public string AccountID { get => accountID; set => accountID = value; }
        public string FirstName { get => firstName; set => firstName = value; }
        public string LastName { get => lastName; set => lastName = value; }
        public float Balance { get => balance; set => balance = value; }
    
        public Account FillInfo()//input new account
        {
            Console.Write("Account ID: ");
            accountID = Console.ReadLine();
            Console.Write("First Name: ");
            firstName = Console.ReadLine();
            Console.Write("Last Name: ");
            lastName = Console.ReadLine();
            Console.Write("Balance: ");
            balance = float.Parse(Console.ReadLine());
            return new Account(accountID, firstName, lastName, balance);
        }
        public void Query()//ToString
        {
            Console.WriteLine($"Account: \n" +
                $"\tAccount ID: {accountID}\n" +
                $"\tFirst Name: {firstName}\n" +
                $"\tLast Name: {lastName}\n" +
                $"\tBalance: {balance}");
        }
    }
}
