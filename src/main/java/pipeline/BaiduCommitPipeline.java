package pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.DB;
import common.HttpClient;
import domain.BlogUrl;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class BaiduCommitPipeline implements Pipeline {	
	
	private  static  Logger logger = LoggerFactory.getLogger(BaiduCommitPipeline.class);
	
	public void process(ResultItems resultItems, Task task) {
		String postUrl = "http://data.zz.baidu.com/urls?site=www.nobuger.com&token=g9xbFjFQ2cLePOiC";
		//String paramStr = "http://www.nobuger.com/articles/2018/12/05/1544014481886.html";
		String url = resultItems.getRequest().getUrl();
		logger.info("提交的链接"+url);
		String result = HttpClient.post(postUrl,url);
		logger.info("提交结果"+result);
		//提交后保存 到db上
		BlogUrl blogUrl = new BlogUrl();
		blogUrl.setCreateDateTime(System.currentTimeMillis());
		blogUrl.setUrl(url);
		DB.insert(BlogUrl.class, blogUrl);
	}

}
