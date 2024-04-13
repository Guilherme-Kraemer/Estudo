#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int ast[20][39]; // Define como um array de inteiros para armazenar valores inteiros

void *num(void* threadid) {
    int i, j;
    for (i = 0; i < 20; i++) {
        for (j = 0; j < 39; j++) {
            ast[i][j] = j;
        }
    }

    for (i = 0; i < 20; i++) {
        for (j = 0; j < 39; j++) {
            printf("%6d", ast[i][j]);
        }
        printf("\n");
    }

    pthread_exit(NULL); // Saindo da thread
}

int main() {
    pthread_t t1;
    int ID = 1;
    pthread_create(&t1, NULL, num, (void*)ID);
    pthread_join(t1, NULL); // Aguarda a thread terminar antes de sair

    return 0;
}

