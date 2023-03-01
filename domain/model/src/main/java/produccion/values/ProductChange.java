package produccion.values;

import generic.EventChange;
import produccion.events.*;
import produccion.values.valueObject.*;

public class ProductChange extends EventChange {
    public ProductChange(Product product) {

        apply(((ProductCreated event) -> {
            product.stock = new Stock(event.getStockList());
            product.information = new Information(event.getPresentations());
            product.description = new Description(event.getDescription());
            product.recipe = new Recipe(event.getRecipe());
        }));

        apply((RawMaterialCreated event) -> {
            RawMaterial rawMaterial = new RawMaterial(event.getName(), event.getQuantity());
            product.recipe.value().ingredientList().add(rawMaterial);
        });

        apply((NumberElementsCreated event) -> {
            Integer numberOfIngredients = event.getIngredientCount();
            product.recipeElements = numberOfIngredients;
        });

        apply((StockDetailCreated event)->{
            StockDetail detail = new StockDetail(event.getUnits(), event.getPresentation());
            product.stock.value().stockList().add(detail);
        });

        apply((PresentationCreated event)->{
            Presentation presentation = new Presentation(event.getQuantity(),event.getPrice());
            product.information.getPresentations().add(presentation);
        });
    }
}
