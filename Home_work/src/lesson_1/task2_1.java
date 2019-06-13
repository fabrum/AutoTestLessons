package lesson_1;
import java.util.Scanner;


public class task2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number mass: ");
        int size = in.nextInt();
        System.out.println("-->");
        int[] mass = new int[size];
        for (int i = 0; i < size; i++) {
            mass[i] = (int) (Math.random() * 100);
        }

        for (int i = 0; i < size; i++) {
            System.out.print(mass[i] + " ");
        }
        System.out.println();
        System.out.println("<--");
        int i = size - 1;
        while (i >= 0) {
            System.out.print(mass[i] + " ");
            i--;
        }


    }

}
