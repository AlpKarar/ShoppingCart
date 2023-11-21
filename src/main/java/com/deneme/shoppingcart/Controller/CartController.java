package com.deneme.shoppingcart.Controller;

import com.deneme.shoppingcart.Dto.AddCartRequest;
import com.deneme.shoppingcart.Dto.DeleteRequestDto;
import com.deneme.shoppingcart.Dto.JoinedCartProduct;
import com.deneme.shoppingcart.Entity.Cart;
import com.deneme.shoppingcart.Service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping()
    public ResponseEntity<List<Cart>> getAllCartProducts() {
        List<Cart> allCartProducts = cartService.getAllCartProducts();

        return new ResponseEntity<>(allCartProducts, HttpStatus.OK);
    }

    @GetMapping("/post")
    public List<Object> getAllPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        RestTemplate restTemplate = new RestTemplate();

        Object[] posts = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(posts);
    }

    @PostMapping()
    public ResponseEntity<String> addProductToCart(@RequestBody AddCartRequest addCartRequest) {
        try {
            cartService.addProductToCart(addCartRequest);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Product added to cart", HttpStatus.OK);
    }

    @GetMapping("/joined")
    public ResponseEntity<List<JoinedCartProduct>> getJoined() {
        List<JoinedCartProduct> result = cartService.getJoinedCartProduct();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/totalCartAmount")
    public ResponseEntity<String> getTotalCartAmount() {
        String totalCartAmount = cartService.getTotalCartPrice();

        return new ResponseEntity<>("<h1>Total: " + totalCartAmount + "</h1>", HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> removeProductFromCart(@RequestBody DeleteRequestDto deleteRequestDto) {
        int pidToBeDeleted = cartService.removeProductFromCart(deleteRequestDto.getPid());
        return new ResponseEntity<>("The product pid: " + pidToBeDeleted + " removed from the cart",
                HttpStatus.OK);
    }
}
