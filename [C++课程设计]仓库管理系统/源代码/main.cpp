#include<iostream>
#include<fstream>
#include<windows.h>
#include<string>
#include<stdio.h>
#include"001.h"
#include<conio.h>



using namespace std;

int sum_number=0,find_number=0;
int save_number=0;
int number[100]={0};
int number0[100]={0};
int noo=0;
int noo1=0;
int noo0=0;
int save=0;
int save_to=0;
int file_number=0;


void gotoxy(int x,int y)  //�����ҵ�goto��������
{
    CONSOLE_SCREEN_BUFFER_INFO    csbiInfo;
    HANDLE    hConsoleOut;
    hConsoleOut = GetStdHandle(STD_OUTPUT_HANDLE);
    GetConsoleScreenBufferInfo(hConsoleOut,&csbiInfo);
    csbiInfo.dwCursorPosition.X = x;
    csbiInfo.dwCursorPosition.Y = y;
    SetConsoleCursorPosition(hConsoleOut,csbiInfo.dwCursorPosition);
}
void skip()
{
    ifstream infile("file.txt",ios::in);
    int ppp[100]={0};
    string ppp2;
    float ppp3;
    for(int i=0;i<100;i++)
    {
        if(i%6==0)infile>>ppp[i];

        else {ppp[i]=1;infile>>ppp2;}



    }
    for(int i=0;i<100;i++)
    {
        if(ppp[i]==0)break;

        else if(i%6==0)noo1++;



    }

 //cout<<noo1;
       // system("pause");


}


void Find( Goods g[])
{
    int sum_c,sum_cc=0,sum_cc2=0;
    string sum_c2;
    int flag2;

       for(;;)
    {

   system("CLS");
    cout<<endl<<endl<<endl;
    cout<<"                ���밴��ʲô��ʽ���ң�"<<endl<<endl<<endl<<endl;
    cout<<"                1.���ջ����Ų�ѯ��"<<endl<<endl;
    cout<<"                2.���ջ������Ʋ�ѯ��"<<endl<<endl<<endl<<endl;
    cout<<"                ������1-2ѡ��ͬ���ܣ�";
    cin>>flag2;


         if(cin.fail()){
                cout<<endl<<"����������������룡"<<endl;

                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
    system("pause");
         }
         else break;
    }
    if(flag2==1)
    {



                      system("CLS");
                      cout<<"����������ţ�";
                      cin>>sum_c;





                      for(int i=0;i<find_number;i++)
                     if(g[i].find10(sum_c)==1)sum_cc++;

					  if(sum_cc==0){cout<<"δ��ѯ���κ���Ϣ��"<<endl<<endl<<endl<<endl<<endl<<endl<<endl;system("pause");}

                     else
                     {
						 cout<<endl<<endl;
                     cout<<"�ܹ����ҵ�"<<sum_cc<<"����Ϣ��";

					 cout<<endl<<endl;

                     for(int j=0;j<find_number;j++)

						g[j].find1(sum_c);

					 cout<<endl<<endl;
                     system("pause");
                     }




                }
        else if(flag2==2)
        {

                system("CLS");
                      cout<<"������������ƣ�";
                      cin>>sum_c2;





                      for(int j=0;j<find_number;j++)
                     if(g[j].find20(sum_c2)==1)sum_cc2++;

					  if(sum_cc2==0){cout<<"δ��ѯ���κ���Ϣ��"<<endl<<endl<<endl<<endl<<endl<<endl<<endl;system("pause");}

                     else
                     {
						 cout<<endl<<endl;
                     cout<<"�ܹ����ҵ�"<<sum_cc2<<"����Ϣ��";

					 cout<<endl<<endl;

                     for(int j=0;j<find_number;j++)
                     g[j].find2(sum_c2);
					  cout<<endl<<endl;
                     system("pause");

                     }


                            }
    else {cout<<"�������";cout<<endl<<endl;system("pause");}

}


