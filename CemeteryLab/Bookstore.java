import java.util.ArrayList;
public class Bookstore
{
  ArrayList<Book> inventory;

  public Bookstore()
  {
      inventory = new ArrayList<>();
  }

  public void addBook(Book b)
  {
    inventory.add(b);
  }

  public int numBooks()
  {
     return inventory.size();
  }

  public Book getBook(int index)
  {
     if (index < 0 || index >= inventory.size())
     {
        return null;
     }
     else
     {
        return inventory.get(index);
     }
  }
}

