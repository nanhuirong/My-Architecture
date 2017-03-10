package com.huirong.hashedwheeltimer.structure;

import com.huirong.hashedwheeltimer.conf.Config;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

/**
 * Created by huirong on 17-3-10.
 */
public class MyStructure {
    //环形队列
    private int[] wheelQueue = new int[Config.QUEUE_LENGTH];
    //环形队列访问位置标识
    private int currentIndex = 0;

    //存放每个solt下配属的任务
    private List<Set<Long>> taskSet = new ArrayList<Set<Long>>();


    //存放每个task对应的solt<uid, index>
    private Map<Long, Integer> taskSoltID = new HashMap<Long, Integer>();

    public MyStructure() {
        for (int i = 0; i < Config.QUEUE_LENGTH; i++){
            taskSet.add(i, new HashSet<>());
//            taskSet.add(i, new Con);
        }
    }

    public void arriveTask(MyTask task){
        Long uid = task.getUID();
        removeOldTask(uid);
        addTaskToCurrentSolt(uid);
        updateMap(uid);
    }

    private void updateMap(Long uid){
        taskSoltID.put(uid, currentIndex);
    }

    private synchronized void addTaskToCurrentSolt(Long uid){
//        if (taskSet.get(currentIndex) == null){
//            taskSet.set(currentIndex, new HashSet<Long>());
//        }
        taskSet.get(currentIndex).add(uid);
    }

    private void removeOldTask(Long uid){
        if (!taskSoltID.containsKey(uid)){
            return;
        }else {
            int solt = taskSoltID.get(uid);
            taskSet.get(solt).remove(uid);
        }
    }

    //滚动环形队列
    public synchronized void moveQueue(){
//        synchronized (this){
//            System.out.println("------------------------------------------------------------");
//            System.out.println(currentIndex + 1 + "\t超时任务id|" + taskSet.get(currentIndex));
//        }
//        Set<Long> set = new HashSet<>(taskSet.get(currentIndex));
        System.out.println("------------------------------------------------------------");
        System.out.println(currentIndex + 1 + "\t超时任务id|" + taskSet.get(currentIndex).size());
        currentIndex = (currentIndex + 1) % Config.QUEUE_LENGTH;
    }



}
