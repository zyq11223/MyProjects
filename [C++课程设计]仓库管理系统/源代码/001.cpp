#include<iostream>
#include<fstream>
#include<windows.h>
#include<string>
#include"001.h"

using namespace std;


extern int sum_number,find_number;
extern int number[100];
extern int save_number;
extern int noo;
extern void gotoxy(int ,int );


int Goods::get_no()
{
    return no;
}
float Goods::get_weight()
{
    return weight;
}
float Goods::get_price()
{
    return price;
}
int Goods::get_num()
{
    return num;
}
int Goods::get_time()
{
    return time;
}

void Goods::input()
{
    int no_1;
	int flag_1=0;
	int time_0;
    system("CLS");

for(;;)
{system("CLS");
cout<<"请输入货物信息："<<endl;
    cout<<"1.编    号：";
    for(;;)
    {

        cin>>no_1;

         if(cin.fail()){
                cout<<endl<<"输入错误！只允许输入数字！"<<endl;
                system("pause");
                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
                 gotoxy(0,2);cout<<"                                                                        ";
    gotoxy(0,3);cout<<"                                                                        ";
     gotoxy(0,4);cout<<"                                                                        ";
      gotoxy(0,5);cout<<"                                                                        ";
    gotoxy(12,1);cout<<"                                  ";
gotoxy(12,1);
         }
         else break;
    }






	for(int i=0;i<find_number;i++)

		{

		    if(number[i]==no_1)
                {cout<<"该设备编号已被占用，请重新输入!"<<endl;system("pause");flag_1=1;break;}
                else flag_1=0;
        }


	 if(flag_1==0)break;
}


	no=no_1;
	number[noo++]=no_1;





    cout<<endl;
    cout<<"2.名    称：";
    cin>>name;
    cout<<endl;
    cout<<"3.重    量：";

    for(;;)
    {
 cin>>weight;


         if(cin.fail()){
                cout<<endl<<"输入错误！只允许输入数字！"<<endl;
                system("pause");
                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
                 gotoxy(0,2);cout<<"                                                                        ";
    gotoxy(0,6);cout<<"                                                                        ";
     gotoxy(0,7);cout<<"                                                                        ";
      gotoxy(0,8);cout<<"                                                                        ";
    gotoxy(12,5);cout<<"                                  ";
gotoxy(12,5);
         }
         else break;
    }

    cout<<endl;
    cout<<"4.价    格：";

    for(;;)
    {
cin>>price;


         if(cin.fail()){
                cout<<endl<<"输入错误！只允许输入数字！"<<endl;
                system("pause");
                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
                 gotoxy(0,2);cout<<"                                                                        ";
    gotoxy(0,8);cout<<"                                                                        ";
     gotoxy(0,9);cout<<"                                                                        ";
      gotoxy(0,10);cout<<"                                                                        ";
    gotoxy(12,7);cout<<"                                  ";
gotoxy(12,7);
         }
         else break;
    }

    cout<<endl;
    cout<<"5.数    量：";
    for(;;)
    {

        cin>>num;

         if(cin.fail()){
                cout<<endl<<"输入错误！只允许输入数字！"<<endl;
                system("pause");
                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
                 gotoxy(0,2);cout<<"                                                                        ";
    gotoxy(0,10);cout<<"                                                                        ";
     gotoxy(0,11);cout<<"                                                                        ";
      gotoxy(0,12);cout<<"                                                                        ";
    gotoxy(12,9);cout<<"                                  ";
gotoxy(12,9);
         }
         else break;
    }

    cout<<endl;
    cout<<"6.入库时间: ";
   int yyy=0;
    for(;;)
    {







        cin>>time_0;

         if(cin.fail()){
                cout<<endl<<"输入错误！只允许输入数字！"<<endl;
                system("pause");
                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
                 gotoxy(0,2);cout<<"                                                                        ";
            gotoxy(0,13);cout<<"                                                                        ";
            gotoxy(0,14);cout<<"                                                                        ";
            gotoxy(0,15);cout<<"                                                                        ";
            gotoxy(12,11);cout<<"                                  ";
            gotoxy(12,11);
            yyy=0;
         }
         else yyy=1;

if(yyy==1){
    if(time_0<10000000||time_0>20160701){
            cout<<endl<<"输入的日期不符合规则，请重新输入!       "<<endl;system("pause");
    gotoxy(0,13);cout<<"                                                                        ";
    gotoxy(0,14);cout<<"                                                                        ";
     gotoxy(0,15);cout<<"                                                                        ";
      gotoxy(0,16);cout<<"                                                                        ";
    gotoxy(12,11);cout<<"                                  ";
gotoxy(12,11);

}
    else break;
    }

    }
    time=time_0;
    system("pause");

    system("CLS");
    cout<<endl;
    cout<<endl;
    cout<<endl;
    cout<<endl;
    cout<<endl;
    cout<<"                您 已 成 功 添 加 一 条 信 息 ！"<<endl;



    cout<<endl<<endl;
	cout<<endl<<endl;
	cout<<endl<<endl;
	cout<<endl<<endl;

system("pause");
}


