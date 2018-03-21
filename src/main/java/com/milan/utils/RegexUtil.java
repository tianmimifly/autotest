package com.milan.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    ///匹配
    public static String getMatcher(String regex, String source) {
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }
}
