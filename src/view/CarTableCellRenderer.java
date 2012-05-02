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
public class CarTableCellRenderer extends AbstractObjectRenderer<Car> implements TableCellRenderer {

    public CarTableCellRenderer(){
        super(new SingleCarRowViewer(new Car()));
    }
}
