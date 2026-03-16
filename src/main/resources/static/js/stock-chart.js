let stockChart = null;

function renderStockChart(stockCode, prices) {

    const labels = prices.map(p => p.month);
    const data = prices.map(p => p.price);

    const ctx = document.getElementById("stockChart").getContext("2d");

    if (stockChart) {
        stockChart.destroy();
    }

    stockChart = new Chart(ctx, {
        type: "line",
        data: {
            labels: labels,
            datasets: [{
                label: stockCode + " 股價",
                data: data,
                borderColor: "#3b82f6",
                backgroundColor: "rgba(59,130,246,0.1)",
                borderWidth: 2,
                tension: 0.3,
                pointRadius: 4
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    display: true
                }
            },
            scales: {
                y: {
                    beginAtZero: false
                }
            }
        }
    });
}