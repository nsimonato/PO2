#include <iostream>
#include <vector>

using namespace std;

template<typename T>
class vett{
protected:
    vector<T> members;
    int length;
public:
    iterator<std::output_iterator_tag, std::ptrdiff_t, T, T*, T&> begin(vector<T>);

    vett(const T& t)
    {
        members = t->members;
        length = t->lenght;
        begin = &(members[0]);
    }

    void add_member(const T e)
    {
        members.push_back(e);
    }

    const T get_length() const
    {
        return length;
    }

    void operator[] (const int a) const
    {
        if(a < length && a >= 0)
        {
            return members[a];
        }
    }

    T operator*(const vett b) const
    {
        T result;
        if(length == b.get_length())
        {
            
            iterator it1_end = members.end;
            iterator it2_b = b.begin;

            for(iterator it1_b = members.begin; it1_b != it_1.end; ++it1_b)
            {
                result += *it_1b * *it2_b;
                ++it2_b;
            }
            return result;
        }
        else{
            throw new exception("Incompatible arrays");
        }
        
    }

};