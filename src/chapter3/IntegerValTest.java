package chapter3;

/*
*@author: pele
*@time: 2018/1/29 12:33
*@project: CrazyJava
*@description:直接给long类型的数据赋值时要注意格式，直接赋予证书是错误的
*/
public class IntegerValTest {
    //下面代码正确，系统会自动把56当成byte类型处理
    byte a = 56;
    /*
       下面代码是错误的，系统不会把9999999999当作long类型处理
      而是将9999999999默认为int类型，再强转为long类型
       所以超出int的表示范围，从而引起错误
     */
    //long bigValue = 9999999999;
    //下面代码是正确的，在巨大的整数值后使用L后缀，强制使用Long类型
    long bigValue2 = 9999999999L;
}
