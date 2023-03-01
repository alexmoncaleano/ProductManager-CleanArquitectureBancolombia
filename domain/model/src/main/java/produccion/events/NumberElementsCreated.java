package produccion.events;

import generic.DomainEvent;
import produccion.values.valueObject.RawMaterial;

import java.util.Objects;
import java.util.Set;

public class NumberElementsCreated extends DomainEvent {
    private Integer ingredientCount;

    public NumberElementsCreated(Set<RawMaterial> recipe) {
        super("numberOfElementsCreated");
        this.ingredientCount = Objects.requireNonNull(countElements(recipe),"The recipe cannot be null");
    }

    public Integer countElements(Set<RawMaterial> recipe){
        return recipe.size();
    }

    public Integer getIngredientCount() {
        return ingredientCount;
    }
}
