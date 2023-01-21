package net.prep.screen.tech.most.juniors;

// package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3
import java.util.*;

// You are given a collection of person objects (in a natural manner
// for the language you're writing in) with three fields:

// {firstName, lastName, age}

//     Example: {Jane, Smith, 14},
//          or: {"firstName": "Jane", "lastName": "Smith", "age": 14}

// We want to know which family has the longest line of "juniors".
// A family has "juniors" when multiple family members have the same full name.

// Consider the following example.

// [
//     {"firstName": "John",  "lastName": "Doe",   "age": 13},
//     {"firstName": "John",  "lastName": "Doe",   "age": 32},
//     {"firstName": "John",  "lastName": "Doe",   "age": 62},
//     {"firstName": "Janet", "lastName": "Doe",   "age": 14},
//     {"firstName": "Jenny", "lastName": "Smith", "age": 34},
//     {"firstName": "Jenny", "lastName": "Smith", "age": 12},
// ]

// In this example, the Doe family has the longest line of juniors.

// Let’s talk about your plan of attack before you start coding, and remember
// to keep talking me through what you are doing as you code.

public class Solution {

    private static class Person {
        String firstName;
        String lastName;
        int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
    }

    private int maxJuniors = 0;
    private String maxJuniorsLastName = "";

    public static void main (String[] args) {

        List<Person> input = parseInput(args);
        var sol = new Solution();
        sol.findMaxJuniors(input);

        System.out.printf("The %s family has the higher number of juniors %d", sol.getMaxJuniorsLastName(), sol.getMaxJuniors());
    }

    private static List<Person> parseInput(String[] args) {
        return new LinkedList<>();
    }

    private void findMaxJuniors(List<Person> input) {

        Map<String, Map<String, Integer>> families = new HashMap<>();

        for (Person p : input) {

            if (!families.containsKey(p.lastName)) {
                // initialize for a new family
                Map<String, Integer> firstNames = new HashMap<>();
                firstNames.put(p.firstName, 1);
                families.put(p.lastName, firstNames);
                if (1 > maxJuniors) {
                    maxJuniors = 1;
                    maxJuniorsLastName = p.lastName;
                }
            } else {
                Map<String, Integer> firstNames = families.get(p.lastName);
                int jrCount = firstNames.getOrDefault(p.firstName, 0);
                jrCount++;
                firstNames.put(p.firstName, jrCount);
                if (jrCount > maxJuniors) {
                    maxJuniors = jrCount;
                    maxJuniorsLastName = p.lastName;
                }
            }
        }
    }

    public int getMaxJuniors() {
        return maxJuniors;
    }

    public String getMaxJuniorsLastName() {
        return maxJuniorsLastName;
    }
}







