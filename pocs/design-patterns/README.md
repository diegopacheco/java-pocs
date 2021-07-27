### Patterns

Classical GOF Design Patterns in Java

![alt text](patterns.png "Design Patterns")

### Creational

* Abstract Factory: Creates an instance of several families of classes
    - JDK Samples:
        * javax.xml.parsers.DocumentBuilderFactory#newInstance()
        * javax.xml.transform.TransformerFactory#newInstance()
        * javax.xml.xpath.XPathFactory#newInstance()
* Builder: Separates object construction from its representation
    - JDK Samples:  
        * java.lang.StringBuilder#append() (unsynchronized)
        * java.lang.StringBuffer#append() (synchronized)
* Factory Method: Creates an instance of several derived classes
    - JDK Samples:
        * java.util.Calendar, ResourceBundle and NumberFormat getInstance() methods uses Factory pattern.
        * valueOf() method in wrapper classes like Boolean, Integer etc.
* Prototype: A fully initialized instance to be copied or cloned
    - JDK Samples:
        * clone() method
* Singleton: A class of which only a single instance can exist
    - JDK Samples:
        * Singleton design pattern is used in core java classes also, for example java.lang.Runtime, java.awt.Desktop.

### Structural

* Adapter: Match interfaces of different classes
    - JDK Samples:
        * java.util.Arrays#asList()
        * java.io.InputStreamReader(InputStream) (returns a Reader)
        * java.io.OutputStreamWriter(OutputStream) (returns a Writer)
* Bridge: Separates an object's interface from its implementation
    - JDK Samples:
        * N/A 
* Composite: A tree structure of simple and composite objects
    - JDK Samples:
        * java.awt.Container#add(Component) is a great example of Composite pattern in java and used a lot in Swing.
* Decorator: Add responsibilities to objects dynamically
    - JDK Samples:
        * Java IO classes, such as FileReader, BufferedReader, etc... 
* Facade: A single class that represents an entire subsystem
    - JDK Samples:
        * N/A  
* Flyweight: A fine-grained instance used for efficient sharing
    - JDK Samples:
        * All the wrapper classes valueOf() method uses cached objects showing use of Flyweight design pattern. The best example is Java String class String Pool implementation.
* Proxy: An object representing another object
    - JDK Samples:
        * Spring, Hibernate, JPA, Java RMI package uses proxy pattern.

### Behavioral

* Chain of responsibility: A way of passing a request between a chain of objects
    - JDK Samples:
        * java.util.logging.Logger#log()
        * javax.servlet.Filter#doFilter()
* Command: Encapsulate a command request as an object
    - JDK Samples:
        * Runnable interface (java.lang.Runnable) and Swing Action (javax.swing.Action) uses command pattern.
* Interpreter: A way to include language elements in a program
    - JDK Samples:
        * java.util.Pattern and subclasses of java.text.Format are some of the examples of interpreter pattern used in JDK.
* Iterator: Sequentially access the elements of a collection
    - JDK Samples:
        * Collection framework Iterator is the best example of iterator pattern
        * java.util.Scanner class also Implements Iterator interface
* Mediator: Defines simplified communication between classes
    - JDK Samples:
        * java.util.Timer class scheduleXXX() methods
        * Java Concurrency Executor execute() method.
        * java.lang.reflect.Method invoke() method.
* Memento: Capture and restore an object's internal state
    - JDK Samples:
        * N/A
* Observer: A way of notifying change to a number of classes
    - JDK Samples:
        * java.util.EventListener in Swing
        * javax.servlet.http.HttpSessionBindingListener
        * javax.servlet.http.HttpSessionAttributeListener
* State: Alter an object's behavior when its state changes
    - JDK Samples:
        * N/A
* Strategy: Encapsulates an algorithm inside a class
    - JDK Samples:
        * N/A
* Template method: Defer the exact steps of an algorithm to a subclass
    - JDK Samples:
        * All non-abstract methods of java.io.InputStream, java.io.OutputStream, java.io.Reader and java.io.Writer.
        * All non-abstract methods of java.util.AbstractList, java.util.AbstractSet and java.util.AbstractMap.
* Visitor: Defines a new operation to a class without change
    - JDK Samples:
        * N/A 

### Build 
```bash
./mvnw clean install 
```
