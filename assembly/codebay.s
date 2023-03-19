.section .data
text:
	.string "Enter a number (1-digit): "  

.section .bss
	.lcomm num1, 2
	.lcomm vag, 30

.section .text
	.globl _start
_start:
	
	movl $0, vag	
	
	movl $25, %edx	
	movl $text, %ecx			
	movl $1, %ebx	
	movl $4 , %eax	
	int $0x80		
	movl $1, %eax	
	
	
	movl $2, %edx	
	movl $3, %eax
	movl $0, %ebx
	movl $num1, %ecx
	int $0x80
	movl num1, %esi	
	sub $48, %esi	
	add %esi, vag	
	
	movl $25, %edx	
	movl $text, %ecx		
	movl $1, %ebx		
	movl $4 , %eax		
	int $0x80		
	movl $1, %eax	
	
	
	movl $2, %edx
	movl $3, %eax
	movl $0, %ebx
	movl $num1, %ecx
	int $0x80
	movl num1, %esi
	sub $48, %esi
	add %esi, vag
	
	movl $25, %edx
	movl $text, %ecx
	movl $1, %ebx
	movl $4 , %eax
	int $0x80
	movl $1, %eax
	
	
	movl $2, %edx
	movl $3, %eax
	movl $0, %ebx
	movl $num1, %ecx
	int $0x80
	movl num1, %esi
	sub $48, %esi
	add %esi, vag
	
	movl $25, %edx
	movl $text, %ecx
	movl $1, %ebx
	movl $4 , %eax
	int $0x80
	movl $1, %eax
	
	
	movl $2, %edx
	movl $3, %eax
	movl $0, %ebx
	movl $num1, %ecx
	int $0x80
	movl num1, %esi
	sub $48, %esi
	add %esi, vag
	
	movl $3, %esi	
	notl %esi		
	and %esi, vag	
	movl vag, %esi
	shrl $2, %esi	
	add $48, %esi	
	
	
	movl %esi, vag
	movl $2, %edx	
	movl $vag, %ecx
	movl $1, %ebx
	movl $4 , %eax
	int $0x80
	movl $1, %eax
	int $0x80
