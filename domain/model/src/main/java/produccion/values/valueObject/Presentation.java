package produccion.values.valueObject;

import generic.ValueObject;

import java.util.Objects;

public class Presentation implements ValueObject<Presentation.Props> {

    private Quantity quantity;
    private Price price;

    public Presentation(Quantity quantity, Price price) {
        this.quantity = Objects.requireNonNull(quantity);
        this.price = Objects.requireNonNull(price);
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Quantity quantity() {
                return quantity;
            }

            @Override
            public Price price() {
                return price;
            }
        };
    }

    public interface Props {
        Quantity quantity();
        Price price();
    }
}
