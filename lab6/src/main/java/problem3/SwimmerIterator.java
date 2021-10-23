package problem3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import problem2.Swimmer;

public class SwimmerIterator implements Iterator<Swimmer> {

  private List<Swimmer> qualifiedSwimmers;
  private static final Integer MIN_BUTTERFLY_TIMES = 5;
  private static final Double QUALIFICATION_TIME = 26.17;


  public SwimmerIterator(List<Swimmer> swimmers){
   this.qualifiedSwimmers = this.getQualifiedSwimmers(swimmers);
  }

  private List<Swimmer> getQualifiedSwimmers(List<Swimmer> swimmers){
    List<Swimmer> qualifiedSwimmers = new ArrayList<Swimmer>();

    for(Swimmer swimmer: swimmers){
      if(swimmer.getButterfly50mTimes().size() >= MIN_BUTTERFLY_TIMES && checkQualifyingFreestyleSwimTimes(swimmer))
        qualifiedSwimmers.add(swimmer);
    }
    return qualifiedSwimmers;
  }

  private Boolean checkQualifyingFreestyleSwimTimes(Swimmer swimmer){
    for(Double swimTime: swimmer.getFreestyle50mTimes()){
      if(swimTime <= QUALIFICATION_TIME)
        return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if the iteration has more elements.
   * (In other words, returns {@code true} if {@link #next} would
   * return an element rather than throwing an exception.)
   *
   * @return {@code true} if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    return qualifiedSwimmers.size() > 0;
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Swimmer next() throws NoSuchElementException {
    return qualifiedSwimmers.remove(0);
  }

  /**
   * Removes from the underlying collection the last element returned
   * by this iterator (optional operation).  This method can be called
   * only once per call to {@link #next}.
   * <p>
   * The behavior of an iterator is unspecified if the underlying collection
   * is modified while the iteration is in progress in any way other than by
   * calling this method, unless an overriding class has specified a
   * concurrent modification policy.
   * <p>
   * The behavior of an iterator is unspecified if this method is called
   * after a call to the {@link #forEachRemaining forEachRemaining} method.
   *
   * @throws UnsupportedOperationException if the {@code remove}
   *                                       operation is not supported by this iterator
   * @throws IllegalStateException         if the {@code next} method has not
   *                                       yet been called, or the {@code remove} method has already
   *                                       been called after the last call to the {@code next}
   *                                       method
   * @implSpec The default implementation throws an instance of
   * {@link UnsupportedOperationException} and performs no other action.
   */
}
