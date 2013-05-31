package de.susebox.jtopas;

import java.util.Iterator;
import java.util.NoSuchElementException;

import de.susebox.jtopas.impl.PatternMatcher;

/**
 * An {@link java.util.Iterator} for pattern.
 */
final class PatternIterator implements Iterator {
  /**
   * constructor taking the calling {@link TokenizerProperties} object.
   *
   * @param parent  the caller
   */
  public PatternIterator(StandardTokenizerProperties parent) {
    _parent   = parent;
    synchronized(parent._patterns) {
      _iterator = parent._patterns.iterator();
    }
  }

  /**
   * the well known method from the {@link java.util.Iterator} interface.
   *
   * @return <code>true</code> if there are more {@link TokenizerProperty}
   *         elements, <code>false</code> otherwise
   */
  public boolean hasNext() {
    return _iterator.hasNext();
  }

  /**
   * Retrieve the next {@link TokenizerProperty} in this enumeration. 
   *
   * @return  the next keyword as a <code>TokenizerProperty</code>
   * @throws NoSuchElementException if there is no more element in this iterator
   */
  public Object next() throws NoSuchElementException {
    synchronized(this) {
      _currentData = (PatternMatcher)_iterator.next();
      return _currentData.getProperty();
    }
  }
  
  /**
   * This method is similar to {@link Tokenizer#removeKeyword}
   */
  public void remove() {
    synchronized(this) {
      _iterator.remove();
      _parent.notifyListeners(new TokenizerPropertyEvent(TokenizerPropertyEvent.PROPERTY_REMOVED, _currentData.getProperty()));
    }
  }

  // members
  private StandardTokenizerProperties _parent = null;
  private Iterator                    _iterator = null;
  private PatternMatcher              _currentData = null;
}