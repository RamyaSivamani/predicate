----------
# Java 8 Streams
<style>
h2{
color: #4d88ff;
font-weight: bold;
font-weight: italic;
}
h3{
    color: #b366ff;
font-weight: bold;
font-weight: italic;
text-decoration: underline;
}
</style>
<h2>1)Different kind of streams</h2>

- Stream()
- ParallelStream()

<h2>i)Streams</h2>

<h3>Description</h3>
<h4>A stream represents a sequence of elements and supports different kind of operations to perform computations upon those elements</h4>

```````
List<String> myList =
    Arrays.asList("a1", "a2", "b1", "c2", "c1");
myList
    .stream()
    .forEach(System.out::println);
```````

<h2>ii)ParallelStreams</h2>
<h3>Description</h3>
<h4>ParallelStream is the alternative of stream for parallel processing. Take a look at the following code segment that prints a count of empty strings using parallelStream.</h4>

```````
List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
int count = strings.parallelStream().filter(string -> string.isEmpty()).count();
```````

<h2>2)Filter</h2>
<h3>Description</h3>
<h4>Java stream provides a method filter() to filter stream elements on the basis of given predicate. Suppose you want to get only even elements of your list then you can do this easily with the help of filter method.</h4>

``````
List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
strings.filter(string -> string.isEmpty()).forEach(System.out::println);
``````
<h2>3)Foreach</h2>

- ForEach
- ForEachOrdered
<h2>i)ForEach</h2>
<h3>Description</h3>
<h4>Java provides a new method forEach() to iterate the elements. It is defined in Iterable and Stream interface.</h4>

```````
String str = "Preethi";
str.chars().parallel().forEach(n -> System.out.println((char) n));
```````

<h2>ii)ForEachOrdered</h2>
<h3>Description</h3>
<h4>Along with forEach() method, Java provides one more method forEachOrdered(). It is used to iterate elements in the order specified by the stream.</h4>

```````
String str = "Preethi";
str.chars().parallel().forEachOrdered(n -> System.out.println((char) n));
```````
<h2>4)Map</h2>
<h3>Description</h3>
<h4>A map contains values on the basis of key i.e. key and value pair. Each key and value pair is known as an entry. Map contains only unique keys.
Map is useful if you have to search, update or delete elements on the basis of key.</h4>

- MapToInt
- MapToLong
- MapToDouble
- MapToObj

<h2>i)MapToInt</h2>

```````
Stream.of("a1", "a2", "a3")
    .mapToInt(Integer::parseInt)
    .ifPresent(System.out::println); 
```````

<h2>ii)MapToLong</h2>

```````
Stream.of("a1","a2","a4","a7","a9")
     .mapToLong(n-> Long.parseLong(n))
    .max()
    .ifPresent(System.out::println); 
```````

<h2>iii)MapToDouble</h2>

```````
Stream.of("a1","a2","a4","a7","a9")
     .mapToDouble(n-> Double.parseDouble(n))
    .max()
    .ifPresent(System.out::println); 
```````
<h2>iv)MapToObj</h2>

```````
Stream.of(1.0, 2.0, 3.0)
    .mapToInt(Double::intValue)
    .mapToObj(i -> "a" + i)
    .forEach(System.out::println);
```````

<h2>5)FlatMap</h2>
<h3>Description</h3>
<h4>Stream flatMap returns a stream by replacing this stream with a mapped stream by applying the provided mapping function.</h4>
Example Diagram for FlatMap-<a href="https://1.bp.blogspot.com/-RJseuNzmm7I/Vtb3pH7iPkI/AAAAAAAAE-s/ZJSxR4EnlSI/s1600/Java%2B8%2BflatMap%2Bexample%2B.jpg">Click Here</a>

```````
List<String> stringList = Arrays.asList("1.2","2.2","3","4","5");
    stringList.stream()
           .flatMap(n-> Stream.of(n) )
           .forEach(System.out::println);
```````
<h2>6)Limit</h2>
<h3>Description</h3>
<h4>The ‘limit’ method is used to reduce the size of the stream. The following code segment shows how to print 10 random numbers using limit.</h4>

```````
Random random = new Random();
random.ints().limit(10).forEach(System.out::println);
```````

<h2>7)Sorted</h2>
<h3>Description</h3>
<h4>The ‘sorted’ method is used to sort the stream. The following code segment shows how to print 10 random numbers in a sorted order.</h4>

