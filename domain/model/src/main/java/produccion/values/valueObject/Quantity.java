package produccion.values.valueObject;

import generic.ValueObject;
import produccion.enums.WeightUnit;

import java.util.Arrays;
import java.util.Objects;

public class Quantity implements ValueObject<Quantity.Props> {

    private Integer quantity;
    private WeightUnit unitOfMeasurement;

    public Quantity(Integer quantity, WeightUnit unitOfMeasurement) {
        if(quantity <= 0){
            throw new IllegalArgumentException(quantity + "Value cannot be negative or zero");
        }
        this.quantity = Objects.requireNonNull(quantity);

        if (!Arrays.asList(WeightUnit.values()).contains(unitOfMeasurement)) {
            throw new IllegalArgumentException("Invalid unit of measure: " + unitOfMeasurement);
        }
        this.unitOfMeasurement = Objects.requireNonNull(unitOfMeasurement);
    }

    public Quantity(){}

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer quantity() {
                return quantity;
            }

            @Override
            public WeightUnit unitOfMeasurement() {
                return unitOfMeasurement;
            }
        };
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "quantity=" + quantity +
                ", unitOfMeasurement=" + unitOfMeasurement.getSymbol() +
                '}';
    }

    public interface Props {
        Integer quantity ();
        WeightUnit unitOfMeasurement();
    }
}