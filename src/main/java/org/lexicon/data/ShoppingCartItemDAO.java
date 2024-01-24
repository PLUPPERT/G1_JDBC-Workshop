package org.lexicon.data;

import org.lexicon.models.ShoppingCartItem;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartItemDAO {
ShoppingCartItem save(ShoppingCartItem cartItem);
Optional<ShoppingCartItem> findById(int id);
List<ShoppingCartItem> findAll();
List<ShoppingCartItem> findByCartId(ShoppingCartItem cartId);
List<ShoppingCartItem> findByProduct(int productId);
void delete(int id);
}
