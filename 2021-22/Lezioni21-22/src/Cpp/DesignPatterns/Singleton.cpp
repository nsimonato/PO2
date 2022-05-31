
//using namespace std;

template <typename T>
class singleton{
private:
    T instance;
public:
    singleton()
    {
        instance = new T();
    }

    T get_instance() const
    {
        if(instance == null)
            instance = new T();
            

        return instance;
    }

    void ~singleton()
    {
        delete instance;
    }   
};