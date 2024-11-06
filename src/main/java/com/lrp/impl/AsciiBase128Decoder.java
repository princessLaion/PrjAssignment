package com.lrp.impl;

import com.lrp.Decode;

public class AsciiBase128Decoder implements Decode {

    @Override
    public byte[] execute(String encodedString) {
        try {
            byte[] asciiBytes = new byte[encodedString.length()];
            for (int i = 0; i < encodedString.length(); i++) {
                asciiBytes[i] = (byte) encodedString.charAt(i); // Convert each char to ASCII byte
            }
            return asciiBytes;
        } catch (NumberFormatException exception) {
            return new byte[0];
        }
    }
}
