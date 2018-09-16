package com.ruhuna.roject.supermarket.model;

import org.json.simple.JSONObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/13/2018
 */
@XmlRootElement(name = "itemSubType")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemSubType {
    private int id;
    private String type;
    private int itemMainTypeId;

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

    public int getItemMainTypeId() {
        return itemMainTypeId;
    }

    public void setItemMainTypeId(int itemMainTypeId) {
        this.itemMainTypeId = itemMainTypeId;
    }

    @Override
    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", id);
        jSONObject.put("itemMainTypeId", itemMainTypeId);
        jSONObject.put("type", type);
        return jSONObject.toJSONString();
    }
}
