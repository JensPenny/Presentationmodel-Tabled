package view;

import com.jgoodies.common.collect.ArrayListModel;
import model.Car;
import model.CarPM;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
public class CarListView {
    private JPanel mainPanel;
    private JButton btnPrintData;
    private JTable tblCarList;
    private JScrollPane pane;

    private final CarTableAdapter carAdapter;

    public CarListView(List<Car> modelList){
        ArrayListModel<Car> carPMListModel = new ArrayListModel<Car>(modelList);
        carAdapter = new CarTableAdapter(carPMListModel);
        tblCarList = new JTable();
        tblCarList.setModel(carAdapter);
        tblCarList.setDefaultRenderer(CarPM.class, new CarTableCellRenderer());
        tblCarList.setDefaultEditor(CarPM.class, new CarTableCellEditor());
        tblCarList.setRowHeight(50);
        tblCarList.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        tblCarList.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        tblCarList.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "none");
        tblCarList.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, InputEvent.SHIFT_DOWN_MASK), "none");
        pane = new JScrollPane(tblCarList);
        mainPanel.add(pane);
        btnPrintData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car model : carAdapter.getList() ){
                    System.out.println(model.toString());
                }
            }
        });
    }

    public JComponent getGui() {
        return mainPanel;
    }
}
