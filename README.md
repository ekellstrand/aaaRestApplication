# Getting Started

# Design Docs
* [Billing Architecture PPT](docs/Billing%20Architecture.pptx)

# TODO

* Security
    * Authentication  (It's roughed in with a hard-coded API Key)
    * Authorization (Left it as generic accept all. non-trivial effort to add RBAC)
    * CORS, CSRF (It's roughed in)
    * Other OWASP items that I'd need to lookup again

* Quality
    * Input data validation
    * Implement REST Syntax Tests (ensure data in DB actually matches what was input and visa versa)
    * Standard REST Exceptions and Advise classes (ObjectNotFound, Invalid Input, etc)

* Project-Related
    * Add Static Analysis to build
    * Add Dependency license check to build to ensure permissive libraries
    * Add Pretty Printer to build to enforce code style

* Logging & Monitoring
    * Hooks to enable logging by module while running
    * Hooks to enable performance metrics (e.g. Request/Response time) while running

## Build and Run

* `gradlew build`
* `gradlew bootRun`

## Docker

* `gradlew bootBuildImage --imageName=springio/gs-spring-boot-docker`
* `docker run -p 8080:8080 -t springio/gs-spring-boot-docker`

## Testing

* List CRUD APIs:  `curl  "http://localhost:8080" --header 'X-API-KEY:magicalBackdoorCisoNightmare'`
* List Custom Object APIs:  `curl  "http://localhost:8080/bills/search" --header 'X-API-KEY:magicalBackdoorCisoNightmare'`
* Get Bills: `curl  "http://localhost:8080/bills" --header 'X-API-KEY:magicalBackdoorCisoNightmare'`

## Example

* Retrieve premium schedule for a policy
    * `curl  "http://localhost:8080/policies/1" --header 'X-API-KEY:magicalBackdoorCisoNightmare'`
* Record a payment attempt and its result (success/failure)
    *
    `curl -X POST "http://localhost:8080/payments" -H "Content-Type:application/json" -d "{\"policyHolderId\":1,\"billId\":1,\"paymentMethodId\":1,\"paymentDate\":\"2025-05-27\",\"amount\":27.94,\"status\":\"NEW\"}" --header 'X-API-KEY:magicalBackdoorCisoNightmare'`
    *
    `curl -X POST "http://localhost:8080/payments" -H "Content-Type:application/json" -d "{\"policyHolderId\":1,\"billId\":1,\"paymentMethodId\":1,\"paymentDate\":\"2025-05-27\",\"amount\":27.94,\"status\":\"SUCCESS\"}" --header 'X-API-KEY:magicalBackdoorCisoNightmare'`
    *
    `curl -X POST "http://localhost:8080/payments" -H "Content-Type:application/json" -d "{\"policyHolderId\":1,\"billId\":1,\"paymentMethodId\":1,\"paymentDate\":\"2025-05-27\",\"amount\":27.94,\"status\":\"FAIL\"}" --header 'X-API-KEY:magicalBackdoorCisoNightmare'`
    * Return a list of policies that are delinquent
    *
    `curl "http://localhost:8080/bills/search/findByDueDateBeforeAndStatus?dueDate=2025-06-27&status=DUE" --header 'X-API-KEY:magicalBackdoorCisoNightmare'`
* Trigger a retry action for failed payments
    * The logic for retry will be baked into the  [PaymentSchedulerController](src/main/java/com/kellstrand/aaarest/scheduler/paymentScheduler/PaymentSchedulerController.java)