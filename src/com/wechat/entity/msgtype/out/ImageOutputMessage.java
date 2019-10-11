package com.wechat.entity.msgtype.out;

import com.wechat.entity.msgtype.MessageType;
/**
 * 图片输出内容
 * @author Administrator
 *
 */
public class ImageOutputMessage extends BaseOutMessage{
    private Image Image;
    public Image getImage() {
        return Image;
    }
    public void setImage(Image image) {
        Image = image;
    }
    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_IMAGE.toString();
    }
}