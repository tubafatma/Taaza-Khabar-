package com.example.android.taazakhabar

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_health.*

class Health_Activity :AppCompatActivity(), NewsItemClicked  {
    private lateinit var mAdapter:NewsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health)
        recyclerview.layoutManager= LinearLayoutManager(this)
        fetchData()
        mAdapter= NewsListAdapter(this)
        recyclerview.adapter=mAdapter
    }
    private fun fetchData(){
        val url="https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
        val jsonobjectRequest= JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener {
                val newsJsonArray=it.getJSONArray("articles")
                val newsArray=ArrayList<News>()
                for(i in 0 until newsJsonArray.length())
                {
                    val newsjsonObject=newsJsonArray.getJSONObject(i)
                    val news=News(
                        newsjsonObject.getString("title"),
                        newsjsonObject.getString("author"),
                        newsjsonObject.getString("url"),
                        newsjsonObject.getString("urlToImage")
                    )
                    newsArray.add(news)
                }
                mAdapter.updatednews(newsArray)
            },
            Response.ErrorListener {
                Toast.makeText(this,"Something went wrong!TRY AGAIN!!", Toast.LENGTH_LONG).show()
            }

        )
        MySingleton.getInstance(this).addtoRequestQueue(jsonobjectRequest)
    }

    override fun onItemClicked(item: News) {
        val Builder= CustomTabsIntent.Builder()
        val customTabsIntent=Builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(item.url))
    }
}