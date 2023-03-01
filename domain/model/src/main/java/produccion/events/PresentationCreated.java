package produccion.events;

import generic.DomainEvent;
import produccion.values.valueObject.Price;
import produccion.values.valueObject.Quantity;

public class PresentationCreated extends DomainEvent {

    private final Quantity quantity;
    private final Price price;


    public PresentationCreated(Quantity quantity, Price price) {
        super("Presentation.PresentationCreated");
        this.quantity = quantity;
        this.price = price;
    }

    public Quantity getQuantity(){
        return quantity;
    }
    public Price getPrice(){
        return price;
    }
}






