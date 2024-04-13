#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
 
void *PrintHello(void *threadid){
  long id;
  id = (long) threadid;
for(int i =0; i<10; i++){
    printf("Thread %ld: Olá mundo!%d\n", id,i);
    sleep(1);
    
}
return NULL;
}

int main(){
  pthread_t t1, t2; //criando t1 e t2 do tipo thread
  long num; //identificador da thread
  num = 1;
  printf("Main: criando a thread %ld\n", num);
  pthread_create(&t1, NULL, PrintHello, (void *)num);
  num = 2;
  printf("Main: criando a thread %ld\n", num);
  pthread_create(&t2, NULL, PrintHello, (void *)num); //criando thread 1
  
  for(int i =0; i<10; i++){
    printf("%d\n", i);
    sleep(1);
  }
 
  printf("Main: finalizando\n");
  return 0;
}