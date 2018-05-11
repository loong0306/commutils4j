package com.git.comm.utils.u4common;

import com.git.comm.utils.u4json.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 钉钉机器人发送消息
 * https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.karFPe&treeId=257&articleId=105735&docType=1
 *
 * @author github -> https://github.com/yinjihuan
 */
@Component
public class DingDingMessageUtil {

    @Value("${ding-access-token}")
    public String dingAccessToken;
    @Value("${ding-open}")
    private Boolean dingOpen;

    public void sendTextMessage(String msg) {
        try {
            if (dingOpen) {
                Message message = new Message();
                message.setMsgtype("text");
                message.setText(new MessageInfo(msg));
                URL url = new URL("https://oapi.dingtalk.com/robot/send?access_token=" + dingAccessToken);
                // 建立http连接
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setUseCaches(false);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Charset", "UTF-8");
                conn.setRequestProperty("Content-Type", "application/Json; charset=UTF-8");
                conn.connect();
                OutputStream out = conn.getOutputStream();
                String textMessage = JsonUtils.toJson(message);
                byte[] data = textMessage.getBytes();
                out.write(data);
                out.flush();
                out.close();
                InputStream in = conn.getInputStream();
                byte[] data1 = new byte[in.available()];
                in.read(data1);
            }
        } catch (Exception e) {
            // 不处理异常
        }
    }
}

class Message {
    private String msgtype;
    private MessageInfo text;

    public String getMsgtype() {
        return msgtype;
    }

    public MessageInfo getText() {
        return text;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public void setText(MessageInfo text) {
        this.text = text;
    }
}

class MessageInfo {
    private String content;

    public MessageInfo(String content) {
        this.content = content;
    }
}