package com.example.cryptocurrencytracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptocurrencytracker.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val data = ArrayList<Coin>()
    val adapter = CustomAdapter(data)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.coinSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
        binding.recyclerview.layoutManager = LinearLayoutManager( this)
        binding.recyclerview.adapter = adapter
        getCoins()

        binding.swipeContainer.setOnRefreshListener {
            data.clear()
            adapter.notifyDataSetChanged()
            getCoins()
            binding.swipeContainer.isRefreshing = false
            binding.swipeContainer.isEnabled = false

        }

    }

    fun getCoins() {
        (application as CoinApplication).service.getcoins().enqueue(object :
                Callback<List<Coin>> {

            override fun onFailure(call: Call<List<Coin>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Coin>>, response: Response<List<Coin>>) {

                response.body()?.let { coinlist ->
                    for (i in 0..20) {
                        coinlist[i].id?.let { getCoinByID(it) }
                    }
                }
            }
        })
    }

    fun getCoinByID(id: String?) {
        (application as CoinApplication).service.getcoinbyid(id)?.enqueue(object :
                Callback<Coin> {
            override fun onFailure(call: Call<Coin>, t: Throwable) {
            }

            override fun onResponse(call: Call<Coin>, response: Response<Coin>) {
                response.body()?.let {
                    data.add(it)
                    adapter.notifyDataSetChanged()
                }

            }
        })

    }
}
