package view;

import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.adapter.ComboBoxAdapter;
import model.Car;
import model.CarPM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 */
public class SingleCarRowEdit implements ViewContract<Car> {
    private JTextField txtName;
    private JTextField txtWielen;
    private JTextField txtDeuren;
    private JComboBox cmbTypes;
    private JPanel mainPanel;

    private CarPM presentationModel;

    public SingleCarRowEdit(CarPM model){
        this.presentationModel = model;
        setKeyMap();
        //setBindings();
        cmbTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("comboBoxEdited")) {
                    getPresentationModel().getSelectedTypeHolder().setValue(cmbTypes.getSelectedItem());
                }
            }
        });
    }

    /**
     * Miniscule hack om te zorgen dat die tabs correct werken. Tabs afzetten van cell en dit component dit zelf
     * compleet laten afhandelen. Kan geabstraheerd worden
     */
    private void setKeyMap() {
        Set<AWTKeyStroke> strokes = new HashSet<AWTKeyStroke>();
        KeyStroke tab = KeyStroke.getKeyStroke("TAB");
        strokes.add(tab);
        txtName.setFocusTraversalKeys(JComponent.WHEN_FOCUSED, strokes);
        txtDeuren.setFocusTraversalKeys(JComponent.WHEN_FOCUSED, strokes);
        txtWielen.setFocusTraversalKeys(JComponent.WHEN_FOCUSED, strokes);
        //Kan evt een actie worden gestuurd naar table indien op cmb een tab gedaan wordt
    }

    public CarPM getPresentationModel(){
        return this.presentationModel;
    }

    public void setBindings(){
        Bindings.bind(txtName, presentationModel.getNameValueModel());
        Bindings.bind(txtWielen, presentationModel.getWheelValueModel());
        Bindings.bind(txtDeuren, presentationModel.getDoorValueModel());
        ComboBoxAdapter adapter = new ComboBoxAdapter((ListModel)presentationModel.getPossibleTypeListModel(), presentationModel.getSelectedTypeHolder());
        cmbTypes.setModel(adapter);
    }

    public void setDataOnce(){
        txtName.setText(presentationModel.getNameValueModel().getValue().toString());
        txtDeuren.setText(presentationModel.getDoorValueModel().getValue().toString());
        txtWielen.setText(presentationModel.getWheelValueModel().getValue().toString());
        ComboBoxAdapter adapter = new ComboBoxAdapter((ListModel)presentationModel.getPossibleTypeListModel(), presentationModel.getSelectedTypeHolder());
        cmbTypes.setModel(adapter);
    }

    @Override
    public Car getModel() {
        return presentationModel.getBean();
    }

    @Override
    public void setModel(final Car model) {
        presentationModel.setBean(model);
    }

    public JComponent getGui() {
        return mainPanel;
    }
}
