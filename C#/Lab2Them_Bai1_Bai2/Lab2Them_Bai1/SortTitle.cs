using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Text;

namespace Lab2Them_Bai1_Bai2
{
    class SortTitle : IComparer
    {
        //public int Compare(object x, Book y)
        //{
        //    if (x == null || y == null)
        //        throw new NotImplementedException();
        //    else
        //    {
        //        return x.Title.CompareTo(y.Title);
        //    }
        //}

        public int Compare(object x, object y)
        {
            Book b1 = x as Book;
            Book b2=y as Book;
            if (b1 == null || b2 == null)
                throw new NotImplementedException();
            else
                return b1.Title.CompareTo(b2.Title);
        }
    }
}
