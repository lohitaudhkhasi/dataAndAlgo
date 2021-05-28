package com.ds.assignment.week1;

public class Question23 {

	public static void main(String[] args) {
		Question23 q = new Question23();
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		q.kadaneAlgo(arr);
	}

	public void kadaneAlgo(int[] arr) {
		int meh = 0;
		int msf = Integer.MIN_VALUE;
		int ml = -1;
		int mr = -1;

		for (int i = 0; i < arr.length; i++) {
			meh = meh + arr[i];
			if (meh < arr[i]) {
				meh = arr[i];
				ml = i;
			}
			// msf = Math.max(msf, meh);
			if (msf < meh) {
				msf = meh;
				mr = i;
			}
		}

		System.out.println(msf);
		System.out.println(ml + "," + mr);
		for (int i = ml; i <= mr; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
