package Functional;

@FunctionalInterface
public interface Consumer<Input> {
    void consume(Input input);
}
