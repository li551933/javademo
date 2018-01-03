package com.lzc.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Author: zhun.shen
 * Date: 2016-03-08 15:52
 * Description:
 */
public class DemoJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("I will sleep in 3 seconds.");
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("HA HA HA, I am running!!!");
    }
}
