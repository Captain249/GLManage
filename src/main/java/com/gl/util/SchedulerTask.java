package com.gl.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SchedulerTask{

    private static Logger log = LoggerFactory.getLogger(SchedulerTask.class);
    //@Scheduled(cron = "*/5 * * * * ?")
    /*private void test(){
        log.debug("定时任务搞起来!");
    }*/
}
