package com.jason.movietvcatalog.utils

import com.jason.movietvcatalog.data.source.remote.response.ActorResponse
import com.jason.movietvcatalog.data.source.remote.response.GenreResponse
import com.jason.movietvcatalog.data.source.remote.response.MovieResponse
import com.jason.movietvcatalog.data.source.remote.response.TvResponse

object DataDummyRepository {

    fun generateDummyMovie(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        val genre1 = GenreResponse("35","Comedy")
        val genre2 = GenreResponse("10749","Romance")
        val dataGenre = ArrayList<GenreResponse>()
        dataGenre.add(genre1)
        dataGenre.add(genre2)
        movies.add(
            MovieResponse(
                "583083",
                "The Kissing Booth 2",
                "/mb7wQv0adK3kjOUr9n93mANHhPJ.jpg",
                "2020-07-24",
                132,
                "Released",
                0.toFloat(),
                dataGenre,
                "With college decisions looming, Elle juggles her long-distance romance with Noah, changing relationship with bestie Lee and feelings for a new classmate.",
                "/wO5QSWZPBT71gMLvrRex0bVc0V9.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "516486",
                "Greyhound",
                "/kjMbDciooTbJPofVXgAoFjfX8Of.jpg",
                "2020-07-10",
                0,
                "",
                0.toFloat(),
                dataGenre,
                "A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the “Black Pit” to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.",
                "/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "313369",
                "La La Land",
                "/uDO8zWDhfWwoFdKS4fzkUJt0Rf0.jpg",
                "2016-11-29",
                0,
                "",
                0.toFloat(),
                dataGenre,
                "Mia, an aspiring actress, serves lattes to movie stars in between auditions and Sebastian, a jazz musician, scrapes by playing cocktail party gigs in dingy bars, but as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair, and the dreams they worked so hard to maintain in each other threaten to rip them apart.",
                "/qJeU7KM4nT2C1WpOrwPcSDGFUWE.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "547016",
                "The Old Guard",
                "/cjr4NWURcVN3gW5FlHeabgBHLrY.jpg",
                "2020-07-10",
                0,
                "",
                0.toFloat(),
                dataGenre,
                "Four undying warriors who've secretly protected humanity for centuries become targeted for their mysterious powers just as they discover a new immortal.",
                "/m0ObOaJBerZ3Unc74l471ar8Iiy.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "300671",
                "13 Hours: The Secret Soldiers of Benghazi",
                "/4qnEeVPM8Yn5dIVC4k4yyjrUXeR.jpg",
                "2016-01-13",
                0,
                "",
                0.toFloat(),
                dataGenre,
                "",
                "/ayDMYGUNVvXS76wQgFwTiUIDNb5.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "454983",
                "The Kissing Booth",
                "/7Dktk2ST6aL8h9Oe5rpk903VLhx.jpg",
                "2018-05-11",
                0,
                "",
                0.toFloat(),
                dataGenre,
                "When teenager Elle's first kiss leads to a forbidden romance with the hottest boy in high school, she risks her relationship with her best friend.",
                ""
            )
        )

        return movies
    }

    fun generateDummyTVShow(): List<TvResponse> {
        val movies = ArrayList<TvResponse>()
        val genre1 = GenreResponse("35","Comedy")
        val genre2 = GenreResponse("10749","Romance")
        val dataGenre = ArrayList<GenreResponse>()
        dataGenre.add(genre1)
        dataGenre.add(genre2)
        val runtime = ArrayList<Int>()
        runtime.add(0)
        movies.add(
            TvResponse(
                "2734",
                "Law & Order: Special Victims Unit",
                "/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "2020-07-24",
                runtime,
                "",
                0.toFloat(),
                dataGenre,
                "With college decisions looming, Elle juggles her long-distance romance with Noah, changing relationship with bestie Lee and feelings for a new classmate.",
                "/wO5QSWZPBT71gMLvrRex0bVc0V9.jpg"
            )
        )
        movies.add(
            TvResponse(
                "1668",
                "Friends",
                "/f496cm9enuEsZkSPzCwnTESEK5s.jpg",
                "2020-07-10",
                runtime,
                "",
                0.toFloat(),
                dataGenre,
                "A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the “Black Pit” to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.",
                "/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg"
            )
        )
        movies.add(
            TvResponse(
                "1622",
                "Supernatural",
                "/uDO8zWDhfWwoFdKS4fzkUJt0Rf0.jpg",
                "2016-11-29",
                runtime,
                "",
                0.toFloat(),
                dataGenre,
                "Mia, an aspiring actress, serves lattes to movie stars in between auditions and Sebastian, a jazz musician, scrapes by playing cocktail party gigs in dingy bars, but as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair, and the dreams they worked so hard to maintain in each other threaten to rip them apart.",
                "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
            )
        )
        movies.add(
            TvResponse(
                "456",
                "The Simpsons",
                "/cjr4NWURcVN3gW5FlHeabgBHLrY.jpg",
                "2020-07-10",
                runtime,
                "",
                0.toFloat(),
                dataGenre,
                "Four undying warriors who've secretly protected humanity for centuries become targeted for their mysterious powers just as they discover a new immortal.",
                "/qcr9bBY6MVeLzriKCmJOv1562uY.jpg"
            )
        )
        movies.add(
            TvResponse(
                "1416",
                "Grey's Anatomy",
                "/4qnEeVPM8Yn5dIVC4k4yyjrUXeR.jpg",
                "2016-01-13",
                runtime,
                "",
                0.toFloat(),
                dataGenre,
                "",
                "/jnsvc7gCKocXnrTXF6p03cICTWb.jpg"
            )
        )
        movies.add(
            TvResponse(
                "1434",
                "Family Guy",
                "/q3E71oY6qgAEiw6YZIHDlHSLwer.jpg",
                "2018-05-11",
                runtime,
                "",
                0.toFloat(),
                dataGenre,
                "When teenager Elle's first kiss leads to a forbidden romance with the hottest boy in high school, she risks her relationship with her best friend.",
                ""
            )
        )

        return movies
    }

    fun generateActorMovie(movieId: String): List<ActorResponse> {
        val actors = ArrayList<ActorResponse>()
        actors.add(
            ActorResponse(
                "Hera Hilmar",
                "",
                "Hester Shaw",
                movieId
            )
        )
        actors.add(
            ActorResponse(
                "Robert Sheehan",
                "",
                "Tom Natsworthy",
                movieId
            )
        )
        actors.add(
            ActorResponse(
                "Hugo Weaving",
                "",
                "Thaddeus Valentine",
                movieId
            )
        )
        actors.add(
            ActorResponse(
                "Jihae",
                "",
                "Anna Fang",
                movieId
            )
        )
        actors.add(
            ActorResponse(
                "Ronan Raftery",
                "",
                "Bevis Pod",
                movieId
            )
        )
        actors.add(
            ActorResponse(
                "Leila George",
                "",
                "Katherine Valentine",
                movieId
            )
        )
        actors.add(
            ActorResponse(
                "Leila George",
                "",
                "Katherine Valentine",
                movieId
            )
        )
        return actors
    }

}