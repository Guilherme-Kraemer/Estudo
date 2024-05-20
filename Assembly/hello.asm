section .data
    mensagem db "Hello world!", 0xA, 0x0

section .text
    global main

main:
    ; Escrever a mensagem na saída padrão (STDOUT)
    mov     rax, 0x1            ; syscall sys_write
    mov     rdi, 0x1            ; file descriptor STDOUT
    mov     rsi, mensagem       ; ponteiro para a mensagem
    mov     rdx, 14             ; comprimento da mensagem
    syscall

    ; Sair do programa
    mov     rax, 0x60           ; syscall sys_exit
    xor     rdi, rdi            ; código de saída 0
    syscall
