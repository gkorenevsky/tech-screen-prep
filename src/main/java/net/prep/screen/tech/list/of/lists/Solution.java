package net.prep.screen.tech.list.of.lists;

import java.util.*;

public class Solution {

    public static class ListOfLists {

        private List<List<String>> lol;
        private ListIterator<List<String>> oit;
        private ListIterator<String> iit;
        public ListOfLists(List<List<String>> input) {
            lol = input;
            oit = lol.listIterator();
            iit = (oit.hasNext()) ? oit.next().listIterator() : new ArrayList<String>().listIterator();
        }

        public String next() {

            if (this.hasNext()) {
                if (iit.hasNext()) {
                    return iit.next();
                } else {
                    List<String> nextList = oit.next();
                    while (nextList.isEmpty() && oit.hasNext())  {
                        nextList = oit.next();
                    }

                    if (!nextList.isEmpty()) {
                        iit = nextList.listIterator();
                        return iit.next();
                    } else {
                        return null;
                    }
                }
            } else {
                return null;
            }
        }

        public boolean hasNext() {
            if (iit.hasNext()) {
                return true;
            }

            if (oit.hasNext()) {
               int nxi = oit.nextIndex();
               List<String> nextList;
               for (nextList = lol.get(nxi); nextList.isEmpty() && nxi < lol.size(); nxi++) {
                   nextList = lol.get(nxi);
               }

               return !nextList.isEmpty();
            } else {
                return false;
            }
        }
    }

}
