#include<vector>

template<typename Input, typename Output>
class command{
    virtual Output execute(Input i) = 0;
};

template<typename comms>
class receiver{
private:
std::vector<comms> commands;
public:
    void get_commands(comms c) const
    {
        commands.push_back(c);
    };

    void action(int i){
        commands.at(i).execute();
    }
};