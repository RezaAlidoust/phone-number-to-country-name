package com.gegidze.countrycodeserver.data;

import com.gegidze.countrycodeserver.entity.CountryCode;
import com.gegidze.countrycodeserver.entity.Node;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import static com.gegidze.countrycodeserver.helper.Helper.convertIntToDigitArray;

@Repository
@DependsOn({"countryCodesTree"})
public class CountryCodesRepositoryImpl implements CountryCodesRepository {

    private final Node node;

    CountryCodesRepositoryImpl(Node node) {
        this.node = node;
    }

    @Override
    public String get(ArrayList<Long> path) {
        Node parent = this.node;
        String lastCountryName = null;
        for (Long key : path) {
            if (parent.getChildren().get(key) != null) {
                parent = parent.getChildren().get(key);
                lastCountryName = parent.getCountry() != null ? parent.getCountry() : lastCountryName;
            } else break;
        }
        return lastCountryName;
    }

    @Override
    public void saveAll(ArrayList<CountryCode> countryCodes) {
        for (CountryCode countryCode : countryCodes) {
            insertWithPath(this.node, convertIntToDigitArray(countryCode.getCode()), countryCode.getCountry());
        }
    }

    @Override
    public Node insertWithPath(Node parent, ArrayList<Long> path, String value) {
        Node current;
        if (parent.getChildren().get(path.get(0)) != null)
            current = parent.getChildren().get(path.get(0));
        else current = new Node();

        if (path.size() == 1) {
            current.setCountry(value);
            parent.addChild(path.get(0), current);
            return current;
        } else {
            parent.addChild(path.get(0), current);
            path.remove(0);
            return insertWithPath(current, path, value);
        }
    }
}
