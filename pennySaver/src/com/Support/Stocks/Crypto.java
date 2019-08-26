package com.Support.Stocks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.Reader;

/**
 *
 * @author DNartey
 */
public class Crypto {
        
      public static boolean isCrypto(String symb) throws IOException, MalformedURLException {
          boolean cryp = false;
        URL url = new URL("https://www.alphavantage.co/query?"
                + "function=CURRENCY_EXCHANGE_RATE&"
                + "from_currency=BTC&"
                + "to_currency=usd&"
                + "apikey=I58H97J6G9Y75TXB");
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
  }
}
