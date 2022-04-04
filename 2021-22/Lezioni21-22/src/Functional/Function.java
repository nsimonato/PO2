package Functional;

@FunctionalInterface
public interface Function<Output, Input> {
    Output apply(Input input);
}
