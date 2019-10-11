package com.wechat.test;

import com.wechat.utils.AccessTokenUtil;
import com.wechat.utils.WebChatUtil;

public class Test {

	public static void main(String[] args) {

/*
		String signature = "39c293e9b15cee3f9f692eae5d92206d935bc4cd";
        String timestamp = "1570511100";
        String nonce = "1009067224";
        String echostr = "3431824140296625919";

        System.out.println(WebChatUtil.checkSignature(signature, 
        		timestamp, nonce));
*/
		
		AccessTokenUtil ats = new AccessTokenUtil("wx472ed1be2d771bb6",
				"6dca3fe0e49dbe43995e279108f7e63a");
		String token = ats.getLatestToken();
		System.out.print(token);

	}

}
