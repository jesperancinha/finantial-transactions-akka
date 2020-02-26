package org.jesperancinha.portuguese.recipes.bras;

import org.joda.time.DateTime;

public class TaskSimulator {

    public static void waitMilliseconds(String name, long millisecondsTimes10){
        for (int i = 0; i < millisecondsTimes10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s, 1, %s", name, DateTime.now().toString()));
        }
    }
}
