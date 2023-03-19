.section .data

    number:
        .int 123
    enter:
    .byte 13,10
.section .bss
            .lcomm num1, 4
            .lcomm num2, 4
            .lcomm num3, 4
.section .text
    .globl _start
_start:

    xor %edx, %edx
    movl (number), %eax
    movl $10, %ecx
    divl %ecx

    addl $48, %edx
    movl %edx, (num3)
    movl %eax, (num1)

    xor %edx, %edx
    movl (num1), %eax
    movl $10, %ecx
    divl %ecx

    addl $48, %edx
    addl $48, %eax
    movl %eax, (num1)
    movl %edx, (num2)


    movl $num1, %ecx
    movl $4, %edx
    movl $1, %ebx
    movl $4, %eax
    int $0x80
    
    movl $num2, %ecx
    movl $4, %edx
    movl $1, %ebx
    movl $4, %eax
    int $0x80

    movl $num3, %ecx
    movl $4, %edx
    movl $1, %ebx
    movl $4, %eax
    int $0x80

    movl $enter, %ecx
    movl $2, %edx
    movl $1, %ebx
    movl $4, %eax
    int $0x80

    movl $1, %eax
    int $0x80