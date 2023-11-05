import java.time.LocalDate;
class MonException extends Exception
{
    public MonException()
    {
        System.out.println("Exception monException has been raised...");
    }
    
    public String toString()
    {
      return "L'année de naissance ne peux pas etre dans le futur ";
    }
}
public class Utilisateur
{
    int anneeNaissance;

    public Utilisateur(int anneeNaissance)
    {
        this.anneeNaissance = anneeNaissance;
    }
    public int age() throws MonException
    {  
        int age = LocalDate.now().getYear() - this.anneeNaissance;
        if (age < 0)
            throw new MonException();
        return (age);
    }

    public static void main(String [] args)
    {
        Utilisateur u = new Utilisateur(2000);
        try
        {
            System.out.println(u.age());
        }
        catch (MonException e)
		{
			System.out.println(e);
		}
        
    }
}



