package leetcode.array;

public class BestTimeToBuyAndSellStockI {

	public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int rtn = 0;
        for(int i=0;i<prices.length;i++){
            if( prices[i]<minprice )
                minprice = prices[i];
            else 
                rtn = Math.max(rtn, prices[i]-minprice);
        }
        return rtn;
    }

}
