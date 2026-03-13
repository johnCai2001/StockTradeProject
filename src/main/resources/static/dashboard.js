document.addEventListener("DOMContentLoaded", () => {
  loadStocks();
async function loadStocks() {
    try {
        const response = await fetch("/api/stocks");
        const stocks = await response.json();
        const stockList = document.getElementById("stockList");
        
		stockList.innerHTML = "";
        stocks.forEach(stock => {
            const card = document.createElement("div");
            card.className = "stock-card";
            card.innerHTML = `
                <h3>${stock.stockCode}</h3>
                <p>${stock.companyName}</p>
                <p>現價：${stock.currentPrice}</p>
                <p>漲跌：${stock.change}</p>
            `;

            card.addEventListener("click", () => {
                loadPriceHistory(stock.stockCode);
                loadRelations(stock.stockCode);
            });

            stockList.appendChild(card);
        });
    } catch (error) {
        console.error("載入股票列表失敗:", error);
    }
}

async function loadPriceHistory(stockCode) {
    try {
        const response = await fetch(`/api/stocks/${stockCode}/prices`);
        const prices = await response.json();

        document.getElementById("chartTitle").textContent = `${stockCode} 一年股價走勢`;

        const chartArea = document.getElementById("chartArea");
        chartArea.innerHTML = `
            <pre>${JSON.stringify(prices, null, 2)}</pre>
        `;
    } catch (error) {
        console.error("載入股價資料失敗:", error);
    }
}

async function loadRelations(stockCode) {
    try {
        const response = await fetch(`/api/stocks/${stockCode}/relations`);
        const relations = await response.json();

        document.getElementById("relationTitle").textContent = `${stockCode} 公司上下游關係`;

        const relationList = document.getElementById("relationList");
        relationList.innerHTML = "";

        relations.forEach(relation => {
            const item = document.createElement("div");
            item.className = "relation-item";
            item.innerHTML = `
                <p><strong>公司：</strong>${relation.companyName}</p>
                <p><strong>關係：</strong>${relation.relationType}</p>
                <p><strong>說明：</strong>${relation.description}</p>
            `;
            relationList.appendChild(item);
        });
    } catch (error) {
        console.error("載入公司關係失敗:", error);
    }
}