ostream& operator<<(ostream &output,Goods &g)
{
    output<<"货物信息如下："<<endl<<"编    号: "<<g.no<<endl<<"名    称: "<<g.name<<endl<<"重    量: "<<g.weight<<endl<<"价    格: "<<g.price<<endl<<"数    量: "<<g.num<<endl<<"入库时间: "<<g.time<<endl;
    return output;
}


int Goods::check0()
{
    if(time<20150401) return 1;
    else return 0;

}


int Goods::rec(int t)
{
    if(t==no)return 1;
    else return 0;
}


void Goods::find1(int i)
{


        if(i==no)cout<<*this<<endl<<endl;




}
void Goods::find2(string i)
{


        if(i==name)cout<<*this<<endl<<endl;



}
int Goods::find10(int i)
{


        if(i==no)return 1;
        else return 0;



}
int Goods::find20(string i)
{


        if(i==name)return 1;
        else return 0;


}
void Goods::modify(int n)
{
    int m,no_1,flag_1=0;
	system("CLS");
    cout<<"你想以什么方式修改？"<<endl<<endl;
    cout<<"1.修改货物编号"<<endl;
	cout<<"2.修改货物名称"<<endl;
	cout<<"3.修改货物重量"<<endl;
	cout<<"4.修改货物价格"<<endl;
	cout<<"5.修改货物数量"<<endl;
	cout<<"6.修改货物入库时间"<<endl;

	cout<<endl<<endl;
    cout<<"请输入1-6选择不同功能：";


cin>>m;


         if(cin.fail()){
                cout<<endl<<"输入错误！本次修改无效！！"<<endl;

                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区

         }


	cout<<endl<<endl<<endl<<endl;
	switch(m)
	{
		 case 1: {
        for(;;)
            {
                system("CLS");
                cout<<"原设备编号："<<no<<endl;
			     cout<<"请输入新设备编号：";

                                      for(;;)
    {

         cin>>no_1;

         if(cin.fail()){
                cout<<endl<<"输入错误！只允许输入数字！"<<endl;
                system("pause");
                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
                 gotoxy(0,2);cout<<"                                                                        ";
    gotoxy(0,2);cout<<"                                                                        ";
     gotoxy(0,3);cout<<"                                                                        ";
      gotoxy(0,4);cout<<"                                                                        ";
    gotoxy(18,1);cout<<"                                  ";
gotoxy(18,1);
         }
         else break;
    }
                for(int i=0;i<find_number;i++)

                    {

                         if(number[i]==no_1)
                            {cout<<"该设备编号已被占用，请重新输入!"<<endl;system("pause");flag_1=1;break;}
                            else flag_1=0;
                    }


	 if(flag_1==0)break;
}


					               no=no_1;
	                               number[n]=no;break;







					               }


                case 2:{
                    system("CLS");
                    cout<<"原设备名称："<<name<<endl;
                    cout<<"请输入新设备名称：";
                    cin>>name;
                    break;
                    }
                    case 3:
                        {system("CLS");
                        cout<<"原设备重量："<<weight<<endl;
                        cout<<"请输入新设备重量：";
                                          for(;;)
    {

        cin>>weight;

         if(cin.fail()){
                cout<<endl<<"输入错误！只允许输入数字！"<<endl;
                system("pause");
                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
                 gotoxy(0,2);cout<<"                                                                        ";
    gotoxy(0,2);cout<<"                                                                        ";
     gotoxy(0,3);cout<<"                                                                        ";
      gotoxy(0,4);cout<<"                                                                        ";
    gotoxy(18,1);cout<<"                                  ";
gotoxy(18,1);
         }
         else break;
    }
                        break;}

                            case 4:
                                {system("CLS");
                                cout<<"原设备价格："<<price<<endl;
                                cout<<"请输入新设备价格：";
                                                  for(;;)
    {

        cin>>price;

         if(cin.fail()){
                cout<<endl<<"输入错误！只允许输入数字！"<<endl;
                system("pause");
                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
                 gotoxy(0,2);cout<<"                                                                        ";
    gotoxy(0,2);cout<<"                                                                        ";
     gotoxy(0,3);cout<<"                                                                        ";
      gotoxy(0,4);cout<<"                                                                        ";
    gotoxy(18,1);cout<<"                                  ";
gotoxy(18,1);
         }
         else break;
    }
                                break;}
                                case 5:
                                    {system("CLS");
                                    cout<<"原设备数量："<<num<<endl;
                                    cout<<"请输入新设备数量：";
                                                      for(;;)
    {

        cin>>num;

         if(cin.fail()){
                cout<<endl<<"输入错误！只允许输入数字！"<<endl;
                system("pause");
                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
                 gotoxy(0,2);cout<<"                                                                        ";
    gotoxy(0,2);cout<<"                                                                        ";
     gotoxy(0,3);cout<<"                                                                        ";
      gotoxy(0,4);cout<<"                                                                        ";
    gotoxy(18,1);cout<<"                                  ";
gotoxy(18,1);
         }
         else break;
    }
                                    break;}
                                    case 6:
                                        {int time_0,yyy=0;
                                        system("CLS");cout<<"原设备入库时间："<<time<<endl;cout<<"请输入新设备入库时间：";

                                    for(;;)
                                    {







        cin>>time_0;

         if(cin.fail()){
                cout<<endl<<"输入错误！只允许输入数字！"<<endl;
                system("pause");
                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
                 gotoxy(0,2);cout<<"                                                                        ";
    gotoxy(0,3);cout<<"                                                                        ";
     gotoxy(0,4);cout<<"                                                                        ";
      gotoxy(0,5);cout<<"                                                                        ";
    gotoxy(22,1);cout<<"                                  ";
gotoxy(22,1);
yyy=0;
         }
         else yyy=1;
         if(yyy==1)
         {



                                if(time_0<100000||time_0>20160701){cout<<endl<<"修改的日期不符合规则，请重新输入:"<<endl;;
                                system("pause");

    gotoxy(0,3);cout<<"                                                                        ";
    gotoxy(0,4);cout<<"                                                                        ";
    gotoxy(0,5);cout<<"                                                                        ";
    gotoxy(0,6);cout<<"                                                                        ";
    gotoxy(0,7);cout<<"                                                                        ";
    gotoxy(22,1);cout<<"                                  ";
    gotoxy(22,1);
   }
                                    else break;
         }
                                            }
                                    time=time_0;
                                    break;
                                    }




    }


    cout<<endl<<endl<<endl<<endl;
    //cout<<"      修 改 成 功！";
    cout<<endl<<endl<<endl<<endl;
    cout<<endl<<endl<<endl<<endl;



}



void Goods::writeTo(ofstream &outfile)
{

    outfile<<no<<endl;
    outfile<<name<<endl;
    outfile<<weight<<endl;
    outfile<<price<<endl;
    outfile<<num<<endl;
    outfile<<time<<endl;





}

void Goods::readFrom(ifstream &infile)
{

    infile>>no;
    infile>>name;
    infile>>weight;
    infile>>price;
    infile>>num;
    infile>>time;
   save_number++;

number[noo++]=no;



   // infile.close();


}

float Goods::count_num()
{
    return num;


}
float Goods::count_price()
{
    return price;


}

void Goods::show()
{
    cout.setf(ios::left);
    cout.width(10);
    cout<<no;
    cout.width(10);
    cout<<name;
    cout.width(10);
    cout<<weight;
    cout.width(10);
    cout<<price;
    cout.width(10);
    cout<<num;
    cout.width(20);
    cout<<time;
    cout<<endl;

}
