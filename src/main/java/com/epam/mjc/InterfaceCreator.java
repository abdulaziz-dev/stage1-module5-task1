package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x-> {
            for(String s : x){
                if( !((s.charAt(0) >= 'A') && (s.charAt(0) <= 'Z')) ){
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> list = new ArrayList<>();
            for (Integer i : x){
                if (i % 2 == 0)
                    list.add(i);
            }
            x.addAll(list);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            int wordCount;
            List<String> list = new ArrayList<>();
            for (String s: values){
                wordCount = s.split(" ").length;
                boolean boshHarf =  (s.charAt(0) >= 'A') && (s.charAt(0) <= 'Z');
                if(wordCount > 3 && s.charAt(s.length()-1) == '.' && boshHarf){
                    list.add(s);
                }
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s : x){
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list = new ArrayList<>(list1);
            list.addAll(list2);
            return list;
        };
    }
}
