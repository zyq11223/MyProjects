#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "conio.h"
struct shebei
{
char ID[10];
char name[15];
char kind[15];
char person[15];
char time[10];
char price[10];
char others[100];
};
typedef struct node
{
struct shebei data;
struct node *next;
}Node;








void input(Node *equip)
{
Node *p,*r,*s;
char id[10];
r=equip;
s=equip->next;
while(r->next!=NULL)
r=r->next;
system("cls");
while(1)
{


    printf("=================================================================");
    printf("\n********************  输入0则返回主菜单  **********************");
    printf("\n=================================================================");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");

    printf("\n请你输入设备ID号:");
    scanf("%s",id);


    printf("\n");
    if(strcmp(id,"0")==0)  break;
    p=(Node *)malloc(sizeof(Node));
    strcpy(p->data.ID,id);

    printf("\n请输入设备名称:");

    scanf("%s",p->data.name);

    printf("\n");

    printf("\n请输入设备种类:");
    scanf("%s",p->data.kind);

    printf("\n");

    printf("\n请输入领用人:");
    scanf("%s",&p->data.person);

    printf("\n");

    printf("\n请输入设备购买时间:");
    scanf("%s",&p->data.time);

    printf("\n");

    printf("\n请输入设备价格:");
    scanf("%s",&p->data.price);
    printf("\n");

    printf("\n请输入备注:");
    scanf("%s",&p->data.others);
    system("cls");

    printf("\n");
    printf("\n===============================================================");
    printf("\n**********  Successful!您已成功添加一条新数据！ **************\n");

    p->next=NULL;
    r->next=p;
    r=p;
}

}







void modify(Node *equip)//修改
{
Node *p;
char find[20];
system("cls");
if(!equip->next)
{printf("\n");printf("\n");
    printf("\n\t    ====================================================");
    printf("\n\t    ********************  无修改项  ********************");
    printf("\n\t    ====================================================");
     printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\t\t   ==========按任意键继续==========");
    getch();
    return;
}
printf("请输入要修改的设备ID号:");
scanf("%s",find);
    p=equip->next;
     while(p!=NULL)
     {
      if(strcmp(p->data.ID,find)==0)
       break;
       p=p->next;
     }
     if(p)
     {
       int x;
       while(1)
       {
        printf("\t\t**********  退出请输入0  **********\n            否则输入任意数再进行修改:");
        scanf("%d",&x);
        if(x==0)
        {break;}
           printf("请输入新设备号(旧设备号 %s ):",p->data.ID);
           scanf("%s",p->data.ID);
           printf("\n");
           printf("请输入新设备名称(旧设备名称 %s ):",p->data.name);
           scanf("%s",p->data.name);
           printf("\n");
           printf("请输入新设备种类(旧设备种类 %s ):",p->data.kind);
           scanf("%s",p->data.kind);
           printf("\n");
           printf("请输入新设备领用人(旧设备领用人 %s ):",p->data.person);
           scanf("%s",p->data.person);
           printf("\n");
           printf("请输入新设备购买时间(旧设备购买时间 %s ):",p->data.time);
           scanf("%s",p->data.time);
           printf("\n");
           printf("请输入新设备价格(旧设备价格%s ):",p->data.price);
           scanf("%s",p->data.price);
           printf("\n");
           printf("请输入新备注(旧备注%s ):",p->data.others);
           scanf("%s",p->data.others);
            system("cls");
            printf("\n");

           printf("\n\t\t**********  成功修改!  **********\n");
    }
    }
    else
    {printf("\n\t\t**********  选项不存在!  **********\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\t\t   ==========按任意键继续==========");
    getch();

    }

}







void display(Node *equip)
{
Node *p;
p=equip->next;
system("cls");
printf("\n");printf("\n");
if(!p)
{
    printf("\n\t\t**********  没有记录可以显示!  **********\n");

    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\t\t   ==========按任意键继续==========");
    getch();
    return;
}

    printf("\t\t\t\t显示结果\n");

    printf("\n================================================================================");
    printf("\n设备号      设备名称     设备种类  领用人   购买时间   价格      备注");


while(p)
{   printf("\n================================================================================");
    printf("\n%-13s%-11s%-10s%-10s%-11s%-10s%-10s",p->data.ID,p->data.name,p->data.kind,p->data.person,p->data.time,p->data.price,p->data.others);



    p=p->next;
}

 printf("\n================================================================================");
printf("\n");
printf("\n");
printf("\n");
printf("\n==================请输入任意键返回===================");
printf("\n");
    getch();
}






