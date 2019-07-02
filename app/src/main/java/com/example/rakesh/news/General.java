package com.example.rakesh.news;


import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class General extends Fragment {
    private RecyclerView myrecyclerview;
    private List<newsitem> list_news_item;
    private RecyclerViewAdapter adapter;
    private View v;
    private static final String URL_NAME ="https://newsapi.org/v2/everything?sources=the-times-of-india&apiKey=9ef3f3896c404b2eb232ad9a642c269b";

    public General() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_general, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.general_recycler);
        int colnum;
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            colnum = 2;
        }
        else colnum =3;
        myrecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),colnum));
        load();
        return v;
    }
    public void load(){
        list_news_item = new ArrayList<>();
        final ProgressDialog progress = new ProgressDialog(getActivity());
        progress.setMessage("Loading Data");
        progress.show();
        StringRequest stringrequest = new StringRequest(Request.Method.GET,
                URL_NAME,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progress.dismiss();
                        try{
                            JSONObject obj = new JSONObject(response);
                            JSONArray article =obj.getJSONArray("articles");
                            for(int i =0;i<article.length();i++){
                                JSONObject ob = article.getJSONObject(i);
                                if(ob.getString("urlToImage")!="null" && ob.getString("urlToImage").length()!=0){
                                    list_news_item.add(new newsitem(ob.getString("title"),ob.getString("description"),ob.getString("urlToImage"),ob.getString("url")));
                                    adapter = new RecyclerViewAdapter(list_news_item,getContext());
                                    myrecyclerview.setAdapter(adapter);
                                }
                                else {
                                    i++;
                                }

                            }


                        }
                        catch(JSONException e){
                            Log.wtf("json",e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progress.dismiss();
                        Toast.makeText(getContext(),"Please connect to INTERNET",Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue reqque = Volley.newRequestQueue(getContext());
        reqque.add(stringrequest);


    }
}
