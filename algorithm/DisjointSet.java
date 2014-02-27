package algorithm;

import java.lang.reflect.Array;

public class DisjointSet <T> {

	private int size;
	private T[] parent;
	private int[] rank;
	
	@SuppressWarnings("unchecked")
	public DisjointSet(Class<T> cls, int size) {
		this.size = size;
		parent = (T[]) Array.newInstance(cls, size);
		rank = new int[size];
	}
	
//	public T find(T ele) {
//		
//	}
}
