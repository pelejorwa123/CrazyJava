package chapter18;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/*
*@author: pele
*@time: 2018/3/1 15:53
*@project: CrazyJava
*@description:
*/
interface UserService{
    String getName(int id);
    String getAge(int id);
}
class UserServiceImpl implements UserService{
    public String getName(int id) {
        return "name："+id;
    }
    public String getAge(int id) {
        return "age:"+id;
    }
}
class MyInvocationHandler implements InvocationHandler{
    Object target;
    public MyInvocationHandler(Object target){
        this.target = target;
    }
    public MyInvocationHandler(){}
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---代理"+method.getName()+"---");
        Object result = method.invoke(target,args);
        return result;
    }
}
public class ProxyTest2 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(userService);
        //生成动态代理对象UserService
        UserService proxyUser=(UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), handler);
        //调用代理对象，实现的是invoke方法，invoke方法实现的是在原方法基础上加上打印信息
        System.out.println(proxyUser.getAge(1));
        System.out.println(proxyUser.getName(1));
    }
}
