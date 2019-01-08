package com.ziqingwang.quartz.cron;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author: Ziven
 * @date: 2019/01/08
 **/
public interface BaseJob extends Job {
	@Override
	void execute(JobExecutionContext context) throws JobExecutionException;
}
