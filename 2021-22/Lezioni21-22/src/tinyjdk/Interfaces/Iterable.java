package tinyjdk.Interfaces;

public interface Iterable<E> {
    Iterator<E> iterator();
}

/*
* The Iterable interface defines just the property of the class that implements it to be "iterable"
* It has one method:
*   iterator() --> returns an Iterator object that let the user iterate through the Collection
* */