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
