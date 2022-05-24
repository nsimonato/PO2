package Exercises.Mag19;

import java.util.*;
import java.util.function.Function;

public class Test {
    public class Rpg {
        public static <A, B> Collection<B> map(Collection<A> c, Function<A, B> f) {
            List<B> r = new ArrayList<>();
            for (A a : c) {
                r.add(f.apply(a));
            }
            return r;
        }
        public static abstract class Character<R extends Number> {
            public int level;
            public final String name;
            protected Character(int level, String name) {
                this.level = level;
                this.name = name;
            }
            public abstract R attack();
        }
        public static class Paladin extends Character<Float> {
            public float mana;
            public Paladin(int level, String name) {
                super(level, name);
                mana = 100.f;
            }
            @Override
            public Float attack() { return mana * level / 2.f; }
        }
        public static class Rogue extends Character<Number> {
            public int energy;
            public Rogue(int level, String name) {
                super(level, name);
                energy = 50;
            }
            @Override
            public Integer attack() { return (energy -= 35) > 20 ? level * 2 : 0; }
        }

        public static int normalizeAttack(Character c) { return 1 + (int) c.attack(); }
        public static Float normalizeAttack(Paladin c) { return c.attack(); }
        public static void normalizeAttack(Paladin c, Number p) {  }

        public static void main(String args[]){
            List<Paladin> retadins = new ArrayList<>();
            retadins.add(new Paladin(60, "Leeroy Jenkins"));
            retadins.add(new Paladin(80, "Arthas"));
            Collection<Number> r2 = map(retadins, Rpg::normalizeAttack);
        }
    }

    /*
    * 1 ) B
    * 2 ) D
    * 3a) C
    * 3b) A
    * */
}
