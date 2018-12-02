package com.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/10/12
 * @Modified By
 */
public class MyJob implements Job{

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("要执行的任务！");
    }
}
