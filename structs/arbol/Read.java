/**
* laft.flyzx@gmail.com
* @author Luis Angel Farelo Toledo
*/

package structs.arbol;

public final class Read{

  private static char character(){
    try{
      return (char) System.in.read();
    }catch(Exception e){
      return character();
    }
  }

  private static String line(){
    char character = character();
    if(character == '\n')return character + "";
    return character + line();
  }

  public static String line(String text){
    System.out.print(text);
    return line().trim();
  }

  public static char character(String text){
    try{
      return line(text).charAt(0);
    }catch(Exception e){
      return line(text).charAt(0);
    }
  }

}
