package Patterns.Factory;

public class ConcreteGenerator implements Generator{
    @Override
    public ConcreteProduct FactoryMethod() {
        return new ConcreteProduct();
    }
}
