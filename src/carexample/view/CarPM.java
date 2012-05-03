package carexample.view;

import carexample.model.Car;
import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.value.ConverterFactory;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.common.collect.ArrayListModel;

import java.text.NumberFormat;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 9:33
 * To change this template use File | Settings | File Templates.
 */
public class CarPM extends PresentationModel<Car> {
    private final ValueModel doorValueModel;
    private final ValueModel nameValueModel;
    private final ValueModel wheelValueModel;
    private final ValueModel selectedTypeModel;
    private final ArrayListModel possibleTypeListModel;


    public CarPM(Car bean) {
        super(bean);
        doorValueModel = ConverterFactory.createStringConverter(this.getModel(Car.DOORS_PROPERTY_NAME), NumberFormat.getNumberInstance());
        nameValueModel = this.getModel(Car.NAME_PROPERTY_NAME);
        wheelValueModel = ConverterFactory.createStringConverter(this.getModel(Car.WHEELS_PROPERTY_NAME), NumberFormat.getNumberInstance());
        selectedTypeModel = getModel(Car.TYPE_PROPERTY_NAME);
        possibleTypeListModel = new ArrayListModel<Car.Type>(Arrays.asList(Car.Type.values()));
    }


    public ValueModel getDoorValueModel() {
        return doorValueModel;
    }

    public ValueModel getNameValueModel() {
        return nameValueModel;
    }

    public ValueModel getWheelValueModel() {
        return wheelValueModel;
    }

    public ValueModel getSelectedTypeModel() {
        return selectedTypeModel;
    }

    public ArrayListModel getPossibleTypeListModel() {
        return possibleTypeListModel;
    }
}
