package cpts451.ecomm.services;

import cpts451.ecomm.entities.Cart;
import cpts451.ecomm.entities.CartItem;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import cpts451.ecomm.repositories.CartItemRepository;
import cpts451.ecomm.repositories.CartRepository;
import cpts451.ecomm.repositories.CustomerRepository;
import cpts451.ecomm.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository)
    {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public Cart getOrCreateCart(Customer customer)
    {
        if (cartRepository.findByCustomer(customer) != null)
        {
            return cartRepository.findByCustomer(customer);
        }
        else
        {
            Cart newCart = new Cart();
            newCart.setCustomer(customer);
            return cartRepository.save(newCart);
        }
    }

    @Override
    public void addToCart(Customer customer, Product product, int quantity)
    {
        Cart cart = getOrCreateCart(customer);

        cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getProduct().getProductID().equals(product.getProductID()))
                .findFirst()
                .ifPresentOrElse(
                        cartItem -> cartItem.setQuantity(cartItem.getQuantity() + quantity),
                        () -> {
                            CartItem newItem = new CartItem();
                            newItem.setCart(cart);
                            newItem.setProduct(product);
                            newItem.setQuantity(quantity);
                            cart.getCartItems().add(newItem);
                        }
                );

        cartRepository.save(cart);
    }

    @Override
    public void removeFromCart(Customer customer, int productID)
    {
        Cart cart = getOrCreateCart(customer);
        cart.getCartItems().removeIf(cartItem -> cartItem.getProduct().getProductID().equals(productID));
        cartRepository.save(cart);
    }

    @Override
    public double getTotalPrice(Customer customer)
    {
        Cart cart = getOrCreateCart(customer);
        List<CartItem> cartItem = cart.getCartItems();
        double price = 0.0;

        for (int i = 0; i < cartItem.size(); i++)
        {
            price += cartItem.get(i).getProduct().getProductPrice() * cartItem.get(i).getQuantity();
        }

        return price;
    }
}
