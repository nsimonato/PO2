package Patterns.Command;

import org.jetbrains.annotations.NotNull;

public class Receiver {

    void action(@NotNull Command c){
        c.execute();
    }
}
