package chapter18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void find(List<Integer> childList,int k,long accord){
        if(childList.size()==1){
            System.out.println(childList.get(0));
            return;
        }
        List<Integer> outList = new ArrayList<>();
        for(int i=0;i<childList.size();i++){
            accord++;
            if(accord % k ==0 || (accord % 10)== k){
                outList.add(childList.get(i));
            }
        }
        for(Integer each:outList){
            childList.remove(each);
        }
        find(childList,k,accord);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();
        List<Integer> childList = new ArrayList<>();
        for(int i=0;i<count;i++){
            childList.add(i+1);
        }
        if(k == 1)
            System.out.println(childList.get(childList.size()-1));
        else
            find(childList,k,0L);
    }
}
