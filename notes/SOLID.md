#### 1. S - Single responsibility ####
Class should only have one responsibility - should have only one reason to change.  
(example: Book, BookPrinter)
###### Benefits: ######
1. Testing - fewer test cases
2. Less functionality in a single class will have fewer dependencies.
3. Organization - easier to search thanks to the classes being small.

#### 2. O - Open for Extensions ####
Classes should be open for extension but closed for modification. (don't change code in the class, extend it to another)

#### 3. L - Liskov Substitution _(most complex)_ ####
If class A is a subtype of class B, we should be able to replace B with A without disrupting the behavior of our program.

#### 4. I - Interface segregation ####
Larger interfaces should be split into smaller ones. By doing so we can ensure that implementing classes only need 
to be concerned about the method that are of interest to them.
# ![img.png](img.png) --------------> ![img_1.png](img_1.png)

#### 5. D - Dependency inversion ####
The principle of dependency inversion refers to the decoupling of software modules. This way, instead of high-level modules depending on low-level modules, both will depend on abstractions.