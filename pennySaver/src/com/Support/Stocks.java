/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Support;
import java.math.BigDecimal;
import yahoofinance.*;
/**
 *
 * @author DNartey
 */
public class Stocks {
    
    public Stocks(){}
    
    public void Test(){
        try{
        Stock stock = YahooFinance.get("INTC");
        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
        
    stock.print();}
        catch(Exception e){
        
    }
    }
}
