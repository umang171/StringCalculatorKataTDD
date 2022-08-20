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

    def test_number_has_alphabets(self):
        self.assertEqual(self.obj.add("1,2,a,c"), 7)
        self.assertEqual(self.obj.add("z,1,26,a"), 54)

    def test_number_has_negative_digit(self):
        self.assertRaises(ValueError, self.obj.add, "-1")
        self.assertRaises(ValueError, self.obj.add, "-21")

    def test_number_has_multiple_negative_digits(self):
        self.assertRaises(ValueError, self.obj.add, "-1,-2,-3")

    def test_number_is_bigger_than_thousand(self):
        self.assertEqual(self.obj.add("10000,2,3"), 5)
        self.assertEqual(self.obj.add("300,1001,1,2000"), 301)

    def test_number_with_new_lines(self):
        self.assertEqual(self.obj.add("1\n,2,3"), 6)
