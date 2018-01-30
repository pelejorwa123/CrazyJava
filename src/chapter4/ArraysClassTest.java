package chapter4;

import java.util.Arrays;

/*
*@author: pele
*@time: 2018/1/30 9:53
*@project: CrazyJava
*@description:Arrays工具类的简单使用
*/
public class ArraysClassTest {
    public static void main(String[] args){
        //定义一个a数组
        int[] a = new int[]{3,4,5,6};
        //定义一个a2数组
        int[] a2 = new int[]{3,4,5,6};
        //利用arrays判断两个数组的内容是否完全相等,返回boolean
        System.out.println("a和a2是否相等："+ Arrays.equals(a,a2));
        //复制a数组的指定长度，生成一个新的b数组，多的位置补默认值
        int[] b = Arrays.copyOf(a,6);
        System.out.println("a数组和b数组是否相等："+Arrays.equals(a,b));
        //输出b数组的元素，即转换为字符串的格式
        System.out.println("b数组的元素为："+Arrays.toString(b));
        //对b数组进行排序
        Arrays.sort(b);
        System.out.println("b排序后的结果为："+Arrays.toString(b));
    }
}
