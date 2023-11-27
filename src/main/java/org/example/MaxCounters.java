package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;


public class MaxCounters {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(1, new int[]{1})));
//        System.out.println(Arrays.toString(solution(3, new int[]{1, 2, 3, 2, 1, 2})));
//        System.out.println(Arrays.toString(solution(1, new int[]{2, 1, 1, 2, 1})));
        System.out.println(Arrays.toString(solution(7, new int[]{3, 6, 3, 6, 2, 7})));

    }

    public static int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        boolean containsBiggerNum = Arrays.stream(A).anyMatch(x -> x > N);
        if (containsBiggerNum) {
            counterIncreaser(counters, A, N);
        } else {
            countersFiller(counters, duplicateCounter(A));
        }
        return counters;
    }

    public static Map<Integer, Integer> duplicateCounter(int[] arr) {
        return Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Integer::intValue, collectingAndThen(counting(), Long::intValue)));
    }

    public static void countersFiller(int[] countersArr, Map<Integer, Integer> counterValues) {
        counterValues.forEach((key, value) -> countersArr[(key - 1)] += value);
    }

    public static void counterIncreaser(int[] countersArr, int[] counterVal, int amountCounters) {
        List<Integer> increaseIndexes = indexesFinder(counterVal, amountCounters);
        int skipIndex = 0;
        int maxIncreaser = 0;
        for (int i = 0; i < increaseIndexes.size(); i++) {
            int limit = increaseIndexes.get(i);
            Map<Integer, Long> group = Arrays.stream(counterVal).skip(skipIndex).limit(limit).filter(x -> x <= amountCounters).boxed()
                    .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
            if (!group.isEmpty()) {
                maxIncreaser += group.values().stream().mapToInt(Long::intValue).max().getAsInt();
                Arrays.fill(countersArr, maxIncreaser);
            }
            skipIndex = limit;
        }
        if (skipIndex < counterVal.length - 1) {
            countersFiller(countersArr, duplicateCounter(Arrays.stream(counterVal).skip(skipIndex + 1).toArray()));
        }
    }

    public static List<Integer> indexesFinder(int[] counterVal, int amountCounters) {
        ArrayList<Integer> list = Arrays.stream(counterVal).boxed().collect(Collectors.toCollection(ArrayList::new));
        List<Integer> biggerVals = list.stream().filter(x -> x > amountCounters).distinct().collect(Collectors.toList());
        List<Integer> indexes = new ArrayList<>();

        biggerVals.forEach(x -> {
            indexes.addAll(IntStream.range(0, list.size()).filter(i -> list.get(i).equals(x)).boxed().collect(Collectors.toList()));
        });

        return indexes;
    }
}

//    public static int[] solution(int N, int[] A) {
//        System.out.println(N);
//        int[] counters = new int[N];
//        boolean containsBiggerNum = Arrays.stream(A).anyMatch(x -> x > N);
//        if (containsBiggerNum) {
//            ArrayList<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toCollection(ArrayList::new));
//            int limit = Arrays.stream(A).filter(x -> x > N).distinct().map(list::lastIndexOf).max().getAsInt();
//            int maxIncreaser = 0;
//            Map<Integer, Long> group = Arrays.stream(A).limit(limit).filter(x -> x <= N).boxed()
//                    .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
//            if (!group.isEmpty()) {
//                maxIncreaser = group.values().stream().mapToInt(Long::intValue).max().getAsInt();
//                Arrays.fill(counters, maxIncreaser);
//            }
//            if (limit > A.length) {
//                return counters;
//            } else {
//                finalIncreasing(Arrays.stream(A).skip(limit+1).toArray(), counters);
//            }
//        } else {
//            counters = finalIncreasing(A, counters);
//        }
//        return counters;
//
//    }
//    public static int[] finalIncreasing(int[] arr, int[] counters){
//
//        for (int i=0; i< arr.length; i++){
//            int counterIndex = arr[i];
//            if (counterIndex > 0) {
//                counters[arr[i] - 1] += 1;
//            }
//        }
//        return counters;
//    }

