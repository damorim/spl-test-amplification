import java.io.PrintStream;
public class Stack {
  public Stack(  int maxSize
//#ifdef STATISTICS
  , StatisticObject s
//#endif
//#ifdef LOGGING
  , PrintStream loggingTarget
//#endif
){
    elementData=new Object[maxSize];
//#ifdef LOGGING
    logTarget=loggingTarget;
//#endif
  }
  private int size=0;
  private Object[] elementData;
//#ifdef LOGGING
  private PrintStream logTarget;
//#endif
  public boolean push(  Object o){
//#ifdef LOCKING
    Lock lock=lock();
//#endif
    elementData[size++]=o;
//#ifdef LOGGING
    log("pushed " + o + ", new size: "+ size);
//#endif
//#ifdef LOCKING
    unlock(lock);
//#endif
    return true;
  }
//#ifdef LOCKING
  private void unlock(  Lock lock){
  }
//#endif
  public Object pop(){
//#ifdef LOCKING
    Lock lock=lock();
//#endif
//#ifdef LOCKING
    if (lock == null) 
//#ifdef LOCKING
{
//#ifdef LOGGING
      log("lock failed for pop");
//#endif
      return null;
    }
//#endif
//#endif
    Object r=elementData[--size];
//#ifdef LOCKING
    unlock(lock);
//#endif
    return r;
  }
//#ifdef LOGGING
  private void log(  String msg){
    logTarget.println(msg);
  }
//#endif
//#ifdef LOCKING
  private Lock lock(){
    return new Lock();
  }
//#endif
}
