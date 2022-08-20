class StringCalculator:
    def add(self, numbers):
        if(len(numbers.strip()) == 0):
            return 0
        elif(len(numbers.strip()) == 1):
            return int(numbers)
        elif(numbers.strip().count(",") >= 1):
            numberlist = numbers.strip().split(",")
            numberlist = list(map(lambda x: int(x), numberlist))
            return sum(numberlist)
