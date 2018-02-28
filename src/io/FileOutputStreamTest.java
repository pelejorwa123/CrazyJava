package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
*@author: pele
*@time: 2018/2/27 21:26
*@project: CrazyJava
*@description:
*/
public class FileOutputStreamTest {
    public static void main(String[] args){
        try(
            //创建字节输入流
            FileInputStream inputStream = new FileInputStream("FileOutputStreamTest.java");
            FileOutputStream outputStream = new FileOutputStream("newFile.txt");
        ) {
           byte[] buff = new byte[32];
           int hasRead = 0;
           while ((hasRead = inputStream.read(buff))>0){
               outputStream.write(buff,0,hasRead);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
