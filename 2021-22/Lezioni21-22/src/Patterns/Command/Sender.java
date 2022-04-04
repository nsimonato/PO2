package Patterns.Command;

public class Sender {
    Command getCommand() {
        return new Command() {
            @Override
            public void execute() {
                //Do Stuff
            }
        };
    }
}
