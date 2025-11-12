package edu.monetary.domain;

import java.math.BigDecimal;

public class ConversionData{

    private BigDecimal amount; 
    private String baseCode; 
    private String targetCode;


    public ConversionData(BigDecimal amount, String baseCode, String targetCode) {
        this.amount = amount;
        this.baseCode = baseCode;
        this.targetCode = targetCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getBaseCode() {
        return baseCode;
    }


    public String getTargetCode() {
        return targetCode;
    }
    
}