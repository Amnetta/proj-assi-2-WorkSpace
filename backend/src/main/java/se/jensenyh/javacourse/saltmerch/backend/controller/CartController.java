package se.jensenyh.javacourse.saltmerch.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

import java.util.List;
@CrossOrigin("http://localhost:3010")
@RequestMapping("/api/v1")
@RestController
public class CartController
{
    @Autowired
    CartService cartService;

    @GetMapping("/carts/{id}")
    public List<CartItem> getCartContents(@PathVariable int id) {
        return cartService.getCartContents();
    }

    @PatchMapping("/carts/{id}")
    public ResponseEntity<Object> addOrRemoveItem(@PathVariable int id,
                                                  @RequestParam String action,
                                                  @RequestBody CartItem cartItem) {
        if (id == 1) {
            int res;
            res = cartService.addOrRemoveItem(action, cartItem);
            switch (res) {
                default:
                case 1:
                    return new ResponseEntity(HttpStatus.CREATED);
                case -1:
                    return new ResponseEntity("Oops!Your cart is empty!", HttpStatus.FORBIDDEN);
                case -2:
                    return new ResponseEntity("Wrong action!", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity("Wrong Id! Please try again", HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<Object> emptyCart(@PathVariable int id,
                                            @RequestParam(required = false) boolean buyout)
    {
        if (id == 1)
        {
            if (buyout)
            {
                cartService.emptyCart(false);
                return new ResponseEntity("Your purchase was successful! ", HttpStatus.ACCEPTED);
            } else
            {
                cartService.emptyCart(true);
                return new ResponseEntity("Items has been removed from shopping cart ", HttpStatus.OK);
            }
        }
        return new ResponseEntity("Wrong Id! Please try again", HttpStatus.UNAUTHORIZED);
    }
}
