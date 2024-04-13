#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

char ast [20] [39];

void *num(void* threadid){
    for (int i = 0; i<20;i++){
        for (int j=0;j<39;j++){
            ast [i] [j] = NULL;
        }
    }
    for (int i = 0; i<20;i++){
        for (int j=0;j<39;j++){
            ast [i] [j] = j;
        }
    }
    for (int i = 0; i<20;i++){
        for (int j=0;j<39;j++){
            printf ("%6d", ast [i] [j]);
        }
    printf("\n");
    }
}

int main(){
    pthread_t t1;
    int ID = 1;
    pthread_create(&t1, NULL, num, (void* )ID);
    sleep(2);
    
}
