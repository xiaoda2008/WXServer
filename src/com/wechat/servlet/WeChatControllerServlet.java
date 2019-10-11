package com.wechat.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.entity.msgtype.MessageType;
import com.wechat.utils.WebChatUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class WeChatControllerServlet extends HttpServlet {

	private String message;

	@Override
	public void init() throws ServletException {
		// 执行必需的初始化
		message = "Hello World";
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //消息来源可靠性验证
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");       // 随机数
        String echostr = request.getParameter("echostr");//成为开发者验证
        //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
        
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        System.out.println(echostr);
        

        PrintWriter out = response.getWriter();
        if(signature != null && timestamp != null
        		&& nonce != null && echostr!= null
        		&& WebChatUtil.checkSignature(signature, timestamp, nonce)){
        	//如果是收到验证请求，进行处理
            out.print(echostr);
    		System.out.println("WeChat certification request received!");
            System.out.println("Sueccess!" + echostr);
        } else {
        	//收到其他请求
//        	out.print("非微信服务请求");
       		System.out.println("Non WeChat certification request received!");

        }
        out.close();
        out = null;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post request received!");
        
		//消息来源可靠性验证
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");       // 随机数
        
        System.out.println("Signature:" + signature);
        System.out.println("Timestamp:" + timestamp);
        System.out.println("Nounce:" + nonce);
        
        
        //确认此次POST请求来自微信服务器，否则接入失败
        if (!WebChatUtil.checkSignature(signature, timestamp, nonce)) {
            //消息不可靠，直接返回
            response.getWriter().write("");
            System.out.println("Not from wechat server");
            return;
        }
        
        System.out.println("Receive msg from Wx Server");
        
        //用户每次向公众号发送消息、或者产生自定义菜单点击事件时，响应URL将得到推送
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/xml");
            //调用parseXml方法解析请求消息
            Map<String, String> map = MessageType.parseXml(request, response);
            String MsgType = map.get("MsgType");
            String xml = null;//处理输入消息，返回结果的xml
            
            System.out.println("MsgType:" + MsgType);
            if(MessageType.REQ_MESSAGE_TYPE_EVENT.equals(MsgType)){
                xml = WeChatMsgProcessor.parseEvent(map);
            }else{
            	System.out.println("message from wx Server");
                xml = WeChatMsgProcessor.parseMessage(map);
            }
            //返回封装的xml
            //System.out.println(xml);
            response.getWriter().write(xml);
        } catch (Exception ex) {
            response.getWriter().write("");
        }
	}
}
