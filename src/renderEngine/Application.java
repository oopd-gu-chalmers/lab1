package renderEngine;

import assets.elements.ActiveElement;
import assets.elements.Element;
import assets.elements.vehicles.cars.passengerCars.Saab95;
import assets.elements.vehicles.cars.passengerCars.Volvo240;
import assets.elements.vehicles.cars.trucks.ScaniaL280;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Application {
    // The frame that represents this instance View of the MVC pattern

    public static void main(String[] args) {
        CarController cc = new CarController();
        SimulationTimer st = new SimulationTimer();
        CarView cv = new CarView("DrivingSim 1.0", cc);

        st.addObserver(cc);
        st.addObserver(cv);

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new ScaniaL280());
        cc.cars.get(1).setPosition(200, 0);
        cc.cars.get(2).setPosition(400,0);
        st.timer.start();
    }
}
