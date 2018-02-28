package io.serializable;

import java.io.*;

/*
*@author: pele
*@time: 2018/2/28 10:43
*@project: CrazyJava
*@description:Person对象自定义序列示例
*/
class Person implements Serializable{
    private String name;
    private int age;
    //注意此处没有提供无参数的构造器
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    //省略getter和Setter方法
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
        System.out.println("执行的是自定义的序列化方法");
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.name = ((StringBuffer)in.readObject()).reverse().toString();
        this.age = in.readInt();
        System.out.println("执行的是自定义的反序列方法");
    }
}
public class PersonCustomSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("pele",20);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("output.txt"));
        out.writeObject(person);
        //只会序列化一次person对象
        out.writeObject(person);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("output.txt"));
        Person person2 = (Person) in.readObject();
        System.out.println(person == person2);
        Person person3 = (Person) in.readObject();
        //person2和person3其实是同一个对象
        System.out.println(person2==person3);
    }
}
