package org.lexicon.data;

import org.lexicon.models.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartDAO {
    ShoppingCartDAO INSTANCE = ShoppingCartDAORepository.getInstance();
    ShoppingCart save(ShoppingCart cart);
    Optional<ShoppingCart> findById(int id);
    List<ShoppingCart> findAll();
    List<ShoppingCart> findByReference(String customer);
    void delete(int id);
}
