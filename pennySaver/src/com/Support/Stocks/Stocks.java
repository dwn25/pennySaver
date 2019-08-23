package com.Support.Stocks;

import com.Support.Constant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import yahoofinance.*;

/**
 *
 * @author DNartey
 */
public class Stocks {
    
    public void Test(){
        try{
            Stock stock = YahooFinance.get("INTC");
            BigDecimal price = stock.getQuote().getPrice();
            BigDecimal change = stock.getQuote().getChangeInPercent();
            BigDecimal peg = stock.getStats().getPeg();
            BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
            stock.print();
        }
        catch(Exception e){
        
    }
        
    }
    
    public static boolean checkSymbol(String symb) throws MalformedURLException, IOException{
        boolean isSymbol = false;
        URL url = new URL("https://www.alphavantage.co/query?"
                + "function=GLOBAL_QUOTE&"
                + "symbol="+symb+"&"
                + "outputsize=compact&"
                + "apikey="+Constant.alphaVantageAPIKey);
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        String line = buff.readLine();
        while(line != null){
            if(line.contains("Error")){
                isSymbol = false;
            }
            else{
                isSymbol = true;
                return isSymbol;
            }
            System.out.println(line);
            line = buff.readLine();
        }
        return isSymbol;
    }
    
    public static void parse(){
        
    }
    
}
