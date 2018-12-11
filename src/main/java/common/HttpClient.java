package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClient {
	
	public static String  post(String url,String paramStr) {
		String respStr = "";
		//创建HttpClient对象
		CloseableHttpClient closeHttpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		//发送Post请求
		HttpPost httpPost = new HttpPost(url);
		//设置Post参数
		//List<NameValuePair> params = Lists.newArrayList();
		//params.add(new BasicNameValuePair(name, value));
		try {
			//转换参数并设置编码格式
			httpPost.setEntity(new StringEntity(paramStr));
			//执行Post请求 得到Response对象
			httpResponse = closeHttpClient.execute(httpPost);
			//httpResponse.getStatusLine() 响应头信息
			//System.out.println(httpResponse.getStatusLine());
			//返回对象 向上造型
			HttpEntity httpEntity = httpResponse.getEntity();
			if(httpEntity != null){
				//响应输入流
				InputStream is = httpEntity.getContent();
				//转换为字符输入流
				BufferedReader br = new BufferedReader(new InputStreamReader(is,Consts.UTF_8));
				String line = null;
				while((line=br.readLine())!=null){
					respStr = line;
				}
				//关闭输入流
				is.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(httpResponse != null){
				try {
					httpResponse.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(closeHttpClient != null){
				try {
					closeHttpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return respStr;
	}
}
