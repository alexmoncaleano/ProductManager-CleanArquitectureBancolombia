package produccion.values.valueObject;

import generic.ValueObject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recipe implements ValueObject<Recipe.Props> {

    private Set<RawMaterial> ingredientList;

    public Recipe(Set<RawMaterial> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public Recipe(){
        this.ingredientList = new HashSet<RawMaterial>();
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Set<RawMaterial> ingredientList() {
                return ingredientList;
            }
        };
    }


    public interface Props {
        Set<RawMaterial> ingredientList();
    }
}
