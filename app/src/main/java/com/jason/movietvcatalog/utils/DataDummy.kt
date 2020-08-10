package com.jason.movietvcatalog.utils

import com.jason.movietvcatalog.data.source.local.entity.ActorEntity
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity

object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                561,
                "Constantine",
                "/vPYgvd2MwHlxTamAOjwVQp4qs1W.jpg",
                "2005-02-08",
                121,
                "Released",
                0.toFloat(),
                "Drama, Fantasy, Horror",
                "John Constantine has literally been to Hell and back. When he teams up with a policewoman to solve the mysterious suicide of her twin sister, their investigation takes them through the world of demons and angels that exists beneath the landscape of contemporary Los Angeles.",
                "/tIG8FwHRiHLOlWJdizp2oxdkSL2.jpg",
                "movie"
            )
        )
        movies.add(
            MovieEntity(
                516486,
                "Greyhound",
                "/kjMbDciooTbJPofVXgAoFjfX8Of.jpg",
                "2020-07-10",
                0,
                "",
                0.toFloat(),
                "Action, Drama, Fantasi",
                "A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the “Black Pit” to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.",
                "/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg",
                "movie"
            )
        )
        movies.add(
            MovieEntity(
                313369,
                "La La Land",
                "/uDO8zWDhfWwoFdKS4fzkUJt0Rf0.jpg",
                "2016-11-29",
                0,
                "",
                0.toFloat(),
                "Action, Drama, Fantasi",
                "Mia, an aspiring actress, serves lattes to movie stars in between auditions and Sebastian, a jazz musician, scrapes by playing cocktail party gigs in dingy bars, but as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair, and the dreams they worked so hard to maintain in each other threaten to rip them apart.",
                "/qJeU7KM4nT2C1WpOrwPcSDGFUWE.jpg",
                "movie"
            )
        )
        movies.add(
            MovieEntity(
                547016,
                "The Old Guard",
                "/cjr4NWURcVN3gW5FlHeabgBHLrY.jpg",
                "2020-07-10",
                0,
                "",
                0.toFloat(),
                "Action, Drama, Fantasi",
                "Four undying warriors who've secretly protected humanity for centuries become targeted for their mysterious powers just as they discover a new immortal.",
                "/m0ObOaJBerZ3Unc74l471ar8Iiy.jpg",
                "movie"
            )
        )
        movies.add(
            MovieEntity(
                300671,
                "13 Hours: The Secret Soldiers of Benghazi",
                "/4qnEeVPM8Yn5dIVC4k4yyjrUXeR.jpg",
                "2016-01-13",
                0,
                "",
                0.toFloat(),
                "Action, Drama, Fantasi",
                "",
                "/ayDMYGUNVvXS76wQgFwTiUIDNb5.jpg",
                "movie"
            )
        )
        movies.add(
            MovieEntity(
                454983,
                "The Kissing Booth",
                "/7Dktk2ST6aL8h9Oe5rpk903VLhx.jpg",
                "2018-05-11",
                0,
                "",
                0.toFloat(),
                "Action, Drama, Fantasi",
                "When teenager Elle's first kiss leads to a forbidden romance with the hottest boy in high school, she risks her relationship with her best friend.",
                "",
                "movie"
            )
        )

        return movies
    }

    fun generateDummyTVShow(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                2734,
                "Law & Order: Special Victims Unit",
                "/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "2020-07-24",
                0,
                "",
                0.toFloat(),
                "Action, Drama, Fantasi",
                "With college decisions looming, Elle juggles her long-distance romance with Noah, changing relationship with bestie Lee and feelings for a new classmate.",
                "/wO5QSWZPBT71gMLvrRex0bVc0V9.jpg",
                "tvshow"
            )
        )
        movies.add(
            MovieEntity(
                1668,
                "Friends",
                "/f496cm9enuEsZkSPzCwnTESEK5s.jpg",
                "2020-07-10",
                0,
                "",
                0.toFloat(),
                "Action, Drama, Fantasi",
                "A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the “Black Pit” to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.",
                "/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg",
                "tvshow"
            )
        )
        movies.add(
            MovieEntity(
                1622,
                "Supernatural",
                "/uDO8zWDhfWwoFdKS4fzkUJt0Rf0.jpg",
                "2016-11-29",
                0,
                "",
                0.toFloat(),
                "Action, Drama, Fantasi",
                "Mia, an aspiring actress, serves lattes to movie stars in between auditions and Sebastian, a jazz musician, scrapes by playing cocktail party gigs in dingy bars, but as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair, and the dreams they worked so hard to maintain in each other threaten to rip them apart.",
                "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "tvshow"
            )
        )
        movies.add(
            MovieEntity(
                456,
                "The Simpsons",
                "/cjr4NWURcVN3gW5FlHeabgBHLrY.jpg",
                "2020-07-10",
                0,
                "",
                0.toFloat(),
                "Action, Drama, Fantasi",
                "Four undying warriors who've secretly protected humanity for centuries become targeted for their mysterious powers just as they discover a new immortal.",
                "/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
                "tvshow"
            )
        )
        movies.add(
            MovieEntity(
                1416,
                "Grey's Anatomy",
                "/4qnEeVPM8Yn5dIVC4k4yyjrUXeR.jpg",
                "2016-01-13",
                0,
                "",
                0.toFloat(),
                "Action, Drama, Fantasi",
                "",
                "/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                "tvshow"
            )
        )
        movies.add(
            MovieEntity(
                1434,
                "Family Guy",
                "/q3E71oY6qgAEiw6YZIHDlHSLwer.jpg",
                "2018-05-11",
                0,
                "",
                0.toFloat(),
                "Action, Drama, Fantasi",
                "When teenager Elle's first kiss leads to a forbidden romance with the hottest boy in high school, she risks her relationship with her best friend.",
                "",
                "tvshow"
            )
        )

        return movies
    }

    fun generateActorMovie(movieId: Int): List<ActorEntity> {
        val actors = ArrayList<ActorEntity>()
        actors.add(
            ActorEntity(
                0,
                "Hera Hilmar",
                "",
                "Hester Shaw",
                movieId
            )
        )
        actors.add(
            ActorEntity(
                0,
                "Robert Sheehan",
                "",
                "Tom Natsworthy",
                movieId
            )
        )
        actors.add(
            ActorEntity(
                0,
                "Hugo Weaving",
                "",
                "Thaddeus Valentine",
                movieId
            )
        )
        actors.add(
            ActorEntity(
                0,
                "Jihae",
                "",
                "Anna Fang",
                movieId
            )
        )
        actors.add(
            ActorEntity(
                0,
                "Ronan Raftery",
                "",
                "Bevis Pod",
                movieId
            )
        )
        actors.add(
            ActorEntity(
                0,
                "Leila George",
                "",
                "Katherine Valentine",
                movieId
            )
        )
        actors.add(
            ActorEntity(
                0,
                "Leila George",
                "",
                "Katherine Valentine",
                movieId
            )
        )
        return actors
    }

}