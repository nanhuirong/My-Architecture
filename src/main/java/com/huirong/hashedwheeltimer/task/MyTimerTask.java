package com.huirong.hashedwheeltimer.task;

import com.huirong.hashedwheeltimer.structure.MyStructure;

import java.util.TimerTask;

/**
 * Created by huirong on 17-3-10.
 * 定时运行任务的抽象
 */
public class MyTimerTask extends TimerTask {
    MyStructure structure;

    public MyTimerTask(MyStructure structure) {
        this.structure = structure;
    }

    public void run() {
        structure.moveQueue();
    }
}
