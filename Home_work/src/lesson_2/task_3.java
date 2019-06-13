package lesson_2;

public class task_3 {

}



    class Student extends Person{

        public void setName(String newName) {
            this.name = "Student name: "+ newName;
        }
        String getName() {
            return this.name;
        }
        private void printName(){
            System.out.println(name);
        }

        protected void doublePrintName(){
            System.out.print(name +"--");
            System.out.println(name);
        }


    }

