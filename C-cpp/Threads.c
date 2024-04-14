#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdint.h> // Para intptr_t

void *PrintHello(void *threadid) {
    intptr_t id = (intptr_t) threadid; // Convertendo para intptr_t
    for(int i = 0; i < 10; i++) {
        printf("Thread %ld: Olá mundo! %d\n", (long)id, i); // Convertendo de volta para long
        sleep(1);
    }
    pthread_exit(NULL); // Encerrar a thread
    return NULL;
}

int main() {
    pthread_t t1, t2; // Criando t1 e t2 do tipo thread
    intptr_t num1 = 1, num2 = 2; // Identificadores das threads

    printf("Main: criando a thread %ld\n", (long)num1);
    pthread_create(&t1, NULL, PrintHello, (void *) num1); // Criando thread 1

    printf("Main: criando a thread %ld\n", (long)num2);
    pthread_create(&t2, NULL, PrintHello, (void *) num2); // Criando thread 2

    // Aguardar a finalização das threads
    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    printf("Main: finalizando\n");
    return 0;
}

