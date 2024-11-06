package com.lrp;

public class EncodeBytesToOctal {

    // Encodes a byte array into an octal string
    public static String encode(byte[] byteArray) {
        StringBuilder octalString = new StringBuilder();

        // Convert to a 3-digit octal string
        for (byte b : byteArray) {
            // Treat the byte as unsigned by masking with 0xFF
            int unsignedByte = b & 0xFF;

            // Convert unsigned byte to octal string
            String octal = Integer.toOctalString(unsignedByte);

            // Ensure 3-digit format for each byte and Pad with leading zeros if necessary
            while (octal.length() < 3) {
                octal = "0" + octal;
            }

            octalString.append(octal);
        }

        return octalString.toString();
    }
}
