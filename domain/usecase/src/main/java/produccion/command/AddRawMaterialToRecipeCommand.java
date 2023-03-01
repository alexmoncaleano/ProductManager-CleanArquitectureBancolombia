package produccion.command;

import generic.Command;
import produccion.enums.WeightUnit;

public class AddRawMaterialToRecipeCommand extends Command {
    private String productId;
    private String recipeId;
    private String name;

    // Quantity
    private Integer quantity;
    private WeightUnit unitOfMeasurement;

    public AddRawMaterialToRecipeCommand() {
    }

    public AddRawMaterialToRecipeCommand(String productId, String name, Integer quantity, String unitOfMeasurement) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.unitOfMeasurement = WeightUnit.valueOf(unitOfMeasurement);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
