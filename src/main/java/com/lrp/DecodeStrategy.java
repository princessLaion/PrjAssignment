package com.lrp;

import com.lrp.impl.AsciiBase128Decoder;
import com.lrp.impl.Base58Decoder;
import com.lrp.impl.Base64Decoder;
import com.lrp.impl.Decoder;
import org.apache.commons.lang3.StringUtils;

public class DecodeStrategy {
    private Decode decoder;

    // Select decoding strategy based from encoding
    public byte[] decode(String input, DataEncodingEnum encoding) {
        if(StringUtils.isEmpty(input)
            || encoding == null) {
            throw new IllegalArgumentException("Input and encoding are required");
        }

        if (encoding.getBase() == DataEncodingEnum.BASE_64.getBase()) {
            decoder = new Base64Decoder();
        } else if (encoding.getBase() == DataEncodingEnum.BASE_58.getBase()) {
            decoder = new Base58Decoder();
        } else if (encoding.getBase() == DataEncodingEnum.BASE_ASCII.getBase()) {
            decoder = new AsciiBase128Decoder();
        } else {
            //Default
            decoder = new Decoder();
            return decoder.execute(input, encoding);
        }

        return decoder.execute(input);
    }
}
