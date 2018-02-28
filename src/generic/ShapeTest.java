package generic;


import java.util.ArrayList;
import java.util.List;

/*
*@author: pele
*@time: 2018/2/13 17:39
*@project: CrazyJava
*@description:类型通配符使用
*/
abstract class Shape{
    public abstract void draw(Canvas c);
}
//定义Shape的子类Circle
class Circle extends Shape{
    @Override
    public void draw(Canvas c) {
        System.out.println(c+"这是Circle");
    }
}
//定义Shape的子类RecTangle
class RecTangle extends Shape{
    @Override
    public void draw(Canvas c) {
        System.out.println(c+"这是RecTangle");
    }
}
class Canvas{
    //同时画多个形状
    public void drawAll(List<? extends Shape> shapes){
        for(Shape s:shapes){
            s.draw(this);
        }
    }
}
public class ShapeTest {
    public static void main(String[] args){
        List<Circle> circleList = new ArrayList<>();
        Canvas canvas = new Canvas();
        canvas.drawAll(circleList);
    }
}
