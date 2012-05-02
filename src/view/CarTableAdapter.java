package view;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.common.collect.ArrayListModel;
import model.Car;
import model.CarPM;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */
public class CarTableAdapter extends AbstractTableAdapter {

    private final ArrayListModel<Car> carList;

    public CarTableAdapter(ArrayListModel<Car> carModelList){
        super(carModelList);
        this.carList = carModelList;
    }

    public List<Car> getList(){
        return carList;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return "Car";
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return (this.carList == null ) ? null : carList.get(rowIndex);
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return CarPM.class;
    }

    @Override
    public boolean isCellEditable(int columnIndex, int rowIndex) {
        return true;
    }
}
