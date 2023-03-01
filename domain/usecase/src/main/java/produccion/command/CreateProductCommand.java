package produccion.command;

import generic.Command;

public class CreateProductCommand  extends Command {
    private String id;
    private String description;

    public CreateProductCommand(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
