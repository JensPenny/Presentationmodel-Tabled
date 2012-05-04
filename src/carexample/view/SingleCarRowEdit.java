package carexample.view;

import carexample.model.Car;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.list.SelectionInList;
import view.EditorViewContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
public class SingleCarRowEdit implements EditorViewContract<Car> {
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
        cmbTypes.setFocusTraversalKeys(JComponent.WHEN_FOCUSED, strokes);
        cmbTypes.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);    //To change body of overridden methods use File | Settings | File Templates.
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("e.getOppositeComponent() = " + e.getOppositeComponent());
            }
        });
        cmbTypes.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("evt.getPropertyName() = " + evt.getPropertyName());
            }
        });
        //Kan evt een actie worden gestuurd naar table indien op cmb een tab gedaan wordt
    }

    public void setBindings(){
        Bindings.bind(txtName, presentationModel.getNameValueModel());
        Bindings.bind(txtWielen, presentationModel.getWheelValueModel());
        Bindings.bind(txtDeuren, presentationModel.getDoorValueModel());
        Bindings.bind(cmbTypes, new SelectionInList<Object>((List) presentationModel.getPossibleTypeListModel(), presentationModel.getSelectedTypeModel()));
    }


    @Override
    public void setModel(final Car model) {
        presentationModel.setBean(model);
    }

    public JComponent getGui() {
        return mainPanel;
    }


    public boolean isLastComponentInView(Component aComponent) {
        return cmbTypes == aComponent;
    }

    public void requestFocus() {
        txtName.requestFocus();
    }
}
