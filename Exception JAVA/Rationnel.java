//package encapsulation.corriges;
class ExceptionDenNull extends Exception
{
	@Override
	public String toString()
	{
		return "Le denominateur ne peut pas etre null";
	}
}
public class Rationnel
{
 private int num, den;

 /*-----------------------------------------------*/

 public Rationnel(int num, int den) throws ExceptionDenNull
 {
    this.num = num;
    if(den == 0)
        throw new ExceptionDenNull();
    this.den = den;

 }

 /*-----------------------------------------------*/

 public int getNum()
 {
  return num;
 }

 /*-----------------------------------------------*/

 public int getDen()
 {
  return den;
 }

 /*-----------------------------------------------*/

 public void setNum(int num)
 {
  this.num = num;
 }

 /*-----------------------------------------------*/

 public void setDen(int den) throws ExceptionDenNull
 {
  if (den != 0)
   this.den = den;
  else
   throw new ExceptionDenNull();
 }

 /*-----------------------------------------------*/

 public String toString()
 {
  return getNum() + "/" + getDen();
 }

 /*-----------------------------------------------*/

 public Rationnel copy() throws ExceptionDenNull
 {
  Rationnel r = new Rationnel(getNum(), getDen());
  return r;
 }

 /*-----------------------------------------------*/

 public Rationnel opposite() throws ExceptionDenNull
 {
  Rationnel r = copy();
  r.setNum(-r.getNum());
  return r;
 }

 /*-----------------------------------------------*/

 private static int pgcd(int a, int b) 
 {
  if (b == 0)
   return a;
  return pgcd(b, a % b);
 }

 public void reduce() throws ExceptionDenNull
 {
  int p = pgcd(getNum(), getDen());
  setNum(getNum() / p);
  setDen(getDen() / p);
 }

 /*-----------------------------------------------*/

 public boolean isPositive()
 {
  return num > 0 && den > 0 || num < 0 && den < 0;
 }

 /*-----------------------------------------------*/

 public Rationnel add(Rationnel other) throws ExceptionDenNull
 {
  Rationnel res = new Rationnel(getNum() * other.getDen() + getDen()
    * other.getNum(), getDen() * other.getDen());
  other.reduce();
  return res;
 }

 /*-----------------------------------------------*/

 public void addBis(Rationnel other) throws ExceptionDenNull
 {
  num = num * other.getDen() + den * other.getNum();
  den = den * other.getDen();
  reduce();
 }

 /*-----------------------------------------------*/

 public Rationnel multiply(Rationnel other) throws ExceptionDenNull
 {
  Rationnel res = new Rationnel(getNum() * other.getNum(), getDen()
    * other.getDen());
  other.reduce();
  return res;
 }

 /*-----------------------------------------------*/

 public Rationnel divide(Rationnel other) throws ExceptionDenNull
 {
  Rationnel res = new Rationnel(getNum() * other.getDen(), getDen()
    * other.getNum());
  other.reduce();
  return res;
 }

 /*-----------------------------------------------*/

 public int compareTo(Rationnel other) throws ExceptionDenNull
 {
  Rationnel sub = add(other.opposite());
  if (sub.isPositive())
   return 1;
  if (sub.opposite().isPositive())
   return -1;
  return 0;
 }

 /*-----------------------------------------------*/

 public static void main(String[] args)
 {
  Rationnel a, b;
    System.out.println(2/0);
  try
  {
  a = new Rationnel(1, 2);
  b = new Rationnel(0, 4);
  System.out.println("a = " + a);
  System.out.println("b = " + b);
  System.out.println("compareTo(" + a + ", " + b + ") = "
    + a.compareTo(b));
  System.out.println(a.copy());
  System.out.println(a.opposite());
  System.out.println(a.add(b));
  System.out.println(a.multiply(b));
  System.out.println(a.divide(b));  
  }
  catch(ExceptionDenNull e)
  {
    System.out.println(e);
  }
  
 }
}