```````
Random random = new Random();
random.ints().limit(10).sorted().forEach(System.out::println);
```````

<h2>8)Collectors</h2>
<h3>Description</h3>
<h4>Collectors are used to combine the result of processing on the elements of a stream. Collectors can be used to return a list or a string.</h4>

```````
List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
System.out.println("Filtered List: " + filtered);
```````
<h2>9)Reduce</h2>
<h3>Description</h3>
<h4>The reduction operation combines all elements of the stream into a single result.Java 8 supports three different kind of reduce</h4>

- reduce
- BinaryOperaor
- BiFunction

<h2>i)reduce</h2>

```````
persons
    .stream()
    .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
    .ifPresent(System.out::println);   
```````
<h2>ii)BinaryOperaor</h2>

```````
Person result =
    persons
        .stream()
        .reduce(new Person("", 0), (p1, p2) -> {
            p1.age += p2.age;
            p1.name += p2.name;
            return p1;
        });

System.out.format("name=%s; age=%s", result.name, result.age);
```````
<h2>ii)BiFunction</h2>

```````
Integer ageSum = persons
    .stream()
    .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

System.out.println(ageSum);  
```````
<h2>10)Join</h2>
<h3>Description</h3>
<h4>Java added a new final class StringJoiner in java.util package. It is used to construct a sequence of characters separated by a delimiter. Now, you can create string by passing delimiters like comma(,), hyphen(-) etc. You can also pass prefix and suffix to the char sequence</h4>

``````
StringJoiner join = new StringJoiner(",", "[", "]");     
        
        joinNames.add("Rahul");  
        joinNames.add("Raju");  
        joinNames.add("Peter");  
        joinNames.add("Raheem");  
        System.out.println(join);  
``````
<h2>11)Find</h2>
<h3>Description</h3>
<h4>
The Streams API supports different types of find operations on stream elements.All find operations are terminal operations. 
The following methods in the Stream interface are used to perform find operations:

- findFirst
- findAny
</h4>

<h2>i)FindFirst</h2>

``````
Optional<Employee> firstMale = persons.stream().filter(Employee::isMale).findFirst();
    if (firstMale.isPresent()) {
      System.out.println("First male:   " + anyMale.get());
    } else {
      System.out.println("No male  found.");
    }
``````    
<h2>ii)FindAny</h2>

```````
Optional<Employee> anyMale = persons.stream().filter(Employee::isMale).findAny();
    if (anyMale.isPresent()) {
      System.out.println("Any male:   " + anyMale.get());
    } else {
      System.out.println("No male  found.");
    }
```````
<h2>12)Match</h2>
<h3>Description</h3>
<h4>
All match operations are terminal operations. They are also short-circuiting operations. A short-circuiting operation may not have to process the entire stream to return the result.</h4>

- allMatch
- anyMatch
- noneMatch

<h2>i)allMatch</h2>

```````
 boolean allMales = persons.stream().allMatch(Employee::isMale);
    System.out.println("All  males: " + allMales);
```````
<h2>ii)anyMatch</h2>

``````
 boolean anyoneBornIn1971 = persons.stream().anyMatch(p -> p.getDob().getYear() == 1971);
    System.out.println("Anyone born  in 1971:  " + anyoneBornIn1971);
``````
<h2>iii)noneMatch</h2>

```````
boolean allMales = persons.stream().noneMatch(Employee::isMale);
    System.out.println("All  males: " + allMales);

```````  
<h2>13)Grouping</h2>
<h3>Description</h3>
<h4> The groupingBy() method from the Collectors class returns a collector that groups the data before collecting them in a Map. It is similar to a "group by" clause in SQL.</h4>

```````
Map<Employee.Gender, Long> countByGender  = Employee.persons()
        .stream()
        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())); 
    System.out.println(countByGender);
```````
   
 <h2>14)Streams Converter </h2>
<h3>Description</h3>
<h4> The first argument is a collector that collects the data. The second argument is a finisher which converts the result.</h4> 

`````````
 List<String> names = Employee.persons()
        .stream()
        .map(Employee::getName)
        .collect(Collectors.collectingAndThen(Collectors.toList(),
             result ->  Collections.unmodifiableList(result))); 
    System.out.println(names); 
  
`````````







