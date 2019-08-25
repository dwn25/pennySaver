package com.Support.Stocks;

import com.Support.Constant;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
/**
 *
 * @author DNartey
 */
public class Stocks {
    
    public static void main() throws Exception {
            //URL url = new URL("https://httpbin.org/get?color=red&shape=oval");
            String symb = "MSFT";
            URL url = new URL("https://www.alphavantage.co/query?"
            + "function=GLOBAL_QUOTE&"
            + "symbol="+symb+"&"
            + "outputsize=compact&"
            + "apikey="+Constant.alphaVantageAPIKey);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            System.out.println(url.toString());
            System.out.println(reader.toString());
            BufferedReader buff = new BufferedReader(reader);
            String line = buff.readLine();
            Alpha json = new Gson().fromJson(reader, Alpha.class);
            System.out.println(json.price);
            while(line != null){
                System.out.println(line);
                line = buff.readLine();
            }
            System.out.println(json.price);
            }

    class Alpha {
        @SerializedName("01. symbol")public String symbol;
        @SerializedName("05. price")public Double price;
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
    
/*
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
  }
    
    private static String streamToString(InputStream inputStream) {
    String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
    return text;
  }
    
  public static void readJsonFromUrl() throws IOException, Exception {
    try {
        
         URL url = new URL("https://www.alphavantage.co/query?"
                + "function=GLOBAL_QUOTE&"
                + "symbol="+symb+"&"
                + "outputsize=compact&"
                + "apikey="+Constant.alphaVantageAPIKey);
             InputStream is = new URL(url).openStream();

        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        Object obj = new JSONParser().parse(jsonText); 
        JSONObject jo = (JSONObject) obj; 
          
        // getting firstName and lastName 
        String firstName = (String) jo.get("firstName"); 
        String lastName = (String) jo.get("lastName"); 
      //JSONObject json = new JSONObject(jsonText);
      
      InputStream inStream = connection.getInputStream();
      json = streamToString(inStream);
      
        "01. symbol": "MSFT",
        "02. open": "137.1897",
        "03. high": "138.3500",
        "04. low": "133.1300",
        "05. price": "133.2200",
        "06. volume": "17861578",
        "07. latest trading day": "2019-08-23",
        "08. previous close": "137.7800",
        "09. change": "-4.5600",
        "10. change percent": "-3.3096%"
    } finally {
      is.close();
    }
  }*/
}
