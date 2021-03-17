package com.app.steedApplication.Configuration;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduledJob  {
	@Bean
    public JobDetail jobADetails() {
        return JobBuilder.newJob(SynDataJob.class).withIdentity("sampleJobA")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobATrigger(JobDetail jobADetails) {

        return TriggerBuilder.newTrigger().forJob(jobADetails)

                .withIdentity("sampleTriggerA")
//                .withSchedule(CronScheduleBuilder.cronSchedule("0 41 18 1/1 * ? *"))
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 5 1/1 * ? *"))
                .build();
    }
	
}
