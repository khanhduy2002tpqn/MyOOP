.section .data
    str:
        .string "Enter your number: "
    enter:
    .byte 13,10
    str1: 
        .string "Tang dan"
    str2: 
        .string "Ko tang dan"
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


    movl $4, %edx	
	movl $3, %eax
	movl $0, %ebx
	movl $num1, %ecx
	int $0x80

    movl $num1, %eax
    mov (%eax), %cl

    mov 1(%eax), %bl

    sub $48, %cl
    sub $48, %bl
    
    cmp %bl, %cl
    jg check2

    mov 2(%eax), %cl
    sub $48, %cl

    cmp %cl, %bl
    jg check2

    movl $4, %eax
    movl $1, %ebx
    movl $str1, %ecx
    movl $8, %edx
    int $0x80

    jmp _exit

check2:
    
    movl $4, %eax
    movl $1, %ebx
    movl $str2, %ecx
    movl $11, %edx
    int $0x80

   
_exit:

    movl $enter, %ecx
    movl $2, %edx
    movl $1, %ebx
    movl $4, %eax
    int $0x80
    movl $1, %eax
    int $0x80