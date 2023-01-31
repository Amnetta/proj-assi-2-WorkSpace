package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;


@Service
public class CartService {
    @Autowired
    CartRepository db;

    public List<CartItem> getCartContents() {
        return db.selectAllItems();
    }

    public int addOrRemoveItem(String action, CartItem cartItem) {
        if (action.equals("add")) {
            return db.insertOrIncrementItem(cartItem);
        } else if (action.equals("remove")) {
            return db.deleteOrDecrementItem(cartItem);
        } else {
            return -1;
        }

    }

    public void emptyCart(boolean restock) {
        db.deleteAllItems(restock);
    }
}
