package lesson_1;
import java.util.Scanner;


public class task2_7 {
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
       
	   int new_size;
if (size%2==0)
	new_size=size;
else 
	new_size=size-1;
	   	   
		int buff;
       

  for (int i = 0; i < new_size/2; i++) {
            buff= mass[i];
			mass[i]= mass[(size-1) - i];
			mass[(size-1) - i]=buff;
        }
Print_mass(mass, size);

    }

    static void Print_mass(int[] mass, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(mass[i] + " ");
        System.out.println();
    }

}