// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Integer nextValue;
    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if(this.iterator.hasNext()) {
            nextValue = this.iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer value = nextValue;
        nextValue = this.iterator.hasNext() ? this.iterator.next() : null;
        return value;
    }

    @Override
    public boolean hasNext() {
        return nextValue != null;
    }
}