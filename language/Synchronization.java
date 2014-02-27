package language;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Synchronization {
	static public  void main(String[] args) {
	}
	
	public static class Friend{
		private final String name;
		private final Lock lock = new ReentrantLock();
		
		public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
	}
}
