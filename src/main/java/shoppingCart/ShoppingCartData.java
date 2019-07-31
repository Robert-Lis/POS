package shoppingCart;

public class ShoppingCartData {

    ShoppingCart cart;
    ShoppingCartService shoppingCartService;

    public ShoppingCartData(ShoppingCart cart, ShoppingCartService shoppingCartService) {
        this.cart = cart;
        this.shoppingCartService = shoppingCartService;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public ShoppingCartService getShoppingCartService() {
        return shoppingCartService;
    }

    public void setNewShoppingCart(){
        this.cart = this.shoppingCartService.getNewShoppingCart();
    }
}
