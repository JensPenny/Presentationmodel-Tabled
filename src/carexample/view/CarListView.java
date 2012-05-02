package carexample.view;

import com.jgoodies.common.collect.ArrayListModel;
import carexample.model.Car;
import view.MyListView;
import view.MyTableAdapter;
import view.MyTableModelFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
public class CarListView extends MyListView<Car> {

    public CarListView(final List<Car> modelList) {
        super(Car.class, new MyTableModelFactory<Car>() {
            @Override
            public MyTableAdapter<Car> createModel(final ArrayListModel<Car> objectList) {
                return new CarTableAdapter(objectList);
            }
        }, modelList, new CarTableCellRenderer(), new CarTableCellEditor());
    }
}
