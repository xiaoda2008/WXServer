package com.wechat.utils;

import java.io.Serializable;

import com.wechat.entity.msgtype.MessageType;
import com.wechat.entity.msgtype.out.Articles;
import com.wechat.entity.msgtype.out.ImageOutputMessage;
import com.wechat.entity.msgtype.out.MusicOutputMessage;
import com.wechat.entity.msgtype.out.NewsOutputMessage;
import com.wechat.entity.msgtype.out.TextMessage;
import com.wechat.entity.msgtype.out.VideoOutputMessage;
import com.wechat.entity.msgtype.out.VoiceOutputMessage;

/**
 * 构建回复消息
 * 
 * @author Administrator
 *
 */
public class ReplyMessageUtil implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[news]]></MsgType>
     * <ArticleCount>2</ArticleCount> <Articles> <item>
     * <Title><![CDATA[title1]]></Title>
     * <Description><![CDATA[description1]]></Description>
     * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
     * <item> <Title><![CDATA[title]]></Title>
     * <Description><![CDATA[description]]></Description>
     * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
     * </Articles> </xml>
     * 
     * @Title sendImageTextMessage
     * @Description 回复图文消息
     * @param message
     * @return
     */
    public static String sendImageTextMessage(NewsOutputMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MessageType.IMAGE_TEXT_MESSAGE + "]]></MsgType>");
        sb.append("<ArticleCount>" + message.getArticleCount() + "</ArticleCount>");
        sb.append("<Articles> ");
        for (Articles article : message.getArticles()) {
            sb.append("<item>");
            if(article.getTitle()!=null && article.getTitle()!=""){
                sb.append("<Title><![CDATA[").append(article.getTitle()).append("]]></Title>");
            }
            if(article.getDescription()!=null && article.getDescription()!=""){
                sb.append("<Description><![CDATA[").append(article.getDescription()).append("]]></Description>");
            }
            if(article.getPicUrl()!=null && article.getPicUrl()!=""){
                sb.append("<PicUrl><![CDATA[").append(article.getPicUrl()).append("]]></PicUrl>");
            }
            if(article.getUrl()!=null && article.getUrl()!=""){
                sb.append("<Url><![CDATA[").append(article.getUrl()).append("]]></Url>");
            }
            sb.append("</item>");
        }
        sb.append("</Articles>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[music]]></MsgType>
     * <Music> <Title><![CDATA[TITLE]]></Title>
     * <Description><![CDATA[DESCRIPTION]]></Description>
     * <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
     * <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
     * <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId> </Music> </xml>
     * 
     * @Title sendMusicMessage
     * @Description 回复音乐消息
     * @param message
     * @return
     */
    public static String sendMusicMessage(MusicOutputMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MessageType.MUSIC_MESSAGE + "]]></MsgType>");
        sb.append("<Music>");
        if (message.getMusic().getTitle() != null && !"".equals(message.getMusic().getTitle())) {
            sb.append("<Title><![CDATA[" + message.getMusic().getTitle() + "]]></Title>");
        }
        if (message.getMusic().getDescription() != null && !"".equals(message.getMusic().getDescription())) {
            sb.append("<Description><![CDATA[" + message.getMusic().getDescription() + "]]></Description>");
        }
        if (message.getMusic().getMusicUrl() != null && !"".equals(message.getMusic().getMusicUrl())) {
            sb.append("<MusicUrl><![CDATA[" + message.getMusic().getMusicUrl() + "]]></MusicUrl>");
        }
        if (message.getMusic().getHQMusicUrl() != null && !"".equals(message.getMusic().getHQMusicUrl())) {
            sb.append("<HQMusicUrl><![CDATA[" + message.getMusic().getHQMusicUrl() + "]]></HQMusicUrl>");
        }

        sb.append("<ThumbMediaId><![CDATA[" + message.getMusic().getThumbMediaId() + "]]></ThumbMediaId>");
        sb.append("</Music>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[video]]></MsgType>
     * <Video> <MediaId><![CDATA[media_id]]></MediaId>
     * <Title><![CDATA[title]]></Title>
     * <Description><![CDATA[description]]></Description> </Video> </xml>
     * 
     * @Title sendVideoMessage
     * @Description 回复视频消息
     * @param message
     * @return
     */
    public static String sendVideoMessage(VideoOutputMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MessageType.VIDEO_MESSAGE + "]]></MsgType>");
        sb.append("<Video>");
        sb.append("<MediaId><![CDATA[" + message.getVideo().getMediaId() + "]]></MediaId>");
        if (message.getVideo().getTitle() != null && !"".equals(message.getVideo().getTitle())) {
            sb.append("<Title><![CDATA[" + message.getVideo().getTitle() + "]]></Title>");
        }
        if (message.getVideo().getDescription() != null && !"".equals(message.getVideo().getDescription())) {
            sb.append("<Description><![CDATA[" + message.getVideo().getDescription() + "]]></Description>");
        }
        sb.append("</Video>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[voice]]></MsgType>
     * <Voice> <MediaId><![CDATA[media_id]]></MediaId> </Voice> </xml>
     * @Title sendVoiceMessage
     * @Description 回复语音消息
     * @param message
     * @return
     */
    public static String sendVoiceMessage(VoiceOutputMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MessageType.VOICE_MESSAGE + "]]></MsgType>");
        sb.append("<Voice>");
        sb.append("<MediaId><![CDATA[" + message.getVoice().getMediaId() + "]]></MediaId>");
        sb.append("</Voice>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[image]]></MsgType>
     * <Image> <MediaId><![CDATA[media_id]]></MediaId> </Image> </xml>
     * @Title sendImageMessage
     * @Description 回复图片消息
     * @param message
     */
    public static String sendImageMessage(ImageOutputMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MessageType.IMAGE_MESSAGE + "]]></MsgType>");
        sb.append("<Image>");
        sb.append("<MediaId><![CDATA[" + message.getImage().getMediaId() + "]]></MediaId>");
        sb.append("</Image>");
        sb.append("</xml>");
        return sb.toString();
    }
    /**
     * <xml> <ToUserName>< ![CDATA[toUser] ]></ToUserName> <FromUserName><
     * ![CDATA[fromUser] ]></FromUserName> <CreateTime>12345678</CreateTime>
     * <MsgType>< ![CDATA[text] ]></MsgType> <Content>< ![CDATA[你好] ]></Content>
     * </xml> sendTextMessage
     * @param message
     * @return
     */
    public static String sendTextMessage(TextMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MessageType.TEXT_MESSAGE + "]]></MsgType>");
        sb.append("<Content><![CDATA[" + message.getContent() + "]]></Content>");
        sb.append("</xml>");
        return sb.toString();
    }
}