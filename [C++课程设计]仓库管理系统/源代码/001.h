#include<iostream>
#include<fstream>
#include<windows.h>
#include<string>

//
using namespace std;




class Goods
{
public:
    void input();


    void find1(int);
    void find2(string);
	int find10(int);
    int find20(string);
    void modify(int);
    void writeTo(ofstream&);
    void readFrom(ifstream&);
    int check0();
    float count_num();
    float count_price();
    int rec(int);
    void show();
    int get_no();
    float get_weight();
    float get_price();
    int get_num();
    int get_time();

    friend ostream& operator<<(ostream&,Goods&);
    friend void display1(Goods g[]);




protected:
    string name;
    int no;
    float weight;
    float price;
    int num;
    int time;
};










