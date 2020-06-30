package com.clt.config;

import com.alibaba.fastjson.JSON;
import com.clt.entity.SocketMsg;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author mrchen
 */
@ServerEndpoint(value = "/websocket/{nickname}")
@Component
public class WebSocketService  {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketService.class);

    private String nickname;

    private Session session;

    private static CopyOnWriteArraySet<WebSocketService> webSocketSet = new CopyOnWriteArraySet<>();

    private static Map<String, Session> map = new HashMap<String, Session>();


    /**
     * 连接建立成功调用的方法
     *
     * @param session
     * @param nickname
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("nickname") String nickname) {
        Map<String,Object> message=new HashMap<>(16);
        this.session = session;
        this.nickname = nickname;
        map.put(session.getId(), session);
        webSocketSet.add(this);
        if (logger.isDebugEnabled()){
            logger.debug("有新连接加入:" + nickname + ",当前在线人数为" + webSocketSet.size());
        }
        message.put("type",0);
        message.put("people",webSocketSet.size());
        message.put("name",nickname);
        message.put("aisle",session.getId());
        this.session.getAsyncRemote().sendText(JSON.toJSONString(message));
    }

    /**
     * 连接关闭调用的方法    
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        if (logger.isDebugEnabled()){
            logger.debug("有一连接关闭！当前在线人数为" + webSocketSet.size());
        }
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("nickname") String nickname) {

        //从客户端传过来的数据是json数据，所以这里使用jackson进行转换为SocketMsg对象，
        // 然后通过socketMsg的type进行判断是单聊还是群聊，进行相应的处理:
        ObjectMapper objectMapper = new ObjectMapper();
        SocketMsg socketMsg;
        try {
            socketMsg = objectMapper.readValue(message, SocketMsg.class);
            if (socketMsg.getType() == 1) {
                //单聊.需要找到发送者和接受者.
                socketMsg.setFromUser(session.getId());
                Session fromSession = map.get(socketMsg.getFromUser());
                Session toSession = map.get(socketMsg.getToUser());
                //发送给接受者.
                if (toSession != null) {
                    //发送给发送者.
                    Map<String,Object> map=new HashMap<>(16);
                    map.put("type",1);
                    map.put("name",nickname);
                    map.put("msg",socketMsg.getMsg());
                    fromSession.getAsyncRemote().sendText(JSON.toJSONString(map));
                    toSession.getAsyncRemote().sendText(JSON.toJSONString(map));
                } else {
                    //发送给发送者.
                    fromSession.getAsyncRemote().sendText(JSON.toJSONString("系统消息：对方不在线或者您输入的频道号不对"));
                }
            } else {
                //群发消息
                broadcast(socketMsg.getMsg());
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发生错误时调用   
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 群发自定义消息
     */
    public void broadcast(String message) {
        for (WebSocketService item : webSocketSet) {
            Map<String,Object> map=new HashMap<>(16);
            map.put("type",1);
            map.put("name",nickname);
            map.put("msg",message);
            item.session.getAsyncRemote().sendText(JSON.toJSONString(map));
        }
    }
}
