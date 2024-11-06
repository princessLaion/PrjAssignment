package com.lrp.util;

public class PrintHelper {
    public static String printResult(byte[] decodedValue) {
        StringBuilder sbResult = new StringBuilder();
        for (byte b : decodedValue) {
            // 0xFF is to handle sign extension when converting 8 to 32 bit
            // to ensure its unsigned integer (0-255)
            sbResult.append((b & 0xFF) + " ");
        }
        return sbResult.toString();
    }
}
