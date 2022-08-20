import unittest
from string_calculator import StringCalculator


class TestStringCalculator(unittest.TestCase):
    def setUp(self):
        self.obj = StringCalculator()

    def test_string_is_empty(self):
        self.assertEqual(self.obj.add(" "), 0)
