# AppDirect Distribution Integration Example

## System Architecture

### Overview
This system integrates with AppDirect Distribution API to enable distribution of sample SimpleBooks application with the AppDirect marketplace.
System is decomposed into independent REST services supporting decoupling, independent deployment , management and scaling.

### Services Design
Following are the runtime services component of the system.

* Notification API Gateway Service: Manages entire integration with AppDirect Distribution API. Consumes SimpleBooks Subscription Service for managing subscription in SimpleBooks.
  Developed in Spring.Boot (Java) exposes REST API.
  [Github repo](https://github.com/tarunjr/simplebooks-appdirect)

* SimpleBooks Subscription Service: A canonical implementation of Accounts and Subscription management. Developed in Spring.Boot (Java) exposes REST API.
  [Github repo](https://github.com/tarunjr/simplebooks-account)
