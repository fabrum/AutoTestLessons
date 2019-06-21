package test;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    int id;
    String name ;
    int [] grades;

    public int MassLength(int[] mass) {
        return mass.length;
    }

    public int MassLength(String[] mass) {
        return mass.length;
    }
    public int MaxFromArray(int[] mass) {
        int max = mass[0];
        for (int i = 1; i < mass.length; i++)
            if (max < mass[i])
                max = mass[i];

        return max;
    }


    public String MaxFromArray(String[] mass) {
        String max = mass[0];
        for (int i = 1; i < mass.length; i++)
            if (max.length() < mass[i].length())
                max = mass[i];

        return max;
    }

    public void SetStudent (int[] grades ,String name ,int id) {
      this.grades=grades;
      this.name=name;
      this.id=id;
    }

    public Object GetStudentId () {

        return id;
    }
    public Object GetStudentName () {

        return name;
    }
    public Object GetStudentGrades () {

        return grades;
    }
}
