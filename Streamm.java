import java.util.*;
import java.util.function.Function;
import java.util.Arrays;  
class Product{  
   
    float price;  
    public Product( float price) {  
        
        this.price = price;  
    }  
}  
public class Streamm {  
    public static void main(String[] args) {  
        String[] a=new String[]{"Poov","Hai","Hello","Priti","Ramya"};
        List<String> productsList = Arrays.asList(a);  
      
        /*productsList.add(new Product(25000f));  
        productsList.add(new Product(30000f));  
        productsList.add(new Product(28000f));  
        productsList.add(new Product(28000f));  
        productsList.add(new Product(90000f));  */
        productsList.stream()
        .filter(s -> s.startsWith("H")).forEach(System.out::println) ;
              //.count()   ; 
       //.forEach(System.out::println);
       //System.out.println(f);
           }  
}  