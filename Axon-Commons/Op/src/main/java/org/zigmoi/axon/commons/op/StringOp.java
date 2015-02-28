package org.zigmoi.axon.commons.op;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Zigmoi-Code on 3/1/2015.
 */


public class StringOp {

    private final static String symbols = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789`~!@#$%^&*()_+-=|;:,<.>?*";

    static Random rnd = new Random();

    static int seq = 1;

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean stringsMatch(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 != null) {
            return str1.equals(str2);
        }
        return str2.equals(str1);
    }

    public static String[] split(String str, char delimiter) {
        return split(str, delimiter, false);
    }

    public static String[] split(String str, char delimiter, boolean removeEmpty) {
        final int len = (str == null) ? 0 : str.length();
        if (len == 0) {
            return new String[0];
        }

        final List<String> result = new ArrayList<>();
        String elem = null;
        int i = 0, j = 0;
        while (j != -1 && j < len) {
            j = str.indexOf(delimiter, i);
            elem = (j != -1) ? str.substring(i, j) : str.substring(i);
            i = j + 1;
            if (!removeEmpty || !(elem == null || elem.length() == 0)) {
                result.add(elem);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static String join(String[] parts, String delim) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            result.append(part);
            if (delim != null && i < parts.length - 1) {
                result.append(delim);
            }
        }
        return result.toString();
    }

    public static String chop(String aString) {
        if (aString == null) {
            return null;
        }
        if (aString.length() == 0) {
            return "";
        }
        if (aString.length() == 1) {
            return "";
        }
        return aString.substring(0, aString.length() - 1);
    }

    public static String replaceMultiple(String str, Map<String, String> replaceMap) {
        for (String toBeReplaced : replaceMap.keySet()) {
            String replacedWith = replaceMap.get(toBeReplaced);
            str = str.replaceAll(toBeReplaced, replacedWith);
        }
        return str;
    }

    public static String getRandomString(int len, String ignoreChars) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(symbols.charAt(rnd.nextInt(symbols.length())));
            if (ignoreChars.indexOf(sb.charAt((sb.length() - 1))) >= 0) {
                sb.deleteCharAt(sb.length() - 1);
                i--;
            }
        }
        return sb.toString();
    }

    public static String getRandomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(symbols.charAt(rnd.nextInt(symbols.length())));
        }
        return sb.toString();
    }

    public static synchronized String getUniqueId() {
        return DateTimeOp.getSysDateCCYYMMDD() + "-"
                + DateTimeOp.getSysTimeHHMMSSMS() + "-"
                + seq;
    }

    public static String reverse(String data) {
        return new StringBuilder(data).reverse().toString();
    }

    public static String leftPad(String data, int size, String padString) {
        return StringUtils.leftPad(data, size, padString);
    }

    public static String rightPad(String data, int size, String padString) {
        return StringUtils.rightPad(data, size, padString);
    }

    public static String trimLeading(String data, String trimString) {
        return StringUtils.stripStart(data, trimString);
    }
}
