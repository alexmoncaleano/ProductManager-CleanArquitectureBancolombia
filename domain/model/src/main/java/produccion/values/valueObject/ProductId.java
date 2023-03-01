package produccion.values.valueObject;

import generic.Identity;

public class ProductId extends Identity {

    public ProductId(String uuid) {
        super(uuid);
    }

    public ProductId(){

    }

    public static ProductId of(String uuid) {return new ProductId(uuid);}
}

