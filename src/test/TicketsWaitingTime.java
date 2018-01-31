package test;

import java.util.Scanner;
//29-01-2018-HackerRank Hiring Challenge
public class TicketsWaitingTime {
	//8/13
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long res;
        int tickets_size = 0;
        tickets_size = Integer.parseInt(in.nextLine().trim());

        int[] tickets = new int[tickets_size];
        for(int i = 0; i < tickets_size; i++) {
            int tickets_item;
            tickets_item = Integer.parseInt(in.nextLine().trim());
            tickets[i] = tickets_item;
        }

        int p;
        p = Integer.parseInt(in.nextLine().trim());

        res = waitingTime(tickets, p);
        System.out.println(res);
    }
	
	static long waitingTime(int[] tickets, int p) {
		int count = 0;
		while(tickets[p] != 0) {
			for(int i=0; i < tickets.length; i++) {
				if(tickets[i] != 0) {
					tickets[i] = tickets[i]-1;
					count++;
				}
				if(tickets[i] == 0 && i == p) {
					break;
				}
			}
		}
		return count;
    }
}
