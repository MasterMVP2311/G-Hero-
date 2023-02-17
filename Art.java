public class Art
{
    private String title;
    private String author;
    private int date;

    public Art(String t, String a, int d)
    {
        title = t;
        author = a;
        date = d;
    }

    public Art()
    {
        title = null;
        author = null;
        date = -1;
    }

    public String toString()
    {
        return "" + date;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setDate(int d)
    {
        date = d;
    }

    public boolean equals(Art e)
    {
        if (title == e.title && author == e.author)
        return true;
        return false;
    }
}
