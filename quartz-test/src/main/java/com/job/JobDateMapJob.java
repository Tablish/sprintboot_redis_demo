package com.job;

import com.utils.DateUtil;
import org.quartz.*;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/10/29
 * @Modified By
 */
public class JobDateMapJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("现在是北京时间：" + DateUtil.getCurrentTime());

        JobKey key = context.getJobDetail().getKey();

        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

        //job配置的参数
        String jobSays = jobDataMap.getString("jobSays");

        float myFloatValue = jobDataMap.getFloat("myFloatValue");

        System.out.println("Instance:" + key + "...says: " + jobSays + "... val is "+myFloatValue);


    }
}
