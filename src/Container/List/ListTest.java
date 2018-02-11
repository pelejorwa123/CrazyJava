package Container.List;

import java.util.ArrayList;
import java.util.List;

/*
*@author: pele
*@time: 2018/2/10 20:21
*@project: CrazyJava
*@description:List集合示例
*/
public class ListTest {
    public static void main(String[] args){
        List<String> books = new ArrayList();
        //向books集合添加三个元素
        books.add(new String("轻量级java ee企业应用实战"));
        books.add(new String("疯狂java讲义"));
        books.add(new String("疯狂Android讲义"));
        System.out.println(books);
        //将新字符串对象插入在第二个位置
        books.add(1,"疯狂ajax讲义");
        for(int i=0;i<books.size();i++){
            System.out.println(i+books.get(i));
        }
        //删除第三个元素
        books.remove(2);
        System.out.println(books);
        //判断指定元素在List集合中的位置
        System.out.println(books.indexOf("疯狂ajax讲义"));
        //将第二个元素替换成新的字符串对象
        books.set(1,"疯狂AJAX讲义");
        System.out.println(books);
        //取子数组
        System.out.println(books.subList(0,2));

    }
}
