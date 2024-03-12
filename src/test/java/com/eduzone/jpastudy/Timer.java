package com.eduzone.jpastudy;

public class Timer {

    private long startTime;

    private long endTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        endTime = System.currentTimeMillis();
        System.out.println("total : " + (endTime - startTime) + "ms");
        init();
    }

    private void init() {
        startTime = 0L;
        endTime = 0L;
    }
}
