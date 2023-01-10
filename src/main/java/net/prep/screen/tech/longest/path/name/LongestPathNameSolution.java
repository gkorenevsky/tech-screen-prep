package net.prep.screen.tech.longest.path.name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestPathNameSolution {

    static final Pattern dirNamePattern = Pattern.compile("([a-zA-Z0-9 ]+)");
    static final Pattern fileNamePattern = Pattern.compile("([a-zA-Z0-9 ]+\\.[a-zA-Z0-9 ]+)");

    private String[] tokenStream = new String[0];
    private int tokenCursor = 0;

    //**
    private String getNextToken() {

        String token = previewNextToken();
        if (token != null) {
            tokenCursor++;
        }

        return token;
    }

    //**
    private String previewNextToken() {

        String token = null;
        if (tokenStream.length > 0 && tokenCursor < tokenStream.length) {
            token = tokenStream[tokenCursor];
        }

        return token;
    }

    private void tokenizeInput(String input) {
        tokenStream = input.split("\n");
    }

    public int longestPathLength(String input) {

        if (input.length() == 0) {
            return 0;
        }

        tokenizeInput(input);

        int nextMaxPathLength = getMaxPathLengthFromDir(0);
        return Math.max(0, nextMaxPathLength);
    }

    private boolean checkCurrentLevel(String id, int level) {
        return (id.startsWith("\t".repeat(level)));
    }

    private int getMaxPathLengthFromDir(int level) {

        int curMaxPathLength = 0;

        // Extract current directory name
        String currentToken = getNextToken();
        if (currentToken == null) {
            return curMaxPathLength;
        }

        String currDirName = currentToken.substring(level);

        // Iterate through a list of tokens
        for (var nextId = previewNextToken(); nextId != null; nextId = previewNextToken()) {
            // if a token doesn't start with the number of tabs == level+1, terminate recursion
            if (!checkCurrentLevel(nextId, level + 1)) {
                break;
            }
            //  for every file name, calculate max path length by adding current path
            if (isFile(nextId)) {
                String fileName = getFileName(getNextToken());
                curMaxPathLength = Math.max(curMaxPathLength, fileName.length());
            } else if (isDirectory(nextId)) {
                //  for every directory name, increment level and recurse
                var nextPathLength = getMaxPathLengthFromDir(level + 1);
                curMaxPathLength = Math.max(curMaxPathLength, nextPathLength);
            }
        }

        return (curMaxPathLength > 0) ? curMaxPathLength + 1 + currDirName.length() : 0;
    }

    private boolean isDirectory(String id) {
        return dirNamePattern.matcher(id).find();
    }

    private boolean isFile(String id) {
        return fileNamePattern.matcher(id).find();
    }

    private String getFileName(String id) {
        Matcher matcher = fileNamePattern.matcher(id);
        matcher.find();
        return matcher.group();
    }

}
