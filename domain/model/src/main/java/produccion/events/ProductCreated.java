package produccion.events;

import generic.DomainEvent;
import produccion.values.valueObject.*;

import java.util.Set;

public class ProductCreated extends DomainEvent {

    private String description;
    private Set<RawMaterial> recipe;
    private Set<StockDetail> stockList;
    private Set<Presentation> presentations;

    public ProductCreated(){super("Product.productCreated");}

    public ProductCreated(String description,
                          Set<RawMaterial> recipe,
                          Set<StockDetail> stock,
                          Set<Presentation> information) {
        super("Product.productCreated");
        this.description = description;
        this.recipe = recipe;
        this.stockList = stock;
        this.presentations = information;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<RawMaterial> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<RawMaterial> recipe) {
        this.recipe = recipe;
    }

    public Set<StockDetail> getStockList() {
        return stockList;
    }

    public void setStockList(Set<StockDetail> stockList) {
        this.stockList = stockList;
    }

    public Set<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(Set<Presentation> presentations) {
        this.presentations = presentations;
    }
}