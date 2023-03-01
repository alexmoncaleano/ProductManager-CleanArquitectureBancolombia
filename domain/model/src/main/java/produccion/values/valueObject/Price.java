package produccion.values.valueObject;

import generic.ValueObject;
import produccion.enums.Currency;

import java.math.BigDecimal;

public class Price implements ValueObject<Price.Props> {

    private BigDecimal price;
    private Currency currency;

    public Price(BigDecimal price, Currency currency) {
        /**if(price.compareTo(BigDecimal.ZERO) <= 0){
         throw new IllegalArgumentException("Price cannot be less than or equal to zero");
         }**/
        this.price = price;
        /**if (!Arrays.asList(Currency.values()).contains(currency)) {
         throw new IllegalArgumentException("Invalid currency type: " + currency);
         }**/
        this.currency = currency;
    }

    public Price price(){
        return new Price (this.price,this.currency);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public BigDecimal price() {
                return price;
            }

            @Override
            public Currency currency() {
                return currency;
            }
        };
    }

    public interface Props {

        BigDecimal price ();

        Currency currency();

    }
}