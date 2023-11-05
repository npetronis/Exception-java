public class division
{
    public static void main(String [] args)
    {
        try{
            double c = 1/0;
        }
        catch(ArithmeticException e)
        {
            System.out.println("eee");
        }
    }
}