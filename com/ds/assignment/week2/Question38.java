package com.ds.assignment.week2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question38 {

	static int platform = 0;

	public static void main(String[] args) {
		Question38 q = new Question38();
		String[] arr = { "2.00", "2.10", "3.00", "3.00", "3.50", "5.00" };
		String[] dep = { "2.30", "2.40", "3.20", "4.30", "4.00", "5.20" };
		q.minPlatform(arr, dep);
		q.minPlatform2(arr, dep);
	}

	public int minPlatform(String[] arr, String[] dep) {
		if (arr.length != dep.length) {
			return 0;
		}
		List<Platform> platforms = new LinkedList<>();
		int[] arrival = new int[arr.length];
		int[] departure = new int[dep.length];
		for (int i = 0; i < arr.length; i++) {
			String[] split = arr[i].split("\\.");
			int t = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
			arrival[i] = t;
			split = dep[i].split("\\.");
			t = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
			departure[i] = t;
		}

		for (int i = 0; i < arr.length; i++) {
			if (platforms.size() == 0) {
				Platform p = new Platform(++platform, arrival[i], departure[i]);
				System.out.println("Train arrived at platform:" + p.getNumber());
				platforms.add(p);
			} else {
				boolean parked = false;
				for (Platform p : platforms) {
					if (arrival[i] > p.getEndTime()) {
						parked = true;
						p.setStartTime(arrival[i]);
						p.setEndTime(departure[i]);
						System.out.println("Train arrived at platform:" + p.getNumber());
						break;
					}
				}
				if (!parked) {
					Platform p = new Platform(++platform, arrival[i], departure[i]);
					platforms.add(p);
					System.out.println("Train arrived at platform:" + p.getNumber());
				}
			}
		}
		System.out.println(platforms.size());
		return platforms.size();
	}

	class Platform {
		int number;
		int startTime;
		int endTime;

		public int getStartTime() {
			return startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public int getNumber() {
			return number;
		}

		public Platform(int number, int startTime, int endTime) {
			super();
			this.number = number;
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}

	}

	public void minPlatform2(String[] arr, String[] dep) {
		int[] arrival = new int[arr.length];
		int[] departure = new int[dep.length];
		for (int i = 0; i < arr.length; i++) {
			String[] split = arr[i].split("\\.");
			int t = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
			arrival[i] = t;
			split = dep[i].split("\\.");
			t = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
			departure[i] = t;
		}

		int i = 0;
		int j = 0;
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int trains = 0;
		int platforms = 0;
		while (i < arrival.length) {
			if (arrival[i] < departure[j]) {
				platforms = Integer.max(platforms, ++trains);
				i++;
			} else {
				--trains;
				j++;
			}
		}
		System.out.println(platforms);
	}
}
