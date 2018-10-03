package leetcode.array;

public class BestTimeToBuyAndSellStockII {

	public int maxProfit(int[] prices) {
        int rtn = 0;
        for(int i=0;i<prices.length-1;i++){
            if( prices[i+1]>prices[i] )
                rtn += prices[i+1]-prices[i];
        }
        return rtn;
    }

}
