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
    printf("\n********************  ����0�򷵻����˵�  **********************");
    printf("\n=================================================================");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");

    printf("\n���������豸ID��:");
    scanf("%s",id);


    printf("\n");
    if(strcmp(id,"0")==0)  break;
    p=(Node *)malloc(sizeof(Node));
    strcpy(p->data.ID,id);

    printf("\n�������豸����:");

    scanf("%s",p->data.name);

    printf("\n");

    printf("\n�������豸����:");
    scanf("%s",p->data.kind);

    printf("\n");

    printf("\n������������:");
    scanf("%s",&p->data.person);

    printf("\n");

    printf("\n�������豸����ʱ��:");
    scanf("%s",&p->data.time);

    printf("\n");

    printf("\n�������豸�۸�:");
    scanf("%s",&p->data.price);
    printf("\n");

    printf("\n�����뱸ע:");
    scanf("%s",&p->data.others);
    system("cls");

    printf("\n");
    printf("\n===============================================================");
    printf("\n**********  Successful!���ѳɹ����һ�������ݣ� **************\n");

    p->next=NULL;
    r->next=p;
    r=p;
}

}







void modify(Node *equip)//�޸�
{
Node *p;
char find[20];
system("cls");
if(!equip->next)
{printf("\n");printf("\n");
    printf("\n\t    ====================================================");
    printf("\n\t    ********************  ���޸���  ********************");
    printf("\n\t    ====================================================");
     printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\t\t   ==========�����������==========");
    getch();
    return;
}
printf("������Ҫ�޸ĵ��豸ID��:");
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
        printf("\t\t**********  �˳�������0  **********\n            ���������������ٽ����޸�:");
        scanf("%d",&x);
        if(x==0)
        {break;}
           printf("���������豸��(���豸�� %s ):",p->data.ID);
           scanf("%s",p->data.ID);
           printf("\n");
           printf("���������豸����(���豸���� %s ):",p->data.name);
           scanf("%s",p->data.name);
           printf("\n");
           printf("���������豸����(���豸���� %s ):",p->data.kind);
           scanf("%s",p->data.kind);
           printf("\n");
           printf("���������豸������(���豸������ %s ):",p->data.person);
           scanf("%s",p->data.person);
           printf("\n");
           printf("���������豸����ʱ��(���豸����ʱ�� %s ):",p->data.time);
           scanf("%s",p->data.time);
           printf("\n");
           printf("���������豸�۸�(���豸�۸�%s ):",p->data.price);
           scanf("%s",p->data.price);
           printf("\n");
           printf("�������±�ע(�ɱ�ע%s ):",p->data.others);
           scanf("%s",p->data.others);
            system("cls");
            printf("\n");

           printf("\n\t\t**********  �ɹ��޸�!  **********\n");
    }
    }
    else
    {printf("\n\t\t**********  ѡ�����!  **********\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\t\t   ==========�����������==========");
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
    printf("\n\t\t**********  û�м�¼������ʾ!  **********\n");

    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\t\t   ==========�����������==========");
    getch();
    return;
}

    printf("\t\t\t\t��ʾ���\n");

    printf("\n================================================================================");
    printf("\n�豸��      �豸����     �豸����  ������   ����ʱ��   �۸�      ��ע");


while(p)
{   printf("\n================================================================================");
    printf("\n%-13s%-11s%-10s%-10s%-11s%-10s%-10s",p->data.ID,p->data.name,p->data.kind,p->data.person,p->data.time,p->data.price,p->data.others);



    p=p->next;
}

 printf("\n================================================================================");
printf("\n");
printf("\n");
printf("\n");
printf("\n==================���������������===================");
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
    printf("\n\t\t******************  �޷�����!  ******************\n");
    printf("\n");
    printf("\n");
    printf("\n");
printf("\n");
printf("\n");
    printf("\n\t\t==================���������������===================");

    getch();
    return;
}

