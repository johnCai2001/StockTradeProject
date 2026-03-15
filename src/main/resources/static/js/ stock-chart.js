let priceChart = null;
function renderStockChart(stockCode, prices) {
    const chartTitle = document.getElementById("chartTitle");
    const canvas = document.getElementById("priceChart");

    if (!canvas) {
        console.error("找不到 id=priceChart 的 canvas");
        return;
    }

    chartTitle.textContent = `${stockCode} 一年股價走勢`;

    const labels = prices.map(price => price.date);
    const data = prices.map(price => price.price);

    const ctx = canvas.getContext("2d");

    if (priceChart !== null) {
        priceChart.destroy();
    }

    priceChart = new Chart(ctx, {
        type: "line",
        data: {
            labels: labels,
            datasets: [
                {
                    label: `${stockCode} 股價`,
                    data: data,
                    borderWidth: 2,
                    tension: 0.3,
                    fill: false
                }
            ]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false
        }
    });
}