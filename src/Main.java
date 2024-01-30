/*
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        List<Student> students = Arrays.asList(
                new Student("Math", "Adama", "Smith", "New York", 19),
                new Student("Math", "John", "Smith", "Miami", 19),
                new Student("Programming", "Mike", "Miles", "New York", 21),
                new Student("Math", "Michael", "Peterson", "New York", 20),
                new Student("Math", "James", "Robertson", "Miami", 20),
                new Student("Programming", "Kyle", "Miller", "Miami", 20),
                new Student("English", "Kyle", "Miller", "Miami", 20)
        );
*/
/*
        //1. Find Students which age is greater than or equal 20
        List<Student> studentAge = students.stream()
                .filter(s -> s.getAge() >= 20)
                .collect(Collectors.toList());
        System.out.println("Students Age: " + studentAge);

        //3. Create a list which contains only name
        List<String> studentNames = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("Student Names: " + studentNames);


        //4.Find students who have Programming subject
        List<Student> studentsSubject = students.stream()
                .filter(s -> s.getSubject().equals("Programming"))
                .collect(Collectors.toList());
        System.out.println("Students subject: " + studentsSubject);

        //4.Find students who have Programming subject
        List<Student> GroupOfStudents = students.stream()
                .filter(s -> s.getSubject().startsWith("Programming"))
                .collect(Collectors.toList());
        System.out.println("Students Group: " + GroupOfStudents);

        //2. Sum age of the students
        int sumOfAges = students.stream()
                .mapToInt(Student::getAge)
                .sum();

        System.out.println("Sum of ages of all students: " + sumOfAges);


        //5. Group Students by subject
        Map<String, Long> studentsBySubject = students.stream()
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.counting()));

        System.out.println("Students grouped by subject: " + studentsBySubject);


        //strings with length less than 5
        long count = students.stream().filter(s->s.getSurname().length()<=5).count();
        System.out.println(" strings with length less than 5"+count);

        //Get student with exact match name "John"
        Optional<Student> matchName=students.stream().filter(std->std.getName().equals("John")).findFirst();
        System.out.println("match name: " +matchName);

        //Get student with matching city "Miami"
        List<Student>address=students.stream().filter(s->s.getCity().equals("Miami")).collect(Collectors.toList());
        System.out.println("Student matching city:" +address);

        //Get all student having age numbers 21
        Long studentAges=students.stream().filter(s->s.getAge()==21).count();
        System.out.println("student age:" +studentAges);

        //Print all students:
        students.forEach(System.out::println);

        //Print all distinct cities:
        List<String> distinctCity=students.stream().map(Student::getCity).distinct().collect(Collectors.toList());
        System.out.println("distinct cities" +distinctCity);

        //Print all distinct cities number:
        Long distinctCityNumber=students.stream().map(Student::getCity).distinct().count();
        System.out.println("distinct cities number: " +distinctCityNumber);

        //Print the average age of all students:
        double averageAge=students.stream().mapToInt(Student::getAge).average().orElse(0.0);
        System.out.println("average age:" +averageAge);
        //Print the names of all students in uppercase:
        List<String>uppercaseName=students.stream().map(s-> s.getName().toUpperCase()).collect(Collectors.toList());
        System.out.println(uppercaseName);

        //Print the count of students for each subject:
        students.stream()
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.counting()))
                .forEach((subject,counts)->System.out.println(subject+ ": "+counts));

        //Find the youngest student:
        Student youngestStudent=students.stream()
                .min(Comparator.comparingInt(Student::getAge)).orElse(null);
        System.out.println("youngest student:"+youngestStudent);

        //Find the Oldest student:
        Student oldestStudent=students.stream()
                .max(Comparator.comparingInt(Student::getAge)).orElse(null);
        System.out.println("Oldest student:"+oldestStudent);

        //Check if there are students from both New York and Miami:
        boolean studentsFromBothCities = students.stream()
                .anyMatch(student -> student.getCity().equals("New York"))
                && students.stream()
                .anyMatch(student -> student.getCity().equals("Miami"));
        System.out.println("Students from both cities: " + studentsFromBothCities);


        List<String> studentsName = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println(studentsName);


        List<Student>notEqual=students.stream()
                .filter(s->!s.getName().equals("Smith")).collect(Collectors.toList());
        System.out.println(notEqual);


        List<Student> notEqual1 = students.stream()
                .filter(s -> !s.getName().equals("Smith"))
                .collect(Collectors.toList());

        System.out.println("Student: "+notEqual1);


        List<String> filteredNames = students.stream()
                .filter(student -> student.getName().startsWith("J"))
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Filter Name:"+filteredNames);


        //sorted date with city
        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparing(Student::getCity))
                .collect(Collectors.toList());
        sortedStudents.forEach(System.out::println);


        //peek()
        final List<Integer> ans = students.stream()
                .filter(student -> student.getAge() % 2 == 1)
                .peek(student -> System.out.println("Filtered " + student.getAge()))
                .map(student -> student.getAge() * 10)
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(ans.toArray()));


        //use limited
        final List<Student> answer = students.stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("Limited List: " + Arrays.toString(answer.toArray()));


        //skip() method
        final List<Student> answer1 = students.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("Skipped List: " + Arrays.toString(answer1.toArray()));


        //count()
        final long count1 = students.stream().count();
        System.out.println("Count: " + count1);


        //allMatch()
        boolean isAllEven = students.stream().allMatch(value -> value.getAge() == 2);
        System.out.println("Is all even: " + isAllEven);

        //

        List<Student> studentList=students.stream()
                .filter(s->s.getName().startsWith("J"))
                .collect(Collectors.toList());
        System.out.println("names: "+studentList);


        long totalStudents=students.stream().count();
        System.out.println("Total Students: "+totalStudents);


        List<Integer> distinct= students.stream()
                .map(Student::getAge)
                .distinct().collect(Collectors.toList());

        System.out.println("Distinct List: "+distinct);*//*


*/
/*
        //1. Find Students which age is greater than or equal 20
        List<Student> studentAge = students.stream().filter(s -> s.getAge() >= 20).collect(Collectors.toList());
        System.out.println("Student age:" + studentAge);

        //2. Sum age of the students
        int studentSum = students.stream().mapToInt(Student::getAge).sum();
        System.out.println("studentSumAge: " + studentSum);

        //3. Average age of the students
        double studentAverage = students.stream().mapToInt(Student::getAge).average().orElse(0.0);
        System.out.println("studentAverage: " + studentAverage);

        //4. Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
        int allEvenNumberSum = students.stream().filter(s -> s.getAge() % 2 == 0).mapToInt(Student::getAge).sum();
        System.out.println("Sum of even numbers: " + allEvenNumberSum);

        //Odd number sum
        int allOddNumberSum = students.stream().filter(s -> s.getAge() % 2 != 0).mapToInt(Student::getAge).sum();
        System.out.println("Sum of odd numbers: " + allOddNumberSum);

        //5. Create a list which contains only name
        List<String> name = students.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println("Student name list: " + name);

        //6. Write a Java program to convert a list of strings to uppercase or lowercase using streams.
        List<String> nameUpperCase = students.stream().map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Student name UpperCase list: " + nameUpperCase);

        //Lowercase
        List<String> nameLowerCase = students.stream().map(Student::getName)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println("Student name LowerCase list: " + nameLowerCase);

        //7.Find students who have Programming subject
        List<Student> studentSubject = students.stream().filter(s -> s.getSubject().startsWith("Programming")).collect(Collectors.toList());
        System.out.println("Subject of Student: " + studentSubject);

        //8. Group Students by subject
        students.stream().collect(Collectors.groupingBy(Student::getSubject, Collectors.counting()))
                .forEach((student, count) -> System.out.println(student + ": " + count));

        //strings with length less than 5
        Long stringLength = students.stream().filter(s -> s.getName().length() <= 5).count();
        System.out.println("Name String Length: " + stringLength);

        //Get all student having age numbers 21
        List<Student> studentAgeNumber = students.stream().filter(s -> s.getAge() == 21).collect(Collectors.toList());
        System.out.println("studentAgeNumber: " + studentAgeNumber);

        //Print all students:
        System.out.println("All students: " + students);

        //Print all distinct cities:
        List<String> all_distinct = students.stream().map(Student::getCity).distinct().collect(Collectors.toList());
        System.out.println("All distinct cities: " + all_distinct);

        //Print all distinct ages number:
        List<Integer> all_distinct_age = students.stream().map(Student::getAge).distinct().collect(Collectors.toList());
        System.out.println("all distinct ages number: " + all_distinct_age);

        //Print the average age of all students:
        double average_age = students.stream().mapToInt(Student::getAge).average().orElse(0.0);
        System.out.println("Average age of all students: " + average_age);

        //Print the count of students for each subject:
        students.stream().collect(Collectors.groupingBy(Student::getSubject, Collectors.counting()))
                .forEach((subject, count) -> System.out.println(subject + ":" + count));


        //Find the youngest student:
        Optional<Student> youngest_student = students.stream().min(Comparator.comparingInt(Student::getAge));
        System.out.println("Youngest student: " + youngest_student);

        //Find the Oldest student:
        Optional<Student> oldest_student = students.stream().max(Comparator.comparingInt(Student::getAge));
        System.out.println("Oldest student: " + oldest_student);

        //Check if there are students from both New York and Miami:
        boolean students_from_both = students.stream().anyMatch(student -> student.getCity().equals("Miami"))
                && students.stream().anyMatch(student -> student.getCity().equals("New York"));
        System.out.println("students from both: " + students_from_both);

        //sorted city
        List<String> sorted_city=students.stream().map(Student::getCity).sorted().toList();
        System.out.println("Sorted city: "+sorted_city);

        //peek()
        List<Student>usePeek=students.stream().peek(student -> student.getCity()).collect(Collectors.toList());
        System.out.println("peek: "+usePeek);

        //use paek() method
       *//*

        */
