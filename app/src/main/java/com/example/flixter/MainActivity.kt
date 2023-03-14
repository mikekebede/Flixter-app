package com.example.flixter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONArray

//
class MainActivity : AppCompatActivity() {
    val client = AsyncHttpClient()
    val params = RequestParams()
    params["api_key"]=API_KEY
    params["language"]="en-US"
    params["page"]="1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        client[
                "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed",
        params,
        object: JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                //uns if the API server returns an error
                if (response != null) {
                    Log.e("uh oh",response)
                }
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {

                Log.e("hooray", json.toString())
                val results:JSONArray?=json?.jsonObject?.getJSONArray("results")
                val gson= Gson()

                val rvMovies = findViewById(R.id.rvMovies)

                val movieAdapter = flixer_adapter(this, )
                rvMovies.adapter = movieAdapter
                rvMovies.layoutManager = LinearLayoutManager(this)






            }




        }
        ]
    }
}