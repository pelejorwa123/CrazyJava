package chapter7.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
*@author: pele
*@time: 2018/2/7 20:36
*@project: CrazyJava
*@description:SimpleDateFormat类的使用
*/
public class SimpleFormatTest {
    public static void main(String[] args) throws ParseException {
        Date d = new Date();
        //创建一个SimpleDateFoemat对象
        SimpleDateFormat sdf1 = new SimpleDateFormat("Gyyyy年");
        String dStr = sdf1.format(d);
        System.out.println(dStr);
        //一个非常特殊的日期字符串
        String str = "14###三月##21";
        SimpleDateFormat sdf2 = new SimpleDateFormat("y###MMM##d");
        System.out.println(sdf2.parse(str));
    }
}
