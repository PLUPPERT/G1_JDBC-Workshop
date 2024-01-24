package org.lexicon.data;


import org.lexicon.models.Product;
import org.lexicon.models.ShoppingCart;
import org.lexicon.models.ShoppingCartItem;
import java.sql.*;

public class ShoppingCartItemDAORepository implements ShoppingCartItemDAO {
         @Override
        public ShoppingCartItem save(ShoppingCartItem cartItem){
            Product product = null;
            String query;
            if(cartItem.getId()==0){
                query="INSERT INTO shopping_cart_item (amount,total_price,product_id,shopping_cart_id) VALUES (?,?,?,?)";
            }else {
                query="UPDATE shopping_cart_item SET amount=?,total_price=?,product_id=?,shopping_cart_id=? WHERE id=?";
            }
                try(Connection connection = ConnectionJDBC.getConnection();
                    PreparedStatement preparedStatement =connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
                ){
                    preparedStatement.setInt(1,cartItem.getAmount());
                    preparedStatement.setDouble(2,cartItem.getTotalPrice());
                    preparedStatement.setInt(3,cartItem.getItem().getId());
                    preparedStatement.setInt(4,cartItem.getCart().getId();

                    if(cartItem.getId()!=0){
                        preparedStatement.setInt(5,cartItem.getId());
                    }

                    int rowsAffected=preparedStatement.executeUpdate();

                    if (rowsAffected>0){
                       ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                       if (generatedKeys.next()){
                           cartItem.setId(generatedKeys.getInt(1));
                       }
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return cartItem;
        }

        @Override
        public Optional<ShoppingCartItem> findById(int id){
            try(Connection connection = ConnectionJDBC.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM shopping_cart_item WHERE id=?")){

                preparedStatement.setInt(1,id);
                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    if (resultSet.next()){
                        int itemId=resultSet.getInt("id");
                        int amount=resultSet.getInt("amount");
                        double totalPrice= resultSet.getDouble("total_price");
                        Product product = new Product(resultSet.getInt("Id"),
                                resultSet.getString("name"),
                                resultSet.getDouble("price"));
                        ShoppingCart cart = new ShoppingCart(resultSet.getInt("Id"),
                                resultSet.getDate("last_update"),
                                resultSet.getString("order_status"),
                                resultSet.getString("delivery_address"),
                                resultSet.getString("customer_reference")
                        );
                        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(id,amount,totalPrice,product,cart);
                        return Optional.of(shoppingCartItem);
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        return Optional.empty();
    }

        @Override
        public List<ShoppingCartItem> findAll() {
            List<ShoppingCartItem> items = new ArrayList<>();
            try(Connection connection = ConnectionJDBC.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM shopping_cart_item")){

                while(resultSet.next()){
                    int id= resultSet.getInt("Id");
                    int amount= resultSet.getInt("amount");
                    double totalPrice=resultSet.getDouble("total_price");
                    Product product = new Product(resultSet.getInt("Id"),
                                                  resultSet.getString("name"),
                                                  resultSet.getDouble("price"));
                    ShoppingCart cart = new ShoppingCart(resultSet.getInt("Id"),
                                                         resultSet.getDate("last_update"),
                                                         resultSet.getString("order_status"),
                                                         resultSet.getString("delivery_address"),
                                                         resultSet.getString("customer_reference")
                            );
                    ShoppingCartItem shoppingCartItem = new ShoppingCartItem(id,amount,totalPrice,product,cart);
                    items.add(shoppingCartItem);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        return items;
    }

        @Override
        public List<ShoppingCartItem> findByCartId(ShoppingCartItem cartId){
            List<ShoppingCartItem> items = new ArrayList<>();
            try(Connection connection = ConnectionJDBC.getConnection();
                PreparedStatement  preparedStatement= connection.prepareStatement("SELECT * FROM shopping_cart_item WHERE shopping_cart_id=?")){

                preparedStatement.setInt(1,cartId);

                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    while(resultSet.next()){
                        int id= resultSet.getInt("Id");
                        int amount= resultSet.getInt("amount");
                        double totalPrice=resultSet.getDouble("total_price");
                        Product product = new Product(resultSet.getInt("Id"),
                                resultSet.getString("name"),
                                resultSet.getDouble("price"));
                        ShoppingCart cart = new ShoppingCart(resultSet.getInt("Id"),
                                resultSet.getDate("last_update"),
                                resultSet.getString("order_status"),
                                resultSet.getString("delivery_address"),
                                resultSet.getString("customer_reference")
                        );
                        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(id,amount,totalPrice,product,cart);
                        items.add(shoppingCartItem);
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }


            }catch (SQLException e){
                e.printStackTrace();
            }
        return items;
    }

        @Override
        public List<ShoppingCartItem> findByProduct ( int productId){
            List<ShoppingCartItem> items = new ArrayList<>();
            try(Connection connection = ConnectionJDBC.getConnection();
                PreparedStatement  preparedStatement= connection.prepareStatement("SELECT * FROM shopping_cart_item WHERE product_id=?")){

                preparedStatement.setInt(1,productId);

                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    while(resultSet.next()){
                        int id= resultSet.getInt("Id");
                        int amount= resultSet.getInt("amount");
                        double totalPrice=resultSet.getDouble("total_price");
                        Product product = new Product(resultSet.getInt("Id"),
                                resultSet.getString("name"),
                                resultSet.getDouble("price"));
                        ShoppingCart cart = new ShoppingCart(resultSet.getInt("Id"),
                                resultSet.getDate("last_update"),
                                resultSet.getString("order_status"),
                                resultSet.getString("delivery_address"),
                                resultSet.getString("customer_reference")
                        );
                        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(id,amount,totalPrice,product,cart);
                        items.add(shoppingCartItem);
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }


            }catch (SQLException e){
                e.printStackTrace();
            }
            return items;
    }

        @Override
        public void delete ( int id){
            try(Connection connection = ConnectionJDBC.getConnection();
                PreparedStatement  preparedStatement= connection.prepareStatement("DELETE * FROM shopping_cart_item WHERE id=?")) {

                preparedStatement.setInt(1, id);
                preparedStatement.executeQuery();
            }catch (SQLException e){
                e.printStackTrace();
            }
    }
}
