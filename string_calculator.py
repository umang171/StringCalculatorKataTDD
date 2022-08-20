class StringCalculator:
    def add(self, numbers):
        if(len(numbers.strip()) == 0):
            return 0
        elif(numbers.strip().count(",") < 1):
            if(int(numbers) < 0):
                raise ValueError("Negative value passed:")
            return int(numbers)
        elif(numbers.strip().count(",") >= 1):
            sum = 0
            numberlist = numbers.strip().split(",")
            for number in numberlist:
                if(not number.isdigit()):
                    sum += (ord(number)-96)
                else:
                    sum += int(number)
            return sum
