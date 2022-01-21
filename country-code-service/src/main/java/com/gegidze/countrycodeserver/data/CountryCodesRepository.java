package com.gegidze.countrycodeserver.data;

import com.gegidze.countrycodeserver.entity.CountryCode;
import com.gegidze.countrycodeserver.entity.Node;

import java.util.ArrayList;

public interface CountryCodesRepository {
    String get(ArrayList<Long> path);

    void saveAll(ArrayList<CountryCode> key);

    Node insertWithPath(Node parent, ArrayList<Long> path, String value);
}
