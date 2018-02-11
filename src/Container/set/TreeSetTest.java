package Container.set;

import java.util.TreeSet;

/*
*@author: pele
*@time: 2018/2/10 15:52
*@project: CrazyJava
*@description:TreeSet示例
*/
public class TreeSetTest {
    public static void main(String[] args){
        TreeSet<Integer> nums = new TreeSet();
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);
        //输出集合元素，看到集合元素已经处于排序状态
        System.out.println(nums);
        //输出集合第一个元素
        System.out.println(nums.first());
        //输出集合最后一个元素
        System.out.println(nums.last());
        //返回小于4的子集，不包含4
        System.out.println(nums.headSet(4));
        //返回大于5的自己，包含5
        System.out.println(nums.tailSet(5));
        //返回大于等于-3，小于4的子集
        System.out.println(nums.subSet(-3,4));
    }
}
