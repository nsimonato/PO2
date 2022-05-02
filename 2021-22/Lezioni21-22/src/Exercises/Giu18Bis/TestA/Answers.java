package Exercises.Giu18Bis.TestA;

public class Answers {
    /*
    * 1)  Singleton
    * 2)  Perch´e i costruttori non sono metodi soggetti al dynamic dispatching, quindi non `e possibile sfruttare il
    *     polimorfismo per costruire oggetti se non tramite un metodo non-statico che incapsula la costruzione.
    * 3)  No, per`o non c’`e limite al numero di interfacce che una classe pu`o implementare.
    * 4a) No, perch´e i metodi avrebbero la medesima type erasure.
    * 4b) No: il constraint <T extends Comparable<T>> impone che Elf implementi Comparable<Elf>, ma
    *     invece implementa Comparable<Humanoid>.
    * 4c) c
    * */
}
