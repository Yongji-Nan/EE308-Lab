#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int calculate(int a,int b,int operators);
int main(){
	time_t t;
	srand((unsigned) time(&t));
	int grade;
	int question_num;
	printf("Please enter your grade!\n");
	scanf("%d",&grade);
	printf("Please enter the number of questions!\n");
	scanf("%d",&question_num);
	int a,b,answer;
	int operators;
	int correct_num=0;
	int i;
	switch(grade){
		case 1:
		case 2:
			operators=1;
			for(i=0;i<question_num;i++){
				a=rand()%101;
				b=rand()%101;
				if(a<b){
					int temp=a;
					a=b;
					b=temp;
				}
				answer=calculate(a,b,operators);
				int input;
				scanf("%d",&input);
				if(input==answer){
					correct_num++;
				}
			}
			break;
		case 3:
		case 4:
			operators=3;
			for(i=0;i<question_num;i++){
				a=rand()%10000;
				b=rand()%10000;
				answer=calculate(a,b,operators);
				int input;
				scanf("%d",&input);
				if(input==answer){
					correct_num++;
				}
			}
			break;
		case 5:
		case 6:
			{
			double x,y,answerd;
			operators=3;
			for(i=0;i<question_num;i++){
				x=(double)(rand()%1000000)/100.0;
				y=(double)(rand()%1000000)/100.0;
				switch(rand()%operators){
					case 0:
						printf("%.2lf+%.2lf=?\n",x,y); 
						answerd=x+y;
						break;
					case 1:
						printf("%.2lf-%.2lf=?\n",x,y);
						answerd=x-y;
						break;
					case 2:
						printf("%.2lf*%.2lf=?\n",x,y);
						answerd=x*y;
						break;
					case 3:
						printf("%.2lf/%.2lf=?\n",x,y);
						answerd=x/y;
						break;
					default:
						break;
				}
				int input;
				scanf("%f",&input);
				if(input==answer){
					correct_num++;
				}
			}
			}
			break;
		default:
			break;
	}
			
	if(correct_num==question_num){
    	printf("end! All right, that's great! Your score is 100.");
	}else{
		int score=(100/question_num)*(correct_num);
		printf("end! Wrong question, your score is %d.",score);
	}
	system("pause");
	return 0;
}

int calculate(int a,int b,int operators){
	switch(rand()%operators){
		case 0:
			printf("%d+%d=?\n",a,b); 
			return a+b;
		case 1:
			printf("%d-%d=?\n",a,b);
			return a-b;
		case 2:
			printf("%d*%d=?\n",a,b);
			return a*b;
		case 3:
			printf("%d/%d=?\n",a,b);
			return a/b;
		default:
			return 0;
	}
}
