package lesson_1;
import java.util.Scanner;


public class task2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number mass: ");
        int size = in.nextInt();

        int[] mass = new int[size];
        for (int i = 0; i < size; i++) {
            mass[i] = (int) (Math.random() * 100);
        }
        double prizv = 1;
        for (int i = 0; i < size; i++) {
            //System.out.println(prizv+ "*" + mass[i] );
            prizv = prizv * mass[i];
        }

        System.out.println("получаются слишком большие числа , по этому  double ~(*_* ~)");
        System.out.println("m[]* = " + prizv);

    }

}
