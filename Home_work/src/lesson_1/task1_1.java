public class task1_1 {
    public static void main(String[] args) {
        String result_1 = "";
        int i = 0;
        while (i < 26) {
            result_1 = result_1 + i + " ";
            i++;
        }
        System.out.println("вариант 1 используя переменную типа String ");
        System.out.println(result_1);
        System.out.println("вариант 2 используя System.out.print ");
        i = 0;
        while (i < 26) {
            System.out.print(i + " ");
            i++;
        }

    }
}
