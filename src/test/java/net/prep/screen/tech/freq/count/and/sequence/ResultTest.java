package net.prep.screen.tech.freq.count.and.sequence;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    Result sut = new Result();

    @Test
    void rewardsSort() {
        var input =    List.of("PL_NEW", "PL_PMT", "SL_PMT", "PL_PMT", "HL_PMT", "SL_PMT", "PL_PMT", "HL_PMT");
        var expected = List.of("PL_PMT", "PL_PMT", "PL_PMT", "HL_PMT", "HL_PMT", "SL_PMT", "SL_PMT", "PL_NEW");
        var output = sut.rewardsSort(input);
        assertIterableEquals(expected, output);
    }

    @Test
    void altRewardsSort() {
        var input =    List.of("PL_NEW", "PL_PMT", "SL_PMT", "PL_PMT", "HL_PMT", "SL_PMT", "PL_PMT", "HL_PMT");
        var expected = List.of("PL_PMT", "PL_PMT", "PL_PMT", "HL_PMT", "HL_PMT", "SL_PMT", "SL_PMT", "PL_NEW");
        var output = sut.altRewardsSort(input);
        assertIterableEquals(expected, output);
    }

    @Test
    void advRewardsSort() {
        var input =    List.of("PL_NEW", "PL_PMT", "SL_PMT", "PL_PMT", "HL_PMT", "SL_PMT", "PL_PMT", "HL_PMT");
        var expected = List.of("PL_PMT", "PL_PMT", "PL_PMT", "HL_PMT", "HL_PMT", "SL_PMT", "SL_PMT", "PL_NEW");
        var output = sut.advRewardsSort(input);
        assertIterableEquals(expected, output);
    }
}