package com.lrp.impl;

import com.lrp.Decode;

import java.util.Base64;

public class Base64Decoder implements Decode {

    @Override
    public byte[] execute(String encodedString) {
        try {
            return Base64.getDecoder().decode(encodedString);
        } catch (NumberFormatException exception) {
            return new byte[0];
        }
    }
}
