package JUC.阻塞队列;

public interface BlockingQueue<E>{
     void put(E e) throws InterruptedException;
     E take() throws InterruptedException;
}