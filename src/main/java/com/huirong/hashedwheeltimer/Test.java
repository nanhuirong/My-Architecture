package com.huirong.hashedwheeltimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by huirong on 17-3-10.
 */
public class Test {
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("shabi");
            }
        }, 0, 2000);

        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
