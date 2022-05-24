package Exercises.Eserciziario1;

public class Es3 {
    /*3.1
    * a) False
    * b) True
    * c) Non compila
    * d) False
    * e) False
    * f) True
    * g) False
    * h) False
X   * i) False
    * j) False
    * k) Non compila
X   * l) False
    * */
    /*3.2
    * 1a) No, perch´e i metodi avrebbero la medesima type erasure.
    * 1b) No: il constraint <T extends Comparable<T>> impone che Elf implementi Comparable<Elf>, ma
        invece implementa Comparable<Humanoid>.
    * 1c) b
    * 2)  S`ı: il primo argomento artists ha tipo List<Artist>, istanziando il generic T con Artist, pertanto
        l’oggetto di tipo Comparator<Person> passato come secondo argomento soddisfa il wildcard con lower
        bound perch´e Person `e supertipo di Artist.
    * */
    /*3.3
    * Ad un riferimento ad un metodo non-statico (instance method reference) di un oggetto specifico, che `e
        this in questo caso; ovvero all’espressione this::volume.
    * */
}