/* students.stream()
                .sorted(Comparator.comparing(Student::getCity))
                .peek(student -> System.out.println(student.getCity() + ": " +
                        student.getName() + " " + student.getSurname()))
                .toList();*//*

        */
/*

        System.out.println("*************************");

       students.stream().sorted(Comparator.comparing(Student::getCity))
               .peek(student -> System.out.println(student.getCity()+" : "+
                       student.getName() +" "+student.getSurname())).toList();


       //use limited
       List<String>limited=students.stream().map(Student::getName).limit(3).toList();
        System.out.println("Use limited: "+limited);

        ////skip() method
        List<Integer>skip=students.stream().map(Student::getAge).skip(2).collect(Collectors.toList());
        System.out.println("Skip: "+skip);

        ////count()
        Long student=students.stream().map(Student::getAge).count();
        System.out.println("Counts: "+student);

        //allMatch()
        boolean allMatch=students.stream().allMatch(value -> value.getAge() == 20);
        System.out.println("allMatch: "+allMatch);*//*

      */
/*  //allMatch()
        boolean allMatch = students.stream().allMatch(student -> student.getAge()==20);
        System.out.println("allMatch: "+allMatch);

        //count()
        Long count=students.stream().map(Student::getAge).count();
        System.out.println("Counts: "+count);

        //skip() method
        students.stream().skip(2)
               .sorted(Comparator.comparing(Student::getCity))
               .peek(student -> System.out.println(student.getCity()+":"+
                       student.getName()+""+student.getSurname())).toList();

        System.out.println();
        //use limited
        students.stream().limit(2).sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);

        System.out.println();
        //use peek() and sorted city method
        students.stream().limit(2)
                .sorted(Comparator.comparing(Student::getCity))
                .peek(student -> System.out.println(student.getCity()+": "+
                student.getName()+" "+student.getSurname())).toList();

        System.out.println();
        //Check if there are students from both New York and Miami:
        boolean students_from_both= students.stream().map(Student::getCity).equals("Miami")
                && students.stream().map(Student::getCity).equals("New York");
        System.out.println("Students from both: "+students_from_both);

        System.out.println();
        //Find the Oldest student:
        int Oldest = students.stream().mapToInt(Student::getAge).max().orElse(0);
        System.out.println("Oldest: "+Oldest);

        System.out.println();
        //Find the youngest student:
        int youngest_student=students.stream().mapToInt(Student::getAge).min().orElse(0);
        System.out.println("Youngest student: "+youngest_student);

        System.out.println();
        //Print the count of students for each subject:
         Map<String, Long>each_subject=students.stream().collect(Collectors.groupingBy(Student::getSubject, Collectors.counting()));
        System.out.println("Each subject: "+each_subject);

        //Print the average age of all students:
        System.out.println();
        double average_age=students.stream().mapToInt(Student::getAge).average().orElse(0.0);
        System.out.println("Average age: "+average_age);

        //Print all distinct ages number:
        System.out.println();
        List<Integer> distinct_ages=students.stream().map(Student::getAge).distinct()
                .sorted(Comparator.comparingInt(Integer::intValue)).toList();
        System.out.println("Distinct ages: "+distinct_ages);

        //Print all distinct cities:
        System.out.println();
        List<String>distinct_cities=students.stream().map(Student::getCity).distinct()
                .sorted(Comparator.naturalOrder()).toList();
        System.out.println("Distinct cities: "+distinct_cities);

        //Get all student having age numbers 21
        System.out.println();
        List<Student>age_numbers=students.stream().filter(s-> s.getAge()==21).toList();
        System.out.println("Age_numbers: "+age_numbers);

        //strings with length less than 5
        System.out.println();
        List<Student>length=students.stream().filter(s->s.getName().length()<5).toList();
        System.out.println("length: "+length);

        //8. Group Students by subject
        System.out.println();
         students.stream().collect(Collectors.groupingBy(Student::getSubject, Collectors.counting()))
                 .forEach((subject1, count1)->System.out.println(subject1+":"+count1));

        //7.Find students who have Programming subject
        System.out.println();
        Map<String, Long> subject=students.stream().filter(s->s.getSubject().equals("Programming"))
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.counting()));
        System.out.println(subject);

        //6. Write a Java program to convert a list of strings to uppercase or lowercase using streams.
        System.out.println();
        List<String>upper=students.stream().map(Student::getSubject).map(String::toUpperCase)
                .toList();
        System.out.println("Uppercase: "+upper);

        List<String>lowerCase=students.stream().map(Student::getCity).sorted().map(String::toLowerCase).toList();
        System.out.println("Lower Case: "+lowerCase);

        //5. Create a list which contains only name
        System.out.println();
        List<String>name=students.stream().map(Student::getName).sorted().toList();
        System.out.println("Names: "+name);


        //4. Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
        //Even number sum
        System.out.println();
        double sum=students.stream().mapToInt(Student::getAge).sum();
        System.out.println(sum);

        //Odd number sum
        double sum1=students.stream().filter(s->s.getAge()% 2==1).mapToInt(Student::getAge).sum();
        System.out.println(sum1);

        //3. Average age of the students
        System.out.println();
        double average=students.stream().mapToInt(Student::getAge).average().orElse(0.0);
        System.out.println("average: "+average);

        //2. Sum age of the students
        System.out.println();
       int sum2= students.stream().mapToInt(Student::getAge).sum();
        System.out.println("sum2: "+sum2);

        //1. Find Students which age is greater than or equal 20
        System.out.println();
        List<Student>studentAge=students.stream().filter(s->s.getAge()>=20).toList();
        System.out.println("Student Age: "+studentAge);*//*



        //1. Find Students which age is greater than or equal 20

        List<Student>equalAge=students.stream().filter(s->s.getAge()>=20).toList();
        System.out.println("Equal Age: "+equalAge);

        //2. Sum age of the students
        System.out.println();
        int sum_age= students.stream().mapToInt(Student::getAge).sum();
        System.out.println("Sum Age:"+sum_age);

        //3. Create a list which contains only name
        System.out.println();
        List<String>names=students.stream().map(Student::getName).sorted().toList();
        System.out.println("Names: "+names);

        //4.Find students who have Programming subject
        System.out.println();
        Map<String, Long>pSubject=students.stream().filter(s->s.getSubject().startsWith("Programming"))
                .collect(Collectors.groupingBy(Student::getSubject,Collectors.counting()));
        System.out.println("Subject: "+pSubject);

        //4.Find students who have Programming subject
        System.out.println();
        Map<String, Long>mSubject=students.stream().filter(s->s.getSubject().equals("Math"))
                .collect(Collectors.groupingBy(Student::getSubject,Collectors.counting()));
        System.out.println("Subject: "+mSubject);


        //5. Group Students by subject
        System.out.println();
        Map<String, Long>subjects=students.stream()
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.counting()));
        System.out.println("Subjects: "+subjects);

        //6.strings with length less than 5
        System.out.println();
        Map<String, Long>length5=students.stream().filter(s->s.getName().length()<5)
                .collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println("Length: "+length5);

        //7.Get student with exact match name "John"
        List<Student>match_name=students.stream().filter(s->s.getName().startsWith("John")).toList();
        System.out.println("Match Name: "+match_name);

        //8.Get student with matching city "Miami"
        Map<String, Long>match_city=students.stream().filter(s->s.getCity().equals("Miami"))
                .collect(Collectors.groupingBy(Student::getCity, Collectors.counting()));
        System.out.println("Match City: "+match_city);

        //9.Get all student having age numbers 21
        List<Student>have_age=students.stream().filter(s->s.getAge()==21).toList();
        System.out.println("Have Age: "+have_age);

        //10.Print all students:
        System.out.println(students);

        //11.Print all distinct cities:
        System.out.println();
        List<String>distinct_cities=students.stream().map(Student::getCity).distinct().toList();
        System.out.println("Distinct Cities: "+distinct_cities);

        //13.Print the average age of all students:
        System.out.println();
        double average_age=students.stream().mapToInt(Student::getAge).average().orElse(0.0);
        System.out.println("Average: "+average_age);

        //14.Print the count of students for each subject:
        Map<String, Long>count_student=students.stream()
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.counting()));
        System.out.println("Subject Counts: "+count_student);

        //15.Find the youngest student:
        System.out.println();
        int youngest_student=students.stream().mapToInt(Student::getAge).min().orElse(0);
        System.out.println("Youngest_student: "+youngest_student);

        //16.Find the Oldest student:
        int oldest_student=students.stream().mapToInt(Student::getAge).max().orElse(0);
        System.out.println("Oldest Students: "+oldest_student);

        //18.sorted date with city
        List<String>sorted_city=students.stream().map(Student::getCity).sorted().toList();
        System.out.println("Sorted City: "+sorted_city);

        System.out.println();
        //use peek() and sorted city method
        students.stream().limit(2)
                .sorted(Comparator.comparing(Student::getCity))
                .peek(student -> System.out.println(student.getCity()+": "+
                        student.getName()+" "+student.getSurname())).toList();

        System.out.println();
        students.stream().limit(3)
                .sorted(Comparator.comparing(Student::getCity))
                .peek(student -> System.out.println(student.getCity()+": "+
                        student.getName()+" "+student.getSurname())).toList();

        //20.use limited
        List<Integer>limit=students.stream().map(Student::getAge).limit(2).toList();
        System.out.println("Limit: "+limit);

        //21.skip() method
        List<Integer>skip=students.stream().map(Student::getAge).sorted().skip(2).toList();
        System.out.println("Skip: "+skip);

        //22.count()
        Long count=students.stream().count();
        System.out.println("Counts: "+count);

        //23.allMatch()
        boolean allMatch=students.stream().allMatch(student -> student.getAge()==2);
        System.out.println("All Match: "+allMatch);

        System.out.println();
        List<Student>peek=students.stream().limit(2)
                .peek(student -> System.out.println(student.getCity()+":"+
                        student.getName()+" "+ student.getSurname())).toList();
        System.out.println(peek);


    }
}*/


