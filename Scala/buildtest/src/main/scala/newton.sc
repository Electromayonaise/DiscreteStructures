def epsilon: Double = 0.0001

def abs(x: Double): Double = if (x < 0) -x else x

def power(x: Double, n: Int): Double =
  if (n == 0) 1
  else if (n % 2 == 0) power(x, n / 2) * power(x, n / 2)
  else x * power(x, n - 1)

def sqrtIter(guess: Double, x: Double): Double =
  if (abs(power(guess, 2) - x) < epsilon) guess
  else sqrtIter((guess + x / guess) / 2, x)

def sqrt(x: Double): Double = sqrtIter(1.0, x)

sqrt(2)