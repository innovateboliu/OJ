package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;



public class WordLadderII {
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dog");
		WordLadderII ins = new WordLadderII();
		ArrayList<ArrayList<String>> result = ins.findLadders("hot", "dog", set);
		result = null;
//		HashSet<String> set = new HashSet<String>();
//		set.add("a");
//		set.add("b");
//		set.add("c");
//		WordLadderII ins = new WordLadderII();
//		ArrayList<ArrayList<String>> result = ins.findLadders("a", "b", set);
//		result = null;
	}
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		Map<String, List<String>> graph = new HashMap<String, List<String>>();
		dict.add(start);
		dict.add(end);
		for (String w : dict) {
			List<String> neighborsList = new ArrayList<String>();
			for (String y : dict) {
				if(wordsDifference(w, y) == 1) {
					neighborsList.add(y);
				}
			}
			graph.put(w, neighborsList);
		}
		return (ArrayList<ArrayList<String>>)getShortestPath(graph, start, end);
    }
	
	public int wordsDifference(String a, String b) {
		int len = a.length();
		int result = 0;
		for (int i = 0; i < len; i++) {
			if (a.charAt(i) != b.charAt(i)) 
				result++;
		}
		return result;
	}
	
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

	public static <T> List<ArrayList<T>> getShortestPath(Map<T, List<T>> graph, T source, T end) {
		Map<T, ArrayList<T>> parentMap = new HashMap<T, ArrayList<T>>();
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
					ArrayList<T> tmp = new ArrayList<T>();
					tmp.add(entry.getNode());
					parentMap.put(neighbor, tmp);
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
			return new ArrayList<ArrayList<T>>();
		}
	}
	
	private static <T> List<ArrayList<T>> getPath(Map<T, ArrayList<T>> parentMap, T from) {
		if(!parentMap.containsKey(from)) {
			return new ArrayList();
		}
		List<ArrayList<T>> result = new ArrayList<ArrayList<T>>();
		if (parentMap.get(from).get(0).equals(from)) {
			result.add(new ArrayList<T>(Arrays.asList(from)));
			return result;
		}
		for (T parent : parentMap.get(from)) {
			List<ArrayList<T>> subPaths = getPath(parentMap, parent);
			for (ArrayList<T> path: subPaths) {
				path.add(from);
				result.add(path);
			}
		}
		
		return result;
		
	}
}

