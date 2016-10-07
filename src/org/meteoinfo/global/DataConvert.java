/* Copyright 2012 Yaqiang Wang,
 * yaqiang.wang@gmail.com
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or (at
 * your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser
 * General Public License for more details.
 */
package org.meteoinfo.global;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author Yaqiang Wang
 */
public class DataConvert {

    /**
     * Byte array convert to float
     *
     * @param b Byte array
     * @param byteOrder Byte order
     * @return Float value
     */
    public static float bytes2Float(byte[] b, ByteOrder byteOrder) {
        ByteBuffer buf = ByteBuffer.wrap(b);
        buf.order(byteOrder);
        return buf.getFloat();
    }
    
    /**
     * Byte array convert to double
     *
     * @param b Byte array
     * @param byteOrder Byte order
     * @return Double value
     */
    public static double bytes2Double(byte[] b, ByteOrder byteOrder) {
        ByteBuffer buf = ByteBuffer.wrap(b);
        buf.order(byteOrder);
        return buf.getDouble();
    }

    /**
     * Byte array convert to integer
     *
     * @param bytes Byte array
     * @param byteOrder Byte order
     * @return Integer value
     */
    public static int bytes2Int(byte[] bytes, ByteOrder byteOrder) {
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        buf.order(byteOrder);
        if (bytes.length == 4) {
            return buf.getInt();
        } else {
            return buf.getShort();
        }
    }
    
    /**
     * Byte array convert to short integer
     *
     * @param bytes Byte array
     * @param byteOrder Byte order
     * @return Short integer value
     */
    public static short bytes2Short(byte[] bytes, ByteOrder byteOrder) {
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        buf.order(byteOrder);
        return buf.getShort();
    }

    /**
     * Byte array convert to integer
     *
     * @param bytes byte array
     * @return Integer value
     */
    public static int bytes2Int(byte[] bytes) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
        }
        return result;
    }

    /**
     * Convert byte to int - byte in Java is signed
     *
     * @param b Input byte
     * @return Output integer
     */
    public static int byte2Int(byte b) {
        return b >= 0 ? (int) b : (int) (b + 256);
    }

    /**
     * Convert LittleEndian to BigEndian
     *
     * @param bytes Input LittleEndian byte array
     * @return Output BigEndian byte array
     */
    public static byte[] littleToBig(byte[] bytes) {
        if (bytes == null) {
            throw new NullPointerException();
        }
        byte[] temp = new byte[bytes.length];
        for (int i = bytes.length - 1; i >= 0; i--) {
            temp[i] = bytes[bytes.length - 1 - i];
        }
        return temp;
    }

    /**
     * Convert BigEndian to LittleEndian
     *
     * @param bytes Input BigEndian byte array
     * @return Output LittleEndian byte array
     */
    public static byte[] bigToLittle(byte[] bytes) {
        return littleToBig(bytes);
    }

    /**
     * Convert int to byte array.
     *
     * @param i Int value
     * @return Byte array
     */
    public static byte[] toBytes(int i) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (i >> 24 & 0xff);
        bytes[1] = (byte) (i >> 16 & 0xff);
        bytes[2] = (byte) (i >> 8 & 0xff);
        bytes[3] = (byte) (i & 0xff);
        return bytes;
    }
    
    /**
     * Convert int to byte array.
     *
     * @param i Int value
     * @return Byte array
     */
    public static int[] toUint3Int(int i) {
        int[] ints = new int[3];
        ints[0] = (i >> 16 & 0xff);
        ints[1] = (i >> 8 & 0xff);
        ints[2] = (i & 0xff);
        return ints;
    }

    /**
     * Convert int to byte array - LittleEndian
     *
     * @param i Int value
     * @return Byte array
     */
    public static byte[] toLittleBytes(int i) {
        byte[] bytes = new byte[4];
        bytes[3] = (byte) (i >> 24 & 0xff);
        bytes[2] = (byte) (i >> 16 & 0xff);
        bytes[1] = (byte) (i >> 8 & 0xff);
        bytes[0] = (byte) (i & 0xff);
        return bytes;
    }

    /**
     * Convert float to byte array
     *
     * @param f Float value
     * @return Byte array
     */
    public static byte[] toBytes(float f) {
        return toBytes(Float.floatToIntBits(f));
    }

    /**
     * Convert float to byte array
     *
     * @param f Float value
     * @param byteOrder ByteOrder
     * @return Byte array
     */
    public static byte[] float2Bytes(float f, ByteOrder byteOrder) {
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.order(byteOrder);
        buf.putFloat(f);
        return buf.array();
    }

    /**
     * Convert float to byte array
     *
     * @param f Float array
     * @return Byte array
     */
    public static byte[] toLittleBytes(float f) {
        return toLittleBytes(Float.floatToIntBits(f));
    }    

    /**
     * Resize array
     *
     * @param oldArray Old array
     * @param newSize New size
     * @return Resized array
     */
    public static Object resizeArray(Object oldArray, int newSize) {
        int oldSize = java.lang.reflect.Array.getLength(oldArray);
        Class elementType = oldArray.getClass().getComponentType();
        Object newArray = java.lang.reflect.Array.newInstance(
                elementType, newSize);
        int preserveLength = Math.min(oldSize, newSize);
        if (preserveLength > 0) {
            System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
        }
        return newArray;
    }

    /**
     * Resize double 2d array
     *
     * @param oldArray Old array
     * @param newSize New size
     * @return Resized array
     */
    public static double[][] resizeArray2D(double[][] oldArray, int newSize) {
        int ynum = oldArray.length;
        int xnum = oldArray[0].length;
        double[][] newArray = new double[newSize][xnum];
        for (int j = 0; j < ynum; j++) {
            for (int i = 0; i < xnum; i++) {
                newArray[j][i] = oldArray[j][i];
            }
        }
        return newArray;
    }

    /**
     * Double to string
     *
     * @param v The double value
     * @return Result string
     */
    public static String doubleToString(double v) {
        BigDecimal a = new BigDecimal(Double.toString(v));
        a = a.setScale(12, BigDecimal.ROUND_HALF_UP);
        return a.stripTrailingZeros().toPlainString();
    }

    /**
     * Remove tail zero
     *
     * @param s The string
     * @return Result string
     */
    public static String removeTailingZeros(String s) {
        if (s.equals("0.0"))
            s = "0";
        if (s.length() <= 1)
            return s;
        if (s.substring(s.length() - 2).equals(".0"))
            return new BigDecimal(s).stripTrailingZeros().toPlainString();
        else
            return s;
    }
}
