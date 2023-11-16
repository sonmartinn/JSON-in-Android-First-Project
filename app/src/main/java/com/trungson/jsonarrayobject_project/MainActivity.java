package com.trungson.jsonarrayobject_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList <Item> arrayItem;
    ListItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.listviewbaibao);
        arrayItem = new ArrayList<>();
        adapter= new ListItemAdapter(MainActivity.this,R.layout.custom_itemlv,arrayItem);
        listView.setAdapter(adapter);
        new JSONRead().execute("https://jsonplaceholder.typicode.com/users");
    }
    private class JSONRead extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content=new StringBuilder();

            try {
                URL url=new URL(strings[0]);

                InputStreamReader inputStreamReader=new InputStreamReader(url.openConnection().getInputStream());

                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

                String line="";
                while ((line=bufferedReader.readLine())!=null){
                    content.append(line);
                }
                bufferedReader.close();


            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray array = new JSONArray(s);
                for (int i=0;i<array.length();i++){
                    JSONObject object = array.getJSONObject(i);
                    String ten = object.getString("name");
                    String email = object.getString("email");
                    arrayItem.add(new Item(ten,email));
                }
                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}