package util;

import java.util.Objects;

public class Tuple<First, Second> {
    public final First first;
    public final Second second;

    public Tuple(First first, Second second) {
        this.first = first;
        this.second = second;
    }

    public First getKey() {
        return first;
    }

    public Second getValue() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return first.equals(tuple.first) && second.equals(tuple.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

}
