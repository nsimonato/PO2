package tinyjdk.Interfaces;

import tinyjdk.NotFoundException;

public interface Collection<X> extends Iterable<X> {
    void add(X e);
    void remove(X e) throws NotFoundException;
    boolean contains(X e);
    void clear();
    int size();
}

/*
* The Collection interface defines the behaviour of the most generic group of objects possible.
* No rules to follow are defined.
* What follows is the definition of its methods:
*   add(X e) --> The X object called "e" is added to the Collection
*   remove(X e) --> The object "e" is removed from the Collection
*   contains(X e); --> Returns true if and only if the Collection contains at least one occurrence of "e"
*   clear(); --> Empties the Collection
*   size(); --> Returns the size of the Collection as an int
* */