printf(">>>>>>>>>>>>>>>>>>>>>>>>>>>   0==�˳�\n>>>>>>>>>>>>>>>>>>>>>>>>>>>   1==���豸��ͳ��\n>>>>>>>>>>>>>>>>>>>>>>>>>>>   2==���豸����ͳ��\n");
printf("\n");
printf("\n");
scanf("%d",&sel);
if(sel==1)
{
    printf("\n������Ҫ���ҵ��豸��:");
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
         printf("\n�豸��       �豸����     �豸����  ������   ����ʱ��   �۸�      ��ע");


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
     printf("\n**********  ���豸��%sͳ�Ʒ������%d����¼:  **********\n\n",find,flag2);
     printf("\n");
     printf("\n");
    }
    else {printf("\n**********  ���豸��%sͳ�ƵĽ��Ϊ0��  **********\n\n",find);printf("\n");}
}
else if(sel==2)
{
     printf("\n������Ҫ���ҵ��豸����:");
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
         printf("\n�豸��       �豸����    �豸����  ������   ����ʱ��   �۸�      ��ע");


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
     printf("\n**********  ���豸��%sͳ�Ʒ������%d����¼:  **********\n\n",find,flag2);
     printf("\n");
     printf("\n");
    }
    else {printf("\n");printf("\n");printf("\n");
            printf("\n**********  ���豸��%sͳ�ƵĽ��Ϊ0��  **********\n\n",find);printf("\n");}
}
else if(sel==0) return;
printf("==================���������������===================");
printf("\n");
    getch();
}


void start()
{
    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t\t\tWelcome!");
    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t    ==========�����������==========");
    getch();
    system("cls");

    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t\t���ƣ�  �豸����ϵͳ");
    printf("\n\n\n\t\t\t�����ˣ��� �� ��");
    printf("\n\n\n\t\t\t<��������֪ʶ��Դ����>");
    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t   ==========�����������==========");
    getch();
    system("cls");


printf("\n");printf("\n");printf("\n");
    printf("\t\t��ϵͳ������ӡ���ʾ���޸ġ���������Ĳ���");
    printf("\n\n\n\t\t�����������ܣ�Ӧ��������Ϣ����");
    printf("\n\n\n\t\t��ע�⣬��Ϣ�����Ա���һ�Σ�����save����");
    printf("\n\n\n\t\t�˳�ϵͳʱ��Ϣ�Զ����");
    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t   ==========�����������==========");
    getch();
    system("cls");

    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t\t��  ��  ��  ��  ��  ��  ϵ  ͳ");
     printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    getch();
    system("cls");



}

void end()
{
    system("cls");
     printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("\t\t\t�� л ʹ �� �� ϵ ͳ��");
    printf("\n\n\n\n\t\t\t�����ˣ�������");
    printf("\n\n\n\t\t\tBye bye~~");
    printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");printf("\n");
    printf("               =======�������¾����˳���=======");
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
    fp=fopen("�豸����ϵͳ","wb+");
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
printf("\t\t\t>>>>>>>>>>>>>>>�豸����ϵͳ<<<<<<<<<<<<<<<\n");

    printf("\n");
    printf("\n");

printf("\t\t\t******************��   ��*****************\n");
printf("\t\t\t*                                        *\n");
printf("\t\t\t*           1.������豸��Ϣ             *\n");
printf("\t\t\t*                                        *\n");
printf("\t\t\t*           2.��ʾ�����豸��Ϣ           *\n");
printf("\t\t\t*                                        *\n");
printf("\t\t\t*           3.�޸������豸��Ϣ           *\n");
printf("\t\t\t*                                        *\n");
printf("\t\t\t*           4.���������豸��Ϣ           *\n");
printf("\t\t\t*                                        *\n");
printf("\t\t\t*           5.�˳����豸����ϵͳ         *\n");
printf("\t\t\t*                                        *\n");
printf("\t\t\t******************************************\n");

printf("\n");
printf("\n");
printf("\n");
printf("\n");


printf("\t\t\t       ������1-5ѡ��ͬ���ܣ� ");

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



