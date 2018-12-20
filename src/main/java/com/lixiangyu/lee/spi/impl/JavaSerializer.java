package com.lixiangyu.lee.spi.impl;

import com.lixiangyu.lee.spi.ObjectSerializer;

import java.io.*;

/**
 * @program: leecode
 * @description: java序列化
 * @author: lixiangyu
 * @create: 2018-11-01 14:05
 **/
public class JavaSerializer implements ObjectSerializer {
    @Override
    public byte[] serialize(Object obj) throws Exception {
        ByteArrayOutputStream arrayOutputStream;
        try {
            arrayOutputStream = new ByteArrayOutputStream();
            ObjectOutput objectOutput = new ObjectOutputStream(arrayOutputStream);
            objectOutput.writeObject(obj);
            objectOutput.flush();
            objectOutput.close();
        } catch (IOException e) {
            throw new Exception("JAVA serialize error " + e.getMessage());
        }
        return arrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deSerialize(byte[] param, Class<T> clazz) throws Exception {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(param);
        try {
            ObjectInput input = new ObjectInputStream(arrayInputStream);
            return (T) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception("JAVA deSerialize error " + e.getMessage());
        }
    }

    @Override
    public String getSchemeName() {
        return "javaSerializer";
    }
}
