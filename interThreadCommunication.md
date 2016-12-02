#inter thread communication

1.Two threads can communicate with each other by using wait(), notify(), notifyall() methods. The thread which is expecting updation is responsible to call wait() then immediately the thread will enter into waiting state. The thread which is responsible to perform updation, after performing updation it is responsible to call notify() then waiting thread will get that notification and continue its execution with those updated items.

2.wait(), notify(), notifyAll() methods present in object class but not in thread class because, thread can call these methods on any java objects.

3. To call wait(), notify() or notifyall() methods on any object, thread should be owner of that object i.e the thread should have lock of that object i.e the thread should be inside synchronized area. Hence, we can call wait(), notify() and notifyall() methods only from synchronized area otherwise we will get runtime exception saying IllegalMonitorStateException.

4. If a thread calls wait() on any object it immediately releases the lock of that particular object and enter into waiting state.

5. If a thread calls notify() on any object it releases the lock of that object but may not be immediately. Except wait(), notify() and notifyall() there is no other method where thread releases the lock.

public final void wait();
public final native void wait(long ms);
public final void wait(long ms, int ns);

throws InterruptedException

public final native void notify();
public final native void notifyAll();   


From the waiting state after calling t.wait() it will go to another waiting state to acquire lock of that object.(since it is notified by another thread)

#producer consumer problem
producer thread is responsible to produce items to the queue and consumer thread is responsible to consume items from the queue. If queue is empty then consumer thread, will call wait() and entered into waiting state. After producing items to queue producer thread is responsible to call notify method then waiting consumer will get the notification and continue its execution with updated items.

#difference notify() and notifyAll()
We can use notify method to give the notification for only one waiting thread. If multiple threads are waiting then only one thread will be notified and the remaining threads have to wait for further notifications. Which thread will be notified we can't expect, it depends on JVM. 

We can use notifyAll()to give the notification for all waiting threads of a particular object. Even though multiple threads notified but execution will be performed one by one because threads require lock and only one lock is available.

On which object we are calling wait method, thread requires the lock of that particular object. for example if we are calling wait() on s1 then we have to get lock of s1 object but not on s2.

#Deadlock
IF two threads are waiting for each other forever such type of infinite waiting is called deadlock. Synchronized keyword is the only reason for dead lock situation. Hence, while using synchronized keyword we have to take special care.

There are no resolution techniques for dead lock but several prevention techniques are available.