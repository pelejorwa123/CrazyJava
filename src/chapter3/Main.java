import java.util.*;
class Number{
    int count;
    List<Integer> numList;
    public Number(int count,List<Integer> numList){
        this.count = count;
        this.numList = numList;
    }
    public static int compare(String a,String b){
        if (a.length()<b.length()){
            return -1;
        }else if (a.length()>b.length()){
            return 1;
        }
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)<b.charAt(i)){
                return -1;
            }else if(a.charAt(i)>b.charAt(i)){
                return 1;
            }
        }
        return 0;
    }
/*
   递归调用来获取最大整数，但是当字符串较多时，效率严重不足
   public String getMaxNum(List<Integer> numList,int count){
        if(numList.size()==1){
            return numList.get(0).toString();
        }
        String max="";
        int first;
        for(first=0;first<count;first++){
            String numStr ="";
            numStr += numList.get(first);
            List<Integer> newNumList = new ArrayList<>(numList);
            newNumList.remove(first);
            numStr += getMaxNum(newNumList,count-1);
            if(compare(max,numStr)==-1){
                max = numStr;
            }
        }
        return max;
    }*/
/*
* 采用冒泡排序的方法来得到最大整数
* */
    public String getMaxNum(List<Integer> numList){
        numList.sort((o1,o2) -> {
            String o1Str = o1.toString();
            String o2Str = o2.toString();
            return (-1)*compare(o1Str+o2Str,o2Str+o1Str);
        });
        String maxNumStr = new String();
        for(Integer num:numList){
            maxNumStr += num;
        }
        return maxNumStr;
    }
}

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean isOdd = true;
        List<Number> list = new ArrayList();
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            if(s.equals(""))
                break;
            int count = Integer.parseInt(s);
            String content = scanner.nextLine();
            String[] numStrList = content.split("\\s");
            List<Integer> numList = new ArrayList();
            for(String num:numStrList){
                numList.add(Integer.parseInt(num));
            }
            Number number =  new Number(count,numList);
            list.add(number);
        }
        scanner.close();
        List<String> maxNumList = new ArrayList();
        for(Number num:list){
            maxNumList.add(num.getMaxNum(num.numList));
        }
        for(String maxNum:maxNumList){
            System.out.println(maxNum);
        }
    }
}