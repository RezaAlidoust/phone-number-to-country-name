package com.gegidze.countrycodeserver.entity;

import java.util.HashMap;

public class Node {
    private HashMap<Long, Node> children;
    private String country;

    public Node() {
        children = new HashMap<>(10, 1);
    }

    public void addChild(Long key, Node node) {
        this.children.put(key, node);
    }

    public HashMap<Long, Node> getChildren() {
        return children;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
