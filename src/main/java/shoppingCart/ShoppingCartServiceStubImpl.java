package shoppingCart;

import product.Product;
import java.util.*;

public class ShoppingCartServiceStubImpl implements ShoppingCartService {

    private List<ShoppingCart> shoppingcarts = new ArrayList<>();


    public void addProductToShoppingCart(Product product, ShoppingCart cart) {
        cart.addProduct(product);
        System.out.println(product.getName() + " added to your shopping cart.");
    }


    public ShoppingCart getNewShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart = setIdForNewShoppingCart(shoppingCart);
        shoppingcarts.add(shoppingCart);
        System.out.println("New shopping cart open: " + shoppingCart.getId());
        return shoppingCart;
    }


    private ShoppingCart setIdForNewShoppingCart(ShoppingCart cart) {
        if (shoppingcarts.size() == 0){
            cart.setId(Long.valueOf(1));
        }
        if (shoppingcarts.size() > 0){
            Long lastAddedProductID = shoppingcarts.get(shoppingcarts.size() - 1).getId() + 1;
            cart.setId(lastAddedProductID);
        }
        return cart;
    }
}
