package com.wechat.entity.msgtype.in;

import com.wechat.entity.msgtype.MessageType;

/**
 * 文本消息
 * @author Administrator
 *
 */
public class TextMessage extends BaseMessage {
    //文本消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String getMsgType() {
        return MessageType.TEXT_MESSAGE.toString();
    }

}