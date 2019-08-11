/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Support;
import java.awt.List;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import yahoofinance.*;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;
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
    
    public static boolean isStock(String stockName) throws IOException{
        try{
           Stock stock = YahooFinance.get(stockName);
           BigDecimal price = stock.getQuote(true).getPrice();
           System.out.println(price);
           return true;
        }
        catch(Exception e){
            System.out.println("Unable to locate");
            return false;
        }
    }
    /*
    public StockDto getStock(String stockName) throws IOException {
		StockDto dto = null;
		Stock stock = YahooFinance.get(stockName);
		return dto;
	}*/

	public static  Map<String, Stock> getStock(String[] stockNames) throws IOException {
		Map<String, Stock> stock = YahooFinance.get(stockNames);
		return stock;
	}

	/*public void getHistory(String stockName) throws IOException {

		Stock stock = YahooFinance.get(stockName);
		List<HistoricalQuote> history = stock.getHistory();
		for (HistoricalQuote quote : history) {
			System.out.println("====================================");
			System.out.println("symobol : " + quote.getSymbol());
			System.out.println("date : " + convertDate(quote.getDate()));
			System.out.println("High Price  : " + quote.getHigh());
			System.out.println("Low Price : " + quote.getLow());
			System.out.println("Closed price : " + quote.getClose());
			System.out.println("=========================================");
		}

	}

	public void getHistory(String stockName, int year, String searchType) throws IOException {
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.add(Calendar.YEAR, Integer.valueOf("-" + year));

		Stock stock = YahooFinance.get(stockName);
		List<HistoricalQuote> history = stock.getHistory(from, to, getInterval(searchType));
		for (HistoricalQuote quote : history) {
			System.out.println("====================================");
			System.out.println("symobol : " + quote.getSymbol());
			System.out.println("date : " + convertDate(quote.getDate()));
			System.out.println("High Price  : " + quote.getHigh());
			System.out.println("Low Price : " + quote.getLow());
			System.out.println("Closed price : " + quote.getClose());
			System.out.println("=========================================");
		}

	}
*/
	private String convertDate(Calendar cal) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String formatDate = format.format(cal.getTime());
		return formatDate;
	}

	private Interval getInterval(String searchType) {
		Interval interval = null;
		switch (searchType.toUpperCase()) {
		case "MONTHLY":
			interval = Interval.MONTHLY;
			break;
		case "WEEKLY":
			interval = Interval.WEEKLY;
			break;
		case "DAILY":
			interval = Interval.DAILY;
			break;

		}
		return interval;
	}
    /*
    public static boolean isStock(String name){
        boolean isStock = false;
        try{
            Stock stock = YahooFinance.get(name);
            BigDecimal price = stock.getQuote(true).getPrice();
            if(price.equals(null)){
                isStock = false;
            }
            else{
                isStock = true;
            }
        }catch(Exception er){
            System.out.println("Failed to get " + name);
        }
        return isStock;
    }   */
    
}
