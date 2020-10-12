using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Text;

namespace Lab2Them_Bai4
{
    class SortById : IComparer
    {
        public int Compare(Object x, Object y)
        {
            Account a1 = x as Account;
            Account a2 = y as Account;
            return a1.AccountID.CompareTo(a2.AccountID);
        }
    }
    class SortByFirstName : IComparer
    {
        public int Compare(Object x, Object y)
        {
            Account a1 = x as Account;
            Account a2 = y as Account;
            return a1.FirstName.CompareTo(a2.FirstName);
        }
    }
    class SortByBalance : IComparer
    {
        public int Compare(Object x, Object y)
        {
            Account a1 = x as Account;
            Account a2 = y as Account;
            return a1.Balance.CompareTo(a2.Balance);
        }
    }
}
