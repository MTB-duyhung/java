using System;
using System.Security.Cryptography.X509Certificates;

namespace Lab1_Bai1
{
    abstract class Animal
    {
        private String type;

        protected Animal(string type)
        {
            this.type = type;
        }

        public string Type { get => type; set => type = value; }

        abstract public String getInformation();
        abstract public String getSound();
        abstract public String ToString();
    }
    class Dog : Animal
    {
        private String name, breed;

        public Dog(string name, string breed, String type):base(type)
        {
            this.name = name;
            this.breed = breed;
        }

        public string Name { get => name; set => name = value; }
        public string Breed { get => breed; set => breed = value; }

        public override string getInformation()
        {
            return "have 4 leg and loyal to the owner";
        }

        public override string getSound()
        {
            return "woof,woof";
        }
        
        public override String ToString()
        {
            return $"Dog: is {Type}, name is {Name}, breed is {Breed}, {getInformation()}, and sound is {getSound()}";
        }
    }

    class Cat : Animal
    {
        private String name;

        public string Name { get => name; set => name = value; }

        public Cat(String name, String type) : base(type)
        {
            this.name = name;
        }

        public override string getInformation()
        {
            return "have 4 leg and very painful pawns";
        }

        public override string getSound()
        {
            return "meow, meow";
        }

        public string Climb()
        {
            return "is climbing tree";
        }

        public override String ToString()
        {
            return $"Cat: is {Type}, name is {Name}, {getInformation()}, sound is {getSound()} and {Climb()}";
        }
    }

    class Duck : Animal
    {
        private String name;
        public Duck(String name, String type) : base(type)
        {
            this.name = name;
        }

        public string Name { get => name; set => name = value; }

        public override string getInformation()
        {
            return "have 2 leg and wings";
        }

        public override string getSound()
        {
            return "quack, quack";
        }

        public string Swim()
        {
            return "is swimming in the pool";
        }

        public override String ToString()
        {
            return $"Duck: is {Type}, name is {Name}, {getInformation()}, sound is {getSound()} and {Swim()}";
        }
    }

    class Animals
    {
        static void Main(string[] args)
        {
            Dog dog = new Dog("Ki", "Chihuahua","mammal");
            Cat cat = new Cat("May", "mammal");
            Duck duck = new Duck("Vit","bird");
            Console.WriteLine(dog.ToString());
            Console.WriteLine(cat.ToString());
            Console.WriteLine(duck.ToString());
            Console.ReadLine();
        }
    }
}