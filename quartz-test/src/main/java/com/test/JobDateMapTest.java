package com.test;

import com.job.JobDateMapJob;
import com.job.ThirdJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/10/29
 * @Modified By
 */
public class JobDateMapTest {

    public static void main(String[] args) throws Exception {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();


        JobDetail jobDetail = JobBuilder.newJob(JobDateMapJob.class).withIdentity("name1", "group1")
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();

        CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule("*/2 * * * * ?");
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule).build();

        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();

        Thread.sleep(10000);
        scheduler.shutdown();
    }

}
