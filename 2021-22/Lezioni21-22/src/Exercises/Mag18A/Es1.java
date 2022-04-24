package Exercises.Mag18A;

class Es {
    public class HannaBarbera {

        public interface Food {
            int getWeight();
        }

        public interface Animal extends Food {
            void eat(Food f);
        }

        public static class Mouse implements Animal {
            private int weight;

            public Mouse(int weight) { this.weight = weight; }

            @Override
            public void eat(Food f) { weight += f.getWeight() / 2; }

            @Override
            public int getWeight() { return weight; }
        }

        public static class Cat implements Animal {
            private int weight;

            public Cat(int weight) { this.weight = weight; }

            @Override
            public void eat(Food f) { weight += f.getWeight() / 5; }

            @Override
            public int getWeight() { return weight; }
        }

        public static class Cheese implements Food {
            @Override
            public int getWeight() { return 50; }
        }
    }

    public class HannaBarberaRefactored{

        public static abstract class Food{
            protected int weight;
            protected abstract int getWeight();
        }

        public static class Animal extends Food {
            Animal(int weight){
                this.weight = weight;
            }
            @Override
            public int getWeight() {
                return weight;
            }

            public void eat(Food f){
                this.weight += f.getWeight();
            }
        }


        public static class Cat extends Animal{

            Cat(int weight) {
                super(weight);
            }

            public void eat(Food f){
                this.weight += f.getWeight() / 5;
            }
        }

        public static class Mouse extends Animal{

            Mouse(int weight) {
                super(weight);
            }

            public void eat(Food f){
                this.weight += f.getWeight() / 2;
            }
        }

        public static class Cheese extends Food {
            @Override
            protected int getWeight() {
                return 50;
            }
        }

        public static void main(String[] args) {
            Animal tom = new Cat(200); //Tom 200
            Animal jerry = new Mouse(10); //Jerry 10
            jerry.eat(new Cheese()); //Jerry 10-->35
            jerry.eat(new Food() { //Jerry 10-->35-->40
                @Override
                public int getWeight() { return 10; }
            });
            tom.eat(jerry); //Tom 200-->208
            System.out.println(String.format("Tom now weights %d", tom.getWeight()));
        }

    }


}

