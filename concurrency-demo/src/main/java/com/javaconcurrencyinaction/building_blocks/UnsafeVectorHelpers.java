package com.javaconcurrencyinaction.building_blocks;

import java.util.Vector;

/**
 * @author junlin_huang
 * @create 2020-10-20 上午12:19
 **/

public class UnsafeVectorHelpers {
    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public static void deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }

}