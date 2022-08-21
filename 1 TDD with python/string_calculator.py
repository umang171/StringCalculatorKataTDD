class StringCalculator:
    def add(self, numbers):
        if(numbers.startswith("//")):
            # For multiple length of delimiter
            if(numbers[2] == "["):
                delimiter = ""
                # delimiter index starts from here
                i = 3
                for ele in numbers[3:]:
                    i += 1
                    if(ele == "]"):
                        break
                    else:
                        delimiter += ele
            # For different types of delimiter
            else:
                delimiter = numbers[2]
                i = 3
            numbers = numbers[i:]
            numbers = numbers.replace(delimiter, ",")
        # Empty String
        if(len(numbers.strip()) == 0):
            return 0
        # String with one number
        elif(numbers.strip().count(",") < 1):
            if(int(numbers) < 0):
                raise ValueError("Negative not allowed:", numbers)
            return int(numbers)
        elif(numbers.startswith("0//") or (numbers.startswith("1//"))):
            if(numbers.startswith("0")):
                i = 0
            else:
                i = 1
            numbers = numbers[3:]
            numbers = numbers.split(",")
            sum = 0
            for ele in numbers:
                if(i % 2 == 0):
                    sum += int(ele)
                i += 1
            return sum
        # String with multiple digit number
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
