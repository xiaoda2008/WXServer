package com.wechat.entity.msgtype.in;

import com.wechat.entity.msgtype.MessageType;
/**
 * 小视频消息
 * @author Administrator
 *
 */
public class ShortVideoInputMessage extends BaseMessage {
    // 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;
    // 视频消息 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    @Override
    public String getMsgType() {
        return MessageType.SHORTVIDEO_MESSAGE.toString();
    }
}
