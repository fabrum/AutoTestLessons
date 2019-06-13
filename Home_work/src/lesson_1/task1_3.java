package lesson_1;
public class task1_3 {
    public static void main(String[] args) {
        System.out.println("для ленивых , но смекалистых i=i+2");
        for (int i = 2; i <= 20; i = i + 2) {
            if(i>10)
            System.out.print(i + " ");

        }
        System.out.println();
        System.out.println("V_2 i%2");
        for (int i = 2; i <= 20; i++) {
            if (i % 2 == 0&&i>10)
                System.out.print(i + " ");

        }

    }
}
