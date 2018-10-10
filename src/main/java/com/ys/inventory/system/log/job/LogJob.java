package com.ys.inventory.system.log.job;


import com.ys.inventory.system.log.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class LogJob implements Job {

    @Autowired
    LogService service;

    private static final int MONTH = 3;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        service.delete(MONTH);
    }
}
