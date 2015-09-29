package com.app.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ScheduleJob
{

   private ThreadPoolTaskExecutor taskExecuter;
   
   public ScheduleJob(ThreadPoolTaskExecutor taskExcecuter)
   {
      System.out.println("=====> instance created");
      this.taskExecuter = taskExcecuter;  
   }
   
   @Scheduled(fixedRate = 5000)
   public void doSomething(){
      taskExecuter.execute( new MessageTask() );
   }
   
}
