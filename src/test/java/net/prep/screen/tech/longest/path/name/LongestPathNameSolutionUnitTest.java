package net.prep.screen.tech.longest.path.name;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPathNameSolutionUnitTest {

    LongestPathNameSolution sut = new LongestPathNameSolution();

    @Test
    void longestPathLengthForEmptyDirectory() {

        int len = sut.longestPathLength("dir");
        assertEquals(0, len);
    }

    @Test
    void longestPathLengthForDirectoryWithSingleFile() {

        int len = sut.longestPathLength("dir"+'\n'+'\t'+"a.ext");
        assertEquals(9, len);
    }

    @Test
    void longestPathLengthForDirectoryWithSingleFileAndSingleSubdir() {

        int len = sut.longestPathLength("dir"+'\n'+'\t'+"a.ext"+'\n'+'\t'+"sub 1");
        assertEquals(9, len);
    }

    @Test
    void longestPathLengthForDirectoryWithFileAndSubdirWithFile() {

        int len = sut.longestPathLength("dir"+'\n'+"\ta.ext"+'\n'+"\tsub 1"+'\n'+"\t\tb.ext");
        assertEquals(15, len);
    }

    @Test
    void longestPathLengthForDirectoryWithFilesAndSubdirectoryWithFiles() {

        int len = sut.longestPathLength("dir"+'\n'+"\ta.ext"+'\n'+"\tsub 1"+'\n'+"\t\tb.ext\n\tvery long file name.ext");
        assertEquals(27, len);
    }

    @Test
    void longestPathLengthForDirectoryWithFilesAndSubdirectoriesWithFiles() {

        int len = sut.longestPathLength("dir"+'\n'+"\ta.ext"+'\n'+"\tsub 1"+'\n'+"\t\tb.ext\n\tvery long file name.ext"
                + "\n\tsub 2\n\t\tsuper long file name.ext");
        assertEquals(34, len);
    }

}