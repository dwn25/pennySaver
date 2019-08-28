package com.Support.Forex;

import com.Support.Constant;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
/**
 *
 * @author DNartey
 */
public class Stocks {
    
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
    }

  public static Double getPrice(String symb) throws IOException {
        String url = "https://www.alphavantage.co/query?"
                + "function=GLOBAL_QUOTE&"
                + "symbol="+symb+"&"
                + "outputsize=compact&"
                + "apikey="+Constant.alphaVantageAPIKey;
        System.out.println(url);
        InputStream is = new URL(url).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          JsonObject jsonObject = new JsonParser().parse(jsonText).getAsJsonObject();
          //String pageName = jsonObject.getAsJsonObject("Global Quote").get("01. symbol").getAsString();
          Double price = jsonObject.getAsJsonObject("Global Quote").get("05. price").getAsDouble();
          System.out.println("Double price: " + price);
          //System.out.println("Symbol " + pageName);
          return price;
        }
        finally{
          is.close();
        }
  }


    /*public static boolean checkSymbol(String symb) throws MalformedURLException, IOException{
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
    }*/
  
  
      public static boolean checkSymbol(String symb) throws IOException, MalformedURLException {
          boolean cryp = false;
          String url = "https://www.alphavantage.co/query?"
                + "function=GLOBAL_QUOTE&"
                + "symbol="+symb+"&"
                + "outputsize=compact&"
                + "apikey="+Constant.alphaVantageAPIKey;
          
        /*URL url = new URL("https://www.alphavantage.co/query?"
                + "function=CURRENCY_EXCHANGE_RATE&"
                + "from_currency="+symb+"&"
                + "to_currency=usd&"
                + "apikey="+Constant.alphaVantageAPIKey);*/
                InputStream is = new URL(url).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          JsonObject jsonObject = new JsonParser().parse(jsonText).getAsJsonObject();
          Double price = jsonObject.getAsJsonObject("Global Quote").get("05. price").getAsDouble();
          System.out.println("Price:  " + price);
          cryp = true;
          return cryp;
        }
        catch(Exception e){
          cryp = false;
          return cryp;
        }
        finally{
          is.close();
        }
      }
}