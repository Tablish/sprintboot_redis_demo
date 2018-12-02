package com.SchedulerFactory;

import org.quartz.SchedulerException;
import org.quartz.impl.DirectSchedulerFactory;
import org.quartz.simpl.RAMJobStore;
import org.quartz.simpl.SimpleThreadPool;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/10/29
 * @Modified By
 */
public class DirectSchedulerFactoryTest {
    public static void createSchedulerFactory() throws SchedulerException {
        //创建一个拥有10个线程的任务程序
        DirectSchedulerFactory.getInstance().createVolatileScheduler(10);
        DirectSchedulerFactory.getInstance().getScheduler().start();
    }

    //
    public static void getSchedulerByThread() {
        SimpleThreadPool threadPool = new SimpleThreadPool(10, Thread.MAX_PRIORITY);
        RAMJobStore jobStore = new RAMJobStore();

        /*DirectSchedulerFactory.getInstance().createScheduler("My Quartz Scheduler", "My Instance", threadPool,jobStore,
                "localhost",1099);*/

    }
}
