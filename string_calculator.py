class StringCalculator:
    def add(self, numbers):
        if(len(numbers.strip()) == 0):
            return 0
        elif(len(numbers.strip()) == 1):
            return int(numbers)
