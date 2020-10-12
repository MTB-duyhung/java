using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Text;

namespace SortList
{
    class SortMa : IComparer<Student>
    {
        public int Compare([AllowNull] Student x, [AllowNull] Student y)
        {
            if (x == null || y == null)
                throw new NotImplementedException();
            else
            {
                if (x.Ma.CompareTo(y.Ma) == 1) return -1;
                else if (x.Ma.CompareTo(y.Ma) == -1) return 1;
                else return 0;
            }
        }

    }
}
