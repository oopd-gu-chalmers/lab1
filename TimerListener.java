import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class TimerListener implements ActionListener {
    private Game game;

    @Override
    public void actionPerformed(ActionEvent e) {
        game.update();
    }
}
