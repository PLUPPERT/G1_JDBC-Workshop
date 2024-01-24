package org.lexicon.data;

import com.mysql.cj.MysqlConnection;
import org.lexicon.models.Product;
import org.lexicon.models.ShoppingCartItem;
import java.sql.*;

public class ShoppingCartItemRepository implements ShoppingCartItemDAO {
        {
        @Override
        public ShoppingCartItem save(ShoppingCartItem cartItem){
            Product product = new Product(1,"product1",200);
            String insertQuery;
            String updateQuery;
            if(cartItem.getId()==0){
                insertQuery="INSERT INTO shopping_cart_item (amount,total_price,product_id,shopping_cart_id) VALUES (?,?,?,?)";
            }else {
                updateQuery="UPDATE TABLE shopping_cart_item WHERE id=?";
            }
                try(Connection connection = MysqlConnection.getConnection();
                    PreparedStatement preparedStatement =connection.prepareStatement(insertQuery,PreparedStatement.RETURN_GENERATED_KEYS);
                ){
                    preparedStatement.setString(1,product.getId());
                    preparedStatement.setString(2,product.getName());
                    preparedStatement.setString(3,product.getPrice());
                }

        return null;
    }

        @Override
        public Optional<ShoppingCartItem> findById(int id){
        return null;
    }

        @Override
        public List<ShoppingCartItem> findAll() {
        return null;
    }

        @Override
        public List<ShoppingCartItem> findByCartId(ShoppingCartItem cartId){
        return null;
    }

        @Override
        public List<ShoppingCartItem> findByProduct ( int productId){
        return null;
    }

        @Override
        public void delete ( int id){

    }
    }
}
/*
public class ShoppingCartItemRepository implements ShoppingCartItemDAO {

  private Map<Integer, ShoppingCartItem> dataStore = new HashMap<>();

  @Override
  public ShoppingCartItem save(ShoppingCartItem cartItem) {
    dataStore.put(cartItem.getId(), cartItem);
    return cartItem;
  }

  @Override
  public Optional<ShoppingCartItem> findById(int id) {
    return Optional.ofNullable(dataStore.get(id));
  }

  @Override
  public List<ShoppingCartItem> findAll() {
    return new ArrayList<>(dataStore.values());
  }

  @Override
  public List<ShoppingCartItem> findByCartId(ShoppingCartItem cartId) {
    return dataStore.values().stream()
        .filter(item -> item.getCartId().equals(cartId))
        .collect(Collectors.toList());
  }

  @Override
  public List<ShoppingCartItem> findByProduct(int productId) {
    return dataStore.values().stream()
        .filter(item -> item.getProductId() == productId)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(int id) {
    dataStore.remove(id);
  }
}
 */