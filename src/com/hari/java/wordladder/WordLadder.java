package com.hari.java.wordladder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.hari.utils.IOUtils;

public class WordLadder {

	private String startWord;
	
	private String endWord;
	
	private String[] dictArray;
	
	public WordLadder(String startWord, String endWord, String[] dictArray) {
		this.startWord = startWord;
		this.endWord = endWord;
		this.dictArray = dictArray;
	}
	
	public static void main(String[] args) {
		System.out.print("Enter Array String seperated by comma : ");
		String dict = IOUtils.readString();
		String[] dictArray = dict.split(",");
		System.out.print("Enter start String : ");
		String start = IOUtils.readString();
		System.out.print("Enter end String : ");
		String end = IOUtils.readString();
		WordLadder wl = new WordLadder(start, end, dictArray);
		Set<String> selectedSet = new HashSet<String>();
		Map<String, Set<String>> dictMap = new HashMap<String, Set<String>>();
		wl.process(start, selectedSet, dictMap);
		wl.chooseRoutes(dictMap, null, start);
		//display(dictMap);
	}

	public void process(String start, Set<String> selectedSet, Map<String, Set<String>> dictMap) {
		if (!selectedSet.contains(start)) {
			Set<String> set = getSet(dictArray, start, selectedSet);
			selectedSet.add(start);
			if (set == null) {
				return;
			}
			dictMap.put(start, set);
			
			for(String st : set) {
				process(st, selectedSet, dictMap);
			}
		}
	}

	public static void display(Map<String, Set<String>> dictMap) {
		Set<String> keys = dictMap.keySet();
		for(String key : keys) {
			System.out.println(key +" --> " );
			Set<String> values = dictMap.get(key);
			if (values != null) {
				for(String value : values) {
					System.out.println("\t\t"+value);
				}
			}
		}
	}
	
	public void chooseRoutes(Map<String, Set<String>> dictMap, String route, String start) {
		if (route != null) {
			route = route + start;
		} else {
			route = start;
		}
		Set<String> keys = dictMap.get(start);
		if (keys != null) {
			if (keys.contains(endWord)) {
				route = route + " --> " + endWord;
				System.out.println("Route === " + route);
				return;
			} else {
				for(String key : keys) {
					route = route + " --> ";
					chooseRoutes(dictMap, route, key);
				}
			}
		}
	}
	
	public static Set<String> getSet(String[] dictArray, String str, Set<String> selectedSet) {
		Set<String> set = new HashSet<String>();
		for(String st : dictArray) {
			if (!st.equals(str) && !selectedSet.contains(st)) {
				if (isSimilar(str, st)) {
					set.add(st);
				}
			}
		}
		return set.size()>0?set:null;
	}
	
	public static boolean isSimilar(String st1, String st2) {
		int charAt = 0;
		for(int ind=0; ind<st1.length(); ind++) {
			if (st1.charAt(ind) == st2.charAt(ind)) {
				charAt++;
			}
		}
		if (charAt == 2) {
			return true;
		}
		return false;
	}
	
}
