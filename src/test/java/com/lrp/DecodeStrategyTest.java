package com.lrp;

import com.lrp.util.PrintHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeStrategyTest {

    private DecodeStrategy decodeStrategy;

    @BeforeEach
    void setUp() {
        decodeStrategy = new DecodeStrategy();
    }

    @Test
    public void testBase8Decode() {
        byte[] result = decodeStrategy.decode("31646541", DataEncodingEnum.BASE_8);

        assertEquals("103 77 97 ", PrintHelper.printResult(result));
    }

    @Test
    public void testBase8Encode() {
        EncodeBytesToOctal encodeBytes = new EncodeBytesToOctal();
        String encodedValue = encodeBytes.encode(new byte[] {103, 77, 97});
        assertEquals("147115141", encodedValue);
    }

    @Test
    public void testLongInputBase8Decode() {
        String input = "2277114742311135167021343424004141432061264036716605455"
                + "35070012425145143366515462107042711115720106717127670062"
                + "71704657770433346073017047360217626325467150763006577133"
                + "54152655466766041402716542311111131505761476052650004524"
                + "21616177052165224543311447543654741617367042213645643631"
                + "33346575330621635642541636644326535501666004333326756424"
                + "47003252221104064117622317044717471111";

        byte[] result = decodeStrategy.decode(input, DataEncodingEnum.BASE_8);

        assertEquals("37 249 51 196 201 46 157 194 46 56 160 16 195 26 24 173 3 220 236 44 181 209 192 42 42 101 49 189 169 179 34 56 139 146 77 232 17 185 229 125 192 203 158 38 191 241 27 115 14 193 226 119 130 63 44 213 155 154 62 96 107 249 110 195 86 182 109 246 16 192 185 214 38 73 36 179 69 248 207 133 90 128 37 81 28 113 252 84 117 74 88 217 50 123 30 179 195 143 123 136 145 122 93 30 101 183 53 245 177 145 206 232 172 57 237 35 90 187 65 219 1 27 109 111 116 82 112 26 169 34 68 26 19 242 76 241 39 62 114 73 ", PrintHelper.printResult(result));
    }

    @Test
    public void testNullInputException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Code that you expect to throw an exception
            decodeStrategy.decode(null, DataEncodingEnum.BASE_58);
        });

        String expectedMessage = "Input and encoding are required";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testBase8DecodeNumberFormatException() {
        byte[] result = decodeStrategy.decode("3164AAAA41", DataEncodingEnum.BASE_8);;
        assertEquals(0, result.length);
    }

    @Test
    public void testBase58Decode() {
        byte[] result = decodeStrategy.decode("2NEpo7TZRRrLZSi2U", DataEncodingEnum.BASE_58);

        assertEquals("72 101 108 108 111 32 87 111 114 108 100 33 ", PrintHelper.printResult(result));
    }

    @Test
    public void testAsciiBase128Decode() {
        byte[] result = decodeStrategy.decode("Hello", DataEncodingEnum.BASE_ASCII);

        assertEquals("72 101 108 108 111 ", PrintHelper.printResult(result));
    }

    @Test
    public void testHexaDecode() {
        byte[] result = decodeStrategy.decode("4A6F686E", DataEncodingEnum.BASE_HEXA);
        assertEquals("74 111 104 110 ", PrintHelper.printResult(result));
    }

    @Test
    public void testBase32Decode() {
        byte[] result = decodeStrategy.decode("1VG4M", DataEncodingEnum.BASE_32);
        assertEquals("31 192 150 ", PrintHelper.printResult(result));
    }
}