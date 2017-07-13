import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
public class StreamFunction
{
    public static void main(String args[])
    {
       
        List<String> s=Arrays.asList("a","","b","","");
        List<String> s1=Arrays.asList("a","","b","");
        //parallel stream
        long count = s.stream().filter(string -> string.isEmpty()).count();
        long count1 = s1.parallelStream().filter(string -> string.isEmpty()).count();
         System.out.println("Empty string"+count1);
         System.out.println("empty string"+count);
       

    }
}