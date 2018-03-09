package io.nio;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/*
*@author: pele
*@time: 2018/3/2 21:44
*@project: CrazyJava
*@description:
*/
public class FileChannelTest {
    public static void main(String[] args){
        File f = new File("FileChannelTest.java");
        try(
                FileChannel inChannel = new FileInputStream(f).getChannel();
                FileChannel outChannel = new FileOutputStream("a.txt").getChannel();
                ){
            //将FileChannel里的全部数据映射成ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY,
                    0,f.length());
            //使用UTF-8的字符集来创建解码器
            Charset charset = Charset.forName("UTF-8");
            //直接将buffer里的数据全部输出
            outChannel.write(buffer);
            //复原position，limit的位置
            buffer.clear();
            //创建解码器对象
            CharsetDecoder decoder = charset.newDecoder();
            //使用解码器将ByteBuffer转换成CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
