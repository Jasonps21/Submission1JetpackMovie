package com.jason.movietvcatalog.utils

import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.data.ActorEntity
import com.jason.movietvcatalog.data.MovieEntity

object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "1",
                "A Star Is Born",
                R.drawable.poster_a_start_is_born,
                "2018",
                "2h 16m",
                "Bradley Cooper",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "75",
                "Drama, Romance, Music",
                R.drawable.backdrop_a_star
            )
        )
        movies.add(
            MovieEntity(
                "2",
                "Alita: Battle Angel",
                R.drawable.poster_alita,
                "2019",
                "2h 2m",
                "Robert Rodriguez",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "71",
                "Action, Science Fiction, Adventure",
                R.drawable.backdrop_alita
            )
        )
        movies.add(
            MovieEntity(
                "3",
                "Aquaman ",
                R.drawable.poster_aquaman,
                "2018",
                "2h 24m",
                "James Wan",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "69",
                "Action, Adventure, Fantasy",
                R.drawable.backdrop_aquaman
            )
        )
        movies.add(
            MovieEntity(
                "4",
                "Bohemian Rhapsody",
                R.drawable.poster_bohemian,
                "2018",
                "2h 15m",
                "Bryan Singer",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "80",
                "Drama, Music",
                R.drawable.backdrop_bohemian
            )
        )
        movies.add(
            MovieEntity(
                "5",
                "Cold Pursuit",
                R.drawable.poster_cold_persuit,
                "2019",
                "1h 59m",
                "Hans Petter Moland",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "56",
                "Action, Crime, Thriller",
                R.drawable.backdrop_cold_pursuit
            )
        )
        movies.add(
            MovieEntity(
                "6",
                "Assassin's Creed",
                R.drawable.poster_creed,
                "2016",
                "1h 55m",
                "Justin Kurzel",
                "Through unlocked genetic memories that allow him to relive the adventures of his ancestor in 15th century Spain, Callum Lynch discovers he's a descendant of the secret 'Assassins' society. After gaining incredible knowledge and skills, he is now poised to take on the oppressive Knights Templar in the present day.",
                "54",
                "Action, Adventure, Science Fiction",
                R.drawable.backdrop_creed
            )
        )
        movies.add(
            MovieEntity(
                "7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                R.drawable.poster_crimes,
                "2018",
                "2h 14m",
                "David Yates",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "69",
                "Adventure, Fantasy, Family",
                R.drawable.backdrop_glass
            )
        )
        movies.add(
            MovieEntity(
                "8",
                "Glass",
                R.drawable.poster_glass,
                "2019",
                "2h 9m",
                "M. Night Shyamalan",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "66",
                "Thriller, Drama, Science Fiction",
                R.drawable.backdrop_glass
            )
        )
        movies.add(
            MovieEntity(
                "9",
                "How to Train Your Dragon",
                R.drawable.poster_how_to_train,
                "2010",
                "1h 40m",
                "Dean DeBlois",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                "78",
                "Fantasy, Adventure, Animation, Family",
                R.drawable.backdrop_how_to_train
            )
        )
        movies.add(
            MovieEntity(
                "10",
                "Avengers: Infinity War",
                R.drawable.poster_infinity_war,
                "2018",
                "2h 29m",
                "Joe Russo",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "83",
                "Adventure, Action, Science Fiction",
                R.drawable.backdrop_war
            )
        )
        movies.add(
            MovieEntity(
                "11",
                "Spider-Man",
                R.drawable.poster_spiderman,
                "2018",
                "2h 29m",
                "Joe Russo",
                "After being bitten by a genetically altered spider, nerdy high school student Peter Parker is endowed with amazing powers to become the Amazing superhero known as Spider-Man. Steve Ditko",
                "83",
                "Adventure, Action, Science Fiction",
                R.drawable.backdrop_war
            )
        )
        movies.add(
            MovieEntity(
                "12",
                "Mortal Engines",
                R.drawable.poster_mortal_engines,
                "2018",
                "2h 9m",
                "Christian Rivers",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "61",
                "Adventure, Fantasy",
                R.drawable.backdrop_mortal
            )
        )
        return movies
    }

    fun generateDummyTVShow(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "tv1",
                "Arrow",
                R.drawable.poster_arrow,
                "2012",
                "42m",
                "Greg Berlanti",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "63",
                "Crime, Drama, Mystery, Action & Adventure",
                R.drawable.backdrop_arrow
            )
        )
        movies.add(
            MovieEntity(
                "tv2",
                "Doom Patrol",
                R.drawable.poster_doom_patrol,
                "2019",
                "49m",
                "Jeremy Carver",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "73",
                "Sci-Fi & Fantasy, Action & Adventure",
                R.drawable.backdrop_cold_pursuit
            )
        )
        movies.add(
            MovieEntity(
                "tv3",
                "Family Guy ",
                R.drawable.poster_family_guy,
                "1999",
                "22m",
                "Seth MacFarlane",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "67",
                "Animation, Comedy",
                R.drawable.backdrop_family
            )
        )
        movies.add(
            MovieEntity(
                "tv4",
                "The Flash",
                R.drawable.poster_flash,
                "2014",
                "44m",
                "Greg Berlanti",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "74",
                "Drama, Sci-Fi & Fantasy",
                R.drawable.backdrop_flash
            )
        )
        movies.add(
            MovieEntity(
                "tv5",
                "God Friended Me",
                R.drawable.poster_god,
                "2019",
                "44m",
                "Hans Petter Moland",
                "A self-proclaimed \"pesky atheist\" is encouraged to help strangers by someone claiming to be God who friends him on Facebook.",
                "83",
                "Drama, Family, Mystery",
                R.drawable.backdrop_god
            )
        )
        movies.add(
            MovieEntity(
                "tv6",
                "Gotham",
                R.drawable.poster_gotham,
                "2014",
                "44m",
                "Justin Kurzel",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "54",
                "Drama, Fantasy, Crime",
                R.drawable.backdrop_god
            )
        )
        movies.add(
            MovieEntity(
                "tv7",
                "Hanna",
                R.drawable.poster_hanna,
                "2019",
                "44m",
                "David Yates",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "69",
                "Adventure, Fantasy, Family",
                R.drawable.backdrop_hanna
            )
        )
        movies.add(
            MovieEntity(
                "tv8",
                "The Man with the Iron Fists",
                R.drawable.poster_iron_fist,
                "2014",
                "44m",
                "M. Night Shyamalan",
                "In feudal China, a blacksmith who makes weapons for a small village is put in the position where he must defend himself and his fellow villagers.",
                "54",
                "Thriller, Drama, Science Fiction",
                R.drawable.backdrop_iron_fins
            )
        )
        movies.add(
            MovieEntity(
                "tv9",
                "Boruto: Naruto Next Generations",
                R.drawable.poster_naruto_shipudden,
                "2017",
                "44m",
                "Dean DeBlois",
                "The Hidden Leaf Village has entered an era of peace and modernity. Tall buildings line the streets, giant screens flash with images, and the Thunder Rail runs through the village, connecting each district together. Though it's still a ninja village, the number of civilians has increased and the life of the shinobi is beginning to change. Boruto Uzumaki, son of Seventh Hokage Naruto Uzumaki, has enrolled in the Ninja Academy to learn the ways of the ninja. The other students are ready to dismiss him as \"just the son of the Hokage,” but Boruto’s heart and character blow all their assumptions away. As a series of mysterious events begins to unfold, it’s up to Boruto and his new friends to handle them. Like a gale-force wind, Boruto makes his own way into everyone's hearts; his story is about to begin!!",
                "81",
                "Fantasy, Adventure, Animation, Family",
                R.drawable.backdrop_naruto
            )
        )
        movies.add(
            MovieEntity(
                "tv10",
                "Riverdale",
                R.drawable.poster_riverdale,
                "2018",
                "44m",
                "Joe Russo",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "83",
                "Adventure, Action, Science Fiction",
                R.drawable.backdrop_river
            )
        )
        movies.add(
            MovieEntity(
                "tv11",
                "Shameless",
                R.drawable.poster_shameless,
                "2018",
                "44m",
                "Christian Rivers",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "79",
                "Adventure, Fantasy",
                R.drawable.backdrop_shameless
            )
        )
        movies.add(
            MovieEntity(
                "tv12",
                "The Umbrella Academy",
                R.drawable.poster_the_umbrella,
                "2019",
                "44m",
                "Christian Rivers",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "77",
                "Adventure, Fantasy",
                R.drawable.backdrop_umbrella
            )
        )

        return movies
    }

    fun generateActorMovie(movieId: String): List<ActorEntity> {
        val actors = ArrayList<ActorEntity>()
        actors.add(
            ActorEntity(
                "Hera Hilmar",
                "",
                "Hester Shaw",
                movieId
            )
        )
        actors.add(
            ActorEntity(
                "Robert Sheehan",
                "",
                "Tom Natsworthy",
                movieId
            )
        )
        actors.add(
            ActorEntity(
                "Hugo Weaving",
                "",
                "Thaddeus Valentine",
                movieId
            )
        )
        actors.add(
            ActorEntity(
                "Jihae",
                "",
                "Anna Fang",
                movieId
            )
        )
        actors.add(
            ActorEntity(
                "Ronan Raftery",
                "",
                "Bevis Pod",
                movieId
            )
        )
        actors.add(
            ActorEntity(
                "Leila George",
                "",
                "Katherine Valentine",
                movieId
            )
        )
        actors.add(
            ActorEntity(
                "Leila George",
                "",
                "Katherine Valentine",
                movieId
            )
        )
        return actors
    }

}