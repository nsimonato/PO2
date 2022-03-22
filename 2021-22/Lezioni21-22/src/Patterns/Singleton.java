package Patterns;

public class Singleton {
    private static Singleton instance;
    //Other attributes
    public Singleton(){
        //Operations
    }

    public static Singleton getInstance(){
        if(instance == null)
            instance = new Singleton();
        return instance;
    }

    //Personalized methods
}
