package com.wechat.entity.msgtype.out;

import com.wechat.entity.msgtype.MessageType;

/**
 * 回复视频消息
 * 
 * @author Administrator
 *
 */
public class VideoOutputMessage extends BaseOutMessage {
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_VIDEO.toString();
    }
}
