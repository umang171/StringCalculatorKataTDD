import unittest
from string_calculator import StringCalculator


class TestStringCalculator(unittest.TestCase):
    def setUp(self):
        self.obj = StringCalculator()

    def test_string_is_empty(self):
        self.assertEqual(self.obj.add(" "), 0)
        self.assertEqual(self.obj.add(""), 0)

    def test_number_is_one_digit(self):
        self.assertEqual(self.obj.add("1"), 1)
        self.assertEqual(self.obj.add("3"), 3)

    def test_number_is_two_digit(self):
        self.assertEqual(self.obj.add("1,2"), 3)
        self.assertEqual(self.obj.add("13,7"), 20)

    def test_number_is_unknown_digit_number(self):
        self.assertEqual(self.obj.add("1,2,3"), 6)
