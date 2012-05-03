package carexample.view;

import carexample.model.Car;
import view.EditableListView;
import view.EditorViewContract;
import view.EditorViewContractFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
public class CarListView extends EditableListView<Car> {

    public CarListView(final List<Car> modelList) {
        super(Car.class, modelList, new SingleCarRowViewer(new Car()), new EditorViewContractFactory<Car>() {
            public EditorViewContract<Car> create(Car car) {
                return new SingleCarRowEdit(new CarPM(car));
            }
        });
    }
}
