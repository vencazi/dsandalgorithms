package com.hari.java.mergeleet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import com.hari.utils.IOUtils;

/**
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author venkat
 *
 */

public class MergeLeetInsert {

	public static void main(String[] args) {
		System.out.print("Enter inputs in the form of a,b|c,d : ");
		String input = IOUtils.readString();
		StringTokenizer st = new StringTokenizer(input, "|");
		List<Interval> intervals = new ArrayList<Interval>();
		while(st.hasMoreTokens()) {
			String[] tokenArray = (st.nextToken()).split(",");
			intervals.add(new Interval(Integer.parseInt(tokenArray[0]), Integer.parseInt(tokenArray[1])));
		}
		
		System.out.print("Enter leet to be inserted a,b : ");
		String insertStr = IOUtils.readString();
		String[] insertArray = insertStr.split(",");
		Interval insertInterval = new Interval(Integer.parseInt(insertArray[0]), Integer.parseInt(insertArray[1]));
		
		intervals.add(insertInterval);
		
		
		Collections.sort(intervals, new IntervalComparator());
		MergeLeet.display(intervals);
		
		List<Interval> result = new ArrayList<Interval>();
		Interval prev = intervals.get(0);
		for(int ind=1; ind<intervals.size(); ind++) {
			Interval curr = intervals.get(ind);
			if (prev.getEnd() > curr.getStart()) {
				prev = new Interval(prev.getStart(), Math.max(curr.getEnd(), prev.getEnd()));
			} else {
				result.add(prev);
				prev = curr;
			}
		}
		result.add(prev);
		
		MergeLeet.display(result);
	}
	
}
