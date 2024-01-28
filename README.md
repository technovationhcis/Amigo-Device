# Amigo-Device
The complexity and fragmentation of health records management present serious difficulties to the efficiency and quality of patient treatment facing the existing state of healthcare administration. There is frequently a lack of smooth information sharing in traditional paper-based and fragmented electronic systems, which causes delays, mistakes, and inefficiencies in patient care.An integrated health care management system is required with light to these obstacles. A system like this would increase data accuracy, automate repetitive jobs, and expedite administrative procedures—all of which would contribute to better patient care. This project enhances efficiency and accuracy. This technology seeks to revolutionise healthcare administration and improve patient outcomes by facilitating seamless information interchange and offering a unified platform for healthcare workers to view and update patient records.A smart device named "amigo" is developed, which is generally used to detect the illness of the patient and send notifications to the doctor by means of a long beep sound or a red alert. By using this , we can prevent or mitigate the further destruction caused. By this we conclude with the term,

"crave for save" !

This  project basically involves the usage of bluetooth module , wifi module , pulse sensor , SpO2 sensor to detect the illness immediately.We also, have the implementation of DJI inspire_3 which is basically a camera drone that roams around the hospital when the doctor is not under validation . This camera drone searches for the respective doctor and shows him the holographic image to the doctor. With the help of this, the doctor sends his nurses or he himself goes for the rescue. Additionally , we also have max cam_360, which automatically connects the radio waves with the signal waves (selected signal ) when the doctor is no where to be found. Due to this, upto a certain range, all devices under this signal emits a long sound

#HealthTechInnovation 🚑✨ Using Bluetooth, WiFi, pulse sensor, and SpO2 sensor, our project detects illness instantly! 📡 DJI Inspire_3 camera drone navigates hospitals, showing holographic images to doctors for quick response. 👨‍⚕️🚁 Max Cam_360 connects radio waves, emitting sound for rescue. #MedicalTech #Innovation #IoTHealthcare

HOLOGRAM CODE :
```
from gpiozero import LED
from time import sleep

# Define GPIO pin numbers for each LED segment
segments = {
    'A': 2,
    'B': 3,
    'C': 4,
    'D': 17,
    'E': 27,
    'F': 22,
    'G': 10,
    'DP': 9  # Decimal point (optional)
}

# Create LED objects for each segment
leds = {segment: LED(pin) for segment, pin in segments.items()}

# Define patterns for each digit (0-9)
digits = {
    0: ['A', 'B', 'C', 'D', 'E', 'F'],
    1: ['B', 'C'],
    2: ['A', 'B', 'G', 'E', 'D'],
    3: ['A', 'B', 'G', 'C', 'D'],
    4: ['F', 'G', 'B', 'C'],
    5: ['A', 'F', 'G', 'C', 'D'],
    6: ['A', 'F', 'G', 'C', 'D', 'E'],
    7: ['A', 'B', 'C'],
    8: ['A', 'B', 'C', 'D', 'E', 'F', 'G'],
    9: ['A', 'B', 'C', 'D', 'F', 'G']
}

# Function to display a digit
def display_digit(digit):
    for segment, led in leds.items():
        if segment in digits[digit]:
            led.on()
        else:
            led.off()

# Main loop to display numbers 0-9
try:
    while True:
        for num in range(10):
            display_digit(num)
            sleep(1)
finally:
    # Cleanup GPIO on exit
    for led in leds.values():
        led.off()
```
Cpp Code:
```
#include <wiringPi.h>
#include <iostream>
#include <vector>

// Define GPIO pin numbers for each LED segment
const std::vector<int> segments = {0, 2, 3, 4, 5, 6, 21, 22}; // Adjust pin numbers accordingly

// Function to initialize GPIO pins
void initializePins() {
    for (int pin : segments) {
        pinMode(pin, OUTPUT);
    }
}

// Function to display a digit
void displayDigit(int digit) {
    for (int i = 0; i < segments.size(); ++i) {
        digitalWrite(segments[i], (digit >> i) & 1);
    }
}

int main() {
    // Initialize WiringPi library
    if (wiringPiSetup() == -1) {
        std::cerr << "Failed to initialize WiringPi." << std::endl;
        return 1;
    }

    // Initialize GPIO pins
    initializePins();

    try {
        while (true) {
            // Display numbers 0-9
            for (int num = 0; num < 10; ++num) {
                displayDigit(num);
                delay(1000);  // 1 second delay
            }
        }
    } catch (...) {
        // Handle exceptions or cleanup if needed
    }

    // Cleanup GPIO on exit
    for (int pin : segments) {
        digitalWrite(pin, LOW);
    }

    return 0;
}

```
Java code
```
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HologramSimulation extends JFrame {
    private double angle = 0;

    public HologramSimulation() {
        setTitle("Hologram Simulation");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 0.02;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int size = 100;

        int[] x = {centerX - size, centerX + size, centerX + size, centerX - size};
        int[] y = {centerY - size, centerY - size, centerY + size, centerY + size};

        // Rotate the cube
        for (int i = 0; i < 4; i++) {
            int newX = centerX + (int) ((x[i] - centerX) * Math.cos(angle) - (y[i] - centerY) * Math.sin(angle));
            int newY = centerY + (int) ((x[i] - centerX) * Math.sin(angle) + (y[i] - centerY) * Math.cos(angle));

            x[i] = newX;
            y[i] = newY;
        }

        g2d.setColor(Color.BLUE);
        g2d.fillPolygon(x, y, 4);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HologramSimulation().setVisible(true);
            }
        });
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HologramSimulation extends JFrame {
    private double angle = 0;

    public HologramSimulation() {
        setTitle("Hologram Simulation");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 0.02;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int size = 100;

        int[] x = {centerX - size, centerX + size, centerX + size, centerX - size};
        int[] y = {centerY - size, centerY - size, centerY + size, centerY + size};

        // Rotate the cube
        for (int i = 0; i < 4; i++) {
            int newX = centerX + (int) ((x[i] - centerX) * Math.cos(angle) - (y[i] - centerY) * Math.sin(angle));
            int newY = centerY + (int) ((x[i] - centerX) * Math.sin(angle) + (y[i] - centerY) * Math.cos(angle));

            x[i] = newX;
            y[i] = newY;
        }

        g2d.setColor(Color.BLUE);
        g2d.fillPolygon(x, y, 4);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HologramSimulation().setVisible(true);
            }
        });
    }
}

```
Assembly language:
```
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

```
