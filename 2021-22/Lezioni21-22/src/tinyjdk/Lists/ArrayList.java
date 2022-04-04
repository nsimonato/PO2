package tinyjdk.Lists;

import tinyjdk.Interfaces.Iterator;
import tinyjdk.Interfaces.List;
import tinyjdk.NotFoundException;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private Object[] a; //The ArrayList is implemented as an Array of Object, so we can store any Class in it
    private int actualLen; //The number of element stored in the array
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        assert capacity > 0;
        a = new Object[capacity];
        actualLen = 0;
    }

    @Override
    public void add(T e) {
        if (actualLen >= a.length) //When maximum capacity is reached, the length of the array is doubled
            a = Arrays.copyOf(a, a.length * 2); //The old array is replaced by a copy of itself. It is invoked the static method "copyOf" of the Array Class
        a[actualLen++] = e; //the new element is added on the bottom of the Array, and the number of elements stored is updated
    }

    @Override
    public int indexOf(T e) throws NotFoundException {
        for (int i = 0; i < actualLen; ++i) //The iteration through the list stops only at the end of the array
            if (a[i].equals(e)) //if the element is found, the loop stops and the index is returned, the Garbage Collector takes care of the clean-up
                return i;
        throw new NotFoundException(); //If the execution flow reaches this point, it means that the element does not belong to the list
    }

    @Override
    public void remove(T e) throws NotFoundException {
        int i = indexOf(e); //the item "e" is searched using the "indexOf" method of this class. In case of failure, the apposite exception is thrown
        for (int j = i; j < size() - 1; ++j)
            a[j] = a[j + 1]; //The element is override with the next one, and all the other elements are translated one place to the left
        --actualLen; //The number of element stored is updated
    }

/*    @Override
    public boolean contains(T e) {
        try {
            indexOf(e); //The result is ignored, but if the invocation does not fail, it means that the element is contained
            return true;
        } catch (NotFoundException ex) {
            return false; //this point is only reached if "indexOf" throws an Exception
        }
    }*/

    @Override
    public void clear() {
        a = new Object[actualLen + 1];
    }

    @Override
    public int size() {
        return actualLen;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() { //The Iterator is implemented as an anonymous class
            private int pos = 0; //The initial position is set as 0

            @Override
            public boolean hasNext() {
                return pos < actualLen; //returns true if and only if the end of the array is reached
            }

            @Override
            public T next() {
                return (T) a[pos++]; //returns the element at the position "pos", then increments the index
            }
        };
    }

    @Override
    public T get(int i) {
        return (T) a[i];
    }

    @Override
    public void set(int i, T e) {
        a[i] = e;
    }
}
