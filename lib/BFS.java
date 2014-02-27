package lib;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BFS {
	
	static class NodeEntry <K, V>{
		private K node;
		public K getNode() {
			return node;
		}
		public V getValue() {
			return value;
		}
		public K getRelativeNodeK() {
			return relativeNodeK;
		}
		V value;
		K relativeNodeK;
		public NodeEntry(K node, V value, K relativeNodeK) {
			this.node = node;
			this.value = value;
			this.relativeNodeK = relativeNodeK;
		}
	}

	public static <T> List<List<T>> getShortestPath(Map<T, List<T>> graph, T source, T end) {
		Map<T, List<T>> parentMap = new HashMap<T, List<T>>();
		if (source == end || source.equals(end)) {
			parentMap.put(source, new ArrayList<T>(Arrays.asList(source)));
			return getPath(parentMap, source);
		}
		Queue<NodeEntry<T, Integer>> toHandleQueue = new LinkedList<NodeEntry<T, Integer>>();
		
		Map<T, Integer> peekedSet = new HashMap<T, Integer>();
		peekedSet.put(source, 0);
		toHandleQueue.add(new NodeEntry<T, Integer>(source, 0, source));
		parentMap.put(source, new ArrayList<T>(Arrays.asList(source)));
		while (!toHandleQueue.isEmpty()) {
			NodeEntry<T, Integer> entry = toHandleQueue.poll();
			for (T neighbor : graph.get(entry.getNode())) {
				if (!peekedSet.containsKey(neighbor)) {
					toHandleQueue.add(new NodeEntry<T, Integer>(neighbor, entry.getValue() + 1, entry.getNode()));
					parentMap.put(neighbor, new ArrayList<T>(Arrays.asList(entry.getNode())));
					peekedSet.put(neighbor, entry.getValue() + 1);
				} else {
					if (entry.getValue() + 1 == peekedSet.get(neighbor)) {
						List<T> t = parentMap.get(neighbor);
						t.add(entry.getNode());
					}
				}
				
			}
		}
		
		if (peekedSet.containsKey(end)) {
			return getPath(parentMap, end);
		} else {
			return null;
		}
	}
	
	private static <T> List<List<T>> getPath(Map<T, List<T>> parentMap, T from) {
		if(!parentMap.containsKey(from)) {
			return null;
		}
		List<List<T>> result = new ArrayList<List<T>>();
		if (parentMap.get(from).get(0).equals(from)) {
			result.add(new ArrayList<T>(Arrays.asList(from)));
			return result;
		}
		for (T parent : parentMap.get(from)) {
			List<List<T>> subPaths = getPath(parentMap, parent);
			for (List<T> path: subPaths) {
				path.add(from);
				result.add(path);
			}
		}
		
		return result;
		
	}
	
	// for test
	private static Map<Integer, List<Integer>> graph;
	private static List<List<Integer>> path;
	
	@BeforeClass
	public static void  init() {
		graph = new HashMap<Integer, List<Integer>>();
		graph.put(0, Arrays.asList(1, 4, 7));
		graph.put(1, Arrays.asList(0, 2, 3));
		graph.put(2, Arrays.asList(1, 5));
		graph.put(3, Arrays.asList(1, 6));
		graph.put(4, Arrays.asList(0, 5));
		graph.put(5, Arrays.asList(2, 4, 6, 7));
		graph.put(6, Arrays.asList(3, 5));
		graph.put(7, Arrays.asList(0, 5));
	}
	
	@Before
	public void setup() {
		path = new ArrayList<List<Integer>>(); 
	}
	
	@Test
	
	public void test1() {
		List<List<Integer>> result = getShortestPath(graph, 0, 6);
//		Assert.assertArrayEquals(new Object[] {0, 1, 3,6}, path.toArray());
		result = getShortestPath(graph, 0, 5);
		int i = 0;
//		Assert.assertArrayEquals(new Object[] {0, 4, 5}, path.toArray());
	}
	
	@Test
	public void test2() {
		List<List<Integer>> result = getShortestPath(graph, 0, 0);
		int i = 0;
//		Assert.assertArrayEquals(new Object[] {0}, path.toArray());
	}
	
	@Test
	public void test3() {
		List<List<Integer>> result = getShortestPath(graph, 0, 10);
		int i = 0;
//		Assert.assertArrayEquals(new Object[] {}, path.toArray());
	}

}
