package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human child1 = new Human("c1", true, 4);
        Human child2 = new Human("c2", true, 8);
        Human child3 = new Human("c3", false,12);
        Human father = new Human("fa", true, 48);
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);
        Human mother = new Human("ma", false,46);
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);

        Human grandpa1 = new Human("p1", true, 72);
        grandpa1.children.add(father);

        Human grandpa2 = new Human("p2", true, 70);
        grandpa2.children.add(mother);

        Human grandma1 = new Human("m1", false, 68);
        grandma1.children.add(father);

        Human grandma2 = new Human("m2", false, 66);
        grandma2.children.add(mother);

        System.out.println(grandpa1);
        System.out.println(grandpa2);
        System.out.println(grandma1);
        System.out.println(grandma2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
