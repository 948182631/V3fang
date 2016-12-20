//package com.fang.quartz;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.quartz.CronTrigger;
//import org.quartz.JobDetail;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.SchedulerFactory;
//import org.quartz.SimpleTrigger;
//import org.quartz.impl.StdSchedulerFactory;
//import org.apache.log4j.Logger;
//
//public class test {
//	private static Logger log = Logger.getLogger( test.class);
//
//	int a =0;
//	 private static final SimpleTrigger CronTrigger = null;  
//	  
//	    public static void main(String[] args){  
//	    	test2();
//	    }  
//	      
//	    public void work(){
//			log.info("V3芳"+a);
//	    }
//	    
//	    public static void test1(){  
//	          //通过SchedulerFactory来获取一个调度器  
//	        SchedulerFactory schedulerFactory = new StdSchedulerFactory();  
//	        Scheduler scheduler;  
//	        try {  
//	            scheduler = schedulerFactory.getScheduler();  
//	          
//	          
//	          
//	          
//	        //引进作业程序  
//	        JobDetail jobDetail =   
//	        new JobDetail("jobDetail-s1", "jobDetailGroup-s1", QuartzDemo.class);  
//	  
//	         //new一个触发器  
//	        SimpleTrigger simpleTrigger =   
//	        new SimpleTrigger("simpleTrigger", "triggerGroup-s1");  
//	  
//	  
//	        //设置作业启动时间  
//	  
//	        long ctime = System.currentTimeMillis();   
//	        simpleTrigger.setStartTime(new Date(ctime));  
//	  
//	  
//	        //设置作业执行间隔   
//	        simpleTrigger.setRepeatInterval(1000);  
//	  
//	        //设置作业执行次数  
//	        simpleTrigger.setRepeatCount(10);  
//	  
//	        //设置作业执行优先级默认为5  
//	        //simpleTrigger.setPriority(10);  
//	  
//	  
//	        //作业和触发器设置到调度器中  
//	        scheduler.scheduleJob(jobDetail, simpleTrigger);  
//	          
//	        //启动调度器  
//	        scheduler.start();  
//	        } catch (SchedulerException e) {  
//	            // TODO Auto-generated catch block  
//	            e.printStackTrace();  
//	        }  
//	    }  
//	      
//	    public static void test2(){  
//	  
//	        try    {  
//	            SchedulerFactory schedFact  =   new  org.quartz.impl.StdSchedulerFactory();  
//	            Scheduler sched  =  schedFact.getScheduler();  
//	            sched.start();  
//	            JobDetail jobDetail  =   new  JobDetail( " Income Report " ,  
//	                     " Report Generation " , QuartzDemo.class );  
//	            jobDetail.getJobDataMap().put( " type " ,  " FULL " );  
//	            CronTrigger trigger  =   new  CronTrigger( " Income Report " ,  
//	                     " Report Generation " );  
//	             /**/ /*  每1分钟执行一次  */   
//	            trigger.setCronExpression( "10/5 * * * * ?" );  
//	            sched.scheduleJob(jobDetail, trigger);  
//	        }   catch  (Exception e)   {  
//	            e.printStackTrace();  
//	        }   
//	    }  
//	      
//	    public static void test3(){  
//	         //通过SchedulerFactory来获取一个调度器  
//	      SchedulerFactory schedulerFactory = new StdSchedulerFactory();  
//	      Scheduler scheduler;  
//	        try {  
//	            scheduler = schedulerFactory.getScheduler();    
//	      //引进作业程序  
//	      JobDetail jobDetail =   
//	      new JobDetail("jobDetail-s1", "jobDetailGroup-s1", QuartzDemo.class);  
//	       //new一个触发器  
//	      CronTrigger simpleTrigger =   
//	        new CronTrigger("trigger", "group", "job", "group", "16 26/1 8-17 * * ?");  
//	     // new SimpleTrigger("simpleTrigger", "triggerGroup-s1");  
//	  
//	  
//	      //设置作业启动时间  
//	    //Calendar excelCal = Calendar.getInstance();  
//	        //excelCal.add(Calendar.DAY_OF_MONTH, 1);  
//	        ///excelCal.set(Calendar.HOUR_OF_DAY, 16);  
//	        //excelCal.set(Calendar.SECOND, 0);  
//	        //excelCal.add(Calendar.MINUTE, 9);  
//	     // long ctime = System.currentTimeMillis();   
//	     // simpleTrigger.setStartTime(excelCal.getTime());  
//	      //设置作业执行间隔   
//	     // simpleTrigger.setRepeatInterval(1000);  
//	      //设置作业执行次数  
//	     // simpleTrigger.setRepeatCount(10);  
//	      //设置作业执行优先级默认为5  
//	      //simpleTrigger.setPriority(10);  
//	          
//	      //作业和触发器设置到调度器中  
//	      scheduler.scheduleJob(jobDetail, simpleTrigger);  
//	        
//	      //启动调度器  
//	      scheduler.start();  
//	        } catch (SchedulerException e) {  
//	            // TODO Auto-generated catch block  
//	            e.printStackTrace();  
//	        } catch (ParseException e) {  
//	            // TODO Auto-generated catch block  
//	            e.printStackTrace();  
//	        }  
//	          
//	          
//	    }  
//	
//}
