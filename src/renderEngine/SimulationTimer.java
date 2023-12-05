package renderEngine;

import assets.elements.ActiveElement;
import assets.elements.Element;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SimulationTimer {
    // 20 updates per second = 50ms
    private final int delay = 50;

    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    //TODO
    // BAD PUBLIC
    public Timer timer = new Timer(delay, new TimerListener());

    private String news;
    private List<Channel> channels = new ArrayList<>();

    /** Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     **/
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setNews();
            //System.out.println("UPDATE OUT");
        }
    }


    public void addObserver(Channel channel) {
        this.channels.add(channel);
    }

    public void removeObserver(Channel channel) {
        this.channels.remove(channel);
    }

    public void setNews() {
        this.news = news;
        for (Channel channel : this.channels) {
            channel.update();
        }
    }

}
