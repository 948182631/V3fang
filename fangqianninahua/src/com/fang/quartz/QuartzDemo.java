package com.fang.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzDemo implements Job{  
  
    public void execute(JobExecutionContext arg0) throws JobExecutionException {  
        System.out.println("执行我.......");  
          
    }  
  
}  