package produccion.values.valueObject;

import generic.ValueObject;

import java.util.Objects;
import java.util.Set;

import static produccion.enums.WeightUnit.KILOGRAMS;
import static produccion.enums.WeightUnit.POUNDS;

public class Stock implements ValueObject<Stock.Props> {

    private Set<StockDetail> stockList;

    private Quantity totalStock;

    public Stock(Set<StockDetail> stockList) {
        this.stockList = Objects.requireNonNull(stockList);
        this.totalStock = generateTotalStock(stockList);
    }

    public Stock(){}

    public Quantity generateTotalStock(Set<StockDetail> list){
        double total = 0.0;
        for (StockDetail detail : list) {
            switch (detail.value().presentation().value().quantity().value().unitOfMeasurement()) {
                case POUNDS:
                    total += detail.value().presentation().value().quantity().value().quantity() / 2.204;
                    break;
                case KILOGRAMS:
                    total += detail.value().presentation().value().quantity().value().quantity();
                    break;
            }
        }
        if(total == 0){
            return new Quantity();
        }else{
            return new Quantity((int) total, KILOGRAMS);}
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Set<StockDetail> stockList() {
                return stockList;
            }

            @Override
            public Quantity totalStock() {
                return totalStock;
            }
        };
    }

    public interface Props {
        Set<StockDetail> stockList();
        Quantity totalStock();
    }
}