void find(Node *equip)
{
Node *p;
int sel;
int flag2=0,ha=0;
p=equip->next;
char find[20];
system("cls");
if(!equip->next)
{
    printf("\n\t\t******************  无法查找!  ******************\n");
    printf("\n");
    printf("\n");
    printf("\n");
printf("\n");
printf("\n");
    printf("\n\t\t==================请输入任意键返回===================");

    getch();
    return;
}

printf(">>>>>>>>>>>>>>>>>>>>>>>>>>>   0==退出\n>>>>>>>>>>>>>>>>>>>>>>>>>>>   1==按设备号统计\n>>>>>>>>>>>>>>>>>>>>>>>>>>>   2==按设备名称统计\n");
printf("\n");
printf("\n");
scanf("%d",&sel);
if(sel==1)
{
    printf("\n输入你要查找的设备号:");
    printf("\n");
    printf("\n");
scanf("%s",find);
    while(p)
    {
     if(strcmp(p->data.ID,find)==0)
     {
      flag2++;
     }
     if(flag2==1&&ha!=flag2)
     { printf("\n=====================================================================");
         printf("\n设备号       设备名称     设备种类  领用人   购买时间   价格      备注");


     printf("\n=====================================================================");
       printf("\n%-14s%-11s%-10s%-10s%-11s%-10s%-10s",p->data.ID,p->data.name,p->data.kind,p->data.person,p->data.time,p->data.price,p->data.others);


       ha=flag2;
     }
     else if(flag2>ha){

            printf("\n=====================================================================");
         printf("\n%14s%-11s%-10s%-10s%-11s%-10s%-10s",p->data.ID,p->data.name,p->data.kind,p->data.person,p->data.time,p->data.price,p->data.others);



        ha=flag2;}
        p=p->next;
    }
    printf("\n=====================================================================");
    if(flag2)
    {
     printf("\n**********  按设备号%s统计分类的有%d条记录:  **********\n\n",find,flag2);
     printf("\n");
     printf("\n");
    }
    else {printf("\n**********  按设备号%s统计的结果为0个  **********\n\n",find);printf("\n");}
}
else if(sel==2)
{
     printf("\n输入你要查找的设备名称:");
           scanf("%s",find);
    while(p)
    {
     if(strcmp(p->data.name,find)==0)
     {
      flag2++;
     }
     if(flag2==1&&ha!=flag2)
     { printf("\n");
         printf("\n=====================================================================");
         printf("\n设备号       设备名称    设备种类  领用人   购买时间   价格      备注");


    printf("\n=====================================================================");
       printf("\n%-14s%-11s%-10s%-10s%-11s%-10s%-10s",p->data.ID,p->data.name,p->data.kind,p->data.person,p->data.time,p->data.price,p->data.others);

      ha=flag2;
     }
     else if(flag2>ha)
     {
         printf("\n=====================================================================");
         printf("\n%-14s%-11s%-10s%-10s%-11s%-10s%-10s",p->data.ID,p->data.name,p->data.kind,p->data.person,p->data.time,p->data.price,p->data.others);

         ha=flag2;
     }
     p=p->next;
    }
    if(flag2)
    {
         printf("\n=====================================================================");
         printf("\n");
    printf("\n");
     printf("\n**********  按设备号%s统计分类的有%d条记录:  **********\n\n",find,flag2);
     printf("\n");
     printf("\n");
    }
    else {printf("\n");printf("\n");printf("\n");
            printf("\n**********  按设备号%s统计的结果为0个  **********\n\n",find);printf("\n");}
}
else if(sel==0) return;
printf("==================请输入任意键返回===================");
printf("\n");
    getch();
}


void start()
{
    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t\t\tWelcome!");
    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t    ==========按任意键继续==========");
    getch();
    system("cls");

    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t\t名称：  设备管理系统");
    printf("\n\n\n\t\t\t制作人：王 子 旭");
    printf("\n\n\n\t\t\t<关于链表知识来源网络>");
    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t   ==========按任意键继续==========");
    getch();
    system("cls");


printf("\n");printf("\n");printf("\n");
    printf("\t\t此系统包含添加、显示、修改、分类查找四部分");
    printf("\n\n\n\t\t包含清屏功能，应用链表将信息串接");
    printf("\n\n\n\t\t但注意，信息仅可以保存一次，不含save功能");
    printf("\n\n\n\t\t退出系统时信息自动清空");
    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t   ==========按任意键继续==========");
    getch();
    system("cls");

    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t\t按  任  意  键  进  入  系  统");
     printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    getch();
    system("cls");



}

void end()
{
    system("cls");
     printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t\t感 谢 使 用 本 系 统！");
    printf("\n\n\n\n\t\t\t制作人：王子旭");
    printf("\n\n\n\t\t\tBye bye~~");
    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("               =======随便点两下就能退出了=======");
    getch();

}




main()
{


Node *equip;
FILE *fp;
int flag;
Node *p,*q;

    equip=(Node*)malloc(sizeof(Node));
    equip->next=NULL;
    p=equip;
    fp=fopen("设备管理系统","wb+");
    q=(Node*)malloc(sizeof(Node));
      if(fread(q,sizeof(Node),1,fp))
      {
       q->next=NULL;
       p->next=q;
       p=q;
      }
    fclose(fp);



  start();


for(;;)
{

system("cls");
printf("\n");printf("\n");
printf("\t\t\t>>>>>>>>>>>>>>>设备管理系统<<<<<<<<<<<<<<<\n");

    printf("\n");
    printf("\n");

printf("\t\t\t******************菜   单*****************\n");
printf("\t\t\t*                                        *\n");
printf("\t\t\t*           1.添加新设备信息             *\n");
printf("\t\t\t*                                        *\n");
printf("\t\t\t*           2.显示已有设备信息           *\n");
printf("\t\t\t*                                        *\n");
printf("\t\t\t*           3.修改已有设备信息           *\n");
printf("\t\t\t*                                        *\n");
printf("\t\t\t*           4.查找已有设备信息           *\n");
printf("\t\t\t*                                        *\n");
printf("\t\t\t*           5.退出此设备管理系统         *\n");
printf("\t\t\t*                                        *\n");
printf("\t\t\t******************************************\n");

printf("\n");
printf("\n");
printf("\n");
printf("\n");


printf("\t\t\t       请输入1-5选择不同功能： ");

scanf("%d",&flag);
if(flag==5) break;
else switch(flag)
    {

        case 1:input(equip);break;
        case 2:display(equip);break;
        case 3:modify(equip);break;
        case 4:find(equip);break;
        default:printf("\nError!\n");break;
    }

}



  end();

}