void Modify( Goods g[])
{

    int n;
    string charge;
    int sum_c,sum_cc=0,sum_cc2=0;


        for(;;)
    {
        system("CLS");
    cout<<endl<<endl<<endl;
    cout<<"����������ţ�";
cin>>sum_c;


         if(cin.fail()){
                cout<<endl<<"����������������룡"<<endl;

                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
    system("pause");
         }
         else break;
    }
    cout<<endl<<endl;
     for(int j=0;j<find_number;j++)
                     if(g[j].find10(sum_c)==1)sum_cc++;

                     if(sum_cc==0)
					 {  cout<<"�û��ﲻ���ڣ�"<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;system("pause");}

                     else
                     {

    cout<<"���ҵ��Ļ�����Ϣ���£�";

                     cout<<endl<<endl;


                     for(int k=0;k<find_number;k++)
                     {
						 if(g[k].find10(sum_c)==1)
						 {
						     g[k].find1(sum_c);
                             n=k;
                             break;
						 }


					 }
					 cout<<endl<<endl;

    cout<<"���ȷ��Ҫ�޸������� Y�����򽫷��� :";
    cin>>charge;
    if(charge=="Y"||charge=="y")
    {
		cout<<endl<<endl;
        for(;;)
        {     system("CLS");
			g[n].modify(n);
            cout<<"���Ҫ�ص����˵������� Y�����򽫼����޸�:";
        cin>>charge;
        if(charge=="Y"||charge=="y"){system("CLS");cout<<endl<<endl<<endl<<"           �޸ĳɹ���"<<endl<<endl<<endl;system("pause");break;}
        }


    }







                     }



}


void Save(Goods g[])
{
     system("CLS");
    ofstream outfile("file.txt");

    if(!outfile)
{
    cerr<<"���ļ�ʧ�ܣ�"<<endl;
    exit(1);
}

    for(int i=0;i<find_number;i++)
    {


        g[i].writeTo(outfile);
    }
    outfile.close();
    cout<<"                      �ļ�������ϣ�"<<endl<<endl<<endl<<endl;
    system("pause");

}

void Read(Goods g[])
{

string charge;




     system("CLS");
    ifstream infile("file.txt",ios::in);

    if(!infile)
{
    cerr<<"û���κμ�¼��"<<endl;

}



else{

        cout<<"��ȷ��Ҫ��ȡ�ļ���Ϣ����Ḳ����������Ϣ��"<<endl<<endl;;
cout<<"ȷ�϶�ȡ������ Y�����򽫷��أ�";
cin>>charge;
if(charge=="Y"||charge=="y")

{

system("CLS");

noo=0;
for(int i=0;i<100;i++)
number[i]=0;
    for(int i=0;i<noo1;i++)
    {
        //infile>>g[i+sum_number];
        //save_number++;

       g[i].readFrom(infile);



    }

    sum_number=save_number;
    find_number=sum_number;
    infile.close();
    cout<<"                   �ļ���ȡ�ɹ���"<<endl<<endl<<endl<<endl;
    system("pause");
    save_number=0;
}
}
}
void Del(Goods g[],Goods s[])
{
    int flag=0;

    string charge;
    int d,search_number;




    system("CLS");
    cout<<"��ȷ����Ҫɾ���Ļ����ţ�";
    cin>>d;
    for(int i=0;i<sum_number;i++)
    {
        if(d==g[i].get_no()){search_number=i;flag=1;break;}
    }
    if(flag==0){cout<<endl<<endl<<"������Ļ����Ų����ڣ�"<<endl<<endl<<endl;system("pause");}
    else if(flag==1)
    {



    cout<<"��Ҫɾ������Ϣ���£�"<<endl<<endl;
    cout<<g[search_number]<<endl<<endl;
    cout<<"ȷ��Ҫɾ��������Y�����򽫷��أ�";
    cin>>charge;
    if(charge=="Y"||charge=="y")
    {
        s[save++]=g[search_number];
        number0[noo0++]=number[search_number];
        save_to++;


        for(int i=search_number;i<find_number-1;i++)
    {
        g[i]=g[i+1];

    }
    for(int i=search_number;i<find_number-1;i++)
    {
        number[i]=number[i+1];

    }
    noo--;
        sum_number--;
        find_number=sum_number;


    system("CLS");
    cout<<"        �� Ϣ ɾ �� �� �� ��"<<endl<<endl<<endl<<endl;
    system("pause");
}
}
}

