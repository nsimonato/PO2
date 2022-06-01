namespace zoo
{
    class animal
    {
    protected:
    int weight_;
    public:
        explicit animal(int w) : weight_(w){}

        animal(const animal& a) : weight_(a.weight_) {}

        virtual void eat(const animal& a) //Virtual definisce che il metodo può subire overriding, di default non è possibile.
        {
            weight_ += a.weight_;
        }

        const int& weight() const { return weight_; } //A
        int& weight() { return weight_; } //B
    };

    class dog : public animal //public su animal rende la subsumption pubblica, ovvero in qualunque scope si può effettuare la subsumption
    {
        public:
            explicit dog(int w) : animal(w) {}

            void eat(const animal* a) //override è una keyword, significa che si sta effettuando un override
            {
                this->weight() = a->weight() * 2; //il primo weight è B, il secondo è A, della superclasse animal
                //weight_ += a->weight_; //Questo non compila, in quanto weight_ è protected
                /*
                * protected significa che TODO: definire protected
                */
            }
    };
};