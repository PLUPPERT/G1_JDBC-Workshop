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
/*
public class ShoppingCartDAORepository implements ShoppingCartDAO {
    private static final ShoppingCartDAORepository INSTANCE = new ShoppingCartDAORepository();
    private Connection connection;

    private ShoppingCartDAORepository() {
        connection = ConnectionJDBC.getConnection();
    }

    static ShoppingCartDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public ShoppingCart save(ShoppingCart cart) {
        if (cart == null) throw new NullPointerException("ShoppingCart object is null");

        String insertQuery = "INSERT INTO shopping_cart (last_update, order_status, delivery_address, customer_reference) VALUES(?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(cart.getLastUpdate()));
            preparedStatement.setString(2, cart.getOrderStatus());
            preparedStatement.setString(3, cart.getDeliveryAddress());
            preparedStatement.setString(4, cart.getCustomerReference());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // You might want to handle this exception differently
        }
        return cart;
    }

    @Override
    public Optional<ShoppingCart> findById(int id) {
        String searchQuery = "SELECT * FROM shopping_cart WHERE id = ?";
        ShoppingCart cart = null;
        try (PreparedStatement ps = connection.prepareStatement(searchQuery)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cart = createShoppingCartFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(cart);
    }

    @Override
    public List<ShoppingCart> findAll() {
        String selectQuery = "SELECT * FROM shopping_cart";
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(selectQuery);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ShoppingCart cart = createShoppingCartFromResultSet(rs);
                shoppingCarts.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // handle the exception
        }

        return shoppingCarts;
    }

    @Override
    public List<ShoppingCart> findByReference(String customer) {
        String selectQuery = "SELECT * FROM shopping_cart WHERE customer_reference = ?";
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(selectQuery)) {
            ps.setString(1, customer);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ShoppingCart cart = createShoppingCartFromResultSet(rs);
                    shoppingCarts.add(cart);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // handle the exception
        }
        return shoppingCarts;
    }

    @Override
    public void delete(int id) {
        String deleteQuery = "DELETE FROM shopping_cart WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // handle the exception
        }
    }

    private ShoppingCart createShoppingCartFromResultSet(ResultSet rs) throws SQLException {
        ShoppingCart cart = new ShoppingCart();
        cart.setId(rs.getInt("id"));
        cart.setLastUpdate(rs.getTimestamp("last_update").toLocalDateTime());
        cart.setOrderStatus(rs.getString("order_status"));
        cart.setDeliveryAddress(rs.getString("delivery_address"));
        cart.setCustomerReference(rs.getString("customer_reference"));
        return cart;
    }
}
*/
