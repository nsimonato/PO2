package Exercises.Eserciziario2;

public class Es1 {
    public static class Es1_2{
        /*
        1)  D - No, per`o non c’`e limite al numero di interfacce che una classe pu`o implementare
      X 2)  D - A permettere di definire classi o interfacce parametriche su altri tipi.
        3)  C - φ ⪯ ρ
      X 4)  D - No, perch´e l’ereditariet`a non garantisce davvero che i membri pubblici delle superclassi esistano anche
               nelle sottoclassi, in quanto `e possibile cambiare la visibilit`a dei membri pubblici ereditati al momento
               dell’override, ad esempio rendendoli privati, quindi non invocabili.
        5)  C - Il tipo ed il numero dei parametri e basta, senza tipo di ritorno n´e eccezioni.
      X 6)  C - Non quello della classe Rogue, poich´e passa Number come type argument alla superclasse, ma dichiara
               Integer (che `e un sottotipo) come tipo di ritorno dell’override.
      X 7)  D - static <A, B> Collection<B> map(Collection<? extends A> c, Function<A, ? extends B> f)
      X 8a) C - Sì, perch´e i due metodi hanno parametri di tipo differente; e nonostante Character sia un supertipo
               di Paladin il compilatore `e in grado di discriminare.
      X 8b) C - No, non compilerebbe senza modificare la firma della map().
        9)  B - L’overriding supporta la co-varianza del tipo di ritorno di un metodo.


        * */
    }

    public static class Es1_3{
        /*
        1.3.1
        a) Booleano
        b) Booleano
        c) Non compila
        d) Booleano
        e) Booleano
        f) Booleano
        g) Booleano
        h) Booleano
        i) Non compila
        j) Booleano
        k) Booleano
        l) Non compila
        * */

        /*
        * 1.3.2
        * 1a) B -  No, perch´e i metodi avrebbero la medesima type erasure.
        * 1b) A - No: il constraint <T extends Comparable<T>> impone che Elf implementi Comparable<Elf>, ma
                invece implementa Comparable<Humanoid>
        * 1c) C
     X  * 2)  A -  No: il primo argomento artists ha tipo List<Artist>, istanziando il generic T con Artist, pertanto
l’oggetto di tipo Comparator<Person> passato come secondo argomento non soddisfa il wildcard perch´e
Person `e diverso da Artist.

        * */

        /*
        * 1.3.3
     X  * A - Ad un riferimento ad un metodo statico (static method reference) della classe Solid; ovvero all’espressione
            Solid::volume
        * */

    }
}
