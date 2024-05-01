package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Object> items = new ArrayList<>(1);
        System.out.println("Shall we?");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            // no op
        }

        try {
            while (true) {
                items.add(new Object());
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Hit memory limit!");
            System.out.println(items.size());
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // no op
        }
    }

}
