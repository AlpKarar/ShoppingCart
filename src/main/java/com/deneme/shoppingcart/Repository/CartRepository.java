package com.deneme.shoppingcart.Repository;

import com.deneme.shoppingcart.Dto.JoinedCartProduct;
import com.deneme.shoppingcart.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(nativeQuery = true,
            value = "select * from cart where pid = :pid")
    Cart findByProductId(@Param("pid") int pid);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "update cart set amount = :amount where pid = :pid")
    void updateCartProductAmount(@Param("amount") int amount, @Param("pid") int pid);

    @Query("select p as product, c as cart from Product p inner join Cart c on p.pid = c.pid")
    List<JoinedCartProduct> getJoinedCartProduct();


    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "delete from Cart where pid = :pid")
    int deleteByProductId(@Param("pid") int pid);
}
