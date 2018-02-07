package chapter7.Time;

import java.util.Calendar;

/*
*@author: pele
*@time: 2018/2/7 19:41
*@project: CrazyJava
*@description:Calendar类使用示例
*/
public class CalendarTest {
    public static void main(String[] args){
        Calendar calendar = Calendar.getInstance();
        //取出年
        System.out.println(calendar.get(Calendar.YEAR));
        //取出月
        System.out.println(calendar.get(Calendar.MONTH));
        //取出日
        System.out.println(calendar.get(Calendar.DATE));
        //分别设置年月日，小时，分钟，秒
        calendar.set(2003,10,23,19,44,00);
        //将年份往后推一年
        calendar.add(Calendar.YEAR,1);
        //将月份前推八个月
        calendar.roll(Calendar.MONTH,-8);
        System.out.println(calendar.getTime());
    }
}