void Recover(Goods g[],Goods s[])
{
     system("CLS");
    string charge;
int flag=0;
    int mmm,i,k;
int flag_1=0;

    if(save_to==0){cout<<"���û��ɾ������Ϣ��"<<endl<<endl<<endl;system("pause");}
    else{
    cout<<"�����������ɾ������Ϣ��"<<endl<<endl;
     for(int i=0;i<save_to;i++)
        cout<<s[i]<<endl<<endl;

     cout<<"������Ҫ�ָ��Ļ���ı�ţ�";
     cin>>mmm;


 for(i=0;i<save_to;i++)
            {if(s[i].rec(mmm)==1){flag=1;break;}}

           if(flag==0) {cout<<endl<<endl<<"������Ļ����Ų����ڣ�"<<endl<<endl<<endl;system("pause");}
       else{
             for(k=0;k<find_number;k++)

		{

		    if(number[k]==mmm)
                {cout<<endl<<endl<<"���豸����Ѵ��ڣ��ָ�����Ϣ������������Ϣ!"<<endl;flag_1=1;break;}
                else flag_1=0;
        }

    cout<<endl<<endl<<"ȷ��Ҫ�ָ�������Y,���򽫷��أ�";
    cin>>charge;
    if(charge=="Y"||charge=="y")
    {




            system("CLS");
    cout<<"        �� Ϣ �� �� �� �� ��"<<endl<<endl<<endl<<endl;
    system("pause");
if(flag_1==0)
{
   g[sum_number++]=s[i];
    number[noo++]=number0[i];
    find_number=sum_number;
    save_to--;
}

else if(flag_1==1)
{
    g[k]=s[i];
    save_to--;
}

    for(int j=i;j<save;j++)
       {
           s[j]=s[j+1];number0[j]=number0[j+1];
       }




    }

}
}
}

void display1(Goods g[])
{
    system("CLS");
    int j=0;

    float sum_money[100];
	int sum_num[100];
    string sum_name[100];

    for(int k=0;k<find_number;k++)
    {
        int flag=0;
        if(k==0){sum_name[j]=g[k].name;sum_num[j]=g[k].num;sum_money[j]=g[k].price;j++;continue;}
        for(int i=0;i<k;i++)//�ж������Ƿ��ظ�
        {

                    if(g[k].name==sum_name[i])//�����ظ�
                {
                    sum_num[i]+=g[k].num;
                    sum_money[i]+=g[k].price;
                    flag=1;
                    break;

                }
                else flag=0;


        }

       if(flag==0)
                    {
                        sum_name[j]=g[k].name;
                         sum_num[j]=g[k].num;
                          sum_money[j]=g[k].price;
                          j++;

                    }


    }
    cout<<"\t\t\tͳ�ƽ�����£�"<<endl<<endl<<endl;
    for(int k=0;k<j;k++)
    {cout.setf(ios::left);

   cout<<"  ";
    cout.width(20);
    cout<<sum_name[k];



    cout<<"������: ";
    cout.width(16);
    cout<<sum_num[k];

    cout<<"�ܽ��: ";
    cout.width(16);
    cout<<sum_money[k];
    cout<<endl<<endl;


    }
    cout<<endl<<endl<<endl;
    system("pause");





}

void display2(Goods g[])
{
    system("CLS");
    float goods_number1=0,goods_money1=0;
    float goods_number2=0,goods_money2=0;
    for(int i=0;i<find_number;i++)
    {
        if(g[i].check0()==1){goods_number1+=g[i].count_num();goods_money1+=g[i].count_price();}
            else if(g[i].check0()==0){goods_number2+=g[i].count_num();goods_money2+=g[i].count_price();}
    }

    cout<<"ͳ�ƽ�����£�"<<endl<<endl;
    cout<<"2015��4�·�ǰ���Ļ�������Ϊ��"<<goods_number1<<endl<<"2015��4�·�ǰ���Ļ�����Ϊ��"<<goods_money1<<endl<<endl<<endl;
    cout<<"2015��4�·ݺ����Ļ�������Ϊ��"<<goods_number2<<endl<<"2015��4�·ݺ����Ļ�����Ϊ��"<<goods_money2<<endl<<endl<<endl;
cout<<endl<<endl<<endl<<endl;
system("pause");
}
void display3(Goods g[])
{
system("CLS");
   cout<<"��������������������������������������������������������������������������������"<<endl;


    cout.setf(ios::left);
cout<<"  ";
    cout.width(5);
    cout<<"   ";

    cout.width(10);
    cout<<"��  ��";
    cout.width(10);
    cout<<"��  ��";
    cout.width(10);
    cout<<"��  ��";
    cout.width(10);
    cout<<"��  ��";
    cout.width(10);
    cout<<"��  ��";
    cout.width(20);
    cout<<"���ʱ��";
    cout<<endl;
    for(int i=0;i<find_number;i++)
    {
         cout<<"��������������������������������������������������������������������������������"<<endl;


    cout<<"  ";
    cout.width(5);
    cout<<i+1;
        g[i].show();
    }
      cout<<"��������������������������������������������������������������������������������"<<endl;

    system("pause");
}

