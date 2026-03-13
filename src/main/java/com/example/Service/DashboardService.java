package com.example.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Dto.CompanyRelationDto;

@Service
public class DashboardService {

    public List<CompanyRelationDto> getMockCompanyRelations(String stockCode) {

        List<CompanyRelationDto> relations = new ArrayList<>();

        if ("2330".equals(stockCode)) {
            relations.add(new CompanyRelationDto("台積電", "上游", "ASML"));
            relations.add(new CompanyRelationDto("台積電", "上游", "東京威力科創"));
            relations.add(new CompanyRelationDto("台積電", "上游", "應用材料"));
            relations.add(new CompanyRelationDto("台積電", "下游", "Apple"));
            relations.add(new CompanyRelationDto("台積電", "下游", "NVIDIA"));
            relations.add(new CompanyRelationDto("台積電", "下游", "AMD"));
        } else if ("2317".equals(stockCode)) {
            relations.add(new CompanyRelationDto("鴻海", "上游", "台積電"));
            relations.add(new CompanyRelationDto("鴻海", "上游", "聯發科"));
            relations.add(new CompanyRelationDto("鴻海", "下游", "Apple"));
            relations.add(new CompanyRelationDto("鴻海", "下游", "Sony"));
        } else if ("2454".equals(stockCode)) {
            relations.add(new CompanyRelationDto("聯發科", "上游", "台積電"));
            relations.add(new CompanyRelationDto("聯發科", "下游", "小米"));
            relations.add(new CompanyRelationDto("聯發科", "下游", "OPPO"));
            relations.add(new CompanyRelationDto("聯發科", "下游", "vivo"));
        } else {
            relations.add(new CompanyRelationDto("未知公司", "上游", "供應商A"));
            relations.add(new CompanyRelationDto("未知公司", "下游", "客戶B"));
        }

        return relations;
    }
}
