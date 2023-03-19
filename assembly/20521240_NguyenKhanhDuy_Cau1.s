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
    @Xuất màn hình chữ "Enter your char: "
    movl $18, %edx	
	movl $str, %ecx			
	movl $1, %ebx	
	movl $4 , %eax	
	int $0x80	

    @Nhập dữ liệu từ bàn phím
    movl $2, %edx	
	movl $3, %eax
	movl $0, %ebx
	movl $num1, %ecx
	int $0x80

    

    @Lấy 1 byte tương ứng với ký tự đã nhập
    mov (num1), %cl

    @Song sánh kí tự đã nhập với kí tự 'A' nếu lớn hơn hoặc bằng sẽ nhãy qua hàm check nếu bé hơn thì dừng chương trình 
    mov $'A, %bl 
    cmp %bl, %cl
    jge check
    jmp _exit

check:

    @So sánh với kí tự 'Z' nếu nhỏ hơn hoặc thì xuất màn hình là chữ in hoa
    @ngược lại sẽ vào hành check2 để ktra có phải chữ cái thường hay không

    mov $'Z, %bl
    cmp %bl, %cl
    jg check2

    @Xuất ra màn hình chuổi "Chu hoa"
    movl $4, %eax
    movl $1, %ebx
    movl $str2, %ecx
    movl $8, %edx
    int $0x80

    jmp _exit

check2:

    @So sánh với ký tự 'a' nếu nhỏ hơn thì dữ liệu nhập không phải là kí tự dừng chương trình
    @Nếu lớn hơn hoặc bằng thì tiếp tục chương trình 
    mov $'a, %bl
    cmp %bl, %cl
    jl _exit
    
    @So sánh với ký tự 'z' nếu nhỏ hơn hoặc thì xuất ra màn hình là chữ thường, ngược lại dừng chương trình 
    mov $'z, %bl
    cmp %bl, %cl
    jg _exit

    @Xuất ra màn hình chuổi "Chu thuong"
    movl $4, %eax
    movl $1, %ebx
    movl $str1, %ecx
    movl $10, %edx
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