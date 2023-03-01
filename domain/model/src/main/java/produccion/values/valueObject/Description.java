package produccion.values.valueObject;

import generic.ValueObject;

import java.util.Objects;

public class Description implements ValueObject<Description.Props>  {

    private String description;

    public Description(String description) {
        this.description = description;
    }

    public Description(){}

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String description() {
                return description;
            }
        };
    }

    public interface Props {
        String description();
    }
}