import java.util.*;
import java.util.stream.*;

class User {
    String name;
    List<Order> orders;

    User(String name, List<Order> orders) {
        this.name = name;
        this.orders = orders;
    }
}

class Order {
    double value;

    Order(double value) {
        this.value = value;
    }
}


class Transaction {
    String currency;
    double amount;

    Transaction(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    String getCurrency() {
        return currency;
    }
}

class Book {
    List<String> authors;

    Book(List<String> authors) {
        this.authors = authors;
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}


public class Main {
    public static void main(String[] args) {

        // 1) Advanced Filtering
        // You have a list of users, each with a list of orders.
        // Extract the names of users who have placed at least one order with a total value exceeding 1000.

        List<User> users = Arrays.asList(
                new User("Joy", Arrays.asList(new Order(500), new Order(1500))),
                new User("Nahid", Arrays.asList(new Order(800), new Order(1200))),
                new User("Hafiz", Arrays.asList(new Order(200), new Order(300)))
        );

        List<String> highOrder = users.stream().filter(user -> user.orders.stream().anyMatch(order -> order.value > 1000))
                .map(user -> user.name).toList();
        System.out.println("High Orders: " + highOrder);


        // 2) Parallel Stream Processing
        //Given a large list of integers, find the sum of the squares of the even numbers using parallel stream processing.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumOfEvenSquares = numbers.stream().filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n).sum();
        System.out.println("Sum of the Squares: " + sumOfEvenSquares);


        // 3) Combining Streams
        //Merge two lists of strings into a single list, remove duplicates, and then sort them in reverse order.
        List<String> list1 = Arrays.asList("apple", "banana", "orange");
        List<String> list2 = Arrays.asList("banana", "grape", "kiwi");

        List<String> remove_duplicates = Stream.concat(list1.stream(), list2.stream())
                .distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Removed Duplicates List:" + remove_duplicates);

        // 4) Grouping and Counting
        //Group a list of transactions by the currency they are in,
        // and then calculate the total transaction count for each currency.

        List<Transaction> transactions = Arrays.asList(
                new Transaction("USD", 100),
                new Transaction("EUR", 200),
                new Transaction("USD", 150),
                new Transaction("EUR", 300),
                new Transaction("USD", 50)
        );

        Map<String, Long> currency_calculate = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency, Collectors.counting()));
        System.out.println("Group of currency calculate:" + currency_calculate);

