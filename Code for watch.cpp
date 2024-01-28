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
