package carexample;

import carexample.model.Car;
import carexample.view.CarListView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 10:58
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Car c1 = new Car(4, Car.Type.CITYCAR, "Testcar 1", 4 );
        Car bike = new Car(0, Car.Type.CITYCAR, "Testfiets", 2);
        Car tank = new Car(1, Car.Type.TANK, "Tank", 2);
        Car lastCar = new Car(8, Car.Type.OFFROAD, "Offroad", 8);
        Car editableCar = new Car();

        final List<Car> modelList = new ArrayList<Car>();
        modelList.add(c1);
        modelList.add(bike);
        modelList.add(tank);
        modelList.add(lastCar);
        modelList.add(editableCar);
        final CarListView view = new CarListView(modelList);

        final Box vbox = Box.createVerticalBox();
        vbox.add(view.getGui());
        vbox.add(new JButton(new AbstractAction("Print the object data") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (Car model : view.getObjects() ){
                            System.out.println(model.toString());
                        }
                    }
                }));
        
        JFrame frame = new JFrame("Test: Editable list");
        frame.setDefaultCloseOperation(2);
        frame.add(vbox);
        frame.setSize(1100,400);
        frame.setVisible(true);

    }
}
