package ngay_1_introduceJava.thuc_hanh;

import java.util.Collections;
import java.util.Scanner;

public class AreaRectangle {
    public static void main(String[] args) {
        float height;
        float width;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width: ");
        width = scanner.nextFloat();
        System.out.println("Enter height: ");
        height = scanner.nextFloat();
        float area = width * height;
        System.out.println(area);
       
    }
}
