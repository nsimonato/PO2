package Exercises.Eserciziario2;

public class Es3 {
    public class Es3d1{
        /*
        * Incapsulamento: spiegare cosa si intende per metodo setter. Fornire almeno una motivazione per la quale l’uso di
        * setter `e preferibile alla definizione di campi pubblici. Fare un esempio concreto (con codice) di un setter che svolge
        * una funzione non ottenibile con un campo pubblico.
        */

        /*
        * Un setter è un metodo di una classe che si occupa di assegnare un valore passato come parametro ad un campo privato.
        * L'uso di questa modalità di interazione con lo stato di una classe permette al programmatore di effettuare dei
        * controlli sui parametri passati al metodo, per motivi che possono essere sia di sicurezza che di integrità.
        * Consideriamo la seguente classe:
        */

        public class PasswordContainer{
            private String password;
            public void SetPassword(String password){
                this.password = SHA256(password);
            }

            public String SHA256(String s){
                return "omissis";
            }
        }

        /*
        * L'utilizzo del setter in questo caso ha permesso di applicare una funzione di Hash alla password da salvare, in
        * modo che, anche in caso di leaking, la password non sia salvata in chiaro e quindi potenzialmente visibile a tutti,
        * ma sotto forma di digest.
        */
    }

    public class Es3d2{
        /*
        * Ereditarietà: spiegare approfonditamente in concetto di sovrascrittura di un metodo e quali sono le condizioni
        * nelle quali può essere utile. Fare un esempio pratico mostrando le necessarie porzioni di codice.
        */

        /*
        * L'override di un metodo avviene nel momento in cui una classe eredita un metodo dalla sua superclasse e sovrascrive
        * il codice da eseguire, mantenendone intatta la firma.
        * E' buona pratica, quando si effettua un override, aggiungere l'annotazione @Override prima del metodo, in quanto permette
        * al compilatore di sollevare un warning nel momento in cui il metodo effettivamente non sovrascrive il metodo della
        * superclasse. Questa annotazione, inoltre, consente una migliore leggibilità del codice.
        * Questo concetto torna particolarmente utile quando si vuole massimizzare il riuso di codice attraverso l'uso del
        * meccanismo dell'ereditarietà.
        * L'overloading del metodo, infatti, ha come limite la necessità di adottare firme diverse affinché i metodi
        * siano riconosciuti come differenti dal compilatore Java.
        * L'overriding permette invece di riutilizzare la stessa firma in classi diverse, prevenendo l'adozione di parametri
        * superflui per aggirare i limiti dell'overloading.
        * L'esempio di seguito rappresenta una gerarchia del mondo animale, ovviamente semplificata:
        */

        public class Animal{
            int hunger;
            public void eat(int food){
                hunger -= food;
            }
        }

        public class Mammal extends Animal{
            @Override
            public void eat(int food){
                hunger -= food - 1;
            }
        }

        public class Rodent extends Animal{
            @Override
            public void eat(int food){
                hunger -= food / 8;
            }
        }

        /*
        * In questo caso si vuole rappresentare che i roditori necessitano più cibo per soddisfare la fame rispetto ai
        * mammiferi. Il meccanismo dell'override ha consentito di riscrivere esclusivamente le modifiche che abbiamo
        * voluto apportare alle sottoclassi, lasciando invariati lo stato ed i metodi ereditati.
        */
    }

    public class Es3d3{
        /*
        * . Espressioni Lambda: considerare l’interfaccia ActionListener con l’unico metodo void actionPerformed(ActionEvent
e). Considerare il JButton b e mostrare (con codice) come utilizzare il metodo void addActionListener(ActionListener
l) per aggiungere un ActionListener che stampi a console la stringa "Java", codificato rispettivamente come
una classe anonima e come un’espressione Lambda.

        * */
    }
}
