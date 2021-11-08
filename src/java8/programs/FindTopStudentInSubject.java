package java8.programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindTopStudentInSubject {
    public static void main(String[] args) {
        List<Student> employeeList = createStudentList();

        String chemistryTopper = employeeList
                .stream()
                .sorted(Comparator.comparing(Student::getChemistry).reversed())
                .findFirst()
                .map(Student::getName)
                .get();

        System.out.println("Chemistry topper :" + chemistryTopper);

    }

    public static List<Student> createStudentList()
    {
        ArrayList<Student> students = new ArrayList<>();

        Student tom = new Student("Tom", 7, 6, 4);
        Student rome = new Student("Rome", 9, 5, 8);
        Student jack = new Student("Jack", 6, 9, 8);
        Student simon = new Student("Simon", 10, 8, 5);
        Student darek = new Student("Darek", 10, 9, 8);

        students.add(tom);
        students.add(rome);
        students.add(jack);
        students.add(simon);
        students.add(darek);

        return students;
    }

    private static class Student {
        protected String name;
        private int chemistry;
        private int mathematics;
        private int physics;


        public Student(String name, int chemistry, int mathematics, int physics) {
            this.name = name;
            this.chemistry = chemistry;
            this.mathematics = mathematics;
            this.physics = physics;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getChemistry() {
            return chemistry;
        }

        public void setChemistry(int chemistry) {
            this.chemistry = chemistry;
        }

        public int getMathematics() {
            return mathematics;
        }

        public void setMathematics(int mathematics) {
            this.mathematics = mathematics;
        }

        public int getPhysics() {
            return physics;
        }

        public void setPhysics(int physics) {
            this.physics = physics;
        }
    }
}
