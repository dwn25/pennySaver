package com.Support.Stocks;

import com.Support.Constant;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 *
 * @author DNartey
 */
public class Crypto {
        
        private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
    }
        
      public static boolean isCrypto(String symb) throws IOException, MalformedURLException {
          boolean cryp = false;
          String url = "https://www.alphavantage.co/query?"
                + "function=CURRENCY_EXCHANGE_RATE&"
                + "from_currency="+symb+"&"
                + "to_currency=usd&"
                + "apikey="+Constant.alphaVantageAPIKey;
                InputStream is = new URL(url).openStream();
                try {
              BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
              String jsonText = readAll(rd);
              JsonObject jsonObject = new JsonParser().parse(jsonText).getAsJsonObject();
              String pageName = jsonObject.getAsJsonObject("Realtime Currency Exchange Rate").get("5. Exchange Rate").getAsString();
              System.out.println("Symbol " + pageName);
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
        /*
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        String line = buff.readLine();
        while(line != null){
            if(line.contains("Error")){
                cryp = false;
            }
            else{
                cryp = true;
                return cryp;
            }
            System.out.println(line);
            line = buff.readLine();
        }
        return cryp;
  }*/
      
}