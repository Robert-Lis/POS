package shoppingCart;

import product.Product;


public interface ShoppingCartService {

    void addProductToShoppingCart(Product product, ShoppingCart cart);
    ShoppingCart getNewShoppingCart();
}
