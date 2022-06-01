#include<vector>
#include<string>
#include<iostream>

int main(int argc, char** args)
{
    std::vector<int> a = {100,300,5,4,6,33,564,5,234,53};
    int sum = 0;

    for(std::vector<int>::iterator b = a.begin(); b < a.end(); ++b)
        sum += *b;
        
    std::cout << sum << '\n';
}