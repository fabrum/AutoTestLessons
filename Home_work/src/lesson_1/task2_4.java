package lesson_1;
import java.util.Scanner;


public class task2_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number mass: ");
        int size = in.nextInt();
        System.out.println("-->");
        int[] mass = new int[size];
        for (int i = 0; i < size; i++) {
            mass[i] = (int) (Math.random() * 100);
        }
        Print_mass(mass, size);
        int numb_0 = 0;
        for (int i = 0; i < size; i++) {
            if (mass[i] == 0) {
                ++numb_0;
            }
        }
        if (numb_0 != 0) {
            System.out.println("количестуо нулей =" + numb_0);
        } else {
            System.out.println("нулей нет :(");
        }
    }

    static void Print_mass(int[] mass, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(mass[i] + " ");
        System.out.println();
    }

}
