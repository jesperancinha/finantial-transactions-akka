package org.jesperancinha.portuguese.recipes.bras;

import org.joda.time.DateTime;

public class TaskSimulator {

    public static void waitMilliseconds(String name, long milliseconds){
        System.out.println(String.format("%s, 1, %s", name, DateTime.now().toString()));
        for (int i = 0; i < milliseconds; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s, 1, %s", name, DateTime.now().toString()));
        }
    }
}
