package lesson_1;
import java.util.Scanner;


public class task2_9 {
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
       	   
	   	   
		int []min = {mass[0],0};
        int []max = {mass[0],0};
		

		for (int i = 1; i < size; i++) {
           
			if (min[0] > mass[i]){
                min[0]=mass[i];
				min[1]=i;
			}
			if (max[0] < mass[i]){
                max[0]=mass[i];
				max[1]=i;
			}

        }
		
 System.out.println("max in "+max[1]+" and min in "+min[1]);

    }

    static void Print_mass(int[] mass, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(mass[i] + " ");
        System.out.println();
    }

}