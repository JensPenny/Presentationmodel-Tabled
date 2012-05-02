package carexample.view;

import com.jgoodies.common.collect.ArrayListModel;
import carexample.model.Car;
import view.MyTableAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */
public class CarTableAdapter extends MyTableAdapter<Car> {

    public CarTableAdapter(ArrayListModel<Car> carModelList){
        super(carModelList);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return "Car";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Car.class;
    }
}
