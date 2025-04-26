package cpts451.ecomm.services;

import cpts451.ecomm.entities.*;
import cpts451.ecomm.repositories.CartItemRepository;
import cpts451.ecomm.repositories.CartRepository;
import cpts451.ecomm.repositories.WishlistItemRepository;
import cpts451.ecomm.repositories.WishlistRepository;
import org.springframework.stereotype.Service;

@Service
public class WishlistServiceImpl implements WishlistService {
    private final WishlistRepository wishlistRepository;
    private final WishlistItemRepository wishlistItemRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository, WishlistItemRepository wishlistItemRepository)
    {
        this.wishlistRepository = wishlistRepository;
        this.wishlistItemRepository = wishlistItemRepository;
    }

    @Override
    public Wishlist getOrCreateWishlist(Customer customer)
    {
        if (wishlistRepository.findByCustomer(customer) != null)
        {
            return wishlistRepository.findByCustomer(customer);
        }
        else
        {
            Wishlist newWishlist = new Wishlist();
            newWishlist.setCustomer(customer);
            return wishlistRepository.save(newWishlist);
        }
    }

    @Override
    public void addToWishlist(Customer customer, Product product)
    {
        Wishlist wishlist = getOrCreateWishlist(customer);

        boolean productNotInWishlist = wishlist.getWishlistItems().stream()
                .noneMatch(item -> item.getProduct().getProductID().equals(product.getProductID()));

        if (productNotInWishlist) {
            WishlistItem newItem = new WishlistItem();
            newItem.setWishlist(wishlist);
            newItem.setProduct(product);
            wishlist.addWishlistItem(newItem);
            wishlistRepository.save(wishlist);
        }
    }

    @Override
    public void removeFromWishlist(Customer customer, int productID)
    {
        Wishlist wishlist = getOrCreateWishlist(customer);
        wishlist.getWishlistItems().removeIf(wishlistItem -> wishlistItem.getProduct().getProductID().equals(productID));
        wishlistRepository.save(wishlist);
    }
}
