using namespace std;

#include <iostream>

/*
Develop a template function min3 that takes three arguments of the same type and returns the least of these
arguments. 
*/

template <typename T>
T min3(T a, T b, T c)
{
    if(a < b && a < c)
        return a;
    else if (b < a && b < c)
        return b;
    else
        return c;
}

/*
(a) Develop a template function sum that computes the sum of zero or more elements (of the same type) that
are stored contiguously in memory. The template should have a single parameter that is the type of the
elements to be processed by the function. The function has two parameters: 1) a pointer to the first element
in the range to be summed; and 2) a pointer to one-past-the-last element in the range to be summed.
(b) Write a program to test the sum function.
*/

template <typename T>
T sum(T* begin, T* end){
    T result = (begin < end) ? *begin : nullptr;
    ++begin;
    while(begin < end)
    {
        result += *begin;
        ++begin;
    }

    return result;
}

void test(){
    int a[] = {1,2,3,4};
    double b[] = {0.,2.,1.,3.};

    cout << sum(a, a + 4);
    cout << sum(b, b + 4);
}