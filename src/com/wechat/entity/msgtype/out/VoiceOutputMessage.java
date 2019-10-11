package com.wechat.entity.msgtype.out;


import com.wechat.entity.msgtype.MessageType;
/**
 * 语音回复消息
 * @author Administrator
 *
 */
public class VoiceOutputMessage extends BaseOutMessage{
    private Voice voice;
    
    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_VOICE.toString();
    }
}
