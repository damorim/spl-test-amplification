package de.susebox.jtopas;

import java.util.Iterator;
import java.util.NoSuchElementException;

import de.susebox.java.lang.ExtRuntimeException;
import de.susebox.jtopas.impl.SequenceStore;

/**
 * Iterator for comments, strings and special sequences.
 * Instances of this inner class are returned when a call to one of the methods
 *<ul><li>
 *    {@link #getBlockComments}
 *</li><li>
 *    {@link #getLineComments}
 *</li><li>
 *    {@link #getStrings}
 *</li><li>
 *    {@link #getSpecialSequences}
 *</li></ul>
 * is done. Each element of the enumeration contains a {@link TokenizerProperty}
 * element, that in turn has the comment, special sequence etc. together with
 * its companion
 */
final class SpecialSequencesIterator implements Iterator {

  /**
   * constructor taking the calling <code>Tokenizer</code> and the type of the
   * {@link TokenizerProperty}. If the type is 0 then special sequences, line and 
   * block comments are returned in one iterator
   *
   * @param parent  the calling tokenizer
   * @param stores  which array of {@link de.susebox.jtopas.impl.SequenceStore} to use
   * @param type    type of the <code>TokenizerProperty</code> 
   */
  public SpecialSequencesIterator(StandardTokenizerProperties parent, SequenceStore[] stores, int type) {
    _type   = type;
    _parent = parent;
    _stores = stores;
  }

  /**
   * the well known method from the {@link java.util.Iterator} interface.
   *
   * @return <code>true</code> if there are more {@link TokenizerProperty}
   *         elements, <code>false</code> otherwise
   */
  public boolean hasNext() {
    synchronized(this) {
      if (_currentIterator != null && _currentIterator.hasNext()) {
        return true;
      }

      while (_stores != null && ++_currentIndex < _stores.length) {
        if (_stores[_currentIndex] != null) {
          _currentIterator = _stores[_currentIndex].getSpecialSequences(_type);
          if (_currentIterator.hasNext()) {
            return true;
          }
        }
      }
      return false;
    }
  }

  /**
   * Retrieve the next {@link TokenizerProperty} in this enumeration.
   *
   * @return a {@link TokenizerProperty} of the desired type or <code>null</code>
   * @throws NoSuchElementException if there is no more element in this iterator
   */
  public Object next() throws NoSuchElementException {
    synchronized(this) {
      if (! hasNext()) {
        throw new NoSuchElementException();
      }
      _currentElement = (TokenizerProperty)_currentIterator.next();
      return _currentElement;
    }
  }
  
  /**
   * Remove the current special sequence entry from the collection. This is an
   * alternative to {@link Tokenizer#removeSpecialSequence}.
   *
   * @throws  IllegalStateExcpetion if {@link #next} has not been called before or
   *          <code>remove</code> has been called already after the last <code>next</code>.
   */
  public void remove() throws IllegalStateException {
    synchronized(this) {
      // if current element is not set
      if (_currentElement == null) {
        throw new IllegalStateException();
      }
    
      // remove current element
      try {
        _currentIterator.remove();
        _parent.notifyListeners(new TokenizerPropertyEvent(TokenizerPropertyEvent.PROPERTY_REMOVED, _currentElement));
        _currentElement = null;
      } catch (Exception ex) {
        throw new ExtRuntimeException(ex, "While trying to remove current element of a SpecialSequencesIterator.");
      }
    }
  }


  // members
  private StandardTokenizerProperties _parent           = null;
  private SequenceStore[]             _stores           = null;
  private TokenizerProperty           _currentElement   = null;
  private Iterator                    _currentIterator  = null;
  private int                         _currentIndex     = -1;
  private int                         _type             = Token.UNKNOWN;
}
