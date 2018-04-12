// 1
def signum(value: Int) = if (value > 0) 1 else if (value < 0) -1 else 0
signum(25)
signum(-25)
signum(0)

// 2
{}

// 3
var x: AnyVal = 1
var y: Int = 2
x = y = 3
y

//4
println("Hello!")
for (i <- (0 to 10).reverse) println(i)
for (i <- 0 to 10; r = 10 - i) println(r)

// 5
def countdown(n: Int): Unit = for (i <- 0 to n reverse) println(i)
countdown(3)

// 6
var mul = 1L
var s = "Hello"
for (i <- s) mul *= i
mul

// 7
mul = 1L
"Hello".foreach(mul *= _)
mul

// 8
def product(s: String) = {
  var result = 1L
  s.foreach(result *= _)
  result
}
val productResult = product("Hello")

// 9
def productTailRec(s: String, acc: Long): Long = {
  if (s.length > 0) productTailRec(s.tail, acc * s.head) else acc
}
val productTailRecResult = productTailRec(s, 1L)

def productRec(s: String): Long = {
  if (s.length > 0) s.head * productRec(s.tail) else 1L
}
val productRecResult = productRec("Hello")

// 10
def pow(x: Double, n: Int): Double = {
  if (n > 0 && n % 2 == 0) {
    pow(x, n / 2) * pow(x, n / 2)
  } else if (n > 0 && n % 2 != 0) {
    x * pow(x, n - 1)
  } else if (n == 0) {
    1
  } else {
    1 / pow(x, -n)
  }
}
pow(2, 3)