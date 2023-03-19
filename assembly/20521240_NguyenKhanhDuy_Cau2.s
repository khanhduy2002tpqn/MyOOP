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

    @Xuất màn hình chữ "Enter your number: "
    movl $18, %edx	
	movl $str, %ecx			
	movl $1, %ebx	
	movl $4 , %eax	
	int $0x80	

    @Nhập dữ liệu từ bàn phím
    movl $4, %edx	
	movl $3, %eax
	movl $0, %ebx
	movl $num1, %ecx
	int $0x80

    movl $num1, %eax

    @ move số thứ nhất vào thanh ghi %cl, move số thứ 2 vào thanh ghi bl 
    mov (%eax), %cl
    mov 1(%eax), %bl
    
    @Chuyển chuổi thành int 
    sub $48, %cl
    sub $48, %bl
    
    @So sánh nếu số thứ nhất lớn hơn số thứ 2 thì nhảy đến hàm check2 xuất ra màn hình "Ko tang dan"
    @Ngược lại tiếp tục so sáng với số thứ 3
    cmp %bl, %cl
    jg check2

    @So sáng số thứ 2 với số thứ 3 nếu lớn hơn nhảy đến hàm check2 xuất ra màn hình "Ko tang dan"
    @Ngược lại thì xuất ra màn hình "Tang dan"
    mov 2(%eax), %cl
    sub $48, %cl
    cmp %cl, %bl
    jg check2

    @xuất chuổi "Tang dan" ra màn hình
    movl $4, %eax
    movl $1, %ebx
    movl $str1, %ecx
    movl $8, %edx
    int $0x80
    jmp _exit

check2:
    @xuất chuổi "Tang dan" ra màn hình
    movl $4, %eax
    movl $1, %ebx
    movl $str2, %ecx
    movl $11, %edx
    int $0x80
   
   @xuống dòng và dừng chương trình 
_exit:

    movl $enter, %ecx
    movl $2, %edx
    movl $1, %ebx
    movl $4, %eax
    int $0x80
    movl $1, %eax
    int $0x80