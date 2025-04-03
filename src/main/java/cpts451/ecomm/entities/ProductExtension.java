package cpts451.ecomm.entities;

public class ProductExtension {
    public Product p;

    private boolean inCart;

    public ProductExtension(Product product, boolean inCart) {
        this.p = product;
        this.inCart = inCart;
    }

    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }

    public Product getProduct() {
        return p;
    }

    public void setProduct(Product product) {
        this.p = product;
    }
}
