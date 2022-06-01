#include <iostream>

using namespace std;

class person{
protected:
    int eta;
public:
    person(int eta) //Parametric constructor
    {
        this->eta = eta;
    }

    /*person(const int &eta) //Copy constructor
    {
        this->eta = eta;
    }*/

    const int get_eta() const
    {
        return eta;
    }

    virtual int mult_eta() const
    {
        return 2 * eta;
    }
};

class student : public person{
private:
    int matricola;
public:
    student(int eta, int matricola) : person(eta) //: person(eta) invoca il costruttore della superclasse
    {
        this-> matricola = matricola;
    }

    const int get_eta() 
    {
        return person::get_eta();
    }

    int mult_eta() const override //override con dynamic dispatching
    {
        return 3*eta;
    }
};
