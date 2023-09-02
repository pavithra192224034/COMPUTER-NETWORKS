#include<stdio.h>
int main()
{
	int i =0,j=0,count=0;
	char inputdata[20],stuffeddata[20];
	printf("enter the data:");
	while(inputdata[i]!='\0')
	{
		stuffeddata[j]=inputdata[i];
		if(inputdata[i]=='1')
		{
			count++;
		}
		else
		{
			count=0;
		}
		if(count==5)
		{
			stuffeddata[++j]='0';
			count=0;
		}
		stuffeddata=='\0';
		i++;
		j++;
	}
	printf("original data is %s\n",inputdata);
	printf("after bit stuffing is : %s",stuffeddata);
}
