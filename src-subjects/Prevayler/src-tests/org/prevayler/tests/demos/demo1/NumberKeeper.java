package org.prevayler.tests.demos.demo1;
import java.util.ArrayList;
import java.util.List;
/** 
 * The NumberKeeper and all its references are the prevalent system.
 * i.e: They are the "business objects" and will be transparently persisted by Prevayler.
 */
public class NumberKeeper implements java.io.Serializable {
  private static final long serialVersionUID=2253937139530882022L;
  public final List numbers=new ArrayList();//private
  void keep(  int nextNumber){
    numbers.add(new Integer(nextNumber));
  }
  List numbers(){
    return numbers;
  }
  int lastNumber(){
    return numbers.isEmpty() ? 0 : ((Integer)numbers.get(numbers.size() - 1)).intValue();
  }
}
