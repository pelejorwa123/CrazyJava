package chapter7.Time;

import java.util.Calendar;
import java.util.Date;

/*
*@author: pele
*@time: 2018/2/7 19:34
*@project: CrazyJava
*@description:java日期时间处理
*/
public class DateAndTime {
    public static void main(String[] args){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        //利用Date生成Calendar
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        //利用Calendar生成Date
        Date date2 = calendar2.getTime();
    }
}
