package com.test;

import com.job.ThirdJob;
import com.utils.DateUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/10/29
 * @Modified By
 */
public class ThirdTest {

    public static void main(String[] args) throws Exception {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = JobBuilder.newJob(ThirdJob.class).withIdentity("name1", "group1").build();

        CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule("*/2 * * * * ?");
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("thirdTrigger1", "thirdTrigger1").withSchedule(cronSchedule).build();
        //安排进调度计划中
        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("开始时间 "+DateUtil.getCurrentTime());
        scheduler.start();


        Thread.sleep(10000);
        scheduler.shutdown();
        System.out.println("结束时间 "+DateUtil.getCurrentTime());

    }

}
