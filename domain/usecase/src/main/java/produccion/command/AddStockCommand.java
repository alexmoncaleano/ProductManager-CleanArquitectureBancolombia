package produccion.command;

import generic.Command;
import produccion.enums.Currency;
import produccion.enums.WeightUnit;

import java.math.BigDecimal;

public class AddStockCommand extends Command {

    private String productId;
    private Integer units;
    //Quantity
    private Integer quantity;
    private WeightUnit unitOfMeasurement;
    //Price
    private BigDecimal price;
    private Currency currency;

    public AddStockCommand(){}

    public AddStockCommand(String productId, Integer units, Integer quantity, WeightUnit unitOfMeasurement, BigDecimal price, Currency currency) {
        this.productId = productId;
        this.units = units;
        this.quantity = quantity;
        this.unitOfMeasurement = unitOfMeasurement;
        this.price = price;
        this.currency = currency;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public WeightUnit getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(WeightUnit unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
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
