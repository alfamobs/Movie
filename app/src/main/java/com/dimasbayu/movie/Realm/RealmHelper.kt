package com.dimasbayu.movie.Realm

import android.content.Context
import com.dimasbayu.movie.Model.ModelMovie
import io.realm.Realm
import io.realm.RealmResults
import java.util.*


class RealmHelper(private val mContext: Context) {
    private val realm: Realm
    private var modelMovie: RealmResults<ModelMovie>? = null
    fun showFavoriteMovie(): ArrayList<ModelMovie> {
        val data = ArrayList<ModelMovie>()
        modelMovie = realm.where(ModelMovie::class.java).findAll()
        if (modelMovie.size() > 0) {
            for (i in 0 until modelMovie.size()) {
                val movie = ModelMovie()
                movie.id = modelMovie.get(i).getId()
                movie.title = modelMovie.get(i).getTitle()
                movie.voteAverage = modelMovie.get(i).getVoteAverage()
                movie.overview = modelMovie.get(i).getOverview()
                movie.releaseDate = modelMovie.get(i).getReleaseDate()
                movie.posterPath = modelMovie.get(i).getPosterPath()
                movie.backdropPath = modelMovie.get(i).getBackdropPath()
                movie.popularity = modelMovie.get(i).getPopularity()
                data.add(movie)
            }
        }
        return data
    }

    fun addFavoriteMovie(Id: Int, Title: String?, VoteAverage: Double, Overview: String?,
                         ReleaseDate: String?, PosterPath: String?, BackdropPath: String?, Popularity: String?) {
        val movie = ModelMovie()
        movie.id = Id
        movie.title = Title
        movie.voteAverage = VoteAverage
        movie.overview = Overview
        movie.releaseDate = ReleaseDate
        movie.posterPath = PosterPath
        movie.backdropPath = BackdropPath
        movie.popularity = Popularity
        realm.beginTransaction()
        realm.copyToRealm(movie)
        realm.commitTransaction()
    }

    fun deleteFavoriteMovie(id: Int) {
        realm.beginTransaction()
        val modelMovie: RealmResults<ModelMovie> = realm.where(ModelMovie::class.java).findAll()
        modelMovie.deleteAllFromRealm()
        realm.commitTransaction()
    }

    init {
        Realm.init(mContext)
        realm = Realm.getDefaultInstance()
    }
}
