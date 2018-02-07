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
            i++;
        }
        return 0;
    }
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
            maxNumList.add(num.getMaxNum(num.numList,num.count));
        }
        for(String maxNum:maxNumList){
            System.out.println(maxNum);
        }
    }
}