
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TripleManager<A, B, C> {
    private List<Triple<A, B, C>> triples;

    public TripleManager() {
        this.triples = new ArrayList<>();
    }

    public void add(A first, B second, C third) {
        Triple<A, B, C> newTriple = new Triple<>(first, second, third);
        triples.add(newTriple);
    }

    public boolean removeTripleByThird(C third) {
        return triples.removeIf(triple -> triple.getThird().equals(third));
    }

    public Triple<A, B, C> findTripleByThird(C thirdElement) {
        for (Triple<A, B, C> triple : triples) {
            if (triple.getThird().equals(thirdElement)) {
                return triple;
            }
        }
        return null; // Return null if no matching Triple is found
    }

    public List<A> getAllFirstElements() {
        return triples.stream()
                .map(Triple::getFirst)
                .collect(Collectors.toList());
    }

    public List<B> getAllSecondElements() {
        return triples.stream()
                .map(Triple::getSecond)
                .collect(Collectors.toList());
    }

}




