package com.lrp;

public enum DataEncodingEnum {
    BASE_8(8),
    BASE_HEXA(16),
    BASE_32(32),
    BASE_64(64),
    BINARY_CODED_DECIMAL(10),
    BASE_58(58),
    BASE_ASCII(128);

    private final int base;

    DataEncodingEnum(int base){
        this.base = base;
    }

    public int getBase() {
        return base;
    }

    // Static method to get the enum constant from a string value
    public static DataEncodingEnum fromValue(int value) {
        for (DataEncodingEnum encoding : DataEncodingEnum.values()) {
            if (encoding.getBase() == value) {
                return encoding;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }
}
