.section .data
    str:
        .string "Enter your number: "
    rs:
        .string "Min is "
    enter:
    .byte 13,10
.section .bss
            .lcomm num1, 4
            .lcomm num2, 4
            .lcomm num3, 4
            .lcomm res, 4
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

    movl $18, %edx	
	movl $str, %ecx			
	movl $1, %ebx	
	movl $4 , %eax	
	int $0x80		
	movl $1, %eax

    movl $4, %edx	
	movl $3, %eax
	movl $0, %ebx
	movl $num2, %ecx
	int $0x80
    

    movl $18, %edx	
	movl $str, %ecx			
	movl $1, %ebx	
	movl $4 , %eax	
	int $0x80		
	movl $1, %eax

    movl $4, %edx	
	movl $3, %eax
	movl $0, %ebx
	movl $num3, %ecx
	int $0x80

    movl (num1), %esi 
    subl $48, %esi
    
    movl (num2), %edi 
    subl $48, %edi

    movl (num3), %esp 
    subl $48, %esp

    
    cmpl %edi, %esi
    jl check_third_var
    movl %edi, %esi

check_third_var:
    cmpl %esp, %esi
    jl _exit
    movl %esp, %esi
_exit:
    addl $'0, %esi
    movl %esi, (res)

    movl $4, %eax
    movl $1, %ebx
    movl $rs, %ecx
    movl $7, %edx
    int $0x80

    movl $res, %ecx
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