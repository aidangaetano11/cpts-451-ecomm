# Sprint 1 Report 
Video Link: https://www.youtube.com/watch?v=GUwCdMUIAio
## What's New (User Facing)
 * Created User, Admin, Customer Entity
 * Created Create Account Controller and Service
 * Created Login Controller and Service
 * Implemented Admin and Customer Account Creation
 * Implemented Account Login
 * Created Tables for Other Entities

## Work Summary (Developer Facing)
The foundation of our project has been laid out. We have implemented H2 database to our project. Repositories for User, Customer and Admin have been set up which allows us to test out our current H2 database. Our repositories are based off of our User, Customer and Admin entities. Customer and Admin are inherited off of our User as they will use a lot of the same variables. We have also set up the ability to create an Admin and Customer account as well as the ability to login. Currently, they are not separate so if a login is successful, it will bring you back to the home page.
On top of this, we have initialized the entity tables in our database, which includes Payment, Products, and the like.

## Unfinished Work
We manages to finish all isues we started this sprint.

## Completed Issues/User Stories
Here are links to the issues that we completed in this sprint:

Aiden Gaetano
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/1 Create User, Admin, Customer Entities
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/8 Create Create Account Controller and Service
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/10 Customer and Admin Create Account Implementation
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/9 Create Login Controller and Service
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/11 Implemented Account Login

Albert Li
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/16 Create Category Entity
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/5 Create Order Entity
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/4 Create Payment Entity
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/2 Create Product Entity

Jim Kino
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/7 Create Wishlist Entity
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/6 Create Review Entity
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/3 Create Cart Entity
   
 ## Incomplete Issues/User Stories
We managed to finish all issues we started this sprint.

## Code Files for Review
Please review the following code files, which were actively developed during this sprint, for quality:
 * [User.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [Admin.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [Customer.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/entities)
 * [CreateAdminAccountController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [CreateCustomerAccountController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [LoginController.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/controllers)
 * [UserRepository.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [AdminRepository.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [CustomerRepository.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/repositories)
 * [CreateAdminAccountService.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateAdminAccountServiceImpl.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateCustomerAccountService.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [CreateCustomerAccountServiceImpl.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [LoginService.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [LoginServiceImpl.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/services)
 * [InitialSetup.java](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/java/cpts451/ecomm/setup)
 * [index.html](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/resources/templates)
 * [createAdmin.html](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/resources/templates)
 * [createCustomer.html](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/resources/templates)
 * [loginPage.html](https://github.com/aidangaetano11/cpts-451-ecomm/tree/main/src/main/resources/templates)
 * [Category.java](https://github.com/aidangaetano11/cpts-451-ecomm/blob/main/src/main/java/cpts451/ecomm/entities/Category.java)
 * [OrderBy.java](https://github.com/aidangaetano11/cpts-451-ecomm/blob/main/src/main/java/cpts451/ecomm/entities/OrderBy.java)
 * [Payment.java](https://github.com/aidangaetano11/cpts-451-ecomm/blob/main/src/main/java/cpts451/ecomm/entities/Payment.java)
 * [Product.java](https://github.com/aidangaetano11/cpts-451-ecomm/blob/main/src/main/java/cpts451/ecomm/entities/Product.java)
 * [Cart.java](https://github.com/aidangaetano11/cpts-451-ecomm/blob/main/src/main/java/cpts451/ecomm/entities/Cart.java)
 * [Wishlist.java](https://github.com/aidangaetano11/cpts-451-ecomm/blob/main/src/main/java/cpts451/ecomm/entities/Wishlist.java)
 * [Review.java](https://github.com/aidangaetano11/cpts-451-ecomm/blob/main/src/main/java/cpts451/ecomm/entities/Review.java)
 * [ReviewProduct.java](https://github.com/aidangaetano11/cpts-451-ecomm/blob/main/src/main/java/cpts451/ecomm/entities/ReviewProduct.java)
 * [ReviewVendor.java](https://github.com/aidangaetano11/cpts-451-ecomm/blob/main/src/main/java/cpts451/ecomm/entities/ReviewVendor.java)



## Retrospective Summary
Here's what went well:
  * The foundation is laid out now, so progress should be able to move a lot quicker.
  * We are communicating frequently.
 
Here's what we'd like to improve:
   * We started pretty late, which has us scrambling a little bit.
   * It was harder to divvy up work at least until we got our initial setup, so going forward, work will be split up better.
   * Communication was a bit harder during spring break since we were all a bit busy, this however shouldn't affect future sprints  

Here are changes we plan to implement in the next sprint:
   * Starting work earlier.
   * Plan to have a better plan on creating branches and naming conventions.
