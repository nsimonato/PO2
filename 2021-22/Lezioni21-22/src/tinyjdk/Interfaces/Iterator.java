package tinyjdk.Interfaces;

public interface Iterator<T> {
    boolean hasNext();
    T next();
}
/*
* Iterator interface defines two methods:
*   hasNext() --> returns true if and only if the next element exists
*   next() --> returns the next element
* */