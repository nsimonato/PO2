package tinyjdk;

public interface List<X> extends Collection<X> {
    X get(int pos);
    void set(int pos, X e);
    int indexOf(X e) throws NotFoundException;

    default boolean contains(X e) { //Default definition provided in order to reuse this code as much as possible
        try {
            indexOf(e);
            return true;
        } catch (NotFoundException ex) {
            return false;
        }
    }
}
/*
* The List interface defines the extension of the Collection, where List is a group of ordered objects.
* It allows random access.
* The definition of its methods are defined as follows:
*   get(int pos); --> Returns the object at position of index "pos"
*   set(int pos, X e); --> The object "e" is put in position of index "pos"
*   indexOf(X e) throws NotFoundException; --> Return the index of the first occurrence of "e"
* */
