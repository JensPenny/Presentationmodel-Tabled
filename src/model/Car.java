package model;

import com.jgoodies.binding.beans.Model;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 9:33
 * To change this template use File | Settings | File Templates.
 */
public class Car extends Model {

    public final static String DOORS_PROPERTY_NAME = "doors";
    public final static String TYPE_PROPERTY_NAME = "type";
    public final static String NAME_PROPERTY_NAME = "name";
    public final static String WHEELS_PROPERTY_NAME = "wheels";

    public enum Type {OFFROAD, CITYCAR, TANK};

    private Long doors = 0L;     //Long, want anders moet ik mijn eigen converters schrijven of iets te lang hierop zoeken:(
    private String type;
    private String name;
    private Long wheels = 0L;

    public Car(){
        this.name = "unknown";
        this.type = Type.CITYCAR.toString();
    }

    public Car(long doors, Type type, String name, long wheels){
        this.doors = doors;
        this.type = type.toString();
        this.name = name;
        this.wheels = wheels;
    }

    public Long getDoors() {
        return doors;
    }

    public void setDoors(Long doors) {
        this.doors = doors;
    }

    public Type getType() {
        return Type.valueOf(type);
    }

    public void setType(Type type) {
        this.type = type.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWheels() {
        return wheels;
    }

    public void setWheels(Long wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("naam: " + name);
        builder.append(" Wielen: " + wheels);
        builder.append(" Deuren: " + doors);
        builder.append(" Type: " + type);
        return  builder.toString();
    }
}
