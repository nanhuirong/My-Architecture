package com.huirong.hashedwheeltimer.timer;

import com.huirong.hashedwheeltimer.task.MyTimerTask;

import java.util.Timer;

/**
 * Created by huirong on 17-3-10.
 */
public class MyTimer {
    private Timer timer;

    public MyTimer() {
        //创建一个看门狗, 以守护线程模式运行
        timer = new Timer("nanhuirong-watchdog");
    }


    //以指定period运行一个timer计数器
    public void schedule(MyTimerTask task, long delay, long period){
        this.timer.schedule(task, delay, period);
    }
}
