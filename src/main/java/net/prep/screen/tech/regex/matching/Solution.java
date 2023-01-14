package net.prep.screen.tech.regex.matching;

class Solution {

    public boolean isMatch(String s, String p) {

        // Assume valid pattern string
        return matches(s, 0, p, 0);
    }

    private boolean matches(String txt, int it, String pattern, int ip) {

        boolean result = false;

        // Not end of text input
        if (it < txt.length()) {
            // Not end of pattern
            if (ip < pattern.length()) {
                if (ip+1 < pattern.length()) {
                    // look ahead and check for *
                    if (pattern.charAt(ip+1) == '*') {
                        ip++;   // if *, skip over original char
                    }
                }

                switch (pattern.charAt(ip)) {
                    case '.':   // consume and advance
                        result = matches(txt, it+1, pattern, ip+1);
                        break;
                    case '*':
                        // if char before * matches
                        result = ((pattern.charAt(ip-1) == '.')
                                || (pattern.charAt(ip-1) == txt.charAt(it)))
                                // consume but don't advance
                                ? (matches(txt, it+1, pattern, ip-1) ||
                                // don't consume and advance
                                matches(txt, it, pattern, ip+1))
                                // if char before * doesn't match
                                // don't consume and advance
                                : matches(txt, it, pattern, ip+1);
                        break;
                    default:
                        result = (txt.charAt(it) == pattern.charAt(ip))
                                ? matches(txt, it+1, pattern, ip+1)
                                : false;
                }
            } else {
                // End of pattern, but more data remains
                // Note: * at the end of the pattern is handled above
                result = false;
            }
        } else {
            // End of text input
            // If end of pattern, then the two match
            result = (ip >= pattern.length());

            // process the remaining pattern
            if (!result) {
                // the only pattern that will match end of input is
                // a char or . followed by *
                if (ip < pattern.length() - 1) {
                    // look ahead and check for *
                    if (pattern.charAt(ip+1) == '*') {
                        // skip past char followed by *
                        result = matches(txt, it, pattern, ip + 2);
                    }
                }
            }
        }

        return result;
    }

}

