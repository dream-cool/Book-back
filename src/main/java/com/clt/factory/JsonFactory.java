package com.clt.factory;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ：clt
 * @Date ：Created in 19:52 2020/02/28
 */
public class JsonFactory {
    private JsonFactory() {
    }

    /**
     * 封装添加json格式Ztree节点的空模块
     */
    public static JSONObject getTreeNode() {
        JSONObject obj = new JSONObject();
        obj.put("isParent", null);
        obj.put("name", null);
        obj.put("typeName", null);
        obj.put("pid", null);
        obj.put("id", null);
        obj.put("level", null);
        return obj;
    }

    /**
     * 封装添加json格式Ztree节点的数据模块
     */
    public static JSONObject getTreeNode(String isParent, String name, String typeName,
                                         String pid, String id, String level) {
        JSONObject obj = new JSONObject();
        obj.put("isParent", isParent);
        obj.put("name", name);
        obj.put("typeName", typeName);
        obj.put("pid", pid);
        obj.put("id", id);
        obj.put("level", level);
        return obj;
    }
}

