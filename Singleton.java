
public class Singleton {
	private static volatile Singleton ins;
	
	private Singleton() {}
	
	public static Singleton getIns() {
		if (ins == null) {
			synchronized(Singleton.class) {
				if (ins == null) {
					ins = new Singleton();
				}
			}
		}
		
		return ins;
	}
}
