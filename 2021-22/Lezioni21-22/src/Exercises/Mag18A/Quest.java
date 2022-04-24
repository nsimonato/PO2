package Exercises.Mag18A;

public class Quest {
    /*
    * In generale, a cosa servono le due forme di polimorfismo (subtyping e generics) che offre Java oggi?
    *
    * A riusare lo stesso codice, in termini di classi e dei loro membri, ereditandoli anzich´e riscrivendoli.
    * */

    /*
    * Si assuma la relazione di subtyping  (ed il suo complemento 6) tale per cui, dati due tipi A e B,
    * se A  B allora A `e sottotipo di B.
    * E siano τ, σ, ρ, ϕ tipi concreti per cui valgono le seguenti relazioni: σ  τ ,
    * ρ  σ e ϕ  τ . Si indichi quali delle seguenti relazioni non `e valida.
    *
    * ϕ  ρ
    * */

    /*
    * L’ereditarietà è una forma di polimorfismo?
    *
    * No, ma rende possibile il polimorfismo subtype poich´e garantisce che i membri pubblici delle superclassi esistano nelle sottoclassi.
    * */

    /*
    * Quali parti della firma di un metodo sono coinvolte nella risoluzione dell’overloading in Java?
    *
    * Il tipo ed il numero dei parametri, il tipo di ritorno ed anche le eccezioni dichiarate.
    * */
}
