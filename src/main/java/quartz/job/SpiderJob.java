package quartz.job;

import pipeline.BaiduCommitPipeline;
import pipeline.DbPipeline;
import processor.GetLinkProcessor;
import us.codecraft.webmagic.Spider;

public class SpiderJob {
	public static void spider(){
		String url = "http://www.nobuger.com/";
		long version = System.currentTimeMillis();
		//活动列表
		//
        Spider.create(new GetLinkProcessor())
                .addUrl(url)
                //.addPipeline(new DbPipeline(version))
                .addPipeline(new BaiduCommitPipeline())
                //开启5个线程抓取
                .thread(1)
                //启动爬虫
                .run();
        System.out.println("爬虫最新版本\r"+version);
	}
}
