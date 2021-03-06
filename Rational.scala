class Rational(n: Int, d: Int) extends Ordered[Rational] {
    require(d != 0)
    private val g = gcd(n.abs, d.abs)
    val numer = n / g
    val denom = d / g
    override def toString = numer +"/"+ denom

    def this(n: Int) = this(n, 1) // auxiliary constructor

    def +(that: Rational): Rational = new Rational(numer * that.denom + that.numer * denom,denom * that.denom)
    def - (that: Rational): Rational = new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
    def - (i: Int): Rational = new Rational(numer - i * denom, denom)

    def lessThan(that: Rational) = this.numer * that.denom < that.numer * this.denom
    def max(that: Rational) = if (this.lessThan(that)) that else this

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
object Rational { implicit def intToRational(x: Int) = new Rational(x)}

val rational1 = new Rational(1,2)
val rational2 = new Rational(3,2)
val rational3 = new Rational(3)
val add = rational1 + rational2
val add2 = 2 + rational2
val lessThan = rational1 lessThan rational2
val max = rational1 max rational2
println(add)
println(add2)
println(lessThan)
println(max)
println(rational3)
