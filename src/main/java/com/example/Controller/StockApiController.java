package com.example.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.CompanyRelationDto;
import com.example.Dto.StockDto;
import com.example.Dto.StockPricePointDto;
import com.example.Service.DashboardService;
import com.example.Service.StockService;

@RestController
@RequestMapping("/api")
public class StockApiController {

	private final StockService stockService;
 
    private final DashboardService dashboardService;

    public StockApiController(StockService stockService, DashboardService dashboardService) {
        this.stockService = stockService;
        this.dashboardService = dashboardService;
    }
    
    // 取得股票列
    @GetMapping("/getstocks")
    public List<StockDto> getStocks() {
        return stockService.getMockStocks();
    }

    // 取得一年股價
    @GetMapping("/{stockCode}/prices")
    public List<StockPricePointDto> getStockPricePointDto(@PathVariable String stockCode) {
        return stockService.getMockPriceHistory(stockCode);
    }

    // 取得公司上下游
    @GetMapping("/{stockCode}/relations")
    public List<CompanyRelationDto>  getCompanyRelationDto(@PathVariable String stockCode) {
        return dashboardService.getMockCompanyRelations(stockCode);
    }
    
}
