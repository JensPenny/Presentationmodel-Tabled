import model.Car;
import model.CarPM;
import view.CarListView;

import javax.swing.*;
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

        List<Car> modelList = new ArrayList<Car>();
        modelList.add(c1);
        modelList.add(bike);
        modelList.add(tank);
        modelList.add(lastCar);
        modelList.add(editableCar);
        CarListView view = new CarListView(modelList);

        JFrame frame = new JFrame("Test: Editable list");
        frame.setDefaultCloseOperation(2);
        frame.add(view.getGui());
        frame.pack();
        frame.setVisible(true);
    }
}
