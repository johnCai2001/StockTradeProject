package com.example.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.Dto.StockDto;
import com.example.Dto.StockPricePointDto;

@Service
public class StockService {

    public List<StockDto> getMockStocks() {

        List<StockDto> stocks = new ArrayList<>();

        stocks.add(new StockDto("2330", "台積電", 950.0, 12.0, 1.28));
        stocks.add(new StockDto("2317", "鴻海", 168.5, -1.5, -0.88));
        stocks.add(new StockDto("2454", "聯發科", 1340.0, 25.0, 1.90));
        stocks.add(new StockDto("2303", "聯電", 52.3, -0.4, -0.76));
        stocks.add(new StockDto("2882", "國泰金", 61.8, 0.6, 0.98));

        return stocks;
    }

    public List<StockPricePointDto> getMockPriceHistory(String stockCode) {

        List<StockPricePointDto> priceHistory = new ArrayList<>();

        if ("2330".equals(stockCode)) {
            priceHistory.add(new StockPricePointDto("2025-01", 780.0));
            priceHistory.add(new StockPricePointDto("2025-02", 795.0));
            priceHistory.add(new StockPricePointDto("2025-03", 820.0));
            priceHistory.add(new StockPricePointDto("2025-04", 845.0));
            priceHistory.add(new StockPricePointDto("2025-05", 860.0));
            priceHistory.add(new StockPricePointDto("2025-06", 890.0));
            priceHistory.add(new StockPricePointDto("2025-07", 910.0));
            priceHistory.add(new StockPricePointDto("2025-08", 930.0));
            priceHistory.add(new StockPricePointDto("2025-09", 920.0));
            priceHistory.add(new StockPricePointDto("2025-10", 940.0));
            priceHistory.add(new StockPricePointDto("2025-11", 955.0));
            priceHistory.add(new StockPricePointDto("2025-12", 970.0));
        } else if ("2317".equals(stockCode)) {
            priceHistory.add(new StockPricePointDto("2025-01", 140.0));
            priceHistory.add(new StockPricePointDto("2025-02", 145.0));
            priceHistory.add(new StockPricePointDto("2025-03", 148.0));
            priceHistory.add(new StockPricePointDto("2025-04", 150.0));
            priceHistory.add(new StockPricePointDto("2025-05", 152.0));
            priceHistory.add(new StockPricePointDto("2025-06", 156.0));
            priceHistory.add(new StockPricePointDto("2025-07", 160.0));
            priceHistory.add(new StockPricePointDto("2025-08", 162.0));
            priceHistory.add(new StockPricePointDto("2025-09", 165.0));
            priceHistory.add(new StockPricePointDto("2025-10", 167.0));
            priceHistory.add(new StockPricePointDto("2025-11", 166.0));
            priceHistory.add(new StockPricePointDto("2025-12", 168.5));
        } else if ("2454".equals(stockCode)) {
            priceHistory.add(new StockPricePointDto("2025-01", 1100.0));
            priceHistory.add(new StockPricePointDto("2025-02", 1130.0));
            priceHistory.add(new StockPricePointDto("2025-03", 1165.0));
            priceHistory.add(new StockPricePointDto("2025-04", 1180.0));
            priceHistory.add(new StockPricePointDto("2025-05", 1210.0));
            priceHistory.add(new StockPricePointDto("2025-06", 1245.0));
            priceHistory.add(new StockPricePointDto("2025-07", 1270.0));
            priceHistory.add(new StockPricePointDto("2025-08", 1295.0));
            priceHistory.add(new StockPricePointDto("2025-09", 1310.0));
            priceHistory.add(new StockPricePointDto("2025-10", 1325.0));
            priceHistory.add(new StockPricePointDto("2025-11", 1332.0));
            priceHistory.add(new StockPricePointDto("2025-12", 1340.0));
        } else {
            priceHistory.add(new StockPricePointDto("2025-01", 100.0));
            priceHistory.add(new StockPricePointDto("2025-02", 102.0));
            priceHistory.add(new StockPricePointDto("2025-03", 101.0));
            priceHistory.add(new StockPricePointDto("2025-04", 105.0));
            priceHistory.add(new StockPricePointDto("2025-05", 108.0));
            priceHistory.add(new StockPricePointDto("2025-06", 110.0));
            priceHistory.add(new StockPricePointDto("2025-07", 112.0));
            priceHistory.add(new StockPricePointDto("2025-08", 111.0));
            priceHistory.add(new StockPricePointDto("2025-09", 114.0));
            priceHistory.add(new StockPricePointDto("2025-10", 116.0));
            priceHistory.add(new StockPricePointDto("2025-11", 118.0));
            priceHistory.add(new StockPricePointDto("2025-12", 120.0));
        }

        return priceHistory;
    }
}
