package task1;

import java.util.*;

public class Solver {
    public static void main(String[] args) {
        int N;

        Scanner in = new Scanner(System.in);

        String input1 = in.nextLine();

        N = Integer.parseInt(input1);

        String input2 = in.nextLine();

        HashTable MyHash = new HashTable(N);

        StringTokenizer ST = new StringTokenizer(input2);

        while (ST.hasMoreTokens()) {
            MyHash.insert(Integer.parseInt(ST.nextToken(" ")), N);
        }
        for (int i = 0; i < N; i++) {
            System.out.println();
            System.out.print(i + ":" + " ");
            ListNode buff = MyHash.Get(i);
            if (buff != null) {
                while (buff.get_next() != null) {
                    System.out.print(buff.getValue());
                    System.out.print(" ");
                    buff = buff.get_next();
                }
            }
        }
    }

    static class ListNode {

        private int value;
        private ListNode next;

        void insert(int newValue) {
            value = newValue;
            next = new ListNode();
        }

        ListNode get_next() {
            return next;
        }

        int getValue() {
            return value;
        }
    }

    static class HashTable {
        HashTable(int N) {
            values = new ListNode[N];
        }

        private ListNode[] values;

        void insert(int newValue, int N) {
            ListNode count = new ListNode();
            int buff = newValue % N;
            if (values[buff] == null) {
                values[buff] = new ListNode();
                values[buff].insert(newValue);
            } else
                count = values[buff];
            while (count.get_next() != null) count = count.get_next();
            count.insert(newValue);
        }

        public ListNode Get(int i) {
            return values[i];


        }
    }
}