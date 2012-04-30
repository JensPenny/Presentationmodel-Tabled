package view;

import model.Car;
import model.CarPM;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 10:51
 * To change this template use File | Settings | File Templates.
 */
public class CarTableCellRenderer implements TableCellRenderer {
    private ViewContract tblComponent;

    public CarTableCellRenderer(){
        Car car = new Car();
        CarPM model = new CarPM(car);
        tblComponent = new SingleCarRowViewer(model);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        CarPM model = (CarPM)value;
        tblComponent.setPresentationModel(model);
        tblComponent.setDataOnce();
        tblComponent.getGui().getPreferredSize();
        return tblComponent.getGui();
    }
}