void ranks(Goods g[])
{
    Goods r[100];
int flag;
    Goods r0;
    system("CLS");
    cout<<endl<<endl<<endl;
    cout<<"\t\t    ��ϣ����������"<<endl<<endl;
    cout<<"\t\t  1.��������򣨴�С����"<<endl<<endl;
    cout<<"\t\t  2.���������򣨴��ᵽ�أ�"<<endl<<endl;
    cout<<"\t\t  3.���۸����򣨴Ӽ�����"<<endl<<endl;
    cout<<"\t\t  4.����Ŀ���򣨴��ٵ��ࣩ"<<endl<<endl;
    cout<<"\t\t  5.�����ʱ�����򣨴�ǰ����"<<endl<<endl<<endl<<endl;
    cout<<"\t\t    ����1-5ѡ��ͬ���ܣ�";
    cin>>flag;
    switch(flag)
    {
        case 1:{
    for(int i=0;i<100;i++)
    {
        r[i]=g[i];
    }
   // display3(r);
     system("CLS");
    int k,j;

    for(k=0;k<find_number;k++)
        for(j=0;j<find_number-k-1;j++)
        if(r[j].get_no()>r[j+1].get_no()){r0=r[j];r[j]=r[j+1];r[j+1]=r0;}


    display3(r);
    break;}
        case 2:{
    for(int i=0;i<100;i++)
    {
        r[i]=g[i];
    }
   // display3(r);
     system("CLS");
    int k,j;

    for(k=0;k<find_number;k++)
        for(j=0;j<find_number-k-1;j++)
        if(r[j].get_weight()>r[j+1].get_weight()){r0=r[j];r[j]=r[j+1];r[j+1]=r0;}


    display3(r);
    break;}
        case 3:{
    for(int i=0;i<100;i++)
    {
        r[i]=g[i];
    }
   // display3(r);
     system("CLS");
    int k,j;

    for(k=0;k<find_number;k++)
        for(j=0;j<find_number-k-1;j++)
        if(r[j].get_price()>r[j+1].get_price()){r0=r[j];r[j]=r[j+1];r[j+1]=r0;}


    display3(r);
    break;}
        case 4:{
    for(int i=0;i<100;i++)
    {
        r[i]=g[i];
    }
   // display3(r);
     system("CLS");
    int k,j;

    for(k=0;k<find_number;k++)
        for(j=0;j<find_number-k-1;j++)
        if(r[j].get_num()>r[j+1].get_num()){r0=r[j];r[j]=r[j+1];r[j+1]=r0;}


    display3(r);
    break;}
        case 5:{
    for(int i=0;i<100;i++)
    {
        r[i]=g[i];
    }
   // display3(r);
     system("CLS");
    int k,j;

    for(k=0;k<find_number;k++)
        for(j=0;j<find_number-k-1;j++)
        if(r[j].get_time()>r[j+1].get_time()){r0=r[j];r[j]=r[j+1];r[j+1]=r0;}


    display3(r);
    break;}
        default:cout<<"�������"<<endl<<endl<<endl;system("pause");break;
    }












}


void statistics(Goods g[])
{
    int flag;
 system("CLS");
 cout<<endl<<endl<<endl;
 cout<<"\t\t    ��ϣ������ͳ�ƣ�"<<endl<<endl;
 cout<<"\t\t  1.����������������"<<endl<<endl;
 cout<<"\t\t  2.2015��4��ǰ��������������Ա�"<<endl<<endl;
 cout<<"\t\t  3.ȫ��������Ϣչʾ"<<endl<<endl;
 cout<<"\t\t  4.����"<<endl<<endl<<endl<<endl;

 cout<<"\t\t    ����1-4ѡ��ͬ���ܣ�";
 cin>>flag;

 switch(flag)
 {
     case 1:display1(g);break;
     case 2:display2(g);break;
     case 3:display3(g);break;
     case 4:ranks(g);break;
     default:cout<<"�������"<<endl<<endl<<endl;system("pause");break;
 }

}


