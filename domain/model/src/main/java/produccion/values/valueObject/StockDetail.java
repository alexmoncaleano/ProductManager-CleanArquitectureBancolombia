package produccion.values.valueObject;

import generic.ValueObject;

import java.util.Objects;

public class StockDetail  implements ValueObject<StockDetail.Props> {

    private Integer units;
    private Presentation presentation;

    public StockDetail(Integer units, Presentation presentation) {
        if(units <= 0){
            throw new IllegalArgumentException("Units cannot be 0 or negative");
        }
        this.units = Objects.requireNonNull(units, "Units cannot be null");
        this.presentation = Objects.requireNonNull(presentation, "Presentation is required");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer units() {
                return units;
            }

            @Override
            public Presentation presentation() {
                return presentation;
            }
        };
    }

    public interface Props{
        Integer units();
        Presentation presentation();
    }
}
