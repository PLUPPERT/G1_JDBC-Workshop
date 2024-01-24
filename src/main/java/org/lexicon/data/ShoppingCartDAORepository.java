package org.lexicon.data;

import org.lexicon.models.ShoppingCart;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ShoppingCartDAORepository implements ShoppingCartDAO {
    private static final ShoppingCartDAO INSTANCE;
    private static Connection connection;

    static {
        INSTANCE = new ShoppingCartDAORepository();
        connection = ConnectionJDBC.getConnection();
    }

    static ShoppingCartDAO getInstance() {
        return INSTANCE;
    }
    @Override
    public ShoppingCart save(ShoppingCart cart) {
        if (cart == null) throw new NullPointerException("ShoppingCart object is null");
        String insertQuery = "INSERT INTO shopping_cart (last_update, order_status, delivery_address, customer_reference) VALUES(?, ?, ?, ?)";
        return null;
    }

    @Override
    public Optional<ShoppingCart> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<ShoppingCart> findAll() {
        return null;
    }

    @Override
    public List<ShoppingCart> findByReference(String customer) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
