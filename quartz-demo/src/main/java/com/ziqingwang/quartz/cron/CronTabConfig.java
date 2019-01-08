package com.ziqingwang.quartz.cron;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.quartz.*;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author: Ziven
 * @date: 2019/01/07
 **/
@Configuration
public class CronTabConfig {

	//	@PostConstruct
//	public void init() throws Exception{
//		// 启动
//		scheduler.start();
//		// 作业详情
//		JobDetail jobDetail = JobBuilder
//				.newJob(HelloJob.class)
//				.storeDurably()
//				.withDescription("测试任务")
//				.withIdentity("helloJob", "helloJobGroup")
//				.build();
//		// 触发器
//		CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule("0/30 * * * * ?");
//		Trigger trigger = TriggerBuilder.newTrigger()
//				.withSchedule(builder)
//				.build();
//
//		// 注册任务和触发器
//		scheduler.scheduleJob(jobDetail, trigger);
//	}

}
