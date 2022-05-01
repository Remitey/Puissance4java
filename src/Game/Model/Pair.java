package Game.Model;

import java.util.Objects;

/**
 *
 * @param <T>
 */
public class Pair <T> {
    private T first;
    private T second;
    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public T getSecond() {
        return second;
    }
    public void setSecond(T second) {
        this.second = second;
    }
    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?> pair = (Pair<?>) o;
        return first.equals(pair.first) && second.equals(pair.second);
    }
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
