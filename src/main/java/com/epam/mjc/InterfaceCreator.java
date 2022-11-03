package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        Predicate<List<String>> predicate = x -> {
            boolean isValuesStartWithUpperCase = false;
            for (String word : x) {
                isValuesStartWithUpperCase = Character.isLetter(word.charAt(0)) && Character.isUpperCase(word.charAt(0));
                if (!isValuesStartWithUpperCase) break;
            }
            return isValuesStartWithUpperCase;
        };

        return predicate;
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        List<Integer> evenList = new ArrayList<>();
        Consumer<List<Integer>> addEvenAtTheEnd = x -> {
            for (Integer integer : x) {
                if (integer % 2 == 0) evenList.add(integer);
            }
            x.addAll(evenList);
        };

        return addEvenAtTheEnd;
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        Supplier<List<String>> filteredCollections = () -> {
            List<String> correctList = new ArrayList<>();
            for (String s : values) {
                if (Character.isLetter(s.charAt(0)) &&
                        Character.isUpperCase(s.charAt(0)) &&
                        s.split(" ").length > 3 &&
                        s.charAt(s.length() - 1) == '.'
                )
                    correctList.add(s);
            }
            return correctList;
        };

        return filteredCollections;
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Function<List<String>, Map<String, Integer>> strSize = x -> {
            Map<String, Integer> res = new HashMap<>();

            for (String s : x) {
                res.put(s, s.length());
            }

            return res;
        };

        return strSize;
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        BiFunction<List<Integer>, List<Integer>, List<Integer>> list = (x, y) -> {
            List<Integer> resList = new ArrayList<>();
            resList.addAll(x);
            resList.addAll(y);
            return resList;
        };

        return list;
    }
}
