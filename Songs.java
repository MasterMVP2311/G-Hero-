public class Songs extends Art
{
    String langauge;
    String genre;
    int released;

    public Songs(String t, String a, int d, String l, String g)
    {
        super(t, a, d);
        langauge = l;
        genre = g;
        released = -1;
    }

    public String toString()
    {
        return "" + released;
    }

    public String importantInfo()
    {
        return super.getTitle() + " released in " + released;
    }

    public void changeD(int d)
    {
        super.setDate(5);
        System.out.println("Your date has been successfully changed!");
        getTitle();
        
    }

    public boolean equals(Songs e)
    {
        if (super.getTitle() == e.getTitle() && super.getAuthor() == e.getAuthor())
        return true;
        return false;
    }

    
}
