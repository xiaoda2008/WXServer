package com.wechat.entity.msgtype;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
 
public class MessageType {
    /*
     * 文本消息
     */
    public static final String TEXT_MESSAGE = "text";
    /*
     * 图片消息
     */
    public static final String IMAGE_MESSAGE = "image";
    /*
     * 语音消息
     */
    public static final String VOICE_MESSAGE = "voice";
    /*
     * 视频消息
     */
    public static final String VIDEO_MESSAGE = "video";
    /*
     * 小视频消息消息
     */
    public static final String SHORTVIDEO_MESSAGE = "shortvideo";
    /*
     * 地理位置消息
     */
    public static final String POSOTION_MESSAGE = "location";
    /*
     * 链接消息
     */
    public static final String LINK_MESSAGE = "link";
    /*
     * 音乐消息
     */
    public static final String MUSIC_MESSAGE = "music";
    /*
     * 图文消息
     */
    public static final String IMAGE_TEXT_MESSAGE = "news";
    /*
     * 请求消息类型：事件推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";
    /*
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    /*
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    /*
     * 事件类型：scan(用户已关注时的扫描带参数二维码)
     */
    public static final String EVENT_TYPE_SCAN = "scan";
    /*
     * 事件类型：LOCATION(上报地理位置)
     */
    public static final String EVENT_TYPE_LOCATION = "location";
    /*
     * 事件类型：CLICK(自定义菜单)
     */
    public static final String EVENT_TYPE_CLICK = "click";

    /*
     * 响应消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    /*
     * 响应消息类型：图片
     */
    public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
    /*
     * 响应消息类型：语音
     */
    public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
    /*
     * 响应消息类型：视频
     */
    public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
    /*
     * 响应消息类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
    /*
     * 响应消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * @Title parseXml
     * @Description 将用户的xml消息提取成map key value 类型
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public static Map<String, String> parseXml(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
    	System.out.println("Start ParceXML");
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        System.out.println("Get InputStream...");
        // 读取输入流
        SAXReader reader = new SAXReader();
        System.out.println("Get Reader...");
        Document document = reader.read(inputStream);
        // 得到xml根元素
        System.out.println("Get document...");
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        System.out.println("Get root...");
        List<Element> elementList = root.elements();
        
        System.out.println("Get elementList...");      
        // 遍历所有子节点
        for (Element e : elementList) {
        	System.out.println("Put text in :" + e.getText());
            map.put(e.getName(), e.getText());
        }
        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;
    }
}