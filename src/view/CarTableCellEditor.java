package view;

import model.CarPM;

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
    CarPM model;
    ViewContract view;

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        CarPM cellModel = (CarPM)value;
        model = cellModel;
        view = new SingleCarRowEdit(cellModel);
        view.setBindings();
        return view.getGui();
    }

    @Override
    public Object getCellEditorValue() {
        //Waarschuwing: wordt niet aangeroepen als venster gesloten OF venster resized
        System.out.printf("Commit hier model: " + model.getCar().toString());
        return null;
    }
}
