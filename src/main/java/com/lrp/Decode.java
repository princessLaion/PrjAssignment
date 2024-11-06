package com.lrp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public interface Decode {
    default byte[] execute(String encodedString) {
        return null;
    }

    default byte[] execute(String encodedString, DataEncodingEnum base) {
        try {
            // Using Big Integer to handle large input
            BigInteger bigInt = new BigInteger(encodedString, base.getBase());

            // Represents the number in binary form
            byte[] binaryBytes = bigInt.toByteArray();

            // Convert each byte to unsigned byte using 0xFF values and store in a list
            List<Byte> byteList = new ArrayList<>();
            for (byte b : binaryBytes) {
                byteList.add((byte) (b & 0xFF));
            }

            byte[] result = new byte[byteList.size()];
            for (int i = 0; i < byteList.size(); i++) {
                result[i] = byteList.get(i);
            }

            return result;
        } catch (NumberFormatException exception) {
            return new byte[0];
        }
    }
}