void start()
{
    cout<<endl<<endl<<endl;
    cout.flush();Sleep(1000);
    cout<<"\t\t\t��  ";
    cout.flush();Sleep(1000);
    cout<<"��  ";
    cout.flush();Sleep(1000);
    cout<<"��  ";
    cout.flush();Sleep(1000);
    cout<<"��  ";
    cout.flush();Sleep(1000);
    cout<<"ϵ  ";
    cout.flush();Sleep(1000);
    cout<<"ͳ"<<endl<<endl;
    cout.flush();Sleep(1800);

    cout<<endl<<endl<<endl;
    cout<<"\t\t\t==>��";
    cout.flush();Sleep(400);
    cout<<"ϵ";
    cout.flush();Sleep(400);
    cout<<"ͳ";
    cout.flush();Sleep(400);
    cout<<"��";
    cout.flush();Sleep(400);
    cout<<"��";
    cout.flush();Sleep(400);
    cout<<"��";
    cout.flush();Sleep(400);
    cout<<"��";
    cout.flush();Sleep(400);
    cout<<"��";
    cout.flush();Sleep(400);
    cout<<"д";
    cout.flush();Sleep(1000);


    cout<<endl<<endl<<endl;

}

void endof()
{
    system("CLS");

    cout<<endl<<endl<<endl<<endl;
    cout<<"\t\t\t    ��л����ʹ��!";
    cout<<endl<<endl<<endl;
    cout<<"\t\t\t  ���в���֮�����½�";
    cout<<endl<<endl<<endl;
    cout<<"\t\t\t==��ϵͳ���������д==";


    cout<<endl<<endl<<endl;
    cout.flush();Sleep(1000);
}


