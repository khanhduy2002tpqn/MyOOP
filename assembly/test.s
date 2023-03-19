.section .data
    number:
        .int 54
    enter:
        .string "\n"

.section .bss
    .lcomm a, 4
    .lcomm b, 4
    .lcomm c,4

.section .text
    .globl _start

_start:
    movl $0, %edx
    movl (number), %eax
    movl $10, %ecx
    divl %ecx

    addl $48, %eax
    addl $48, %edx

    movl %eax, (a)
    movl %edx, (b)

    movl $4, %eax
    movl $1, %ebx
    movl $a, %ecx
    movl $4, %edx
    int $0x80

    movl $0, %edx
    movl (number), %eax
    movl $10, %ecx
    divl %ecx

    addl $48, %eax
    addl $48, %edx

    movl $4, %eax
    movl $1, %ebx
    movl $b, %ecx
    movl $4, %edx
    int $0x80


    movl $1, %eax
    int $0x80


