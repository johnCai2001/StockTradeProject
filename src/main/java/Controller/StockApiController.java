package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Dto.CompanyRelationDto;
import Dto.StockDto;
import Dto.StockPricePointDto;
import Service.DashboardService;
import Service.StockService;

@RestController
@RequestMapping("/APIstocks")
public class StockApiController {

    @Autowired
	private final StockService stockService;
    @Autowired
    private final DashboardService dashboardService;

    public StockApiController(StockService stockService, DashboardService dashboardService) {
        this.stockService = stockService;
        this.dashboardService = dashboardService;
    }

    // 取得股票列表
    @GetMapping("/api/getstocks")
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
