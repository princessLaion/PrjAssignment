package com.lrp;

import com.lrp.util.PrintHelper;

/**
 * Main class to show output for decode
 */
public class UniversalDecoder {

    private DecodeStrategy decodeStrategy = new DecodeStrategy();

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide two arguments: a string and an integer.");
            return;
        }

        String inputString = args[0];

        // Second argument, which should be the base encoding (8, 16, 32 . . .)
        // Refer to DataEncodingEnum for the baseEncoding available
        DataEncodingEnum base;

        try {
            base = DataEncodingEnum.fromValue(Integer.parseInt(args[1]));
        } catch (NumberFormatException e) {
            System.out.println("The second argument must be an integer.");
            return;
        }

        UniversalDecoder universalDecoder = new UniversalDecoder();

        byte[] decodedOctalBytes = universalDecoder.decodeStrategy.decode(inputString, base);
        System.out.print("Decoded Octal to Decimal Bytes: ");
        System.out.println(PrintHelper.printResult(decodedOctalBytes));
    }

}
