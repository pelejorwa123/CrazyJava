package chapter7.ScannerTest;

import java.util.Scanner;

/*
*@author: pele
*@time: 2018/2/7 13:34
*@project: CrazyJava
*@description:
*/
public class ScannerLongTest {
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String input = scanner.nextLine();
            if(input.equals(""))
                break;
            System.out.println(input);
        }
    }
}
