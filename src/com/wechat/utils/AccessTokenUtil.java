package com.wechat.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccessTokenUtil {

	static long latestTokenTime = 0;
	static String appId = null;
	static String appSec = null;
	static String getUrl = null;
	static String latestToken = null;
	
	public AccessTokenUtil(String appId, String appSec) {
		AccessTokenUtil.appId = appId;
		AccessTokenUtil.appSec = appSec;
		AccessTokenUtil.getUrl = "https://api.weixin.qq.com/cgi-bin/token?"
				+ "grant_type=client_credential&appid=" + AccessTokenUtil.appId + 
				"&secret=" + AccessTokenUtil.appSec;
	}
	
	public String getLatestToken() {
		
		long nowTime = new Date().getTime();
		if((nowTime - latestTokenTime) > 7200000) {
			//如果已经超出7200秒的有效期，则重新获取，否则返回原有的
			latestToken = AccessTokenUtil.sendGetRequest(getUrl);
			latestTokenTime = nowTime;
		}
		return latestToken;
	}
	
	
    /**
     * Get方法
     * @return 
     */
    public static String sendGetRequest(String url) {
    	
    	String result = "";
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                HttpGet httpGet = new HttpGet(url);

                client = HttpClients.createDefault();
                response = client.execute(httpGet);
                HttpEntity entity = response.getEntity();
                String entityStr = EntityUtils.toString(entity);
                JSONObject jsonObject = JSON.parseObject(entityStr);
                System.out.println(jsonObject);
                result = jsonObject.getString("access_token");
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return result;
    }

    /**
     * Post发送form表单数据
     */
    public static void sendPostFormRequest(String url) {
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                // 创建一个提交数据的容器
                List<BasicNameValuePair> parames = new ArrayList<>();
                parames.add(new BasicNameValuePair("code", "001"));
                parames.add(new BasicNameValuePair("name", "测试"));

                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(new UrlEncodedFormEntity(parames, "UTF-8"));

                client = HttpClients.createDefault();
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Post发送json数据
     */
    public static void sendPostJsonRequest(String url) {
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> data = new HashMap<String, Object>();
                data.put("code", "001");
                data.put("name", "测试");

                HttpPost httpPost = new HttpPost(url);
                httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json");
                httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(data),
                        ContentType.create("text/json", "UTF-8")));

                client = HttpClients.createDefault();
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
