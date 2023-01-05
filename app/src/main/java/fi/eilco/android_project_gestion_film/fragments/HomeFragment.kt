package fi.eilco.android_project_gestion_film.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import fi.eilco.android_project_gestion_film.MainActivity
import fi.eilco.android_project_gestion_film.R
import fi.eilco.android_project_gestion_film.adapter.MovieAdapter
import fi.eilco.android_project_gestion_film.adapter.RootModel
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException

class HomeFragment ( private val context: MainActivity): Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        //recupérer le recycler view
        val recycler = view?.findViewById<RecyclerView>(R.id.recycler)
        Log.d("recycler : ","tttttttttttttttttttttttttttttt")

        lifecycleScope.launch {
            if (recycler != null) {
                getData(recycler)
            }
        }

        Log.d("recycler : ","lllllllllllllllllllllllllll")



        return view
    }

    private fun getData(recyclerView: RecyclerView) {
        Log.d("recycler : ","gggggggggggggggggggggggggg")

        val client = OkHttpClient()
        val request =Request.Builder()
            .url("https://api.themoviedb.org/3/discover/movie?api_key=2174d146bb9c0eab47529b2e77d6b526&with_genres=28")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)
                val gson = GsonBuilder().create()
                val data = gson.fromJson(body, RootModel::class.java)
                Log.d("hhjjjjjjjjjjjj","eeeeeeeeeeeeeeeeeeeeeee")
                Log.d("11111111111",data.results[0].original_title.toString())

                //Set adapter and recycler view on UI with values get from http request
                activity?.runOnUiThread {
                    recyclerView.layoutManager=LinearLayoutManager(context)

                    val adapter = MovieAdapter(context, data.results)
                    recyclerView.adapter = adapter
                }
                Log.d("hhjjjjjjjjjjj1111111111",data.results.toString())

            }

        })

    }
}
