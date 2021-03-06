NPE

Java 14: Helpful NullPointerException Messages
A new JVM option, -XX:+ShowCodeDetailsInExceptionMessages, has been introduced in Java 14, in order to provide helpful NullPointerException messages showing precisely what was null when a NullPointerException occurred. For example, consider the code below:

var name = library.get("My Book").getAuthor().getName();
Before Java 14, the JVM would only print the method, filename, and line number that caused the NPE:

Exception in thread "main" java.lang.NullPointerException
 at Library.main(Library.java:7)
As you can tell, this error message is not very useful because it is impossible to determine which variable was actually null (without using a debugger). Was it the library, the book returned from the library, or the author of the book?

In Java 14, after enabling -XX:+ShowCodeDetailsInExceptionMessages, you will get the following message:

Exception in thread "main" java.lang.NullPointerException: 
Cannot invoke "Author.getName()" because the return value of "Book.getAuthor()" is null
 at Library.main(Library.java:7)
The exception message pinpoints what was null (Book.getAuthor()) and also displays the action that could not be performed as a result of this (Author.getName()).