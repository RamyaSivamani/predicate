import java.util.stream.Stream;
// diff b/w map and flatmap
public class MapFunction {
  public static void main(String[] args) {
    /*Stream.of("XML", "Java",  "CSS")
        .map(name  ->  name.chars())
        .flatMap(intStream ->  intStream.mapToObj(n ->  (char)n))
        .forEach(System.out::println); 
*/
//String s="santhosh";
//System.out.println(s.substring(2));

Stream.of("a1","a2","a4","a7","a9")
    //.map(s -> s.substring(1))
    .mapToLong(n-> Long.parseLong(n))
    .max()
    .ifPresent(System.out::println);
   /* IntStream.range(1, 4)
    .mapToObj(i -> "a" + i)
    .forEach(System.out::println);*/
   //Stream.of("ramya")
    //.flatMap(name->IntStream.range(name.lenght))
    

  }
}