document.addEventListener("DOMContentLoaded", () => {
    loadStocks();
	console.log("JS LOADED");
});
  
//導入股票資訊至前端畫面
async function loadPriceHistory(stockCode) {
    const response = await fetch(`/api/${stockCode}/prices`);
    const prices = await response.json();
    document.getElementById("chartTitle").textContent = `${stockCode} 一年股價走勢`;

    const labels = prices.map(price => price.date);
    const data = prices.map(price => price.price);
    const ctx = document.getElementById("priceChart").getContext("2d");
	if (priceChart !== null) {
	       priceChart.destroy();
	   }
	   priceChart = new Chart(ctx, {
	       type: "line",
	       data: {
	           labels: labels,
	           datasets: [{
	               label: `/api/${stockCode}/prices`,
	               data: data,
	               borderWidth: 2,
	               tension: 0.3,
	               fill: false
	           }]
	       },
	       options: {
	           responsive: true,
	           maintainAspectRatio: false
	       }
	   });
    console.log("PriceHistory Chart LOADED");
}


//歷史股價
async function loadPriceHistory(stockCode) {
	
    const response = await fetch(`/api/${stockCode}/prices`);
    const prices = await response.json();

    const chartTitle = document.getElementById("chartTitle");
    const chartArea = document.getElementById("chartArea");

    chartTitle.textContent = `${stockCode} 一年股價走勢`;

    chartArea.innerHTML = "";

    prices.forEach(price => {

        const row = document.createElement("div");
        row.className = "price-row";

        row.innerHTML = `
            <span class="price-date">${price.date}</span>
            <span class="price-value">${price.price}</span>
        `;

        chartArea.appendChild(row);

    });

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
            <p><strong>說明：</strong>${relation.description}</p>
        `;
        relationList.appendChild(item);
		console.log("Relations LOADED");
	   
    });
}