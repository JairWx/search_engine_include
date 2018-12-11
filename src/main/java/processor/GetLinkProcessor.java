package processor;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quartz.job.SpiderJob;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class GetLinkProcessor implements PageProcessor{
	
	private static Logger logger = LoggerFactory.getLogger(GetLinkProcessor.class);
	private Site site = Site.me();
	private String videoLink = "(http://www\\.nobuger\\.com/.+)";
	public void process(Page page) {
		List<String> urlList = page.getHtml().links().regex(videoLink).all();
		for (String url : urlList) {
			page.putField("url", url);
			logger.info("获取的链接"+url);
			//需要增加判断
			
			//page.addTargetRequest(url);
		}
	}

	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		SpiderJob.spider();
	}
}
