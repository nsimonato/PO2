package Exercises.Mag18B;

public class Es1 {
    public class HannaBarbera {
        public interface Food {
            int getWeight();
        }

        public static class Animal implements Food {
            protected int weight;

            public Animal(int weight){
                this.weight = weight;
            }

            void eat(Food f){
                weight += f.getWeight();
            }

            @Override
            public int getWeight() {
                return weight;
            }
        }

        public static class Mouse extends Animal {

            public Mouse(int weight) { super(weight); }

            @Override
            public void eat(Food f) { weight += f.getWeight() / 3; }

        }

        public static class Cat extends Animal {
            private int weight;

            public Cat(int weight) { super(weight); }

            @Override
            public void eat(Food f) { weight += f.getWeight() / 10; }
        }

        public static class Cheese implements Food {
            @Override
            public int getWeight() { return 300; }
        }

        public static void main(String[] args) {
            Animal tom = new Cat(8000); //Tom: 8000
            Animal jerry = new Mouse(100); //Jerry: 100
            jerry.eat(new Cheese()); //Jerry: 100 -> +100
            jerry.eat(new Food() {
                @Override
                public int getWeight() { return 900; }
            }); //Jerry: 100 -> +100 -> +300 --> 500
            tom.eat(jerry); //Tom: 8000 -> +50 --> 8050
            System.out.println(String.format("Tom now weights %d", tom.getWeight())); //8050
        }
    }

}
