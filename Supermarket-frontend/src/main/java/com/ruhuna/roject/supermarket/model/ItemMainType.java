package com.ruhuna.roject.supermarket.model;

import org.json.simple.JSONObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/9/2018
 */
@XmlRootElement(name = "bank")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemMainType {
    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", id);
        jSONObject.put("type", type);
        return jSONObject.toJSONString();
    }
}
