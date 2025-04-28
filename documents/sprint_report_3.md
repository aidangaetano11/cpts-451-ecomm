# Sprint 3 Report
Video Link: 
## What's New (User Facing)
 * Ability to update/delete a review
 * Wishlist for products
 * Checkout cart
 * Create a order
 * View list of past orders
 * Ability to sort and organize the list of products
 * Added categories to products

## Work Summary (Developer Facing)
We implemented a new repository for things like address, payment, orders, and wishlist, so those things can be stored inside an appropriate database. Using this, we added a new wishlist page to store products the user may want and later add to cart, and a checkout page to allow the user to order the products they stored in a cart. The checkout page requires the user to input their payment and shipping address which gets stored into their respictive repositories, and once it is confirmed an order is created. The user can check the order to see previous products they purchased. We also added a new store page to sort and organiaze products and reviews, with the ability to update and remove old reviews for products the user previously created.

## Unfinished Work
We completed most things we wanted to do, but there were certain features like having individual pages for each product that we did not have enough time to start on.

## Completed Issues/User Stories
Here are links to the issues that we completed in this sprint:

 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/39 Checkout/Payment Screen
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/50 Update Reviews
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/34 Create Payment Servuce, Controller
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/25 Customer Orders and Order History
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/58 Update password to be more secure
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/42 Create Wishlist
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/51 Add averaged ratings to product
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/53 Update admin home page
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/54 Create Category Controller and Service
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/49 Add Category to products
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/52 Sort products
 
## Incomplete Issues/User Stories
 We were able to complete all issues started this sprint.

## Code Files for Review
Please review the following code files, which were actively developed during this sprint, for quality:
 * [StoreController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [CartController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [CreateProductController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [LoginController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [UpdateProductAccountController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [CheckoutController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [CreateCategoryController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [WishlistController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [OrderController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 
 * [Address.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [Category.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [Customer.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [CustomerOrder.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [OrderItem.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [Payment.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [Product.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [ReviewProduct.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [Wishlist.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [WishlistItem.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 
 * [AddressService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [AddressServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CategoryService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CategoryServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CartService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CartServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CheckoutService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CheckoutServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateCategoryService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateCategoryServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateProductServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateReviewProductServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [OrderService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [OrderServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [PaymentService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [PaymentServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [ProductServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [ReviewProductService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [ReviewProductServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [WishlistService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [WishlistServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [UpdateProductService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [UpdateProductServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 
 * [AddressRepository.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [CategoryRepository.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [OrderItemReposioty.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [OrderRepository.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [PaymentRepository.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [ProductRepository.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [ReviewProductRepository.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [WishlistItemRepository.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [WishlistRepository.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 
## Retrospective Summary
Here's what went well:
  * Coordinated what each person was working on
  * Communication
  * Asked questions when needed
 
Here's what we'd like to improve:
   * Start working earlier
   * Organize project better
  
Here are changes we plan to implement in the next sprint:
   * Make a detailed plan for what each person should work on earlier
   * Have a list of issues to be worked on earlier
   * Have a more detailed descriptions for issues
