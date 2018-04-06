package com.lzc.pollquery;

import com.lzc.http.HttpRequestUtil;

import java.util.concurrent.locks.Lock;

public class Test {
    public static void main(String[] args){
        int pass=7840;
        PollingThread pollingThread=new PollingThread();
        pollingThread.start();
        while(true&&pass<=10000)
        {
            PollingThread.queue.offer(new Message(pass));
            pass++;
            System.out.println(pass);
            //有消息入队后激活轮询线程
            synchronized (Lock.class)
            {
                Lock.class.notify();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
