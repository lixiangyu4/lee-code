package com.lixiangyu.lee.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-07-15 10:54
 **/
public class ByteBufferTest {


    public static void testFileChannel() throws IOException {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("/Users/lixiangyu/work/log/gc-1.log", "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buff = ByteBuffer.allocate(1024);
            long timeBegin = System.currentTimeMillis();
            while (channel.read(buff) != -1) {
                buff.flip();
                buff.clear();
            }
            long timeEnd = System.currentTimeMillis();
            System.out.println("Read time: " + (timeEnd - timeBegin) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 它并不需要将数据读取到OS内核缓冲区，而是直接将进程的用户私有地址空间中的一部分区域与文件对象建立起映射关系，
     * 就好像直接从内存中读、写文件一样，速度当然快了。
     * 内存映射文件的效率比标准IO高的重要原因就是因为少了把数据拷贝到OS内核缓冲区这一步。
     * @throws IOException
     */
    public static void testMappedByteBuffer() throws IOException {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("/Users/lixiangyu/work/log/gc-1.log", "rw");
            FileChannel fc = file.getChannel();
            int len = (int) file.length();
            MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, len);
            byte[] b = new byte[1024];
            long timeBegin = System.currentTimeMillis();
            for (int offset = 0; offset < len; offset += 1024) {
                if (len - offset > 1024) {
                    buffer.get(b);
                } else {
                    buffer.get(new byte[len - offset]);
                }
            }
            long timeEnd = System.currentTimeMillis();
            System.out.println("Read time: " + (timeEnd - timeBegin) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        testFileChannel();
        testMappedByteBuffer();
    }


}
