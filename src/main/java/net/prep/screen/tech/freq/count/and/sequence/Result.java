package net.prep.screen.tech.freq.count.and.sequence;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


class Result {

    /*
     * Complete the 'rewardsSort' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY transactions as parameter.
     */

    //
    // Initial implementation with conventions data structures
    //
    public List<String> rewardsSort(List<String> transactions) {

        Map<String, Integer> transFreqs = new HashMap<>();
        Map<Integer, SortedSet<String>> transSorted = new TreeMap<>(Comparator.reverseOrder());

        List<String> result = new LinkedList<>();

        // accumulate freq counts
        for (String s : transactions) {
            transFreqs.put(s, transFreqs.getOrDefault(s, 0) + 1);
        }

        // invert the freq tree
        for (Map.Entry<String, Integer> e : transFreqs.entrySet()) {
            SortedSet<String> set = transSorted.getOrDefault(e.getValue(), new TreeSet<String>());
            set.add(e.getKey());
            transSorted.put(e.getValue(), set);
        }

        for (Map.Entry<Integer, SortedSet<String>> e : transSorted.entrySet()) {
            Set<String> set = e.getValue();
            for (String s : set) {
                for (int i = 0; i < e.getKey(); i++) {
                    result.add(s);
                }
            }
        }

        return result;
    }

    //
    // Alternative implementation with some streams
    //
    public List<String> altRewardsSort(List<String> transactions) {

        Map<String, Integer> transFreqs = new HashMap<>();
        Map<Integer, SortedSet<String>> transSorted = new TreeMap<>(Comparator.reverseOrder());

        List<String> result = new LinkedList<>();

        // accumulate freq counts
        transactions.forEach(s -> transFreqs.put(s, transFreqs.getOrDefault(s, 0) + 1));

        // invert the freq tree
        for (Map.Entry<String, Integer> e : transFreqs.entrySet()) {
            SortedSet<String> set = transSorted.getOrDefault(e.getValue(), new TreeSet<String>());
            set.add(e.getKey());
            transSorted.put(e.getValue(), set);
        }

        transSorted.entrySet().stream().flatMap(e -> toSortedList(e).stream()).forEach(result::add);

        return result;
    }

    private List<String> toSortedList(Map.Entry<Integer, SortedSet<String>> e) {
        return e.getValue().stream().flatMap(s -> {
            String[] sa = new String[e.getKey()];
            Arrays.fill(sa, s);
            return Arrays.stream(sa);
        }).collect(Collectors.toList());
    }

    //
    // Alternative implementation with some streams
    //
    public List<String> advRewardsSort(List<String> transactions) {

        // Collect frequencies
        Map<String, Long> transFreqs = transactions.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // each entry contains code and count
        List<String> result = transFreqs.entrySet().stream()
                // sort by frequency
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                // convert to list of identical entries, then to stream
                .flatMap(e -> Collections.nCopies(Math.toIntExact(e.getValue()), e.getKey()).stream())
                // collect to a list
                .collect(Collectors.toList());

        return result;
    }

}