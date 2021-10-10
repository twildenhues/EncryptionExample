public class Pair<T, U> {

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    private T first;
    private U second;

    public T getFirst() {
        return first;
    }
    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public void setFirst(T first) {
        this.first = first;
    }
}
