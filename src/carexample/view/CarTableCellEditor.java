package carexample.view;

import carexample.model.Car;
import view.ViewContract;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public class CarTableCellEditor extends AbstractCellEditor implements TableCellEditor {

    private Car model;

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        model = (Car)value;
        SingleCarRowEdit view = new SingleCarRowEdit(new CarPM(model));
        return view.getGui();
    }

    @Override
    public Object getCellEditorValue() {
        //Waarschuwing: wordt niet aangeroepen als venster gesloten OF venster resized
        System.out.printf("Commit hier model: " + model.toString());
        return null;
    }
}
