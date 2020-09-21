package com.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Multiply_43 {


    @Test
    public void testMultiply() {
        System.out.println(multiply("2", "3"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String first;
        String second;
        if (num1.length() >= num2.length()) {
            first = num1;
            second = num2;
        } else {
            first = num2;
            second = num1;
        }
        int j = second.length() - 1;
        List<String> result = new ArrayList<>();
        while (j != -1) {
            String temp = "";
            int plus = 0;
            for (int i = first.length() - 1; i >= 0; i--) {
                int multiply = Integer.parseInt(String.valueOf(first.charAt(i))) * Integer.parseInt(String.valueOf(second.charAt(j)));
                multiply = multiply + plus;
                plus = multiply / 10;
                temp = multiply % 10 + temp;
            }
            if (plus != 0) {
                temp = plus + temp;
            }
            int p = second.length() - 1 - j;
            while (p > 0) {
                temp = temp + "0";
                p--;
            }
            j--;
            StringBuilder sb = new StringBuilder(temp);
            result.add(sb.reverse().toString());
        }
        return add(result);
    }


    public String add(List<String> list) {
        int maxLength = list.get(list.size() - 1).length();
        String result = "";
        int plus = 0;
        for (int p = 0; p < maxLength; p++) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).length() > p) {
                    sum = sum + Integer.parseInt(String.valueOf(list.get(i).charAt(p)));
                }
            }
            sum = sum + plus;
            plus = sum / 10;
            result = sum % 10 + result;
        }
        if (plus != 0) {
            result = plus + result;
        }
        return result;
    }
}