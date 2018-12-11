package quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import quartz.job.SpiderJob;
import us.codecraft.webmagic.Spider;

/**
 * 提交任务
 * @author admin
 *
 */
public class FirstTask extends QuartzJobBean {
	 
 
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    	String className = getClass().getName();
    	 System.out.println(new SimpleDateFormat("YYYYMMdd HH:mm:ss").format(new Date()) + className + "---start FirstService");
    	 SpiderJob.spider();
    }
 
}
