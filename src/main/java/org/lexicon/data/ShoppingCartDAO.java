package org.lexicon.data;

import org.lexicon.models.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartDAO {
<<<<<<< HEAD

=======
    ShoppingCartDAO INSTANCE = ShoppingCartDAORepository.getInstance();
    ShoppingCart save(ShoppingCart cart);
    Optional<ShoppingCart> findById(int id);
    List<ShoppingCart> findAll();
    List<ShoppingCart> findByReference(String customer);
    void delete(int id);
>>>>>>> f8efda47983495f3a506c7be099f977c37af1f73
}
