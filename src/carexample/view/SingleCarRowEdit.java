package carexample.view;

import carexample.model.Car;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.list.SelectionInList;
import view.ViewContract;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
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
        setBindings();
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

    public void setBindings(){
        Bindings.bind(txtName, presentationModel.getNameValueModel());
        Bindings.bind(txtWielen, presentationModel.getWheelValueModel());
        Bindings.bind(txtDeuren, presentationModel.getDoorValueModel());
        Bindings.bind(cmbTypes, new SelectionInList<Object>((List) presentationModel.getPossibleTypeListModel(), presentationModel.getSelectedTypeHolder()));
    }

    public void setDataOnce(){
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
