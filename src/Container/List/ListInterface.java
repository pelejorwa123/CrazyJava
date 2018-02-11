package Container.List;

import java.util.ArrayList;
import java.util.List;

/*
*@author: pele
*@time: 2018/2/10 20:39
*@project: CrazyJava
*@description:List接口的两个默认方法，sort(),replaceAll（）
*/
public class ListInterface {
    public static void main(String[] args){
        List<String> books = new ArrayList<>();
        //向books集合中添加四个元素
        books.add(new String("轻量级java ee企业应用实战"));
        books.add(new String("疯狂java讲义"));
        books.add(new String("疯狂Android讲义"));
        books.add(new String("疯狂IOS讲义"));
        //使用目标类型为Comparator的lambda表达式对List集合排序
        books.sort((o1,o2) -> (o1.length()-o2.length()));
        System.out.println(books);
        //使用目标类型为UnaryOperator的lambda表达式来替换所有元素
        //该lambda表达式控制使用每个字符串的长度作为新的集合元素
        books.replaceAll(ele -> (String.valueOf(ele.length())));
        System.out.println(books);
     }
}
