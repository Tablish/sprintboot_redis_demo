package com.job;

import com.utils.DateUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/10/29
 * @Modified By
 */
public class ThirdJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("现在是北京时间：" + DateUtil.getCurrentTime() + "- ThirdJob任务执行");
    }
}
