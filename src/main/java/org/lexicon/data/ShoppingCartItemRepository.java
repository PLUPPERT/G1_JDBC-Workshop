package org.lexicon.data;

import org.lexicon.models.ShoppingCartItem;

public class ShoppingCartItemRepository implements ShoppingCartItemDAO {
    @Override
    public ShoppingCartItem save(ShoppingCartItem cartItem) {
        return null;
    }

    @Override
    public Optional<ShoppingCartItem> findById(int id) {
        return null;
    }

    @Override
    public List<ShoppingCartItem> findAll() {
        return null;
    }

    @Override
    public List<ShoppingCartItem> findByCartId(ShoppingCartItem cartId) {
        return null;
    }

    @Override
    public List<ShoppingCartItem> findByProduct(int productId) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

}
