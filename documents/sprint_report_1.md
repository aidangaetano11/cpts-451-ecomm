# Sprint 1 Report 
Video Link: 
## What's New (User Facing)
 * Created User, Admin, Customer Entity
 * Created Create Account Controller and Service
 * Created Login Controller and Service
 * Implemented Admin and Customer Account Creation
 * Implemented Account Login

## Work Summary (Developer Facing)
Provide a one paragraph synposis of what your team accomplished this sprint. Don't repeat the "What's New" list of features. Instead, help the instructor understand how you went about the work described there, any barriers you overcame, and any significant learnings for your team.

The foundation of our project has been laid out. We have implemented H2 database to our project. Repositories for User, Customer and Admin have been set up which allows us to test out our current H2 database. Our repositories are based off of our User, Customer and Admin entities. Customer and Admin are inherited off of our User as they will use a lot of the same variables. We have also set up the ability to create an Admin and Customer account as well as the ability to login. Currently, they are not separate so if a login is successful, it will bring you back to the home page.

## Unfinished Work
If applicable, explain the work you did not finish in this sprint. For issues/user stories in the current sprint that have not been closed, (a) any progress toward completion of the issues has been clearly tracked (by checking the checkboxes of  acceptance criteria), (b) a comment has been added to the issue to explain why the issue could not be completed (e.g., "we ran out of time" or "we did not anticipate it would be so much work"), and (c) the issue is added to a subsequent sprint, so that it can be addressed later.

## Completed Issues/User Stories
Here are links to the issues that we completed in this sprint:

 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/1
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/8
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/10
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/9
 * https://github.com/aidangaetano11/cpts-451-ecomm/issues/11

 Desirables (Remove this section when you save the file):
  * Each issue should be assigned to a milestone
  * Each completed issue should be assigned to a pull request
  * Each completed pull request should include a link to a "Before and After" video
  * All team members who contributed to the issue should be assigned to it on GitHub
  * Each issue should be assigned story points using a label
  * Story points contribution of each team member should be indicated in a comment
 
 ## Incomplete Issues/User Stories
 Here are links to issues we worked on but did not complete in this sprint:
 
 * URL of issue 1 <<One sentence explanation of why issue was not completed>>
 * URL of issue 2 <<One sentence explanation of why issue was not completed>>
 * URL of issue n <<One sentence explanation of why issue was not completed>>
 
 Examples of explanations (Remove this section when you save the file):
  * "We ran into a complication we did not anticipate (explain briefly)." 
  * "We decided that the feature did not add sufficient value for us to work on it in this sprint (explain briefly)."
  * "We could not reproduce the bug" (explain briefly).
  * "We did not get to this issue because..." (explain briefly)

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
 
## Retrospective Summary
Here's what went well:
  * The foundation is laid out now, so progress should be able to move a lot quicker.
  * We are communicating frequently.
 
Here's what we'd like to improve:
   * We started pretty late, which has us scrambling a little bit.
   * It was harder to divvy up work at least until we got our initial setup, so going forward, work will be split up better.
  
Here are changes we plan to implement in the next sprint:
   * Starting work earlier.
   * Plan to have a better plan on creating branches and naming conventions.