int choose()
{
    for(;;)
    {
system("CLS");

    int charge;
    cout<<endl<<endl<<endl<<endl;
    cout<<"\t\t\t1.��  ��   �� ½"<<endl<<endl;
    cout<<"\t\t\t2.�� �� Ա �� ½"<<endl<<endl;
    cout<<"\t\t\t������1-2ѡ��ͬ���ܣ�";


        cin>>charge;
        if(cin.fail()){
                system("CLS");
                cout<<endl<<"\t����δ���Ϲ涨���밴�չ涨���룡"<<endl<<endl<<endl;

                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
                 system("pause");
                 continue;
            }




 if(charge==1) {return 0;break;}
 else if(charge==2)
 {

     char password[12];
     system("CLS");
     cout<<"���������Ա���룺";
     for(int j=0;j<11;j++)
     {
         char c;
         c=getch();
         if(c=='\r')break;
         if(c==0x8){j--;j--;cout<<"\b"<<" "<<"\b";continue;}
         password[j]=c;

     cout<<"*";

    }

     if(strcmp(password,"wzx19970809")==0)
        {
            cout.flush();


            system("CLS");
            cout<<endl<<endl<<endl<<endl;
            cout<<endl<<"\t\t\t��֤�ɹ������ڳ�ʼ�������Ժ�"<<endl;
            cout<<"\t\t\t";
            for(int i=0;i<28;i++)
            {
                cout.flush();
                Sleep(100);
                cout<<"=";


            }
return 1;
            break;
     }
     else {cout<<endl<<"������������֤ʧ�ܣ�"<<endl<<endl<<endl;
     system("pause");}
 }

    }
}
int main()
{

start();


    Goods g[100];
    Goods s[100];

    int flag;

skip();


int choose_number=choose();


if(choose_number==1)
{


    for(;;)

    {
        system("CLS");

        cout<<endl;

        cout<<"                **************�ֿ���������ϵͳ****************"<<endl;
        cout<<"                *                                            *"<<endl;
        cout<<"                *             1.  ��      ��                 *"<<endl;
        cout<<"                *             2.  ��      ѯ                 *"<<endl;
        cout<<"                *             3.  ��      ��                 *"<<endl;
        cout<<"                *             4.  ��      ��                 *"<<endl;
        cout<<"                *             5.  ��      ȡ                 *"<<endl;
        cout<<"                *             6.  ɾ      ��                 *"<<endl;
        cout<<"                *             7.  ��      ��                 *"<<endl;
        cout<<"                *             8.  ͳ      ��                 *"<<endl;
        cout<<"                *             9.  ��      ��                 *"<<endl;
        cout<<"                *                                            *"<<endl;
        cout<<"                **********************************************"<<endl;
        cout<<endl<<endl<<endl<<endl;
        cout<<"                           ������1-9ѡ��ͬ���ܣ�";


cin>>flag;

         if(cin.fail()){
                system("CLS");
                cout<<endl<<"\t����δ���Ϲ涨���밴�չ涨���룡ϵͳ�Զ����������棡"<<endl<<endl<<endl;

                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
                 cout.flush();
                Sleep(2000);
                 continue;

         }


        if(flag==9)break;
        else switch(flag)
        {
            case 1: g[sum_number++].input();find_number=sum_number;break;
                case 2:Find(g);break;
                   case 3:Modify(g);break;
                        case 4:Save(g);break;
                            case 5:Read(g);break;
                                case 6:
                                    {if(sum_number==0){ system("CLS");cout<<"û����Ϣ����ɾ��������������ȡ��"<<endl<<endl<<endl<<endl<<endl;cout.flush();Sleep(2000);}
                                      else Del(g,s);
                                      break;}
                                    case 7:Recover(g,s);break;
                                        case 8:
                                            {
                                                if(sum_number==0){ system("CLS");cout<<"û����Ϣ��¼������������ȡ��"<<endl<<endl<<endl<<endl<<endl;cout.flush();Sleep(2000);}
                                                else statistics(g);
                                                break;
                                      }

                                        case 0:display3(g);break;
                                       default:cout<<"�������"<<endl<<endl<<endl;system("pause");break;

        }


    }
}

else if(choose_number==0)
{
     ifstream infile("file.txt",ios::in);
    noo=0;
for(int i=0;i<100;i++)
number[i]=0;
    for(int i=0;i<noo1;i++)
    {
        //infile>>g[i+sum_number];
        //save_number++;

       g[i].readFrom(infile);



    }

    sum_number=save_number;
    find_number=sum_number;
    infile.close();

    save_number=0;

    for(;;)

    {
        system("CLS");

        cout<<endl;

        cout<<"                **************�ֿ���������ϵͳ****************"<<endl;
        cout<<"                *                                            *"<<endl;
        cout<<"                *             1.  ��      ��                 *"<<endl;
        cout<<"                *             2.  ��      ѯ                 *"<<endl;
        cout<<"                *             3.  ��      ��                 *"<<endl;
        cout<<"                *             4.  ��      ��                 *"<<endl;
        cout<<"                *             5.  ��      ȡ                 *"<<endl;
        cout<<"                *             6.  ɾ      ��                 *"<<endl;
        cout<<"                *             7.  ��      ��                 *"<<endl;
        cout<<"                *             8.  ͳ      ��                 *"<<endl;
        cout<<"                *             9.  ��      ��                 *"<<endl;
        cout<<"                *                                            *"<<endl;
        cout<<"                **********************************************"<<endl;
        cout<<endl<<endl<<endl<<endl;
        cout<<"                           ������1-9ѡ��ͬ���ܣ�";


cin>>flag;

         if(cin.fail()){
                system("CLS");
                cout<<endl<<"\t����δ���Ϲ涨���밴�չ涨���룡ϵͳ�Զ����������棡"<<endl<<endl<<endl;

                cin.clear();//���cin�Ĵ���״̬
                 cin.sync();//���������
                  cout.flush();
                Sleep(2000);
                 continue;

         }


        if(flag==9)break;
        else switch(flag)
        {
            case 1: system("CLS");cout<<endl<<endl<<"\t\t�˹�����Ҫ��ù���ԱȨ�ޣ�"<<endl<<endl; cout.flush();Sleep(2000);break;
                case 2:Find(g);break;
                   case 3:system("CLS");cout<<endl<<endl<<"\t\t�˹�����Ҫ��ù���ԱȨ�ޣ�"<<endl<<endl;cout.flush();Sleep(2000);break;
                        case 4:system("CLS");cout<<endl<<endl<<"\t\t�˹�����Ҫ��ù���ԱȨ�ޣ�"<<endl<<endl;cout.flush();Sleep(2000);break;
                            case 5:system("CLS");cout<<endl<<endl<<"\t\t�Ѷ�ȡ��ɣ������ظ�������"<<endl<<endl;cout.flush();Sleep(2000);break;
                                case 6:system("CLS");cout<<endl<<endl<<"\t\t�˹�����Ҫ��ù���ԱȨ�ޣ�"<<endl<<endl;cout.flush();Sleep(2000);break;

                                    case 7:system("CLS");cout<<endl<<endl<<"\t\t�˹�����Ҫ��ù���ԱȨ�ޣ�"<<endl<<endl;cout.flush();Sleep(2000);break;
                                        case 8:
                                            {
                                                if(sum_number==0){ system("CLS");cout<<"û����Ϣ��¼������������ȡ��"<<endl<<endl<<endl<<endl<<endl;cout.flush();Sleep(2000);}
                                                else statistics(g);
                                                break;
                                      }

                                        case 0:display3(g);break;
                                       default:cout<<"�������"<<endl<<endl<<endl;system("pause");break;

        }


    }
}

endof();




    return 0;
}
