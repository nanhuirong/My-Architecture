package com.huirong.hashedwheeltimer;

import com.huirong.hashedwheeltimer.structure.MyStructure;
import com.huirong.hashedwheeltimer.structure.MyTask;
import com.huirong.hashedwheeltimer.task.MyTimerTask;
import com.huirong.hashedwheeltimer.timer.MyTimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by huirong on 17-3-10.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        MyStructure structure = new MyStructure();
        MyTimer timer = new MyTimer();
        MyTimerTask timerTask = new MyTimerTask(structure);
        timer.schedule(timerTask, 30000, 1000);
        //生产数据
        while (true){
            Long uid = new Double(random.nextDouble() * 100000).longValue();
//            Thread.sleep(1);
            MyTask task = new MyTask(uid);
            structure.arriveTask(task);
        }

    }

}
