class int_pair
{
private:
    int first, second;
public:
    int_pair(const int& a,const int& b)
    {
        first = a
        second = b
    } //Vengono inizializzati first e second, tramite invocazione del costruttore vuoto, poi viene copiato al suo interno il valore.

    int_pair(const int& a,const int& b) : first(a), second(b)
    {
    } //Vengono inizializzati first e second, invocando direttamente i loro costruttori con un parametro solo.
}

template <typename A, typename B> //dichiarazione dei generics
class pair
{
private:
    A first;
    B second;
public:
    pair(const A& a,const int& b) : first(a), second(b)
    {}

    pair(const pair<A,B>& p) : first(p.first), second(p.second)
	{}
    
	template <typename C, typename D>
    pair(const pair<C,D>& p) : first(p.first), second(p.second)
	{}
	
	A get_first() const //const è riferito a "this"
	{
		return first;
	}
	
	const A& get_first() const //in questo caso viene ritornato un valore immutabile, un pointer ad un valore A
	{
		return first;
	} //Equivalente ad un binding
}