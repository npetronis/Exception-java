public class ClasseInutile
{   
    public void nePasInvoquer() throws ExceptionInutile
    {
        throw new ExceptionInutile();
    }

    public static void main(String []args)
    {   ClasseInutile c = new ClasseInutile();
        try
        {
            c.nePasInvoquer();
        }
        catch(ExceptionInutile e)
        {
            System.out.println(e);

        }
        
    }
}
class ExceptionInutile extends Exception
{
	@Override
	public String toString()
	{
		return "Je vous avais dit de ne pas invoquer cette fonction !";
	}
}