package lesson_1;
import java.util.Scanner;


public class task2_12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number mass: ");
        int size = in.nextInt();
        System.out.println("-->");
        System.out.println("певоначальный массив");
        int[] mass = new int[size];
        for (int i = 0; i < size; i++) {
            mass[i] = (int) (Math.random() * 100);
        }
        Print_mass(mass, size);
        System.out.println("---");
        System.out.println("вариант 1 простой и надёжный как лом temp mass. и тяжелиый :), наверно ");
        int[] temp_mass = new int[size];

        for (int i = size - 3; i >= 0; i--) {

            temp_mass[i + 2] = mass[i];
        }
        //	mass = temp_mass ;

        Print_mass(temp_mass, size);
        System.out.println("вариант 1 c проворотом ");
        for (int i = size - 1; i >= 0; i--) {
            if (i + 2 < size) {
                temp_mass[i + 2] = mass[i];
            } else {
                temp_mass[i + 2 - size] = mass[i];
            }

        }
        //mass = temp_mass ;
        Print_mass(temp_mass, size);
        System.out.println("вариант 2 последовательное изменение массива ");

        for (int i = size - 3; i >= 0; i--) {
            mass[i + 2] = mass[i];
        }
        Print_mass(mass, size);


    }

    static void Print_mass(int[] mass, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(mass[i] + " ");
        System.out.println();
    }

}