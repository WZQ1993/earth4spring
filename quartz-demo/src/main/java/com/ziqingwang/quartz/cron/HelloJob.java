package com.ziqingwang.quartz.cron;

import java.util.logging.Logger;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author: Ziven
 * @date: 2018/12/29
 **/
public class HelloJob implements BaseJob {
	private Logger logger = Logger.getLogger("HelloJob");

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.warning("execute hello world!");
	}
}
