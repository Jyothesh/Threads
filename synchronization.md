#Synchronization:

1.Synchronized is the modifier applicable only for methods and blocks but not for classes and variables.
2.If multiple threads are trying to operate simultaneously on the same java object then there may be a chance of data inconsistency problem. To overcome this problem, we should go for synchronized keyword.
3.If a method or block declared as synchronized then at a time only one thread is allowed to execute that method or block on the given object, so that data inconsistency problem will be resolved.

4.The main advantage of synchronized keyword is, we can resolve data inconsistency problems, but the main disadvantage of synchronized keyword is it increases waiting time of threads and creates performance problems. Hence, if there is no specific requirement then it is not recommended to use synchronized keyword.

Internally synchronization is implemented by using lock. Every object in java has a unique lock, when ever we are using synchronized keyword then lock concept will come into picture.

If a thread wants to execute synchronized method on the given object, first it has to get lock of that object. Once thread got the lock then it is allowed to execute any synchronized method on that object. Once method execution completes automatically thread releases the lock. Acquiring and releasing lock internally takes care by jvm and programmer not responsible for this activity.

while a thread executing synchronized method on the given object the remaining threads are not allowed to execute any synchronized method simultaneously on the same object, but threads are allowed to execute non synchronized methods simultaneously.

lock concept is implemented based on object but on method.

Non Synchronized area: This area can be accessed by any no threads simultaneously
Synchronized area: this area can be accessed by one thread at a time.
Ex: reservation system checkAvailability is non sync where as bookTickets is sync method.

If we are not declaring wish method as synchronized then both both threads will be executed simultaneously and hence we will get irregular output. If we declare wish method as synchronized then at a time only one thread is allowed to execute, wish method on the given display object(SynchronizedDemo.java). Hence we will get regular output.

Case Study: 

1. Even though wish method is synchronized we will get irregular output because threads are operating on different objects. If multiple threads are operating on same object then synchronization is required. If multiple threads are operating on multiple java objects then synchronization is not required.
 
#class level lock:
Every class in java has a unique lock, which is nothing but class level lock. If a thread wants to execute a static synchronized method then thread require class level lock. Once thread got class level lock then it is allowed to execute any static synchronized method of that class. Once method execution completes automatically thread releases the lock.

While a thread executing static synchronized method the remaining threads are not allowed to execute static synchronized methods of that class simultaneously. But, threads are allowed to execute the following methods simultaneously
1. normal static methods
2. synchronized instance methods
3. normal instance methods

If very few lines of code require synchronization, then it is not recommended to declare entire method as synchronized. We have to enclose those few lines of the code by using synchronized block.
The main advantage of synchronized block over synchronized method is it reduces waiting time of threads and improves performance of the system. 

We can declare synchronized block as follows:

synchronized(this) -- > to get lock of current object
synchronized(b) --> to get lock of particular object
synchronized(Display.class) --> to get lock of display class

lock concept is applicable for object types and class types but not for primitives. Hence, we can't pass primitive type as argument to synchronized block. otherwise we will get compile time error saying unexpected type found int required reference.

Race condition: If multiple threads are operating simultaneously on same java object then there may be a chance of data inconsistency problem. This is called race condition.

Yes, of course from different objects thread can acquire multiple locks.

synchronized statement:
The statements present in synchronized method and synchronized block are called synchronized statements.   