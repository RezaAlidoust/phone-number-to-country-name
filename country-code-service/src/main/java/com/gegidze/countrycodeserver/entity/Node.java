package com.gegidze.countrycodeserver.entity;

import java.util.HashMap;

public class Node {
    private HashMap<Integer, Node> children;
    private String country;

    public Node() {
        children = new HashMap<>(10, 1);
    }

    public void addChild(int key, Node node) {
        this.children.put(key, node);
    }

    public HashMap<Integer, Node> getChildren() {
        return children;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
