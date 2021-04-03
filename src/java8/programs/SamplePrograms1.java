package java8.programs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SamplePrograms1 {
    public static void main(String[] arg){

        Integer[] intArray = new Integer[]{2,4,7,4,3,22,67};
        //System.out.println(intArray.length);
        System.out.println("Second largest:: "+ new SamplePrograms1().findSecondLargest(intArray));
        // sum of elements conditionally
        System.out.println("Sum-->" + new SamplePrograms1().sum3And5(new ArrayList(Arrays.asList(intArray))));
        // Reverse string using string builder
        System.out.println("Reversed string::"+ new StringBuilder("saurabh").reverse());
        System.out.println("Uppercase all:: " + new SamplePrograms1().convertToUppercase(new ArrayList<String>(Arrays.asList("sau","shah"))));
        System.out.println("First no div by 2 :: " + new SamplePrograms1().firstNumberDivBy2(new ArrayList<Integer>(Arrays.asList(intArray))));
        System.out.println("Largest odd number :: " + new SamplePrograms1().largestOdd(new ArrayList<Integer>(Arrays.asList(intArray))));
        System.out.println("Prime number :: " + new SamplePrograms1().isPrime(23));
        System.out.println("Double even number :: " + new SamplePrograms1().doubleEvenNumbers(new ArrayList<Integer>(Arrays.asList(intArray))));
        System.out.println("Sorted list Asc:: " + new SamplePrograms1().sortAscList(new ArrayList<Integer>(Arrays.asList(intArray))));
        System.out.println("Sorted list Desc:: " + new SamplePrograms1().sortDescList(new ArrayList<Integer>(Arrays.asList(intArray))));
        System.out.println("Separate with comma:: " + new SamplePrograms1().CommaSeparated(new ArrayList<String>(Arrays.asList("sau","shah", "abc"))));
        System.out.println("Sorting without lambda using comparator:: " + new SamplePrograms1().sortListUsingComparator(new ArrayList<String>(Arrays.asList("sau","shah", "abc"))));
        //Sorting with lambada expression
        System.out.println("Sorting with lambda(shortest way):: " +
                new SamplePrograms1().sortListUsingLambda(new ArrayList<String>(Arrays.asList("sau","shah", "abc"))));

    }

    private String sortListUsingLambda(ArrayList<String> list){
        System.out.println("Before sorting lamb::"+ list);

        list.sort((String s1,String s2) -> s1.compareTo(s2));

        System.out.println("After sorting::"+ list);
        return "";
    }
    private String sortListUsingComparator(ArrayList<String> list){
        System.out.println("Before sorting lamb::"+ list);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });

        System.out.println("After sorting::"+ list);
        return "";
    }


    private String CommaSeparated(ArrayList<String> list){
        System.out.println("Printing comma separated");
        Optional<String> reduced =
                list
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "," + s2);

        reduced.ifPresent(System.out::println);

        return "";
    }

    private List<Integer> sortDescList(ArrayList<Integer> list){
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }


    private List<Integer> sortAscList(ArrayList<Integer> list){
        return list.stream()
                .sorted()
        .collect(Collectors.toList());
    }

    private List<Integer> doubleEvenNumbers(ArrayList<Integer> list){
        return list.stream()
                .filter(s -> s%2 == 0)
                .map(val->val*2)
                .collect(Collectors.toList());
    }
    private boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number).noneMatch(i -> number%i==0);
    }

    private Integer largestOdd(ArrayList<Integer> list){
        return list.stream()
                .filter(s -> s%2 == 1)
                .max(Integer::compareTo)
                .get();
    }

    private Integer firstNumberDivBy2(ArrayList<Integer> list){
        return list.stream().
                filter(s -> s%2 == 0)
                .findFirst().get();
    }

    private String convertToUppercase(ArrayList<String> list){
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        return "";
    }

    private Integer sum3And5(ArrayList<Integer> list) {

        return list.stream()
                .filter(s-> s>3 && s<66)
                .mapToInt(s->s)
                .sum();
    }
    private Integer findSecondLargest(Integer[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (Integer integer : arr) {
            if (integer > max) {
                secondMax = max;
                max = integer;
            }

            if (integer < max && integer > secondMax) {
                secondMax = integer;
            }
        }
        return secondMax;
    }
}
