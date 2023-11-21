package com.deneme.shoppingcart.Dto;

import com.deneme.shoppingcart.Entity.Cart;
import com.deneme.shoppingcart.Entity.Product;

public interface JoinedCartProduct {
    Product getProduct();
    Cart getCart();
}
