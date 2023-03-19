.section .bss
	.lcomm input, 4

.section .text
	.globl _start

_start:
	movl $3, %eax
	movl $0, %ebx
	movl $input, %ecx
	movl $4, %edx
	int $0x80

	movl $input, %eax

	sub $32, (%eax)
	sub $32, 1(%eax)
	sub $32, 2(%eax)

	movl $4, %eax
	movl $1, %ebx
	movl $input, %ecx
	movl $4, %edx
	int $0x80

	movl $1, %eax
	int $0x80


