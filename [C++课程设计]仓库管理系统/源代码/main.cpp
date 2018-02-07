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


void gotoxy(int x,int y)  //网上找的goto函数定义
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
    cout<<"                你想按照什么方式查找？"<<endl<<endl<<endl<<endl;
    cout<<"                1.按照货物编号查询："<<endl<<endl;
    cout<<"                2.按照货物名称查询："<<endl<<endl<<endl<<endl;
    cout<<"                请输入1-2选择不同功能：";
    cin>>flag2;


         if(cin.fail()){
                cout<<endl<<"输入错误！请重新输入！"<<endl;

                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
    system("pause");
         }
         else break;
    }
    if(flag2==1)
    {



                      system("CLS");
                      cout<<"请输入货物编号：";
                      cin>>sum_c;





                      for(int i=0;i<find_number;i++)
                     if(g[i].find10(sum_c)==1)sum_cc++;

					  if(sum_cc==0){cout<<"未查询到任何信息！"<<endl<<endl<<endl<<endl<<endl<<endl<<endl;system("pause");}

                     else
                     {
						 cout<<endl<<endl;
                     cout<<"总共查找到"<<sum_cc<<"条信息！";

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
                      cout<<"请输入货物名称：";
                      cin>>sum_c2;





                      for(int j=0;j<find_number;j++)
                     if(g[j].find20(sum_c2)==1)sum_cc2++;

					  if(sum_cc2==0){cout<<"未查询到任何信息！"<<endl<<endl<<endl<<endl<<endl<<endl<<endl;system("pause");}

                     else
                     {
						 cout<<endl<<endl;
                     cout<<"总共查找到"<<sum_cc2<<"条信息！";

					 cout<<endl<<endl;

                     for(int j=0;j<find_number;j++)
                     g[j].find2(sum_c2);
					  cout<<endl<<endl;
                     system("pause");

                     }


                            }
    else {cout<<"输入错误！";cout<<endl<<endl;system("pause");}

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
    cout<<"请输入货物编号：";
cin>>sum_c;


         if(cin.fail()){
                cout<<endl<<"输入错误！请重新输入！"<<endl;

                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
    system("pause");
         }
         else break;
    }
    cout<<endl<<endl;
     for(int j=0;j<find_number;j++)
                     if(g[j].find10(sum_c)==1)sum_cc++;

                     if(sum_cc==0)
					 {  cout<<"该货物不存在！"<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;system("pause");}

                     else
                     {

    cout<<"查找到的货物信息如下：";

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

    cout<<"如果确定要修改请输入 Y，否则将返回 :";
    cin>>charge;
    if(charge=="Y"||charge=="y")
    {
		cout<<endl<<endl;
        for(;;)
        {     system("CLS");
			g[n].modify(n);
            cout<<"如果要回到主菜单请输入 Y，否则将继续修改:";
        cin>>charge;
        if(charge=="Y"||charge=="y"){system("CLS");cout<<endl<<endl<<endl<<"           修改成功！"<<endl<<endl<<endl;system("pause");break;}
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
    cerr<<"打开文件失败！"<<endl;
    exit(1);
}

    for(int i=0;i<find_number;i++)
    {


        g[i].writeTo(outfile);
    }
    outfile.close();
    cout<<"                      文件保存完毕！"<<endl<<endl<<endl<<endl;
    system("pause");

}

void Read(Goods g[])
{

string charge;




     system("CLS");
    ifstream infile("file.txt",ios::in);

    if(!infile)
{
    cerr<<"没有任何记录！"<<endl;

}



else{

        cout<<"你确认要读取文件信息吗？这会覆盖现已有信息。"<<endl<<endl;;
cout<<"确认读取请输入 Y，否则将返回：";
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
    cout<<"                   文件读取成功！"<<endl<<endl<<endl<<endl;
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
    cout<<"请确认你要删除的货物编号：";
    cin>>d;
    for(int i=0;i<sum_number;i++)
    {
        if(d==g[i].get_no()){search_number=i;flag=1;break;}
    }
    if(flag==0){cout<<endl<<endl<<"您输入的货物编号不存在！"<<endl<<endl<<endl;system("pause");}
    else if(flag==1)
    {



    cout<<"你要删除的信息如下："<<endl<<endl;
    cout<<g[search_number]<<endl<<endl;
    cout<<"确认要删除请输入Y，否则将返回：";
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
    cout<<"        信 息 删 除 成 功 ！"<<endl<<endl<<endl<<endl;
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

    if(save_to==0){cout<<"最近没有删除的信息！"<<endl<<endl<<endl;system("pause");}
    else{
    cout<<"以下是你最近删除的信息："<<endl<<endl;
     for(int i=0;i<save_to;i++)
        cout<<s[i]<<endl<<endl;

     cout<<"输入你要恢复的货物的编号：";
     cin>>mmm;


 for(i=0;i<save_to;i++)
            {if(s[i].rec(mmm)==1){flag=1;break;}}

           if(flag==0) {cout<<endl<<endl<<"您输入的货物编号不存在！"<<endl<<endl<<endl;system("pause");}
       else{
             for(k=0;k<find_number;k++)

		{

		    if(number[k]==mmm)
                {cout<<endl<<endl<<"该设备编号已存在，恢复该信息将覆盖已有信息!"<<endl;flag_1=1;break;}
                else flag_1=0;
        }

    cout<<endl<<endl<<"确认要恢复请输入Y,否则将返回：";
    cin>>charge;
    if(charge=="Y"||charge=="y")
    {




            system("CLS");
    cout<<"        信 息 恢 复 成 功 ！"<<endl<<endl<<endl<<endl;
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
        for(int i=0;i<k;i++)//判断名字是否重复
        {

                    if(g[k].name==sum_name[i])//名字重复
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
    cout<<"\t\t\t统计结果如下："<<endl<<endl<<endl;
    for(int k=0;k<j;k++)
    {cout.setf(ios::left);

   cout<<"  ";
    cout.width(20);
    cout<<sum_name[k];



    cout<<"总数量: ";
    cout.width(16);
    cout<<sum_num[k];

    cout<<"总金额: ";
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

    cout<<"统计结果如下："<<endl<<endl;
    cout<<"2015年4月份前入库的货物数量为："<<goods_number1<<endl<<"2015年4月份前入库的货物金额为："<<goods_money1<<endl<<endl<<endl;
    cout<<"2015年4月份后入库的货物数量为："<<goods_number2<<endl<<"2015年4月份后入库的货物金额为："<<goods_money2<<endl<<endl<<endl;
cout<<endl<<endl<<endl<<endl;
system("pause");
}
void display3(Goods g[])
{
system("CLS");
   cout<<"————————————————————————————————————————"<<endl;


    cout.setf(ios::left);
cout<<"  ";
    cout.width(5);
    cout<<"   ";

    cout.width(10);
    cout<<"编  号";
    cout.width(10);
    cout<<"名  称";
    cout.width(10);
    cout<<"重  量";
    cout.width(10);
    cout<<"价  格";
    cout.width(10);
    cout<<"数  量";
    cout.width(20);
    cout<<"入库时间";
    cout<<endl;
    for(int i=0;i<find_number;i++)
    {
         cout<<"————————————————————————————————————————"<<endl;


    cout<<"  ";
    cout.width(5);
    cout<<i+1;
        g[i].show();
    }
      cout<<"————————————————————————————————————————"<<endl;

    system("pause");
}

void ranks(Goods g[])
{
    Goods r[100];
int flag;
    Goods r0;
    system("CLS");
    cout<<endl<<endl<<endl;
    cout<<"\t\t    你希望怎样排序？"<<endl<<endl;
    cout<<"\t\t  1.按编号排序（从小到大）"<<endl<<endl;
    cout<<"\t\t  2.按重量排序（从轻到重）"<<endl<<endl;
    cout<<"\t\t  3.按价格排序（从贱到贵）"<<endl<<endl;
    cout<<"\t\t  4.按数目排序（从少到多）"<<endl<<endl;
    cout<<"\t\t  5.按入库时间排序（从前到后）"<<endl<<endl<<endl<<endl;
    cout<<"\t\t    输入1-5选择不同功能：";
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
        default:cout<<"输入错误！"<<endl<<endl<<endl;system("pause");break;
    }












}


void statistics(Goods g[])
{
    int flag;
 system("CLS");
 cout<<endl<<endl<<endl;
 cout<<"\t\t    你希望怎样统计？"<<endl<<endl;
 cout<<"\t\t  1.各类货物数量及金额"<<endl<<endl;
 cout<<"\t\t  2.2015年4月前后货物数量及金额对比"<<endl<<endl;
 cout<<"\t\t  3.全部货物信息展示"<<endl<<endl;
 cout<<"\t\t  4.排序"<<endl<<endl<<endl<<endl;

 cout<<"\t\t    输入1-4选择不同功能：";
 cin>>flag;

 switch(flag)
 {
     case 1:display1(g);break;
     case 2:display2(g);break;
     case 3:display3(g);break;
     case 4:ranks(g);break;
     default:cout<<"输入错误！"<<endl<<endl<<endl;system("pause");break;
 }

}


void start()
{
    cout<<endl<<endl<<endl;
    cout.flush();Sleep(1000);
    cout<<"\t\t\t仓  ";
    cout.flush();Sleep(1000);
    cout<<"库  ";
    cout.flush();Sleep(1000);
    cout<<"管  ";
    cout.flush();Sleep(1000);
    cout<<"理  ";
    cout.flush();Sleep(1000);
    cout<<"系  ";
    cout.flush();Sleep(1000);
    cout<<"统"<<endl<<endl;
    cout.flush();Sleep(1800);

    cout<<endl<<endl<<endl;
    cout<<"\t\t\t==>本";
    cout.flush();Sleep(400);
    cout<<"系";
    cout.flush();Sleep(400);
    cout<<"统";
    cout.flush();Sleep(400);
    cout<<"由";
    cout.flush();Sleep(400);
    cout<<"王";
    cout.flush();Sleep(400);
    cout<<"子";
    cout.flush();Sleep(400);
    cout<<"旭";
    cout.flush();Sleep(400);
    cout<<"编";
    cout.flush();Sleep(400);
    cout<<"写";
    cout.flush();Sleep(1000);


    cout<<endl<<endl<<endl;

}

void endof()
{
    system("CLS");

    cout<<endl<<endl<<endl<<endl;
    cout<<"\t\t\t    感谢您的使用!";
    cout<<endl<<endl<<endl;
    cout<<"\t\t\t  如有不足之处请谅解";
    cout<<endl<<endl<<endl;
    cout<<"\t\t\t==本系统由王子旭编写==";


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
    cout<<"\t\t\t1.游  客   登 陆"<<endl<<endl;
    cout<<"\t\t\t2.管 理 员 登 陆"<<endl<<endl;
    cout<<"\t\t\t请输入1-2选择不同功能：";


        cin>>charge;
        if(cin.fail()){
                system("CLS");
                cout<<endl<<"\t输入未符合规定！请按照规定输入！"<<endl<<endl<<endl;

                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
                 system("pause");
                 continue;
            }




 if(charge==1) {return 0;break;}
 else if(charge==2)
 {

     char password[12];
     system("CLS");
     cout<<"请输入管理员密码：";
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
            cout<<endl<<"\t\t\t验证成功，正在初始化，请稍后"<<endl;
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
     else {cout<<endl<<"密码错误！身份验证失败！"<<endl<<endl<<endl;
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

        cout<<"                **************仓库物流管理系统****************"<<endl;
        cout<<"                *                                            *"<<endl;
        cout<<"                *             1.  添      加                 *"<<endl;
        cout<<"                *             2.  查      询                 *"<<endl;
        cout<<"                *             3.  修      改                 *"<<endl;
        cout<<"                *             4.  保      存                 *"<<endl;
        cout<<"                *             5.  读      取                 *"<<endl;
        cout<<"                *             6.  删      除                 *"<<endl;
        cout<<"                *             7.  恢      复                 *"<<endl;
        cout<<"                *             8.  统      计                 *"<<endl;
        cout<<"                *             9.  退      出                 *"<<endl;
        cout<<"                *                                            *"<<endl;
        cout<<"                **********************************************"<<endl;
        cout<<endl<<endl<<endl<<endl;
        cout<<"                           请输入1-9选择不同功能：";


cin>>flag;

         if(cin.fail()){
                system("CLS");
                cout<<endl<<"\t输入未符合规定！请按照规定输入！系统自动返回主界面！"<<endl<<endl<<endl;

                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
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
                                    {if(sum_number==0){ system("CLS");cout<<"没有信息可以删除！请先输入或读取！"<<endl<<endl<<endl<<endl<<endl;cout.flush();Sleep(2000);}
                                      else Del(g,s);
                                      break;}
                                    case 7:Recover(g,s);break;
                                        case 8:
                                            {
                                                if(sum_number==0){ system("CLS");cout<<"没有信息记录！请先输入或读取！"<<endl<<endl<<endl<<endl<<endl;cout.flush();Sleep(2000);}
                                                else statistics(g);
                                                break;
                                      }

                                        case 0:display3(g);break;
                                       default:cout<<"输入错误！"<<endl<<endl<<endl;system("pause");break;

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

        cout<<"                **************仓库物流管理系统****************"<<endl;
        cout<<"                *                                            *"<<endl;
        cout<<"                *             1.  添      加                 *"<<endl;
        cout<<"                *             2.  查      询                 *"<<endl;
        cout<<"                *             3.  修      改                 *"<<endl;
        cout<<"                *             4.  保      存                 *"<<endl;
        cout<<"                *             5.  读      取                 *"<<endl;
        cout<<"                *             6.  删      除                 *"<<endl;
        cout<<"                *             7.  恢      复                 *"<<endl;
        cout<<"                *             8.  统      计                 *"<<endl;
        cout<<"                *             9.  退      出                 *"<<endl;
        cout<<"                *                                            *"<<endl;
        cout<<"                **********************************************"<<endl;
        cout<<endl<<endl<<endl<<endl;
        cout<<"                           请输入1-9选择不同功能：";


cin>>flag;

         if(cin.fail()){
                system("CLS");
                cout<<endl<<"\t输入未符合规定！请按照规定输入！系统自动返回主界面！"<<endl<<endl<<endl;

                cin.clear();//清除cin的错误状态
                 cin.sync();//清除缓冲区
                  cout.flush();
                Sleep(2000);
                 continue;

         }


        if(flag==9)break;
        else switch(flag)
        {
            case 1: system("CLS");cout<<endl<<endl<<"\t\t此功能需要获得管理员权限！"<<endl<<endl; cout.flush();Sleep(2000);break;
                case 2:Find(g);break;
                   case 3:system("CLS");cout<<endl<<endl<<"\t\t此功能需要获得管理员权限！"<<endl<<endl;cout.flush();Sleep(2000);break;
                        case 4:system("CLS");cout<<endl<<endl<<"\t\t此功能需要获得管理员权限！"<<endl<<endl;cout.flush();Sleep(2000);break;
                            case 5:system("CLS");cout<<endl<<endl<<"\t\t已读取完成，无需重复操作！"<<endl<<endl;cout.flush();Sleep(2000);break;
                                case 6:system("CLS");cout<<endl<<endl<<"\t\t此功能需要获得管理员权限！"<<endl<<endl;cout.flush();Sleep(2000);break;

                                    case 7:system("CLS");cout<<endl<<endl<<"\t\t此功能需要获得管理员权限！"<<endl<<endl;cout.flush();Sleep(2000);break;
                                        case 8:
                                            {
                                                if(sum_number==0){ system("CLS");cout<<"没有信息记录！请先输入或读取！"<<endl<<endl<<endl<<endl<<endl;cout.flush();Sleep(2000);}
                                                else statistics(g);
                                                break;
                                      }

                                        case 0:display3(g);break;
                                       default:cout<<"输入错误！"<<endl<<endl<<endl;system("pause");break;

        }


    }
}

endof();




    return 0;
}
