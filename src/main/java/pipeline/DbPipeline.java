package pipeline;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.lang3.StringUtils;

import com.mchange.v2.c3p0.DataSources;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.selector.RegexSelector;

public class DbPipeline implements Pipeline {
	
	private static DataSource ds = null;
	
	private long version = 0;
	
	
	
	public DbPipeline(long version){
		this.version = version;
		if(ds == null) {
			try {
				ds =DataSources.unpooledDataSource("jdbc:mysql://127.0.0.1:3306/test", "root", "root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void process(ResultItems resultItems, Task task) {
		//如果是jsoup获取描述则
		String name = resultItems.get("name");
		if(StringUtils.isNotEmpty(name)){
			String productId = resultItems.get("product_id");
			String url = resultItems.getRequest().getUrl();
			//float price = 0;
			String price = resultItems.get("price");
			if(StringUtils.isEmpty(price)){
				price = "0";
			}
			if(StringUtils.isEmpty(productId)){
				productId = "0";
			}
			QueryRunner qr = new QueryRunner(ds);
			String sql = "insert into product(`name`,`desc`,`price`,`version`,`createtime`,`url`,`product_id`) values (?,?,?,?,?,?,?)";
			try {
				qr.insert(sql, new MapHandler(), resultItems.get("name"),resultItems.get("desc"),price,version,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),url,productId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
