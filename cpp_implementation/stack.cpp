#define _CRT_SECURE_NO_WARNINGS

 

/*
*******************************************
     用递归实现阶乘10！
*******************************************

*/



 
# include <stdio.h>
#include <stdlib.h>
int fact (int n) 
    { 
      if(n==1)  
           return(1);
      else 
           return(n*fact (n-1));
     } 


int main(void)
{
	int val;
	int i = 10;
	val = fact(i);
	printf("%d! = %d\n",i, val);

	system("pause");

	return 0;
}

 
 



/*
*******************************************
     用循环实现阶乘10！
********************************************
*/

/*  
# include <stdio.h>
#include <stdlib.h>
int main(void)
{
	int val;
	int i, mult=1;

	printf("Please input a number: ");
	printf("val = ");
	scanf("%d", &val);

	for (i=1; i<=val; ++i)
		mult = mult * i;
	
	printf("%d! = %d\n", val, mult);

	system("pause");
	return 0;
}

*/ 


/*
	如果是1个盘子
		直接将A柱子上的盘子从A移到C
	否则
	    先将A柱子上的n-1个盘子借助C移到B
		直接将A柱子上的盘子从A移到C
		最后将B柱子上的n-1个盘子借助A移到C
*/

 
 /*
#include <stdio.h>
#include <stdlib.h>
void hannuota(int n, char A, char B, char C)
{

	if( 1 == n)
	{	
		printf("将编号为%d的盘子直接从%c柱子移到%c柱子\n", n, A, C);
	}
	else 
	{
		hannuota(n-1, A, C, B);
		printf("将编号为%d的盘子直接从%c柱子移到%c柱子\n", n, A, C);
		hannuota(n-1, B, A, C);
	}
}

int main()
{
	char ch1 = 'A';
	char ch2 = 'B';
	char ch3 = 'C';
    int n;

	printf("请输入要移动盘子的个数：");
	scanf("%d", &n);

	hannuota(n , 'A', 'B', 'C' );
	system("pause");

	return 0;
}
 */



/*
*******************************************
    用递归实现累加1+2+3+……+100
*******************************************
*/
 
 
/* 
 
#include <stdio.h>
#include <stdlib.h>
int sum(int n)

{
	if(1 == n)
		return 1;
	else 
		return n + sum(n-1);

}


int main(void)
{

	printf("%ld\n", sum(1000));
	system("pause");
	return 0;
}
 
*/ 


/*
*******************************************
    用循环实现累加1+2+3+……+100
*******************************************

*/

/*
 
#include <stdio.h>
#include <stdlib.h>
int main()
{
	int i; 
	int sum = 0;

	for (i=1; i<=1000; ++i)
	{
		sum = sum + i;
	}
   printf("sum = %d\n", sum );
   	system("pause");
	return 0;
}
*/ 