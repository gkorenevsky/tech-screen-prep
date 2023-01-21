package net.prep.screen.tech.player.rank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     *
     * Ranked values are sorted in descending order
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        Integer[] uniqRank = ranked.stream().distinct().collect(toList()).toArray(new Integer[0]);

        return player.stream().map(score -> rankPlayer(uniqRank, score)).collect(toList());
    }

    public static int rankPlayer(Integer[] rank, int score) {

        if (rank.length == 0) {
            return 1;
        }

        return binarySearch(score, rank, 0, rank.length - 1) + 1;
    }

    private static int binarySearch(int score, Integer[] rank, int start, int end) {
        if (end - start < 1) {
            if (score >= rank[start]) {
                return start;
            } else {
                return start + 1;
            }
        } else {
           int mid = (start + end) / 2;
           if (score == rank[mid]) {
               return mid;
           } else if (score > rank[mid]) {
               return binarySearch(score, rank, start, mid - 1);
           } else {
               return  binarySearch(score, rank, mid + 1, end);
           }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
