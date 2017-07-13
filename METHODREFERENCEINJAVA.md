```
package com.kg.lambdaapp;

import java.util.*;
import java.util.Arrays;
import java.util.function.Consumer;

class HowForEachWorks {

    public static void main(String[] args) {
        List<String> disneyCharacters = Arrays.asList("Micky", "Donald", "Minnie", "Aurora", "Winnie", "Pluto");

        /*Consumer<String> con = new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
        };*/

        //Consumer<String> con = s -> System.out.println(s);
        //disneyCharacters.forEach(con);
        //disneyCharacters.forEach(s->System.out.println(s));

        
        // call by method
        disneyCharacters.forEach(System.out::println);

    }
}
```

```
package com.kg.lambdaapp;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class HowForEachWorks1 {
    public static void main(String[] args) {
        ArrayList list1=new ArrayList();
        List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        for (Integer i : numberList) {
            if ((i & 1)==0) {
                System.out.println(i);
            }

        }
    }

}
```
```
package com.kg.lambdaapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

class PredicateExample {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numberList.forEach(System.out::println);
        //List<Integer> evenNumberList=PredicateExample.testPredicate(numberList,x->PredicateExample.IsEvenNumber(x));
        //ContainingClass::staticMethodName
        List<Integer> evenNumberList = PredicateExample.testPredicate(numberList, PredicateExample::IsEvenNumber);
        System.out.println(evenNumberList);
    }

    public static boolean IsEvenNumber(Integer x) {
        return (x & 1) == 0;
    }

    public static List<Integer> testPredicate(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> returnList = new ArrayList<>();
        for (Integer x : list) {
            if (predicate.test(x))
                returnList.add(x);
        }
        return returnList;
    }
}
```

```
package com.kg.lambdaapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

class MethodReference1 {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numberList.forEach(System.out::println);
        //List<Integer> evenNumberList=PredicateExample.testPredicate(numberList,x->PredicateExample.IsEvenNumber(x));
        //ContainingClass::staticMethodName
        List<Integer> evenNumberList = MethodReference1.testPredicate(numberList, MethodReference1::IsEvenNumber);
        System.out.println(evenNumberList);
    }

    public static boolean IsEvenNumber(Integer x) {
        return (x & 1) == 0;
    }

    public static List<Integer> testPredicate(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> returnList = new ArrayList<>();
        for (Integer x : list) {
            if (predicate.test(x))
                returnList.add(x);
        }
        return returnList;
    }
}
```

```
package com.kg.lambdaapp;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;

class MethodReference2 {
    public static void main(String[] args) {
        List<Integer> integerNumbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //className::new
        List<Double> doubleNumbers = MethodReference2.applyFunction(integerNumbers, Double::new);
        System.out.println(doubleNumbers);
    }

    public static List<Double> applyFunction(List<Integer> list, Function<Integer, Double> function) {
        List<Double> returnList = new ArrayList<>();
        list.forEach(x -> returnList.add(function.apply(x)));
        return returnList;
    }
}
```

```
package com.kg.lambdaapp;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class MethodReference3 {
    public static void main(String[] args) {
        List<Color> colorList = Arrays.asList(new Color("Red"), new Color("Green"), new Color("Blue"),
                new Color("Yellow"));
        //List<String> colorNameList = MethodReference3.applyFunction(colorList, color->color.getName());
        //Reference to an instance method of an arbitrary object of a particular type -> containingType::methodName
        List<String> colorNameList = MethodReference3.applyFunction(colorList, Color::getName);
        System.out.println(colorNameList);
    }

    public static List<String> applyFunction(List<Color> list, Function<Color, String> function) {
        List<String> returnList = new ArrayList<>();
        list.forEach(x -> returnList.add(function.apply(x)));
        return returnList;
    }
}

class Color {
    private String name;

    public Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

```
package com.kg.lambdaapp;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class MethodReference4 {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        /*MethodReference4.acceptConsumer(numberList, x -> {
            System.out.println(x);
        });*/
        PrintStream printStream = System.out;
        //Reference to an instance method of a particular object -> containingObject::instancemethodName  
        MethodReference4.acceptConsumer(numberList, printStream::println);
    }

    public static void acceptConsumer(List<Integer> list, Consumer<Integer> consumer) {
        list.forEach(x -> consumer.accept(x));
    }
}

```