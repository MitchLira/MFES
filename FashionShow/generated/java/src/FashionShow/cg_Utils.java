package FashionShow;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class cg_Utils {
  public cg_Utils() {}

  public static Boolean isAfter(final Platform.Date date1, final Platform.Date date2) {

    if (date1.year.longValue() > date2.year.longValue()) {
      return true;

    } else {
      if (date1.year.longValue() < date2.year.longValue()) {
        return false;

      } else {
        if (date1.month.longValue() > date2.month.longValue()) {
          return true;

        } else {
          if (date1.month.longValue() < date2.month.longValue()) {
            return true;

          } else {
            if (date1.day.longValue() > date2.day.longValue()) {
              return true;

            } else {
              return false;
            }
          }
        }
      }
    }
  }

  public String toString() {

    return "cg_Utils{}";
  }
  
  public static boolean isNumeric(String str)  
  {  
    try  
    {  
      int d = Integer.parseInt(str);  
    }  
    catch(NumberFormatException nfe)  
    {  
      return false;  
    }  
    return true;  
  }
  
}
