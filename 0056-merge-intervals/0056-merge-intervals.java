class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
            return a[0]-b[0];
        }});
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ans.isEmpty()||intervals[i][0]>ans.get(ans.size()-1).get(1))
            ans.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            else
            ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),intervals[i][1]));
        }
        int[][] result=new int[ans.size()][];
        for(int i=0;i<ans.size();i++){
            List<Integer> row=ans.get(i);
            result[i]=new int[row.size()];
            for(int j=0;j<row.size();j++){
                result[i][j]=row.get(j);
            } 
        }
        return result;
    }
}