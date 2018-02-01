package chapter4;

import java.io.InputStream;
import java.util.Scanner;

/*
*@author: pele
*@time: 2018/1/30 10:19
*@project: CrazyJava
*@description:实现subString(String a,int src,int des)的功能
*/
public class SubString {
    //subString功能函数
    static String subString(String a,int src,int des){
        //截取的长度
        int length = des - src;
        char[] b = new char[length];
        int index = 0;
        for(int i=src;i<des;i++){
            b[index] = a.charAt(i);
            index++;
        }
        String result = new String(b);
        return result;
    }
    static int a = 1;


    void test(){
        subString("",1,2);
        System.out.println(a);
    }

    public static void main(String[] args){
        System.out.println("请输入字符串：");
        Scanner scanner = new Scanner(System.in);
        String srcString = scanner.next();
        System.out.println("请输入起始位置和目标位置，用,隔开");
        String inputPosition = scanner.next();
        scanner.close();
        //处理position
        String[] position = inputPosition.split(",");
        int src = Integer.parseInt(position[0]);
        int des = Integer.parseInt(position[1]);
        String destination = subString(srcString,src,des);
        System.out.println(destination);
    }
}

