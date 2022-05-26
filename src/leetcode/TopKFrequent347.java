package leetcode;

import java.util.HashMap;
import java.util.Map;

class TopKFrequent347 {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            int v = mp.getOrDefault(nums[i], 0);
            mp.put(nums[i], v+1);
        }
        int z=0;
        int[] b = new int[n];
        for(Map.Entry<Integer, Integer>  entry : mp.entrySet()){
            System.out.println( entry.getValue());
            b[z++] = entry.getValue();
        }
        int w = quickSelect(b, 0, z-1, k);

        int[] result = new int[k];
        z=0;
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue()>=w){
                result[z++] = entry.getKey();
            }
        }
        return result;
    }

    int quickSelect(int[] a, int low, int hi, int k){
        if(low >=hi) return a[low];

        int pos = partition(a, low, hi);
        int r = pos - low + 1;
        if(k <= r){
            return quickSelect(a, low, pos, k);
        }
        else{
            return quickSelect(a, pos+1, hi, k-r);
        }
    }

    int partition(int[] a, int low, int hi){
        int p = low -1, q=hi+1, v = a[(low+hi)>>1];
        while(p<q){
            while(a[++p] > v);
            while(a[--q] < v);
            if(p<q) exch(a, p, q);
        }
        return q;
    }

    void exch(int[] a, int p, int q){
        int t = a[p];
        a[p] = a[q];
        a[q] = t;
    }
}