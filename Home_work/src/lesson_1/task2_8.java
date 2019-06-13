package lesson_1;
import java.util.Scanner;


public class task2_8 {
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
	   	   
		int min = mass[0];
        int max = mass[0];

		for (int i = 1; i < size; i++) {
           
			if (min > mass[i]){
				min=mass[i];
			}

			if (max < mass[i]){
				max=mass[i];
			}

        }
		
 System.out.print("max={"+max+"} and min={"+min+"}");

    }

    static void Print_mass(int[] mass, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(mass[i] + " ");
        System.out.println();
    }

}