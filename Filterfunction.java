
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
public class Filterfunction
{   public static void main(String args[])
    {
    List<String> myList =
    Arrays.asList("a1", "a2", "b1", "c2", "c1");

myList
    .stream()
    //.filter(s -> s.startsWith("c"))
    .map(s->s.startsWith("c"))
    //.sorted()
    .forEach(System.out::println);
}
}