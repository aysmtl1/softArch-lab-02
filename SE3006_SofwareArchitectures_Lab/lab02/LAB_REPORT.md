# SE 3006: Software Architecture - Lab 02 Report

**Submitted by:** Aysu Mutlu  
**Student Number:** 220717712  
**Topic:** Transitioning from Layered Architecture to Modular Monolith  

---

## 1. Objective
The objective of this laboratory session was to refactor the **Three-Tier Layered Architecture** from Lab 01 into a **Modular Monolith**. The primary focus was on implementing **Information Hiding**, defining strict **Module Boundaries**, and ensuring that inter-module communication occurs exclusively through public **Interfaces** rather than shared internal implementations.

---

## 2. Comparison: Lab 01 vs. Lab 02
This transition represents a significant architectural shift from horizontal technical layers to vertical business domains:

| Feature | Lab 01: Layered Architecture | Lab 02: Modular Monolith |
| :--- | :--- | :--- |
| **Organization** | Horizontal (Presentation → Logic → Data) | Vertical Business Modules (`Catalog` & `Orders`) |
| **Access Control** | Most classes were `public` | Strict use of `package-private` (default) visibility |
| **Coupling** | `OrderService` coupled to `ProductRepository` | `OrderService` coupled only to `CatalogService` API |
| **Visibility** | Internal models (`Product`) leaked globally | Internal models encapsulated within modules |
| **Wiring** | Manual instantiation in `Main` | Managed via the **Factory Pattern** |

---

## 3. Implementation Details

### Task 1: Catalog Module & Information Hiding
In the `Catalog` module, I applied **Encapsulation** by setting classes such as `Product`, `ProductRepository`, and `CatalogServiceImpl` to **package-private** access. 
* This architectural constraint ensures that the `Orders` module cannot bypass the service layer to manipulate product data directly.
* The only exposed entry point for the module is the `CatalogService` interface.

### Task 2: Cross-Module Communication
The `Orders` module was refactored to be completely decoupled from the product implementation details.
* `OrderService` no longer interacts with `Product` entities. Instead, it relies on the contract defined by `catalogService.checkAndReduceStock()`.
* This reduction in **Tight Coupling** allows for independent changes within the Catalog module without impacting the Order processing logic.

### Task 3: The Factory Pattern (Modular Wiring)
I implemented `CatalogFactory` and `OrdersFactory` to manage the complexity of internal dependency wiring.
* Unlike Lab 01, where the `Main` class acted as a global orchestrator, Lab 02 uses Factories to hide assembly details. 
* `Main` only interacts with the public factories to retrieve the required controller, maintaining the integrity of modular boundaries.

---

## 4. Execution & Test Results
The system was validated against various business scenarios to confirm that architectural constraints correctly handle both successful and failed requests:

```text
🚀 System Starting in Modular Monolith Mode...
----------------------------------------------

--- Test Scenarios ---
>>> New Request: Product ID=1, Quantity=2
Stock updated successfully for 1. New stock: 3
Order processed successfully for Product ID: 1
✅ Order Confirmed

>>> New Request: Product ID=1, Quantity=10
❌ ERROR: Insufficient stock! Available: 3, Requested: 10

>>> New Request: Product ID=99, Quantity=1
❌ ERROR: Product not found with ID: 99