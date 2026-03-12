package Dto;

public class CompanyRelationDto {

    private String companyName;
    
    private String relationType;
    
    private String relatedCompanyName;

    public CompanyRelationDto() {
    }

    public CompanyRelationDto(String companyName, String relationType, String relatedCompanyName) {
        this.companyName = companyName;
        this.relationType = relationType;
        this.relatedCompanyName = relatedCompanyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getRelatedCompanyName() {
        return relatedCompanyName;
    }

    public void setRelatedCompanyName(String relatedCompanyName) {
        this.relatedCompanyName = relatedCompanyName;
    }
}