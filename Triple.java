import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Triple<A, B, C> {
    private A first;
    private B second;
    private C third;

    //Refactorize: Can add the arraylist of triples here instead of you'd like to, like a class-attributes that consists of an arraylist hold all already created triples. Could then also-
    //- add findTripleByThirdElement as a class-method (static) here as well -> better design than to have it in CarController, which wouldn't really follow Seperation of Responsibility principle.

    public Triple(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;

    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public C getThird() {
        return third;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public void setThird(C third) {
        this.third = third;
    }
}



