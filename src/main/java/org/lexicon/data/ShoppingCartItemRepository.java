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