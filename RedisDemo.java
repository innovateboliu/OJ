import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RedisDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("nodejitsudb4112456240.redis.irstack.com", 6379);
		jedis.auth("nodejitsudb4112456240.redis.irstack.com:f327cfe980c971946e80b8e975fbebb4");
		jedis.connect();

//		for (int i = 0; i < 10; i++) {
//			jedis.publish("twitter_trend", "0.1");
//			Thread.sleep(2000);
//			jedis.publish("twitter_trend", "0.2");
//			Thread.sleep(2000);
//			jedis.publish("twitter_trend", "0.1");
//			Thread.sleep(2000);
//			jedis.publish("twitter_trend", "0.2");
//			Thread.sleep(2000);
//		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("href", "www");
		map.put("id", "bo");
		map.put("cnt", "88");
		List<Map<String, String>> list = new ArrayList<>();
		list.add(map);
		map = new HashMap<String, String>();
		map.put("href", "www");
		map.put("id", "xingyu");
		map.put("cnt", "66");
		list.add(map);
		Gson gson = new GsonBuilder().create();
		
		
		jedis.publish("twitter_trend", gson.toJson(list));
		
		Thread.sleep(2000);
		list.clear();
		map = new HashMap<String, String>();
		map.put("href", "www");
		map.put("id", "xingyu");
		map.put("cnt", "100");
		list.add(map);
		map = new HashMap<String, String>();
		map.put("href", "www");
		map.put("id", "bo");
		map.put("cnt", "10");
		list.add(map);
		jedis.publish("twitter_trend", gson.toJson(list));
	}

}
