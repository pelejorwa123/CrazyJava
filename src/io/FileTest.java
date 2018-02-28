package io;

import java.io.File;
import java.io.IOException;

/*
*@author: pele
*@time: 2018/2/27 17:43
*@project: CrazyJava
*@description:File类实例
*/
public class FileTest {
    public static void main(String[] args) throws IOException {
        //以当前路径创建一个File对象
        File file = new File(".");
        //直接获取文件名，输出一点
        System.out.println(file.getName());
        //获取相对路径的父路径可能出错，下面代码输出null
        System.out.println(file.getParent());
        //获取绝对路径
        System.out.println(file.getAbsolutePath());
        //获取绝对路径的上一级路径
        System.out.println(file.getAbsoluteFile().getParent());
        //在当前路径下创建一个临时文件
        File tempFile = File.createTempFile("aaa",".txt",file);
        //指定当JVM退出时删除文件
        tempFile.deleteOnExit();
        //以系统当前时间作为新文件名来创建新文件
        File newFile = new File(System.currentTimeMillis()+"");
        System.out.println("newFile文件是否存在："+newFile.exists());
        //以newFile对象来创建真正的物理文件
        newFile.createNewFile();
        //以newFile对象创建一个目录，因为newFile已经存在
        //所以下面方法返回false，即无法创建该目录
        newFile.mkdir();
        //使用list()方法列出当前路径下的所有文件和路径
        String[] fileList = file.list();
        System.out.println("====当前路径下所有文件和路径如下====");
        for(String fileName : fileList){
            System.out.println(fileName);
        }
        //listRoots()静态方法列出所有的磁盘根路径
        File[] roots = File.listRoots();
        System.out.println("====系统所有根路径如下====");
        for(File root:roots){
            System.out.println(root);
        }
    }
}
