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
cout<<"�����������Ϣ��"<<endl;
    cout<<"1.��    �ţ�";
    for(;;)
    {

        cin>>no_1;

         if(cin.fail()){
                cout<<endl<<"�������ֻ�����������֣�"<<endl;
                system("pause");
                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
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
                {cout<<"���豸����ѱ�ռ�ã�����������!"<<endl;system("pause");flag_1=1;break;}
                else flag_1=0;
        }


	 if(flag_1==0)break;
}


	no=no_1;
	number[noo++]=no_1;





    cout<<endl;
    cout<<"2.��    �ƣ�";
    cin>>name;
    cout<<endl;
    cout<<"3.��    ����";

    for(;;)
    {
 cin>>weight;


         if(cin.fail()){
                cout<<endl<<"�������ֻ�����������֣�"<<endl;
                system("pause");
                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
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
    cout<<"4.��    ��";

    for(;;)
    {
cin>>price;


         if(cin.fail()){
                cout<<endl<<"�������ֻ�����������֣�"<<endl;
                system("pause");
                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
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
    cout<<"5.��    ����";
    for(;;)
    {

        cin>>num;

         if(cin.fail()){
                cout<<endl<<"�������ֻ�����������֣�"<<endl;
                system("pause");
                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
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
    cout<<"6.���ʱ��: ";
   int yyy=0;
    for(;;)
    {







        cin>>time_0;

         if(cin.fail()){
                cout<<endl<<"�������ֻ�����������֣�"<<endl;
                system("pause");
                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
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
            cout<<endl<<"��������ڲ����Ϲ�������������!       "<<endl;system("pause");
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
    cout<<"                �� �� �� �� �� �� һ �� �� Ϣ ��"<<endl;



    cout<<endl<<endl;
	cout<<endl<<endl;
	cout<<endl<<endl;
	cout<<endl<<endl;

system("pause");
}


ostream& operator<<(ostream &output,Goods &g)
{
    output<<"������Ϣ���£�"<<endl<<"��    ��: "<<g.no<<endl<<"��    ��: "<<g.name<<endl<<"��    ��: "<<g.weight<<endl<<"��    ��: "<<g.price<<endl<<"��    ��: "<<g.num<<endl<<"���ʱ��: "<<g.time<<endl;
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
    cout<<"������ʲô��ʽ�޸ģ�"<<endl<<endl;
    cout<<"1.�޸Ļ�����"<<endl;
	cout<<"2.�޸Ļ�������"<<endl;
	cout<<"3.�޸Ļ�������"<<endl;
	cout<<"4.�޸Ļ���۸�"<<endl;
	cout<<"5.�޸Ļ�������"<<endl;
	cout<<"6.�޸Ļ������ʱ��"<<endl;

	cout<<endl<<endl;
    cout<<"������1-6ѡ��ͬ���ܣ�";


cin>>m;


         if(cin.fail()){
                cout<<endl<<"������󣡱����޸���Ч����"<<endl;

                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������

         }


	cout<<endl<<endl<<endl<<endl;
	switch(m)
	{
		 case 1: {
        for(;;)
            {
                system("CLS");
                cout<<"ԭ�豸��ţ�"<<no<<endl;
			     cout<<"���������豸��ţ�";

                                      for(;;)
    {

         cin>>no_1;

         if(cin.fail()){
                cout<<endl<<"�������ֻ�����������֣�"<<endl;
                system("pause");
                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
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
                            {cout<<"���豸����ѱ�ռ�ã�����������!"<<endl;system("pause");flag_1=1;break;}
                            else flag_1=0;
                    }


	 if(flag_1==0)break;
}


					               no=no_1;
	                               number[n]=no;break;







					               }


                case 2:{
                    system("CLS");
                    cout<<"ԭ�豸���ƣ�"<<name<<endl;
                    cout<<"���������豸���ƣ�";
                    cin>>name;
                    break;
                    }
                    case 3:
                        {system("CLS");
                        cout<<"ԭ�豸������"<<weight<<endl;
                        cout<<"���������豸������";
                                          for(;;)
    {

        cin>>weight;

         if(cin.fail()){
                cout<<endl<<"�������ֻ�����������֣�"<<endl;
                system("pause");
                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
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
                                cout<<"ԭ�豸�۸�"<<price<<endl;
                                cout<<"���������豸�۸�";
                                                  for(;;)
    {

        cin>>price;

         if(cin.fail()){
                cout<<endl<<"�������ֻ�����������֣�"<<endl;
                system("pause");
                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
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
                                    cout<<"ԭ�豸������"<<num<<endl;
                                    cout<<"���������豸������";
                                                      for(;;)
    {

        cin>>num;

         if(cin.fail()){
                cout<<endl<<"�������ֻ�����������֣�"<<endl;
                system("pause");
                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
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
                                        system("CLS");cout<<"ԭ�豸���ʱ�䣺"<<time<<endl;cout<<"���������豸���ʱ�䣺";

                                    for(;;)
                                    {







        cin>>time_0;

         if(cin.fail()){
                cout<<endl<<"�������ֻ�����������֣�"<<endl;
                system("pause");
                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
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



                                if(time_0<100000||time_0>20160701){cout<<endl<<"�޸ĵ����ڲ����Ϲ�������������:"<<endl;;
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
    //cout<<"      �� �� �� ����";
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
