package example;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testExample {

    public static void main(String[] args)
            throws InterruptedException, RemoteException, MalformedURLException {

        testesxiuuu();
    /*Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập vào số thứ nhất: ");
    int num1 = scanner.nextInt();
    System.out.println("Nhập vào số thứ hai: ");
    int num2 = scanner.nextInt();
    int phanNg = num1 / num2;
    int phanDu = num1 % num2;
    System.out.println("Phần nguyên là: " + phanNg);
    System.out.println("Phần dư là: " + phanDu);*/
    }

    public static int testesxiuuu()
            throws MalformedURLException, RemoteException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("so a la: ");
            int a = scanner.nextInt();
            a = (int) Integer.parseInt(String.valueOf(a));
            System.out.println("so b la: ");
            int b = scanner.nextInt();
            int phanNg = (int) (a / b);
            System.out.println("Phần nguyên là: " + phanNg);
        } catch (Exception e) {
            System.out.println("wrong format");
        }
        return 1;
    }

    @Test
    public String testReturnText() {

        String a = "nghia hahaha";
        System.out.println(a);
        return a;

    }

    public List<String> nghiaJava() throws Exception {
        List<Integer> listExample = new ArrayList<>();
        int a = 1;
        int listSize = 5;
        while (true) {
            try {
                if (a > 0) {
                    for (int i = 0; i < listSize; i++) {
                        listExample.add(i);
                    }
                }
                else{
                    System.out.println("Nghiahahaha");
                }


            } catch (Exception e) {
                throw e;
            }


        }


    }



}
