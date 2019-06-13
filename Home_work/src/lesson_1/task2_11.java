package lesson_1;
import java.util.Scanner;


public class task2_11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number mass: ");
        int size = in.nextInt();
        System.out.println("--> доп усмовие: значение за пределами  массива принимаем = 0");
        int[] mass = new int[size];
        for (int i = 0; i < size; i++) {
            mass[i] = (int) (Math.random() * 100);
        }
        Print_mass(mass, size);
        System.out.println("вариант 1 простой и надёжный как лом temp mass. и тяжелиый :), наверно ");
        int[] temp_mass = new int[size];

        for (int i = 0; i < size; i++) {
            if (i - 1 < 0) {
                temp_mass[i] = (int) (0 + mass[i + 1]) / 2;
                continue;
            }
            if (i + 1 > size-1) {
                temp_mass[i] = (int) (mass[i - 1] + 0) / 2;
                continue;
            }
            temp_mass[i] = (int) (mass[i - 1] + mass[i + 1]) / 2;
        }
        mass = temp_mass;
        Print_mass(mass, size);
        System.out.println("вариант 2 последовательное изменение массива из  варианта 1");

        for (int i = 0; i < size; i++) {
            if (i - 1 < 0) {
                mass[i] = (int) (0 + mass[i + 1]) / 2;
                continue;
            }
            if (i + 1 > size-1) {
                mass[i] = (int) (mass[i - 1] + 0) / 2;
                continue;
            }
            mass[i] = (int) (mass[i - 1] + mass[i + 1]) / 2;
        }
        Print_mass(mass, size);


    }

    static void Print_mass(int[] mass, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(mass[i] + " ");
        System.out.println();
    }

}