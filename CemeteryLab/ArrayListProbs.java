import java.util.*;
public class ArrayListProbs
{
   public ArrayListProbs(){}
   public void makeListAndPrint(int num, int limit)
   {
       Random rand = new Random(limit);
       ArrayList<Integer> arr = new ArrayList<>();
       for (int i = 0; i < num; i++){
           arr.add(rand.nextInt(limit) + 1);
        }
      System.out.println(arr);
   }

   public ArrayList<Integer> addOne(ArrayList<Integer> list)
   {
       for (int i = 0; i < list.size(); i++)
       {
           list.set(i, list.get(i) + 1);
       }
       return list;
   }

   public ArrayList<Integer> minToFront(ArrayList<Integer> list)
   {
       int min = list.get(0);
       for (int i = 0; i < list.size(); i++)
       {
           if (list.get(i) < min)
           {
               min = list.get(i);
           }
       }
       list.add(0, min);
       return list;
   }

   public ArrayList<String> removeDupes(ArrayList<String> list)
   {
       for (int i = list.size() - 1; i > 0; i--)
       {
           if (list.get(i).equals(list.get(i - 1)))
           {
               list.remove(i);
           }
       }
       return list;
   }

   public ArrayList<Integer> swapPairs(ArrayList<Integer> list)
   {
       int temp = list.get(0);
       for (int i = 0; i < list.size() - 1; i += 2)
       {
          temp = list.get(i);
          list.set(i, list.get(i + 1));
          list.set(i + 1, temp);
       }
       return list;
   }

   public ArrayList<String> removeLenN(ArrayList<String> list, int n)
   {
       for (int i = 0; i < list.size(); i++)
       {
           if (list.get(i).length() == n)
           {
               list.remove(i);
           }
       }
       return list;
   }

   public int dumbestPerson(ArrayList<Person> list)
   {
      int dumbIQ = list.get(0).getIQ();
      int index = 0;
      for (int i = 0; i < list.size(); i++)
      {
          if (list.get(i).getIQ() < dumbIQ)
          {
              dumbIQ = list.get(i).getIQ();
              index = i;
          }
      }
      return index;
   }

   public Book highestPricedBook(ArrayList<Book> list)
   {
       double price = list.get(0).getPrice();
       int index = 0;
       for (int i = 0; i < list.size(); i++)
       {
           if (list.get(i).getPrice() > price)
           {
               price = list.get(i).getPrice();
               index = i;
           }
       }
       Book high = list.get(index);
       return high;
   }

   public ArrayList<Book> banBook(ArrayList<Book> list, Book book)
   {
       for (int i = 0; i < list.size(); i++)
       {
           if (list.get(i).getTitle().equals(book.getTitle()))
           {
               list.remove(i);
           }
       }
       return list;
   }

   public double bookstoreValue(Bookstore store)
   {
       double total = 0.0;
       for (int i = 0; i < store.numBooks(); i++)
       {
           total += store.getBook(i).getPrice();
       }
       return total;
   }
}
