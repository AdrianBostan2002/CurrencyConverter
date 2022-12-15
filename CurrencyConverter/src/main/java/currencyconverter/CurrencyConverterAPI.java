package currencyconverter;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CurrencyConverterAPI {
    public CurrencyConverterAPI(){}
    public double getConversion(String fromCurrency, String toCurrency, String value) throws Exception {
        String url = "https://api.apilayer.com/fixer/convert?to=" + toCurrency +
                "&from=" + fromCurrency + "&amount=" + value+"";

        System.out.println(url);
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("apikey", "OwkIxrJqkIQrFgImxXnwrjIPZMxEEIk4")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(response.getClass());

        System.out.println(response.body().string());

        JSONObject Jobject=new JSONObject(response.body().string());
        System.out.printline(Jobject);
        return 0.0;
    }
}
