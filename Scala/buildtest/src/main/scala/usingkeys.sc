def sqrt(x: Double) = {

  def abs = (x: Double) => if (x < 0) -x else x

  def improve(guess: Double, x: Double) = (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) < 0.001

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  sqrtIter(1.0, x)

}

println(sqrt(2))

// { } On scala, you can use { } to define a block of code.
// The last expression in the block is the return value of the block.