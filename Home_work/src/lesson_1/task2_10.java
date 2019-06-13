package lesson_1;
import java.util.Scanner;


public class task2_10 {
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


        for (int i = 0; i < size; i++) {
            if (i == size-1) {
                System.out.println("массив  возрастающий ");
                break;
            }
            if (mass[i] > mass[i + 1])
            {
                System.out.println("массив не  возрастающий ");
                break;
            }


        }


    }

    static void Print_mass(int[] mass, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(mass[i] + " ");
        System.out.println();
    }

}