        // 5) FlatMap Challenge
        //You have a list of books, each with a list of authors.
        // Create a unique list of all distinct authors from all the books.
        List<Book> books = Arrays.asList(
                new Book(Arrays.asList("Author1", "Author2", "Author3")),
                new Book(Arrays.asList("Author2", "Author3", "Author1")),
                new Book(Arrays.asList("Author3", "Author4", "Author1"))
        );

        List<String> distinct_authors = books.stream().flatMap(b -> b.authors.stream())
                .distinct().toList();
        System.out.println("Distinct Authors" + distinct_authors);


        // 6) Collectors and Custom Collector
        //Given a list of words, create a custom collector to concatenate them into a single comma-separated string.
        List<String> words = Arrays.asList("Hello", "world", "this", "is", "a", "custom", "collector");

        List<String> concatenatedString = words.stream().toList();
        System.out.println("Concatenated String: " + concatenatedString);


        // 7) Handling Nulls
        //Given a list of strings that may contain null values, filter out the nulls, convert to uppercase, and then print them.
        List<String> nullableStrings = Arrays.asList("One", null, "Two", null, "Three");

        List<String> nullString = nullableStrings.stream().filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Null String: "+nullString);


        // 8) Advanced Reduction
        //Calculate the product of all even numbers in a list using the reduce operation.
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6);


        // 9) Custom Comparator
        //Sort a list of custom
        // objects based on multiple criteria (e.g., first by age in ascending order, then by name in descending order).
        List<Person> persons = Arrays.asList(
                new Person("John", 30),
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Alice", 22)
        );
    }
}
