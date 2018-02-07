package chapter7.Random;

import java.util.Random;

/*
*@author: pele
*@time: 2018/2/7 15:44
*@project: CrazyJava
*@description:生成随机数例子。
*/
public class RandomTest {
    public static void main(String[] args){
        //以当前时间作为种子
        Random random = new Random();
        System.out.println(random.nextBoolean());
        //生成0.0~1.0之间的伪随机double数
        System.out.println(random.nextDouble());
        //生成0.0~1.0之间的伪随机float数
        System.out.println(random.nextFloat());
        //生成一个处于int整数范围的伪随机整数
        System.out.println(random.nextInt());
        //生成一个处于限定大小范围的伪随机int
        System.out.println(random.nextInt(26));
        //生成一个处于long整数范围内的伪随机整数
        System.out.println(random.nextLong());
    }
}
