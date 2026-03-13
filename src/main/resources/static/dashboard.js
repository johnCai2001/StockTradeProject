document.addEventListener("DOMContentLoaded", () => {

    console.log("dashboard.js 已載入");

    fetch("/api/getstocks")
        .then(response => {
            if (!response.ok) {
                throw new Error("API 請求失敗: " + response.status);
            }
            return response.json();
        })
        .then(data => {
            console.log("前端收到股票資料:", data);

            const output = document.getElementById("output");

            if (output) {
                output.innerHTML = JSON.stringify(data, null, 2);
            }
        })
        .catch(error => {
            console.error("發生錯誤:", error);
        });

});