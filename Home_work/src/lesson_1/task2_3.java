package lesson_1;
import java.util.Scanner;


public class task2_3 {
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
        System.out.println("№1");
        for (int i = 0; i < size; i++) {
            if ((i + 1) % 3 == 0) {
                mass[i] = mass[i] * 2;
            }
        }
        Print_mass(mass, size);
        System.out.println("№2");
        int i = 2;
        while (i < size) {
            mass[i] = mass[i] * 2;
            i = i + 3;
        }
        Print_mass(mass, size);


    }

    static void Print_mass(int[] mass, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(mass[i] + " ");
        System.out.println();
    }

}
