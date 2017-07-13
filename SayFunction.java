interface Sayable{  
    void say();  
}  
public class SayFunction {  
    public static void some(){  
        System.out.println("Hello, this is static method.");  
    }  
    public static void main(String[] args) {  
        Sayable sayable = SayFunction::some;  
        sayable.say();
       /* SayFunction h=new SayFunction();
        h.some();*/  
    }  
}  