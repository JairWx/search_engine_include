package processor;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;

import quartz.job.SpiderJob;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.RegexSelector;

public class GetLinkProcessor implements PageProcessor{
	
	private static Logger logger = LoggerFactory.getLogger(GetLinkProcessor.class);
	private Site site = Site.me();
	private String videoLink = "(http://blog\\.nobuger\\.com/.+)";
	
	private String validity = "(http://blog\\.nobuger\\.com/.+\\.html# .+)";
	public void process(Page page) {
		List<String> urlList = page.getHtml().links().regex(videoLink).all();
		RegexSelector regexSelector= new RegexSelector("(http://blog\\.nobuger\\.com/.+.html#.+)");
		for (String url : urlList) {
			page.putField("url", url);
			//需要增加判断
			if(StringUtils.isEmpty(regexSelector.select(url))){
				logger.info("获取的链接"+url);
				page.addTargetRequest(url);
			}
			
		}
	}

	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		SpiderJob.spider();
	}
}
