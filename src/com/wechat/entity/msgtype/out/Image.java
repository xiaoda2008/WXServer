package com.wechat.entity.msgtype.out;

/**
 * 图片回复消息
 * @author Administrator
 *
 */
public class Image{
    //通过上传多媒体文件，得到的id
    private String MediaId;
    
    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}