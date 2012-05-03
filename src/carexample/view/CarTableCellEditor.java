package carexample.view;

import carexample.model.Car;
import view.EditorViewContract;
import view.MyEditor;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public class CarTableCellEditor extends MyEditor<Car> {

    @Override
    protected EditorViewContract<Car> prepareEditor(Car car) {
        return new SingleCarRowEdit(new CarPM(getModel()));
    }

}
