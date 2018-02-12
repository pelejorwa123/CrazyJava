package Container.List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
*@author: pele
*@time: 2018/2/11 21:46
*@project: CrazyJava
*@description:List的ListIterator示例
*/
public class ListIteratorTest {
    public static void main(String[] args){
        String[] books = {"疯狂java讲义","疯狂IOS讲义","轻量级java ee企业应用实战"};
        List<String> bookList = new ArrayList();
        for(int i=0;i<books.length;i++){
            bookList.add(books[i]);
        }
        ListIterator<String> listIterator = bookList.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
            //ListIterator增加了add方法
            listIterator.add("-----分隔符-----");
        }
        //可以反向迭代
        System.out.println("开始反向迭代");
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }
}
