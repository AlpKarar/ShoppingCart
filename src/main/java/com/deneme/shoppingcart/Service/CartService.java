package com.deneme.shoppingcart.Service;

import com.deneme.shoppingcart.Dto.AddCartRequest;
import com.deneme.shoppingcart.Dto.JoinedCartProduct;
import com.deneme.shoppingcart.Entity.Cart;
import com.deneme.shoppingcart.Repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCartProducts() {
        return cartRepository.findAll();
    }

    public void addProductToCart(AddCartRequest addCartRequest) throws Exception {
        int pid = addCartRequest.getPid();
        int amount = addCartRequest.getAmount();

        if (pid < 0 && amount < 0) {
            throw new Exception("pid and amount can not be negative number.");
        } else if (pid < 0) {
            throw new Exception("pid can not be negative number.");
        } else if (amount < 0) {
            throw new Exception("amount can not be negative number.");
        }

        Cart productToAdd = findByProductId(pid);

        if (productToAdd == null) {
            cartRepository.save(new Cart(pid, amount));
        } else {
            int currentAmount = productToAdd.getAmount();
            int newAmount = currentAmount + amount;

            cartRepository.updateCartProductAmount(newAmount, pid);
        }
    }

    public Cart findByProductId(int pid) {
        return cartRepository.findByProductId(pid);
    }

    public List<JoinedCartProduct> getJoinedCartProduct() {
        return cartRepository.getJoinedCartProduct();
    }

    public String getTotalCartPrice() {
        List<JoinedCartProduct> allCartProducts = getJoinedCartProduct();
        double total = 0;

        for (JoinedCartProduct cartProduct : allCartProducts) {
            total += cartProduct.getCart().getAmount() * cartProduct.getProduct().getPrice();
        }

        return String.format("%,.2f TL", total);
    }

    public int removeProductFromCart(int pid) {
        cartRepository.deleteByProductId(pid);

        return pid;
    }
}
