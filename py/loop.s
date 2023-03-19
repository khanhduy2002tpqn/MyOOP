.section .data
    msg:
        .string "aaa\n"
        msgLen = . - msg

.section .bss
    .lcomm output, 4

.section .text
	.globl _start

_start:
    movl $0, %r15d
    movl $20, %r14d

    jmp loop

loop:
    addl $1, %r15d
    movl %r15d, %r13d
    addl $48, %r13d
    movl %r13d, (output)

    movl $4, %eax
	movl $1, %ebx
	movl $output, %ecx
	movl $4, %edx
	int $0x80

    cmpl %r15d, %r14d
    jg loop

    movl $1, %eax
    int $0x80

    
