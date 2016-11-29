package de.hfu.Buchstaben;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

	private Queue queue;
	private int param1=1, param2=2, param3=3;
	
	@Before
	public void erzeugeQueue(){
		queue = new Queue(3);
	}
	
	@Test(expected=IllegalArgumentException.class, timeout = 1000)
	public void QueueSizeTest() {
		queue = new Queue(0);
	}
	
	@Test(expected=IllegalStateException.class, timeout = 1000)
	public void Dequeue_EmptyTest() {
		queue.dequeue();
	}
	
	@Test
	public void QueueTest() {
		queue.enqueue(param1);
		queue.enqueue(param2);
		queue.enqueue(param3);
		assertEquals(param1,queue.dequeue());
		assertEquals(param2,queue.dequeue());
		assertEquals(param3,queue.dequeue());
	}
	
	@Test
	public void QueueRingTest() {
		queue.enqueue(0);
		queue.enqueue(0);
		queue.enqueue(0);
		queue.dequeue();
		queue.enqueue(param1);
		queue.dequeue();
		queue.dequeue();
		assertEquals(param1,queue.dequeue());
	}
	
	@Test
	public void QueueRingEndeTest() {
		queue.enqueue(0);
		queue.enqueue(0);
		queue.enqueue(0);
		queue.enqueue(param1);
		queue.enqueue(param2);
		queue.enqueue(param3);
		queue.dequeue();
		queue.dequeue();
		assertEquals(param3,queue.dequeue());
	}

}
