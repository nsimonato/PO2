package Exercises.Eserciziario1;

public class Es2 {
    /*
    * 1)  D - No, per`o non c’`e limite al numero di interfacce che una classe pu`o implementare.
  X * 2)  D - A permettere di definire classi o interfacce parametriche su altri tipi.
    * 3)  B - σ ̸⪯ ρ
    * 4)  B - No, ma rende possibile il polimorfismo subtype poich´e garantisce che i membri pubblici delle superclassi
             esistano nelle sottoclassi.
  X * 5)  C - Il tipo ed il numero dei parametri e basta, senza tipo di ritorno n´e eccezioni.
    * 6)  B - S`ı, anche se le sottoclassi Paladin e Rogue specializzano il tipo di ritorno rispetto al type argument
            passato alla superclasse, la specializzazione del tipo di ritorno `e supportata dall’overriding in Java.
    * 7)  A - static <A, B> Collection<B> map(Collection<A> c, Function<? super A, ? extends B> f)
    * 8a) C - S`ı, perch´e i due metodi hanno parametri di tipo differente; e nonostante Character sia un supertipo
            di Paladin il compilatore `e in grado di discriminare.
    * 8b) A - S`ı, compilerebbe e risolverebbe normalizeAttack(Paladin)
    * 9)  B - L’overriding supporta la co-varianza del tipo di ritorno di un metodo.
    * */
}
