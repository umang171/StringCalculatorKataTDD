class StringCalculator:
    def add(self, numbers):
        if(numbers.startswith("//")):
            delimiter = numbers[2]
            numbers = numbers[3:]
            numbers = numbers.replace(delimiter, ",")
        if(len(numbers.strip()) == 0):
            return 0
        elif(numbers.strip().count(",") < 1):
            if(int(numbers) < 0):
                raise ValueError("Negative not allowed:", numbers)
            return int(numbers)
        elif(numbers.startswith("0//")):
            i = 0
            sum = 0
            numbers = numbers[3:]
            numbers = numbers.split(",")
            for ele in numbers:
                if(i % 2 == 0):
                    sum += int(ele)
                i += 1
            return sum
        elif(numbers.startswith("1//")):
            i = 0
            sum = 0
            numbers = numbers[3:]
            numbers = numbers.split(",")
            for ele in numbers:
                if(i % 2 != 0):
                    sum += int(ele)
                i += 1
            return sum
        else:
            sum = 0
            if(numbers.count("\n") != 0):
                numbers = numbers.replace("\n", ",")
            numberlist = numbers.strip().split(",")
            negative_values = []
            for number in numberlist:
                if(len(number) >= 2 and int(number) < 0):
                    negative_values.append(number)
                elif(not number.isdigit()):
                    if(not number.strip() == ""):
                        sum += (ord(number)-96)
                else:
                    if(not int(number) > 1000):
                        sum += int(number)
            if(len(negative_values) != 0):
                raise ValueError("Negatives not allowed", negative_values)
            return sum
