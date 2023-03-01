package produccion.command;

import generic.Command;
import produccion.enums.Currency;
import produccion.enums.WeightUnit;

import java.math.BigDecimal;

public class AddPresentationCommand extends Command {
    //Product
    private String productId;
    //Quantity
    private Integer quantity;
    private WeightUnit unitOfMeasure;
    //Price
    private BigDecimal price;
    private Currency currency;

    public AddPresentationCommand(String productId, Integer quantity, WeightUnit unitOfMeasure, BigDecimal price, Currency currency) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.price = price;
        this.currency = currency;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public WeightUnit getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(WeightUnit unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
