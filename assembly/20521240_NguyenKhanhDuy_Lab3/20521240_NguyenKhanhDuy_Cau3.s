.section .data

    array:
        .int 2,0,5,2,1,2,4,0
    enter:
    .byte 13,10
    str1:
        .string "Tong: "
    str2:
        .string " la so chan"
    str3:
        .string " la so le"
.section .bss
            .lcomm num1, 4
            .lcomm num2, 4
            .lcomm num3, 4
.section .text
    .globl _start
_start:

    movl $str1, %ecx
    movl $7, %edx
    movl $1, %ebx
    movl $4, %eax
    int $0x80
    
    movl $array, %esi
    movl $0, %ebx
    movl (%esi), %eax
    addl %eax, %ebx

    movl 4(%esi), %eax
    addl %eax, %ebx

    movl 8(%esi), %eax
    addl %eax, %ebx

    movl 12(%esi), %eax
    addl %eax, %ebx

    movl 16(%esi), %eax
    addl %eax, %ebx

    movl 20(%esi), %eax
    addl %eax, %ebx

    movl 24(%esi), %eax
    addl %eax, %ebx

    movl 28(%esi), %eax
    addl %eax, %ebx

    movl %ebx, (num1)

    xor %edx, %edx
    movl (num1), %eax
    movl $10, %ecx
    divl %ecx

    addl $48, %edx
    addl $48, %eax
    movl %eax, (num2)
    movl %edx, (num3)


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

    xor %edx, %edx
    movl (num3), %eax
    movl $2, %ecx
    divl %ecx

    movl $0, %ebx
    cmpl %edx,%ebx
    je check

    movl $str3, %ecx
    movl $9, %edx
    movl $1, %ebx
    movl $4, %eax
    int $0x80

    jmp _exit

check:
    movl $str2, %ecx
    movl $11, %edx
    movl $1, %ebx
    movl $4, %eax
    int $0x80

_exit: 
    movl $enter, %ecx
    movl $2, %edx
    movl $1, %ebx
    movl $4, %eax
    int $0x80

    movl $1, %eax
    int $0x80