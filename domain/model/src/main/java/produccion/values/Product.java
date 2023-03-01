package produccion.values;

import generic.AggregateRoot;
import generic.DomainEvent;
import produccion.events.*;
import produccion.values.valueObject.*;

import java.util.List;
import java.util.Set;




public class Product extends AggregateRoot<ProductId> {

    protected Description description;
    protected Recipe recipe;
    protected Stock stock;
    protected Information information;
    protected Integer recipeElements;

    public Product(ProductId id, Description description, Recipe recipe, Stock stock, Information information) {
        super(id);
        subscribe(new ProductChange(this));
        appendChange(new ProductCreated(description.value().description(), recipe.value().ingredientList(), stock.value().stockList(), information.getPresentations())).apply();
    }

    private Product(ProductId id) {
        super(id);
        subscribe(new ProductChange(this));
    }

    public static Product from(ProductId id, List<DomainEvent> events){
        Product product = new Product(id);
        events.forEach(event -> product.applyEvent(event));
        return product;
    }

    public void addPresentation(Quantity amount, Price price){
        appendChange(new PresentationCreated(amount, price));
    }
    public void addRawMaterial(String name, Quantity amount){
        appendChange(new RawMaterialCreated(name, amount)).apply();
    }
    public void addStock(Integer units, Presentation presentation){
        appendChange(new StockDetailCreated(units, presentation)).apply();
    }
    public Recipe getRecipe(){
        return this.recipe;
    }

    public void setNumberOfIngredients(Set<RawMaterial> recipe){
        appendChange(new NumberElementsCreated(recipe)).apply();
    }
}