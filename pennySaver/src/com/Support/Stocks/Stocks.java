/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Support.Stocks;
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import static sun.java2d.cmm.ColorTransform.In;
import yahoofinance.*;

/**
 *
 * @author DNartey
 */
public class Stocks {
        public final String SYM = "";

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
    
    public static void scrape() throws MalformedURLException, IOException{
        System.setProperty("http.agent", "Chrome");
        URL url = new URL("https://www.google.com/search?q=ko&tbm=fin&hl=en#scso=_Qn9RXbKSAse5ggfjuhc6:0");
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        String line = buff.readLine();
        while(line != null){
            if(line.contains("[\"KO\","))
                System.out.println(line);
            line = buff.readLine();
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
