package produccion.events;

import generic.DomainEvent;
import produccion.values.valueObject.Information;
import produccion.values.valueObject.Quantity;
import produccion.values.valueObject.RawMaterial;

import java.util.HashSet;

public class RawMaterialCreated extends DomainEvent {
    private final String name;
    private final Quantity quantity;

    public RawMaterialCreated(String name, Quantity quantity, Information information) {
        super("RawMaterial.RawMaterialCreated");
        this.name = name;
        this.quantity = quantity;
        new NumberElementsCreated(new HashSet<RawMaterial>());
    }

    public RawMaterialCreated(String name, Quantity quantity) {
        super("RawMaterial.RawMaterialCreated");
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
