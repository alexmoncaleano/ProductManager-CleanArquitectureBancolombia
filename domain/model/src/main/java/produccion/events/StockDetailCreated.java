package produccion.events;

import generic.DomainEvent;
import produccion.values.valueObject.Presentation;

public class StockDetailCreated extends DomainEvent {
    private final Integer units;
    private final Presentation presentation;

    public StockDetailCreated(Integer units, Presentation presentation) {
        super("StockDetail.StockDetailCreated");
        this.units = units;
        this.presentation = presentation;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public Integer getUnits() {
        return units;
    }
}