package com.gegidze.countrycodeserver.helper;

import java.util.ArrayList;

import static java.util.Collections.reverse;

public class Helper {

    public static ArrayList<Long> convertIntToDigitArray(long num) {
        ArrayList<Long> array = new ArrayList<>();
        do {
            array.add(num % 10);
            num /= 10;
        } while (num > 0);
        reverse(array);
        return array;
    }
}
