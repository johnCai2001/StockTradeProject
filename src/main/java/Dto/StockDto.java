package Dto;

public class StockDto {
	    
	    private String stockCode;
	    
	    private String stockName;
	    
	    private double currentPrice;
	    
	    private double changeAmount;
	    
	    private double changePercent;

	    public StockDto() {
	    }
	    
	    

		public StockDto(String stockCode, String stockName, double currentPrice, double changeAmount,
				double changePercent) {
			super();
			this.stockCode = stockCode;
			this.stockName = stockName;
			this.currentPrice = currentPrice;
			this.changeAmount = changeAmount;
			this.changePercent = changePercent;
		}



		public String getStockCode() {
			return stockCode;
		}

		public void setStockCode(String stockCode) {
			this.stockCode = stockCode;
		}

		public String getStockName() {
			return stockName;
		}

		public void setStockName(String stockName) {
			this.stockName = stockName;
		}

		public double getCurrentPrice() {
			return currentPrice;
		}

		public void setCurrentPrice(double currentPrice) {
			this.currentPrice = currentPrice;
		}

		public double getChangeAmount() {
			return changeAmount;
		}

		public void setChangeAmount(double changeAmount) {
			this.changeAmount = changeAmount;
		}

		public double getChangePercent() {
			return changePercent;
		}

		public void setChangePercent(double changePercent) {
			this.changePercent = changePercent;
		}
	    
}
