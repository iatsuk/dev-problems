package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach obj) {
        int distanceParam = (int) (distance - obj.getDistance());
        int qualityParam = quality - obj.getQuality();
        return 10000 * name.compareTo(obj.getName()) + 100 * distanceParam + qualityParam;
    }

    public static void main(String[] args)
    {
        Beach beach1 = new Beach("beach1", 123.6f, 7);
        Beach beach2 = new Beach("beach2", 124.6f, 8);
        Beach beach3 = new Beach("beach3", 124f, 8);
        System.out.println(beach1.compareTo(beach2));
        System.out.println(beach1.compareTo(beach3));
        System.out.println(beach2.compareTo(beach3));



    }
}