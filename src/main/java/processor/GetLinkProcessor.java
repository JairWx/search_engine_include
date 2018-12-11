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
	//private String productLink = "(http://item\\.mi\\.com/product/[\\w]+.html)";
	private String videoLink = "(http://www\\.nobuger\\.com/.+)";
	public void process(Page page) {
		//page.addTargetRequests(page.getHtml().links().regex(videoLink).all());
		List<String> urlList = page.getHtml().links().regex(videoLink).all();
		for (String url : urlList) {
			page.putField("url", url);
			logger.info("获取的链接"+url);
			page.addTargetRequest(url);
		}
		// TODO Auto-generated method stub
//		String video_type = page.getHtml().xpath("//[@class='topDot']/text()").toString();
		
//		System.out.println(video_type);
//		System.out.println(StringUtils.isEmpty(video_type));
//		//String video_name = page.getHtml().xpath("//p[@class='progInfo_pic_info_title']/text()").toString();
//		//String video_name2 = page.getHtml().xpath("//span[@id='widget-videotitle']/text()").toString();
//		System.out.println(page.getUrl());
//		//System.out.println(video_name);
//		//System.out.println(video_name2);
//		//System.out.println(page.getHtml().links().regex(videoLink).all());
//		page.addTargetRequests(page.getHtml().links().regex(videoLink).all());
	}

	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		SpiderJob.spider();
	}
}
