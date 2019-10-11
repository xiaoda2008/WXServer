package com.wechat.entity.msgtype.out;


import com.wechat.entity.msgtype.MessageType;

/**
 * 文本回复消息
 * 
 * @author Administrator
 *
 */
public class TextMessage extends BaseOutMessage {
    // 文本消息
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_TEXT.toString();
    }
}