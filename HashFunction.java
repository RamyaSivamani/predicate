import java.util.*;
//import java.util.LinkedHashSetSet;
public class HashFunction
 {
   public static void main(String[] args) 
    {
        Set<Object> hashset = new LinkedHashSet<Object>();
       hashset.add("Preti");
        hashset.add(20);
        hashset.add(20);
        hashset.add(25);
        hashset.add(22);
        hashset.add("Pei");
        hashset.remove(20);
        Set<Object> hashset1 = new LinkedHashSet<Object>(hashset);
         System.out.println(hashset1);
   }
}
