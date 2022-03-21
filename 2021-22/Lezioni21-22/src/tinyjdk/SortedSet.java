package tinyjdk;

public interface SortedSet<T extends Comparable<? super T>> extends Collection<T> {

}
/*
* There is no need to define new methods, because the SortedSet interface and the Collection interface are the same.
* Although, it is intended that the behaviour of a SortedSet must follow the following requirements:
* - In a Set there are no duplicates;
* - The addition or the removal of an element keep the Set Sorted.
* It is a common practice to not encode any behaviour if this cannot be encoded. The semantics of the interface are expressed
* in the documentation and the programmers are encouraged to follow it during the development of the implementation.
* The Generic used is supposed to be used with the Utility Class "Collections", that contains the sorting methods: The Type Parameter
*  are compatible with those defined by Collections.
* */