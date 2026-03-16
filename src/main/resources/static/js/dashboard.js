document.addEventListener("DOMContentLoaded", () => {
    loadStocks();
    document.getElementById("chartTitle").textContent = "";
    document.getElementById("chartArea").innerHTML = "";
    document.getElementById("relationTitle").textContent = "";
    document.getElementById("relationList").innerHTML = "";
    document.getElementById("chartEmpty").style.display = "block";
	document.getElementById("stockChart").style.display = "none";
	console.log("js data loaded");
});

//導入股票資訊至前端畫面
async function loadStocks() {
    const response = await fetch('/api/getstocks');
    const stocks = await response.json();

    const stockList = document.getElementById("stockList");
    stockList.innerHTML = "";

    stocks.forEach(stock => {
        const item = document.createElement("div");
		item.className = "stock-card";
        item.innerHTML = `
            <p><strong>代號：</strong>${stock.stockCode}</p>
            <p><strong>名稱：</strong>${stock.stockName}</p>
        `;
		item.addEventListener("click", () => {
		           loadPriceHistory(stock.stockCode);
		           loadRelations(stock.stockCode);
		           console.log("clicked:", stock.stockCode);
		       });
        stockList.appendChild(item);
    });
    console.log("Stocks LOADED");
}
  

//歷史股價
async function loadPriceHistory(stockCode) {
    const response = await fetch(`/api/${stockCode}/prices`);
    const prices = await response.json();
	const chartArea = document.getElementById("chartArea");
	  
	chartArea.innerHTML = "";
	  document.getElementById("chartTitle").textContent = `${stockCode} 一年股價走勢`;
 
    prices.forEach(price => {
        const row = document.createElement("div");
        row.className = "price-row";
        row.innerHTML = `
            <span class="price-date">${price.date}</span>
            <span class="price-value">${price.price}</span>
        `;
		
        chartArea.appendChild(row);
    });
	chartArea.onclick = () => {
				      loadPriceHistory(stock.stockCode);
				      loadRelations(stock.stockCode);
				  };			  
    renderStockChart(stockCode, prices);
    console.log("PriceHistory LOADED");
}


//廠商上下游關係
async function loadRelations(stockCode) {
    const response = await fetch(`/api/${stockCode}/relations`);
    const relations = await response.json();
    const relationList = document.getElementById("relationList");
    document.getElementById("relationTitle").textContent = `${stockCode} 公司上下游關係`;
    relationList.innerHTML = "";

    relations.forEach(relation => {
        const item = document.createElement("div");
        item.className = "relation-item";
        item.innerHTML = `
            <p><strong>公司：</strong>${relation.companyName}</p>
            <p><strong>關係：</strong>${relation.relationType}</p>
            <p><strong>說明：</strong>${relation.relatedCompanyName}</p>
        `;
        relationList.appendChild(item);
        console.log("Relations LOADED");
    });
}