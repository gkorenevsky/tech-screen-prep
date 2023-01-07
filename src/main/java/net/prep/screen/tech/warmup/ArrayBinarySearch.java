package net.prep.screen.tech.warmup;

// Binary search of sorted arrays of Comparable objects
public class ArrayBinarySearch<T extends Comparable<T>> implements ArraySearch<T> {
    @Override
    public T search(T[] source, T key) {
        T result = null;

        // only consider non-empty arrays
        if (source.length > 0) {
            int lower = 0;
            int upper = source.length - 1;
            boolean proceed = true;

            // iterate while more elements remain to be examined
            while (proceed) {
                int middle = (upper + lower) / 2;
                int test = source[middle].compareTo(key);
                if (test == 0) {    // found matching entry
                    proceed = false;
                    result = source[middle];
                } else if (test > 0) {  // search key is lower
                    upper = middle - 1;
                } else {    // search key is higher
                    lower = middle + 1;     // advance past middle
                }

                if ((upper - lower) < 0) {
                    proceed = false;
                }
            }
        }

        return result;
    }
}
