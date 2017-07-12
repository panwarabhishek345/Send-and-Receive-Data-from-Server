package com.abhishekpanwar.demodatabase;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Abhishek Panwar on 7/10/2017.
 */

public class BackgroundTaskReceive extends AsyncTask<String,Void,String> {
    Context context;
    public String data = "";
    public String dataParsed = "";
    public String singleParsed = "";



    public BackgroundTaskReceive(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... voids) {

        try {
            URL url = new URL("http://192.168.0.100/project/getjson.php");  //The address of the PHP file on your server that provides the JSONData
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            StringBuffer stringBuffer = new StringBuffer();
            while( line != null){
                Log.d("line:", line);
                line = bufferedReader.readLine();
                stringBuffer.append(line);
            }
            data = stringBuffer.toString();
            bufferedReader.close();
            inputStream.close();
            return "Received the Data";

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context,s,Toast.LENGTH_LONG).show();
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("server_response");
            for (int i = 0; i< jsonArray.length(); i++){
                JSONObject JO = jsonArray.getJSONObject(i);
                singleParsed =  "Name:" + JO.get("name") + "\n"  // All the fields being parsed im a String
                                +"Password:" + JO.get("password") + "\n"
                                +"Contact:" +  JO.get("contact") + "\n"
                                +"Country:" +  JO.get("country");
                dataParsed = dataParsed + "\n" + singleParsed  +"\n";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ReceiveData.data.setText(dataParsed);
        super.onPostExecute(s);
    }
}
