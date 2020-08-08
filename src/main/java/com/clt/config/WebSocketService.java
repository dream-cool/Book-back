package com.clt.config;

import com.alibaba.fastjson.JSON;
import com.clt.constant.Const;
import com.clt.entity.Message;
import com.clt.utils.SpringUtils;
import com.clt.utils.UUIDUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author mrchen
 */
@ServerEndpoint(value = "/websocket/{userName}")
@Component
public class WebSocketService {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketService.class);

    private String userName;

    private Session session;

    private static CopyOnWriteArraySet<WebSocketService> webSocketSet = new CopyOnWriteArraySet<>();

    private static Map<String, Session> map = new HashMap<>();


    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 连接建立成功调用的方法
     *
     * @param session
     * @param userName
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userName") String userName) {
        if (redisTemplate == null) {
            redisTemplate = SpringUtils.getBean("redisTemplate", RedisTemplate.class);
        }
        this.session = session;
        this.userName = userName;
        map.put(userName, session);
        webSocketSet.add(this);
        if (logger.isDebugEnabled()) {
            logger.debug("有新连接加入:" + userName + ",当前在线人数为" + webSocketSet.size());
        }
    }

    /**
     * 连接关闭调用的方法    
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        map.remove(this.userName);
        if (logger.isDebugEnabled()) {
            logger.debug("有一连接关闭！当前在线人数为" + webSocketSet.size());
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("userName") String userName) {
        ObjectMapper objectMapper = new ObjectMapper();
        Message msg;
        try {
            msg = objectMapper.readValue(message, Message.class);
//            if (socketMsg.getType() == 1) {
            //单聊.需要找到发送者和接受者.
            msg.setSessionId(session.getId());
            Session fromSession = map.get(msg.getSendUserName());
            Session toSession = map.get(msg.getReceiveUserName());
            msg.setMessageId(UUIDUtil.getUUID());
            msg.setSendingTime(new Date());
            msg.setStatus(0);
            fromSession.getAsyncRemote().sendText(JSON.toJSONString(msg));
            //如何接受消息用户在线，则直接通过WebSocket发送消息
            //否则将消息存入redis数据库中，等到用户重新登陆上线再消费消息
            if (toSession != null) {
                toSession.getAsyncRemote().sendText(JSON.toJSONString(msg));
            } else {
                redisTemplate.opsForList().rightPush(msg.getReceiveUserName() + Const.MESSAGE_SUFFIX, msg);
            }
//            } else {
//                //群发消息
//                broadcast(socketMsg.getMsg());
//            }
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
        logger.error("session:{}, error: {}", session.getId(), error.getMessage());
    }

    /**
     * 群发自定义消息
     */
    public void broadcast(String message) {
        for (WebSocketService item : webSocketSet) {
            Map<String, Object> map = new HashMap<>(16);
            map.put("type", 1);
            map.put("name", userName);
            map.put("msg", message);
            item.session.getAsyncRemote().sendText(JSON.toJSONString(map));
        }
    }
}
