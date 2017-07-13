import java.util.function.Predicate;

public class Predicate1
{
   static boolean verify(int num)
    {
        if(num>12)
            {
                return true;
            }
            else
            {
               return false;
           }
    }
    public static void main(String[] args) {
        Predicate<Integer> pre=Predicate1::verify;
        boolean value=pre.test(10); 
        System.out.println(value);
    }
}