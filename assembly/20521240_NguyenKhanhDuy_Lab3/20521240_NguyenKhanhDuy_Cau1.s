.section .data
    str:
        .string "Enter your char: "
    enter:
    .byte 13,10
    str1: 
        .string "Chu thuong"
    str2: 
        .string "Chu Hoa"
.section .bss
            .lcomm num1, 4
            .lcomm char, 2
.section .text
    .globl _start
_start:

    movl $18, %edx	
	movl $str, %ecx			
	movl $1, %ebx	
	movl $4 , %eax	
	int $0x80	


    movl $2, %edx	
	movl $3, %eax
	movl $0, %ebx
	movl $num1, %ecx
	int $0x80

    


    mov (num1), %cl
    mov $'A, %bl 
    
    cmp %bl, %cl
    jge check

    movl $4, %eax
    movl $1, %ebx
    movl $num1, %ecx
    movl $8, %edx
    int $0x80

    jmp _exit
check:
    mov $'Z, %bl
    cmp %bl, %cl
    jg check2

    movl $4, %eax
    movl $1, %ebx
    movl $str2, %ecx
    movl $8, %edx
    int $0x80

    jmp _exit

check2:
    mov $'a, %bl
    cmp %bl, %cl
    jl _exit
    
    mov $'z, %bl
    cmp %bl, %cl
    jg _exit

    movl $4, %eax
    movl $1, %ebx
    movl $str1, %ecx
    movl $10, %edx
    int $0x80

   
_exit:

    movl $enter, %ecx
    movl $2, %edx
    movl $1, %ebx
    movl $4, %eax
    int $0x80
    movl $1, %eax
    int $0x80