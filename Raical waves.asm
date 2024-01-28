section .data
    frequency dd 4          ; Frequency of the sine wave
    amplitude dd 10         ; Amplitude of the sine wave
    duration dd 2000000     ; Duration in microseconds
    sample_rate dd 44100    ; Audio sample rate

section .text
    global _start

_start:
    mov eax, 4              ; sys_write system call
    mov ebx, 1              ; file descriptor 1 (stdout)
    mov ecx, message        ; message to display
    mov edx, message_len    ; message length
    int 0x80                ; make system call

    ; Call function to generate and display sine wave
    call generate_sine_wave

    ; Exit the program
    mov eax, 1              ; sys_exit system call
    xor ebx, ebx            ; exit code 0
    int 0x80                ; make system call

generate_sine_wave:
    ; Your code to generate and display a sine wave goes here

    ; For simplicity, a placeholder message is displayed
    mov eax, 4              ; sys_write system call
    mov ebx, 1              ; file descriptor 1 (stdout)
    mov ecx, wave_message   ; wave message to display
    mov edx, wave_message_len ; wave message length
    int 0x80                ; make system call

    ret

section .data
    message db 'Assembly Wave Generator', 0xA
    message_len equ $ - message

    wave_message db 'Placeholder: Sine wave will be displayed here', 0xA
    wave_message_len equ $ - wave_message
