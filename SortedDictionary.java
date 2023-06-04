import java.util.*;
public class SortedDictionary extends Dictionary{
  ArrayList<Pair> data = getData();
  //since binary search is needed 2x, ill make a seperate fn for it:
  private int binarySearch(String word) {
    int l = 0;
    int h = data.size() - 1;
    while (l <= h) {
        int m = (l + h) / 2;
        int c = word.compareTo(data.get(m).getKey()); 
        if (c < 0) {
            h = m - 1;
        } else if (c > 0) {
            l = m + 1;
        } else {
            return m;
        }
    }
    return l;
  }

  public void addEntry(String word, String def) {
      int index = binarySearch(word);
      data.add(index, new Pair(word, def));
  }


  public String getDef(String word) {
      int index = binarySearch(word);
      if (index >= 0) {
          return data.get(index).getValue();
      }
      return "Definition not found.";
  }
  
}