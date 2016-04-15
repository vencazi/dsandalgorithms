package com.hari.java.mergeleet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import com.hari.utils.IOUtils;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * @author venkat
 *
 */

public class MergeLeet {

	public static void main(String[] args) {
		System.out.print("Enter inputs in the form of a,b|c,d : ");
		String input = IOUtils.readString();
		StringTokenizer st = new StringTokenizer(input, "|");
		List<Interval> intervals = new ArrayList<Interval>();
		while(st.hasMoreTokens()) {
			String[] tokenArray = (st.nextToken()).split(",");
			intervals.add(new Interval(Integer.parseInt(tokenArray[0]), Integer.parseInt(tokenArray[1])));
		}
		
		Collections.sort(intervals, new IntervalComparator());

		display(intervals);
		
		List<Interval> result = new ArrayList<Interval>();
		Interval prev = intervals.get(0);
		for(int ind=0; ind<intervals.size(); ind++) {
			Interval curr = intervals.get(ind);
			if (prev.getEnd() < curr.getStart()) {
				result.add(prev);
				prev = curr;
			} else {
				prev = new Interval(prev.getStart(), curr.getEnd());
			}
		}
		result.add(prev);

		display(result);
	}

	public static void display(List<Interval> intervals) {
		for(Interval interval : intervals) {
			System.out.println(interval.toString());
		}
	}
	
}
