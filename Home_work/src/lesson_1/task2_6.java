package lesson_1;
import java.util.Scanner;


public class task2_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number mass: ");
        int size = in.nextInt();
        System.out.println("-->");
        int[] mass = new int[size];
        for (int i = 0; i < size; i++) {
            mass[i] = (int) (Math.random() * 100);
        }
        System.out.println("первый массив");
        Print_mass(mass, size);
        System.out.println("вариант 1 КАЖДЫЙ элимент  со следующим " );
        int buff;
        for (int i = 0; i < size - 1; i++) {
            buff = mass[i];
            mass[i] = mass[i + 1];
            mass[i + 1] = buff;
        }
        Print_mass(mass, size);
        System.out.println("вариант 2  элименты меняются по пароно нв массиве из (вариант 1)" );
        int new_size;
        if (size % 2 == 0)
            new_size = size;
        else
            new_size = size - 1;

        for (int i = 0; i < new_size; i = i + 2) {
            buff = mass[i];
            mass[i] = mass[i + 1];
            mass[i + 1] = buff;
        }
        Print_mass(mass, size);

    }

    static void Print_mass(int[] mass, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(mass[i] + " ");
        System.out.println();
    }

}
