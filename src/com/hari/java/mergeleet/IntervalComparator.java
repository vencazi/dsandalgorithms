package com.hari.java.mergeleet;

import java.util.Comparator;

public class IntervalComparator implements Comparator<Interval> {

	public int compare(Interval o1, Interval o2) {
		int st1 = o1.getStart();
		int st2 = o2.getStart();
		return st1 - st2;
	}
	
}
