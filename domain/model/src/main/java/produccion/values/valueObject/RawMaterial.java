package produccion.values.valueObject;

import generic.ValueObject;

import java.util.Objects;

public class RawMaterial implements ValueObject<RawMaterial.Props> {

    private String name;
    private Quantity quantity;
    private Information information;

    public RawMaterial(String name, Quantity quantity, Information information) {

        this.name = Objects.requireNonNull(validateName(name));
        this.quantity = Objects.requireNonNull(quantity);
        this.information = Objects.requireNonNull(information);
    }

    public RawMaterial(String name, Quantity quantity) {

        this.name = Objects.requireNonNull(validateName(name));
        this.quantity = Objects.requireNonNull(quantity);
    }

    private String validateName(String name){
        if (name.length() > 30) {
            throw new IllegalArgumentException("The name cannot have more than 30 characters");
        }
        return name;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String name() {
                return name;
            }

            @Override
            public Quantity quantity() {
                return quantity;
            }

            @Override
            public Information information() {
                return information;
            }
        };
    }

    public interface Props {

        String name ();

        Quantity quantity();

        Information information();

    }
}
