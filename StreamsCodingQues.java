package StreamsRealTimeQueries;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsCodingQues {
    public static void main(String[] args){
        //find the sum of elements in the list using streams
        List<Integer> li = Arrays.asList(1,2,3,4,5,6,7,8);
        int sum1=li.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);

        //given a list of integers,write a program to find the maximum element using streams

     int max = li.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);

        ////given a list of integers,write a program to find the second largest element using streams

      int second=li.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(second);

        //given a list of strings write a program to count the number of strings starting with special character

        List<String> fruits= Arrays.asList("banana", "apple", "apple","cantaloupe", "orange");
        Long countofFruits=fruits.stream().filter(s->s.equals("apple")).count();
        System.out.println(countofFruits);

        //convert list of strings to uppercase
        fruits.stream().map(String::toUpperCase).forEach(System.out::println);

        //given a list of integers,wap to filter out even numbers in the stream

        li.stream().filter(s->s%2==0).forEach(System.out::println);
        //count the number of elements in a list that satisfy a specific condition
        Long countof=li.stream().filter(s->s%5==0).count();
        System.out.println(countof);

        //wap to find the average of list of floating pouint of numbers

       // Note: avg returns a optional vallue so we can return the getasDouble
        List<Double> d=Arrays.asList(23.4,56.7,89.0,678.98);
        Double avg = d.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println(avg);

        //given a list of strings wap to concate aall the strings usinng strreams

        String concatedString=fruits.stream().collect(Collectors.joining(",","keerthi","rajulapati"));
        System.out.println(concatedString);

        //remove duplicate elements in a list

        li.stream().distinct().forEach(System.out::println);

        //given a list of objects , write a program to sort the objects based on specific attribute

//        List<Person> p =Arrays.asList(
//                new Person(1, "John"),
//                new Person(2, "Johny Company")
//        );

        //p.stream().sorted(Comparator.comparing(Person::getId)).forEach(System.out::println);

        //wap to check if all elements in a list satisfy a given condition

        boolean con=li.stream().allMatch(s->s%2==0);
        System.out.println(con);

        ///wap to check if any elements in a list satisfy a given condition
        //it returns boolean
        //        boolean con=li.stream().anyMatch(s->s%2==0);
        //        System.out.println(con);

        //Frequency of characters in a string

        String name="keerthi rajulapati joined cognizant at august 16 and cognizant is a very good mnc";
//\\s+ matches one or more whitespaces
        Map<String,Long>map=Arrays.stream(name.split("\\s+")).collect(Collectors.groupingBy(String::toLowerCase,Collectors.counting()));
        System.out.println(map);

        //Given a List of Integers find integers starting with 1

        List<Integer> nums=Arrays.asList(1,22,121,1234,34);
        //since string has starts with function so we need to cob=nvert each ele into sytring so
        //we use valueoF
        List<Integer> li1=nums.stream().filter(s->String.valueOf(s).startsWith("1")).collect(Collectors.toList());
        System.out.println(li1);


//Given a List of names group them by their first letter and then count the number of names i
// each group

        String[] namesofFruits={"apple", "orange", "cantaloupe","banana","mango"};

        //since its array we need to use Arrays.stream

        Map<Character ,Long> count=Arrays.stream(namesofFruits).collect(Collectors.groupingBy(s->s.charAt(0),Collectors.counting()));
        System.out.println(count);

        //find and print duplicates numbers in array if there are multiple

        int[] ar={2,4,4,2,5,6,7,8,9};
        Arrays.stream(ar).boxed().collect(Collectors.groupingBy(e->e,Collectors.counting())).
                entrySet().stream().
                filter(entry->entry.getValue()>1).
                map(Map.Entry::getKey).
                forEach(System.out::println);

        //how are duplicates are removed from array

        int[] arr={23,23,45,45,67,89,23};
        Arrays.stream(arr).distinct().forEach(System.out::println);

        //given a list of elements filter and print the palindromes

        List<String> strings=Arrays.asList("mom","tom","radar","toy");
        List<String> palindrome=strings.stream().filter(str->str.equals(new StringBuilder(str).reverse().toString())).collect(Collectors.toList());
        System.out.println(palindrome);

        //how to reverse a string
        String str="keerthi allam";
        String collect = Arrays.stream(str.split("\\s+")).map(w -> new StringBuffer(w).reverse()).collect(Collectors.joining(" "));
        System.out.println(collect);

        //how to merge two unsorted arrays into sorted array

        int[] ar1={34,45,67,89,32};
        int[] ar2={767,89,34,23,67};

        int[] sorted=IntStream.concat(Arrays.stream(ar1),Arrays.stream(ar2)).sorted().distinct().toArray();
        System.out.println(Arrays.toString(sorted));

        //Given two list of strings and concate them and remove duplicates

        List<String> fruitss=Arrays.asList("apple","mango","banana");
        List<String> fruitss2=Arrays.asList("cantalopue","pineapple","cantalopue");

        List<String> newList=Stream.concat(fruitss.stream(),fruitss2.stream()).distinct().collect(Collectors.toList());
        System.out.println(newList);

        //Student Grade Claasification

//        List<Student> studentsMap=List.of(
//                new Student ("keerthi",90),
//                new Student("manisha",50)
//        );
//        Map<String, List<Student>> collect1 = studentsMap.stream().collect(Collectors.groupingBy(s -> s.getRank() > 70 ? "pass" : "fail"));
//        System.out.println(collect1);

        //Given A list of strings sort them according to the length
        List<String> freshFruits= Arrays.asList("apple","orange","cantalopue");
        freshFruits.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);

        // //12.Partition a list of numbers into two groups: even and odd, using a custom predicate.

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

       Map<Boolean,List<Integer>> b= numbers1.stream().collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println(b);

        //Find the squares of the first three even numbers in a list.

        List<Integer> sample = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect1 = sample.stream().filter(n -> n % 2 == 0).limit(3).map(n -> n * n).collect(Collectors.toList());
        System.out.println(collect1);

    }
}
