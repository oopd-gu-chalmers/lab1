import java.awt.*;

public class HanomagCarTransport extends CarTransporter{

    public HanomagCarTransport(){
        super(2,400, Color.BLUE, "HanomagCarTransport", 5, 6567);
    }

    protected double speedFactor(){
        return 4;
        }
    }
