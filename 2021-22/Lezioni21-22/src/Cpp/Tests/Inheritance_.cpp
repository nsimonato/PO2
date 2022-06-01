
class Animal{
private:
    int p_w;
protected:
    int pp_w;
public:
    int weight;

    Animal(): weight(0), p_w(0), pp_w(0) {}

    Animal(int weight): weight(weight), p_w(weight), pp_w(weight) { }

    Animal(const Animal& a): weight(a.weight), p_w(a.p_w), pp_w(a.pp_w) { }

    virtual void eat(int food){
        weight += food;
    }
};

class Dog : public Animal{
    void eat(int food) override 
    { 
        weight += food / 2;
    }

    Dog(const Dog* a){ 
       this->pp_w = a->pp_w;
       this->weight = a->weight;
    }
};

class Cat : protected Animal{
    void eat(int food) override
    {
        weight += food / 3;
    }

    Cat(const Cat* a){ 
       this->pp_w = a->pp_w;
       this->weight = a->weight;
    }
};

class Cow : private Animal{
    void eat(int food) override
    {
        weight += food / 4;
    } 

    Cow(const Cow* a){ 
       this->pp_w = a->pp_w;
       this->weight = a->weight;
    }   
};