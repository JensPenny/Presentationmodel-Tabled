package carexample.view;

import com.jgoodies.binding.adapter.Bindings;
import carexample.model.Car;
import com.jgoodies.binding.list.SelectionInList;
import view.ViewContract;

import javax.swing.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
public class SingleCarRowViewer implements ViewContract<Car> {
    private JPanel mainPanel;
    private JLabel txtName;
    private JLabel txtWielen;
    private JLabel txtDeuren;
    private JComboBox cmbTypes;

    private final CarPM carPM;

    public SingleCarRowViewer(Car model) {
        this.carPM = new CarPM(model);
        setBindings();
    }

    public void setDataOnce() {

    }

    private Car getCar() {
        return carPM.getCar();
    }

    @Override
    public Car getModel() {
        return carPM.getBean();
    }

    @Override
    public void setModel(Car model) {
        carPM.setBean(model);
    }

    public JComponent getGui() {
        return mainPanel;
    }

    @Override
    public void setBindings() {
        Bindings.bind(txtName,carPM.getNameValueModel() );
        Bindings.bind(txtDeuren, carPM.getDoorValueModel());
        Bindings.bind(txtWielen, carPM.getWheelValueModel());
        Bindings.bind(cmbTypes, new SelectionInList<Object>((List) carPM.getPossibleTypeListModel(), carPM.getSelectedTypeModel()));
    }
}
