package xupt.se.ttms.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class httpClient {
	static String uri = "http://132.232.169.227:798/path/index";

	public static String getMovieIndex(String urlString) {
		try {
			URL url = new URL(uri + "/?url=" + urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoOutput(true); // 设置该连接是可以输出的
			connection.setRequestMethod("GET"); // 设置请求方式
			connection.setRequestProperty("Content-Type", "application/json");

			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line = null;
			StringBuilder result = new StringBuilder();
			while ((line = br.readLine()) != null) { // 读取数据
				result.append(line + "\n");
			}
			connection.connect();
			return result.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
