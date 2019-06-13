package lesson_2;

public class Example {
    public static void main(String[] args) {


        task_1.Methods methods = new task_1.Methods();
        int TestNamberA = 5;
        int TestNamberB = 50;
        int TestNamberC = 11;
        System.out.println("Найти минимальное число из 2 чисел, вернуть минимальное");
        System.out.println(methods.minNumber(TestNamberA, TestNamberC));
        System.out.println(methods.minNumber(TestNamberC, TestNamberB));
        System.out.println("Проверить четное число или нечетное, вернуть boolean результат");
        System.out.println(methods.Chet(TestNamberA));
        System.out.println(methods.Chet(TestNamberB));
        System.out.println("Возвести число в куб, вернуть результат возведения");
        System.out.println(methods.nambSqr3(TestNamberA));
        System.out.println("Возвести число в квадрат, вернуть результат возведения");
        System.out.println(methods.sqrNew(TestNamberA));

        Student student1 = new Student();

        System.out.println("public  ");
        student1.setName("Piter");
        System.out.println("friend ");
        System.out.println(student1.getName());
        System.out.println("private ");
        student1.doublePrintName();
        System.out.println("метод PrintName() невидно так как он private");
    }
}
