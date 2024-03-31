/**
* Types of ULM Diagrams 
*   1. Structural UML Diagrams (Deals with struckture of the code)
*       a) Class Diagram
*   2. Behavioural UML Diagrams (Deals with working behavioural or feature of system)
*       a) Use Case Diagram
*/

/** (Behavioural UML Diagrams)
 * 1. Use Case Diagram
 *  a) System Boundary
 *      
 *      E-commerce platform
 *      -------------
 *      ' Feature 1 '          
 *      ' Feature 2 '       
 *      ' Feature 3 '         
 *      '           '
 *      '-----------'
 *       
 *            
    ![System Boundary](image.png)

 * b) Use Case
    1. It is function or feature
    2. Labelled as a verb
    3. They are placed inside an oval   
    ![Use Case](image-1.png)

 * c) User/Actor
    1. They are represented by the thik figures
    2. They are nouns
    ![User/Actor](image-2.png)

 * d) Includes
    1. How one use case is dependent on another use case
    ![Includes](image-3.png)

 * d) Extends
    1. When a feature has multiple variants, and a special features extends a several feature
    ![Extends](image-4.png)



/** (Structural UML Diagrams)
    1. Class Diagram
    ![Class Diagram](image-5.png)

    2. Interface
    ![Interface](image-6.png)

    3. Abstraction
    ![Abstraction](image-7.png)

    4. Enums
    ![Enums](image-8.png)

/** Relationship between entities
    1. IS-A relationship
        - Parent child inheritance
        - Implementaiton of interface
    
    2. Association or HAS-A relationship
        - having an attribute of other entirty (Dependency)
        - Association can be of two types
            a) Composition
                - A relationship of two objects where object A exist only if B exist or vice versa.
                - Strong assocaition
            b) Aggregation
                - A relationship of two objects where both the object can exist without each other.
                - weak association 
        ![Assocaition](image-9.png)

        ![Assocaition Example](image-10.png)