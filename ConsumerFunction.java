import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class ConsumerFunction {
    public static void main(String[] args) {
        int index=0;
     List<String> colorList = Arrays.asList("Red","Green","Blue","Yellow","lavender");
     //ConsumerFunction cf=new ConsumerFunction();
     System.out.println(colorList);
                for(String st:colorList){
                    if(st=="Yellow")
                    {
                        colorList.set(index,"BlueColor");
                    }   
                    index++;
                }
                System.out.println(colorList);
    }  
}