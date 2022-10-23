package currencyconverter;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import javax.swing.plaf.ColorUIResource;

public class CurrencyConverterAPI {
    static public class SimpleEntity {
        protected String name;

        public SimpleEntity(String name) {
            this.name = name;
        }
    }
    public CurrencyConverterAPI(){}
    public double getConversion(String fromCurrency, String toCurrency, String value) throws Exception{
        String url="https://api.apilayer.com/fixer/convert?to="+fromCurrency+
                "&from=" + toCurrency + "&amount=" + value;
        System.out.println(url);
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                //.url("https://api.apilayer.com/fixer/convert?to=RON&from=EUR&amount=241")
                .url(url)
                .addHeader("apikey", "OwkIxrJqkIQrFgImxXnwrjIPZMxEEIk4")
                .method("GET", null)
                .build();


        Response response = client.newCall(request).execute();
        //System.out.println(response.getClass());
        Gson gson=new Gson();
        SimpleEntity important=gson.fromJson(response.body().string(), SimpleEntity.class);
        //JSONObject obj=new JSONObject(response.body());
        System.out.println(important);

        //Double result=(Double)obj.get("result");
        return 0.0;
    }
}
