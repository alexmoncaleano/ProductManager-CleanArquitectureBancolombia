package produccion.values.valueObject;

import generic.ValueObject;

import java.util.Objects;
import java.util.Set;

public class Information implements ValueObject<Set<Presentation>> {

    private Set<Presentation> presentations;

    public Information(Set<Presentation> presentations) {
        this.presentations = Objects.requireNonNull(presentations, "Presentation is required");
    }

    public Information(){}

    public Set<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(Set<Presentation> presentations) {
        this.presentations = presentations;
    }

    @Override
    public Set<Presentation> value() {
        return presentations;
    }
}
