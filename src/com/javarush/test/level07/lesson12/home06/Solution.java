package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human grandPa1 = new Human("gp1", true, 74, null, null);
        Human grandPa2 = new Human("gp2", true, 72, null, null);
        Human grandMa1 = new Human("gm1", false, 76, null, null);
        Human grandMa2 = new Human("gm2", false, 78, null, null);
        Human fath = new Human("fa", true, 47, grandPa1, grandMa1);
        Human moth = new Human("mo", true, 44, grandPa2, grandMa2);
        Human chi1 = new Human("c1", true, 12, fath, moth);
        Human chi2 = new Human("c2", false, 8, fath, moth);
        Human chi3 = new Human("c3", false, 4, fath, moth);

        System.out.println(grandPa1);
        System.out.println(grandPa2);
        System.out.println(grandMa1);
        System.out.println(grandMa2);
        System.out.println(fath);
        System.out.println(moth);
        System.out.println(chi1);
        System.out.println(chi2);
        System.out.println(chi3);

    }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
