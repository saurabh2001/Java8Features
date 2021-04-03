package java8.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SamplePrograms2 {
    // Program to demonstrate sorting of objects based on one or more attributes
    private static List<User> users = Arrays.asList(
            new User("C", 20, 5),
            new User("D", 40, 3),
            new User("A", 10, 6),
            new User("B", 20, 8),
            new User("E", 50, 10));

    public static void main(String[] args) {

        // Sort using lambda
        /*List<User> sortedList = users.stream()
            .sorted((o1, o2) -> o1.getAge() - o2.getAge())
            .collect(Collectors.toList());*/

        // it will sort users by age, if age is same then sort with height
        // use thenComparing to carry sorting sequentially
        List<User> sortedList = users.stream()
                .sorted(Comparator.comparingInt(User::getAge).thenComparing(User::getHeight))
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);

    }

    static class User {

        private String name;
        private int age;
        private int Height;

        User(String name, int age, int height) {
            this.name = name;
            this.age = age;
            Height = height;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        int getHeight() {
            return Height;
        }

        public void setHeight(int height) {
            Height = height;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", Height=" + Height +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                    Height == user.Height &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, Height);
        }
    }
}
