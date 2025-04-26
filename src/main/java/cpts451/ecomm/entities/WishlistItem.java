﻿package cpts451.ecomm.entities;

import jakarta.persistence.*;

@Entity
public class WishlistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Wishlist getWishlist() { return wishlist; }

    public void setWishlist(Wishlist wishlist) { this.wishlist = wishlist; }

    public Product getProduct() { return product; }

    public void setProduct(Product product) { this.product = product; }
}
