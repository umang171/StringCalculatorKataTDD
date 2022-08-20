class StringCalculator:
    def add(self, numbers):
        if(len(numbers.strip()) == 0):
            return 0
        elif(numbers.strip().count(",") < 1):
            if(int(numbers) < 0):
                raise ValueError("Negative not allowed:", numbers)
            return int(numbers)
        elif(numbers.strip().count(",") >= 1):
            sum = 0
            numberlist = numbers.strip().split(",")
            negative_values = []
            for number in numberlist:
                if(len(number) >= 2 and int(number) < 0):
                    negative_values.append(number)
                elif(not number.isdigit()):
                    sum += (ord(number)-96)
                else:
                    sum += int(number)
            if(len(negative_values) != 0):
                raise ValueError("Negatives not allowed", negative_values)
            return sum
