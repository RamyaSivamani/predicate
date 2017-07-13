import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.Scanner;

class ConsumerAdd {
    public static void main(String[] args) {
    /*int index=0;
     List<String> colorList = Arrays.asList("Red","Green","Blue","Yellow","lavender");
     //colorList.add("Kkgd");
     System.out.println(colorList);
     for(String st:colorList)
     {
         index++;
     }
     colorList.set(index,"Hello");
     System.out.println(colorList);*/
     int index,i,yn,new_index,final_index;
     Scanner scan= new Scanner(System.in);
     index=scan.nextInt();
     List<String> color=new ArrayList<String>();
     for(i=0;i<index;i++)
     {
         String color_temp=scan.next();
         color.add(color_temp);
     }     
     List<String> colorList =new ArrayList<String>();
     colorList.addAll(color);
     System.out.println(colorList);
     System.out.println("You Want to add(Yes/No) Yes=1 No=0");
     yn=scan.nextInt();
     if(yn==1)
     {
        System.out.println("How many index u want to add..");
        new_index=scan.nextInt();
        //final_index=index+new_index;
        //String[] color = new String[final_index];
         int s=0;
         while(s<new_index)
         {
         colorList.add(scan.next());
         s++;
         
        }
        System.out.println("After adding"+colorList);

     }
     else{
         System.out.println("Thanq");
     }
     
}    
}