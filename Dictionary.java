import java.util.*;
class Dictionary {
  private ArrayList<Pair> data;

  public Dictionary(){
    data = new ArrayList<Pair>();
  }
  protected ArrayList<Pair> getData(){ //protected only lets subclasses use this
    return data;
  }
  public Dictionary(String[] words, String[] definitions){
    data = new ArrayList<Pair>();
    for(int i = 0, i < words.length; i++){
      data.add(new Pair(words[i],definitions[i]));
    }
  }
  public void addEntry(String word, String def){
    data.add(new Pair(word,def));
  }
  public String getDef(String a){
    for(int i = 0; i < data.size(); i++){
      if(data.get(i).getKey().equals(a)){
        return data.get(i).getValue();
      }
    }
    return "Definition not found.";
  }
  public boolean randomFlashCard(){
    int x = (int)Math.random() * (data.size()-1);
    System.out.println("DEF: "+data.get(x).getValue());
    Scanner s = new Scanner(System.in);
    System.out.println("Enter Word:");
    String g = s.nextLine();
    s.close();
    if(g.equals(data.get(x).getValue())){
      System.out.println("Correct");
      return true;
    }
    System.out.println("Incorrect");
    return false;
  }
  
}