package net.prep.screen.tech.player.rank;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {

    @Test
    public void emptyRankTest() {
        var result = Result.climbingLeaderboard(new ArrayList<>(), new ArrayList<>(List.of(1, 2, 3)));
        result.stream().forEach(v -> assertEquals(1,v));
    }

    @Test
    public void singleRankTest() {
        var result = Result.climbingLeaderboard(new ArrayList<>(List.of(2)), new ArrayList<>(List.of(1, 2, 3)));
        assertEquals(3, result.size());
        assertEquals(2, result.get(0));
        assertEquals(1, result.get(1));
        assertEquals(1, result.get(2));
    }

    @Test
    public void threeRankTest() {
        var result = Result.climbingLeaderboard(new ArrayList<>(List.of(7,5,4)), new ArrayList<>(List.of(10, 6, 5, 4, 2)));
        assertEquals(5, result.size());
        assertEquals(1, result.get(0));
        assertEquals(2, result.get(1));
        assertEquals(2, result.get(2));
        assertEquals(3, result.get(3));
        assertEquals(4, result.get(4));
    }

    @Test
    public void theirRankTest() {
        var result = Result.climbingLeaderboard(new ArrayList<>(List.of(100, 100, 50, 40, 40, 20, 10)),
                new ArrayList<>(List.of(5, 25, 50, 120)));
        assertEquals(4, result.size());
        assertEquals(6, result.get(0));
        assertEquals(4, result.get(1));
        assertEquals(2, result.get(2));
        assertEquals(1, result.get(3));
    }


}