package com.koala;

import org.json.JSONException;
import org.json.JSONObject;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 聊天室服务器.
 * @author Marting.Lee
 * 2020/1/7
 */

@ServerEndpoint("/websocket/{roomName}")
public class ChatServer {
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final Map<String, Set<Session>> rooms = new ConcurrentHashMap<>();


    /**
     * 用户接入
     * @param session 可选
     */
    @OnOpen
    public void onOpen(@PathParam("roomName")String roomName,Session session){
        if (!rooms.containsKey(roomName)){//如果房间不存在，创建房间
            Set<Session> room = new HashSet<>();
            room.add(session);
            rooms.put(roomName,room);
        }else {
            rooms.get(roomName).add(session);//加入房间
        }
        System.out.println("客户端已连接");
    }

    /**
     * 接收到来自用户的消息
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(@PathParam("roomName") String roomName, String message,Session session) throws JSONException {

        //把用户发来的消息解析为JSON对象
        JSONObject obj = new JSONObject(message);
        //向JSON对象中添加发送时间
        obj.put("date", df.format(new Date()));
        //遍历聊天室中的所有会话
        for(Session se : rooms.get(roomName)){
            //设置消息是否为自己的
            obj.put("isSelf", se.equals(session));
            //发送消息给远程用户
            se.getAsyncRemote().sendText(obj.toString());
        }
    }

    /**
     * 用户断开
     * @param session
     */
    @OnClose
    public void onClose(@PathParam("roomName") String roomName,Session session){
        rooms.get(roomName).remove(session);
        System.out.println("客户端已断开");
    }

    /**
     * 用户连接异常
     * @param t
     */
    @OnError
    public void onError(Throwable t){

    }
}
