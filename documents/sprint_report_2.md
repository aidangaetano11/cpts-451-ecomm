# Sprint 2 Report
Video Link: https://youtu.be/M5-PJsqKrro
## What's New (User Facing)
 * Admin Controller, Service, Home Page
 * Customer Controller, Service, Home Page
 * Product Controller, Service
 * Create Product Service, Controller
 * Store Page
 * Password Hashing
 * Logout functionality
 * Customer Cart, Add to cart
 * Update User details, delete user
 * Create Reviews

## Work Summary (Developer Facing)
We started with creating the home page for customer and admin so when the user logged in, the user session would be assigned accordingly. The password needed to be more secure, so we implemented password hashing so that database could not see the user's password. We implemented a create product feature in the admin home so admins can create products. We created the store page so all products are listed on the page. We implemented the cart so each customer has their own cart and on the store page they can add products to their cart. The cart page displays all products that the customer added.

## Unfinished Work
We completed most things we wanted to do. We are at a good 75% point with our project.

## Completed Issues/User Stories
Here are links to the issues that we completed in this sprint:

 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/23 Create Admin Controller, Service
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/24 Create Customer Controller, Service
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/26 Create Product
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/25 Create Store Page for Products (StorePage Controller, Service)
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/28 Update password to be more secure
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/36 Implement Logout
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/27 Create Cart For Customer
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/38 Option to Edit and Delete User Accounts
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/40 Edit Product Details and Delete Product
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/32 Create Reviews for product
 
 ## Incomplete Issues/User Stories
 We were able to complete all issues started this sprint.

## Code Files for Review
Please review the following code files, which were actively developed during this sprint, for quality:
 * [AdminController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [CustomerController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [StoreController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [CartController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [CreateAdminAccountController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [CreateCustomerAccountController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [CreateProductController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [LoginController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [UpdateAdminAccountController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [UpdateCustomerAccountController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [UpdateProductAccountController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [Admin.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [Customer.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [Cart.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [CartItem.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [User.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [AdminService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [AdminServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CustomerService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CustomerServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CartService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CartServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateAdminAccountService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateAdminAccountServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateCustomerAccountService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateCustomerAccountServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateProductService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateProductServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [LoginService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [LoginServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [ProductService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [ProductServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [UpdateAdminAccountService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [UpdateAdminAccountServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [UpdateCustomerAccountService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [UpdateCustomerAccountServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [UpdateProductService.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [UpdateProductServiceImpl.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CartItemRepository.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [CartRepository.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [ProductRepository.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [CustomerRepository.Java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 
## Retrospective Summary
Here's what went well:
  * Communication was good.
  * We were able to complete the sprint in time
  * Everyone was able to contribute to work on the project
 
Here's what we'd like to improve:
   * Delegate issues to work on in a more organized way
   * Have more detailed explanation for each issue
   * Compelte sprint early
  
Here are changes we plan to implement in the next sprint:
   * Keep more organized list of issues
   * Start planning what to do in a sprint earlier
   * Have some more communications
