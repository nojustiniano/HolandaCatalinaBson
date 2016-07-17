package org.hcjf.bson;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.UUID;

/**
 * @author javaito
 * @mail javaito@gmail.com
 */
public enum BsonType {

    END((byte)0x00),

    DOUBLE((byte)0x01),

    STRING((byte)0x02),

    DOCUMENT((byte)0x03),

    ARRAY((byte)0x04),

    BINARY((byte)0x05),

    BOOLEAN((byte)0x08),

    DATE((byte)0x09),

    NULL((byte)0x0A),

    REGEX((byte)0x0B),

    INTEGER((byte)0x10),

    TIMESTAMP((byte)0x11),

    LONG((byte)0x12);

    private final byte id;

    private BsonType(byte id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public byte getId() {
        return id;
    }

    /**
     *
     * @param id
     * @return
     */
    public static BsonType fromId(byte id) {
        BsonType result = null;

        for(BsonType type : BsonType.values()) {
            if(type.getId() == id) {
                result = type;
                break;
            }
        }

        return result;
    }

    /**
     *
     * @param value
     * @return
     */
    public static BsonType fromValue(Object value) {
        BsonType type = null;

        Class clazz = value.getClass();
        if(value == null) {
            type = NULL;
        } else if(Double.class.isAssignableFrom(clazz)) {
            type = DOUBLE;
        } else if(String.class.isAssignableFrom(clazz)) {
            type = STRING;
        } else if(ByteBuffer.class.isAssignableFrom(clazz)) {
            type = BINARY;
        } else if(Boolean.class.isAssignableFrom(clazz)) {
            type = BOOLEAN;
        } else if(Date.class.isAssignableFrom(clazz)) {
            type = DATE;
        } else if(Integer.class.isAssignableFrom(clazz)) {
            type = INTEGER;
        } else if(Long.class.isAssignableFrom(clazz)) {
            type = LONG;
        } else if(ByteArrayOutputStream.class.isAssignableFrom(clazz)) {
            type = BINARY;
        } else if(byte[].class.isAssignableFrom(clazz)) {
            type = BINARY;
        } else if(UUID.class.isAssignableFrom(clazz)) {
            type = BINARY;
        }

        return type;
    }
}
