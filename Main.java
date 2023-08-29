package com.pallindrome;

import java.util.PriorityQueue;

public class Main {
    static class pair implements Comparable<pair>{
        int value;
        int index;

        public pair(int value,int index){
            this.value=value;
            this.index=index;
        }
        @Override
        public int compareTo(pair p2){
            //ascending
            //return this.value-p2.value;
            //descending
            return p2.value-this.value;
        }

    }

    public static void main(String[] args) {//time complexity ->0(nlogk)
	int array[]={1,3,-1,-3,5,3,6,7};
    int k=3;//window size
        int res[]=new int[array.length-k+1];//n-k+1

        PriorityQueue<pair>pq=new PriorityQueue<>();
        //1ST window
        for (int i=0;i<k;i++){
            pq.add(new pair(array[i],i));
        }
        res[0]=pq.peek().value;
        //calculating for other windows
        for (int i=k;i< array.length;i++){
            while (pq.size()>0 && pq.peek().index<=(i-k)){
                pq.remove();
            }
            pq.add(new pair(array[i],i));  //new element store
            res[i-k+1]=pq.peek().value;//window number=i-k+1
        }

        //print result
        for(int i=0;i< res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();

    }
}
