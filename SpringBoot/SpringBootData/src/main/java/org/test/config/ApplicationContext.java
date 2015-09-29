package org.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.app.tasks.ScheduleJob;

@Configuration
@EnableAsync
@EnableScheduling
public class ApplicationContext
{
   
   @Bean
   public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
      ThreadPoolTaskExecutor taskExecuter = new ThreadPoolTaskExecutor();
      taskExecuter.setCorePoolSize( 10 );
      taskExecuter.setMaxPoolSize( 10 );
      taskExecuter.setQueueCapacity( 25 );
      return taskExecuter;
   }

   @Bean
   public ScheduleJob taskPoolExecuter(){
      return new ScheduleJob( threadPoolTaskExecutor() );
   }
   
}
