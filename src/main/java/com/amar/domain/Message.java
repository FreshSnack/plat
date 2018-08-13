package com.amar.domain;

/**
 * @author dingmx
 * @date 2018/8/11 01:21
 */
public class Message {

    private String id;
    private Long length;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
