using System;
using System.Collections;
using System.Security.Cryptography.X509Certificates;

namespace OOP_Person
{
    class Point
    {
        private double x;
        private double y;

        public Point(double x, double y)
        {
            this.y = y;
            this.x = x;
        }

        public double X { get => x; set => x = value; }
        public double Y { get => y; set => y = value; }
        public void addPoint(double a, double b)
        {

        }
        public string ToString()
        {
            return $"Point({X},{Y})";
        }
    }
    abstract class Shape
    {
        private Point p;

        protected Shape(Point p)
        {
            this.p = p;
        }

        internal Point P { get => p; set => p = value; }

        public void move(int newx, int newy)
        {
            p.X += newx;
            p.Y += newy;
            Console.WriteLine("After move");
        }
        public abstract void Show();
    }

    class Lines : Shape
    {
        private Point p2;

        public Lines(Point p, Point p2) : base(p)
        {
            this.p2 = p2;
        }

        internal Point P2 { get => p2; set => p2 = value; }

        public override void Show()
        {
            Console.WriteLine($"This is a line with 2 points are {P.ToString()} and {P2.ToString()}");
        }
    }
    class Circles : Shape
    {
        private double r;

        public Circles(double r, Point p) : base(p)
        {
            this.r = r;
        }

        public double R { get => r; set => r = value; }

        public override void Show()
        {
            Console.WriteLine($"This is a circles with center is {P.ToString()} and radius is {R}");
        }
    }
    class Rectangle : Shape
    {
        private double d, r;


        public Rectangle(double d, double r, Point p) : base(p)
        {
            this.d = d;
            this.r = r;
        }

        public double D { get => d; set => d = value; }
        public double R { get => r; set => r = value; }

        public override void Show()
        {
            Point p2 = new Point(P.X + d, P.Y);
            Point p3 = new Point(P.X, P.Y + r);
            Console.WriteLine($"This is a rectangle with 3 points are {P.ToString()}, {p2.ToString()} and {p3.ToString()}");
        }
    }
    class PolyLine : Shape
    {
        ArrayList ls = new ArrayList();

        public PolyLine(Point p) : base(p)
        {
            ls.Add(p);
        }

        public ArrayList Ls { get => ls; set => ls = value; }
        public void addPoint(Point p)
        {
            ls.Add(p);
        }
        public override void Show()
        {
            Console.WriteLine("This is a polyline with points:\n");
            foreach (Point point in ls)
            {
                Console.Write($"{point.ToString()}\n");
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {

            Lines l = new Lines(new Point(0, 0), new Point(1, 1));
            l.Show();
            l.move(100, 100);
            l.Show();
            Console.WriteLine("---------------------------");
            Circles c = new Circles(2, new Point(2, 2));
            c.R = 2.3;
            c.Show();
            c.move(100, 100);
            c.Show();
            Console.WriteLine("---------------------------");
            Rectangle r = new Rectangle(2, 3, new Point(2, 2));
            r.Show();
            r.move(100, 100);
            r.Show();
            Console.WriteLine("---------------------------");
            PolyLine p = new PolyLine(new Point(5, 5));
            p.addPoint(new Point(4, 2));
            p.addPoint(new Point(1, 2));
            p.addPoint(new Point(5, 7));
            p.addPoint(new Point(6, 3));
            p.Show();
            p.move(100, 100);
            p.Show();
        }
    }
}
