package com.wechat.entity.msgtype.out;

import com.wechat.entity.msgtype.MessageType;
/**
 * 回复音乐消息
 * @author Administrator
 *
 */
public class MusicOutputMessage extends BaseOutMessage {
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_MUSIC.toString();
    }
}