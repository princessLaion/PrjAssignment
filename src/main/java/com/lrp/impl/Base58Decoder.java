package com.lrp.impl;

import com.lrp.Decode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Base58Decoder implements Decode {

    // For Base-58 character map
    private static final String BASE58_ACCEPTABLE_ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
    private static final Map<Character, Integer> BASE58_MAP = new HashMap<>();

    // Populate base-58 character index map
    static {
        for (int ctr = 0; ctr < BASE58_ACCEPTABLE_ALPHABET.length(); ctr++) {
            BASE58_MAP.put(BASE58_ACCEPTABLE_ALPHABET.charAt(ctr), ctr);
        }
    }

    @Override
    public byte[] execute(String encodedString) {
        try {
            BigInteger result = BigInteger.ZERO;
            BigInteger base = BigInteger.valueOf(58);

            for (char encodedChar : encodedString.toCharArray()) {
                int value = BASE58_MAP.get(encodedChar);
                result = result.multiply(base).add(BigInteger.valueOf(value));
            }

            return result.toByteArray();
        } catch (NumberFormatException exception) {
            return new byte[0];
        }
    }
}
