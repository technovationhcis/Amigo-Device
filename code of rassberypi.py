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
