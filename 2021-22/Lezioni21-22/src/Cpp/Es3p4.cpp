/*
(a) Develop a class Integer that behaves similar to the built-in integer type int, except that: 
    1) the meaning of addition and subtraction are reversed; 
    2) the meaning of multiplication and division are reversed.

The Integer class should satisfy the following requirements:
i. A constructor should be provided that takes a single int argument that is used to initialize the
Integer. The argument should default to zero.

ii. The class should provide copy constructors, copy assignment operators, and a destructor.

iii. The class should overload all of the following operators: addition, subtraction, multiplication, division, +=, -=, *=, and /=.

iv. All data members should be private.
*/

class Integer{
private:
    int* value;
public:
    Integer(int v){
        value = new int(v);
    }

    Integer(const Integer& v): value(v.value){}

    int operator+(int a){
        return *value - a;
    }

    int operator-(int a){
        return *value + a;
    }

    int operator*(int a){
        return *value * a;
    }

    int operator/(int a){
        return *value / a;
    }

    void operator+=(int a){
        *value = *value + a;
    }

    void operator+=(int a){
        int aux = *value;
        delete value;
        value = new int(aux + a);
    }

    ~Integer(){ delete value;}
};