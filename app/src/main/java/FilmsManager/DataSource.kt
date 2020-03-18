package com.bsuir.FilmsManager

import android.content.Context
import com.bsuir.FilmsManager.models.Cartoon

class DataSource{

    companion object{

        fun createDataSet(context: Context, jsonSerializer: JsonFileSerializer): ArrayList<Cartoon>{
            val deserialized = jsonSerializer.deserialize(context)

            if(deserialized != null){
                return deserialized
            }

            val list = ArrayList<Cartoon>()
            list.add(
                Cartoon(
                    "How To Train Your Dragon: The Hidden World!",
                    "Not Disney",
                    7200,
                    5.0,
                    "Adventure",
                    "",
                    "https://kinovasek.net/uploads/posts/2019-12/1575212161-874666874.jpg"
                )
            )

            list.add(
                Cartoon(
                    "Naruto uSobaki",
                    "Speedart",
                    999999,
                    4.0,
                    "Anime",
                    "http://s4.kinovasek.space/200101/NarutoFilm_1_720-kinovasek.net.mp4y",
                    "https://kinovasek.net/uploads/posts/2019-07/1563474526-709797654.jpg"
                )
            )






            list.add(
                Cartoon(
                    "Up!",
                    "Disney",
                    5400,
                    3.4,
                    "Adventure",
                    "http://n1.kinovasek.space/movies/way1/Vverh_2009_720_kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2019-02/1549104160-1214943258.jpg"
                )
            )





            list.add(
                Cartoon(
                    "Тайна третьей планеты",
                    "СССР",
                    7800,
                    4.0,
                    "Adventure",
                    "http://s1.kinovasek.space/movies/200302/Tayna_tretey_planety_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2020-03/1583766093-1277335399.jpg"
                )
            )
            list.add(
                Cartoon(
                    "Tarzan and Jane",
                    "Disney",
                    5600,
                    5.0,
                    "Adventure",
                    "http://s1.kinovasek.space/movies/200301/Tarzan_i_Jane_2002_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2020-03/1583421844-860067027.jpg"
                )
            )
            list.add(
                Cartoon(
                    "Вперед",
                    "Disney",
                    5450,
                    3.2,
                    "Adventure",
                    "http://s.kinovasek.space/movies/Vpered_2020_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2020-03/1583434803-244782027.jpg"
                )
            )
            list.add(
                Cartoon(
                    "Дамбо",
                    "Disney",
                    4000,
                    3.2,
                    "Adventure",
                    "http://s1.kinovasek.space/movies/200301/Dambo_1941_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2020-03/1583500649-496453655.jpg"
                )
            )
            list.add(
                Cartoon(
                    "Олаф и холодное приключение",
                    "Disney",
                    3000,
                    3.2,
                    "Adventure",
                    "http://s3.kinovasek.space/190300/Olaf_i_Holodnoe_Prikljuchenie_2017_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2020-01/1578929406-1552194073.jpg"
                )
            )
            list.add(
                Cartoon(
                    "Белый клык",
                    "Disney",
                    7800,
                    10.0,
                    "Adventure",
                    "http://s2.kinovasek.space/film/720/Bely_Klyk_1991_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2020-01/1578753591-1497822730.jpg"
                )
            )
            list.add(
                Cartoon(
                    "Naruto uSobaki",
                    "Speedart",
                    999999,
                    4.0,
                    "Anime",
                    "http://s4.kinovasek.space/200101/NarutoFilm_1_720-kinovasek.net.mp4y",
                    "https://kinovasek.net/uploads/posts/2019-07/1563474526-709797654.jpg"
                )
            )






            list.add(
                Cartoon(
                    "Up!",
                    "Disney",
                    5400,
                    3.4,
                    "Adventure",
                    "http://n1.kinovasek.space/movies/way1/Vverh_2009_720_kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2019-02/1549104160-1214943258.jpg"
                )
            )


            list.add(
                Cartoon(
                    "How To Train Your Dragon: The Hidden World!",
                    "Not Disney",
                    7200,
                    5.0,
                    "Adventure",
                    "http://s1.kinovasek.space/movies/a1/Kak_priruchit_drrakona_Vozvrashenie_domoy_webrip_mvo_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2019-12/1575212161-874666874.jpg"
                )
            )


            list.add(
                Cartoon(
                    "Тайна третьей планеты",
                    "СССР",
                    7800,
                    4.0,
                    "Adventure",
                    "http://s1.kinovasek.space/movies/200302/Tayna_tretey_planety_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2020-03/1583766093-1277335399.jpg"
                )
            )
            list.add(
                Cartoon(
                    "Tarzan and Jane",
                    "Disney",
                    5600,
                    5.0,
                    "Adventure",
                    "http://s1.kinovasek.space/movies/200301/Tarzan_i_Jane_2002_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2020-03/1583421844-860067027.jpg"
                )
            )
            list.add(
                Cartoon(
                    "Pokémon Detective Pikachu",
                    "Disney",
                    6000,
                    3.2,
                    "Adventure",
                    "https://www.w3schools.com/html/mov_bbb.mp4",
                    "https://m.media-amazon.com/images/M/MV5BZmE3ZmYwNTgtNTBmOC00NGU1LWJjNzktOTVhMjEzODFmOGFlXkEyXkFqcGdeQXdhZHppdGE@._V1_UX477_CR0,0,477,268_AL_.jpg"
                )
            )
            list.add(
                Cartoon(
                    "Вперед",
                    "Disney",
                    5450,
                    3.2,
                    "Adventure",
                    "http://s.kinovasek.space/movies/Vpered_2020_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2020-03/1583434803-244782027.jpg"
                )
            )
            list.add(
                Cartoon(
                    "Дамбо",
                    "Disney",
                    4000,
                    3.2,
                    "Adventure",
                    "http://s1.kinovasek.space/movies/200301/Dambo_1941_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2020-03/1583500649-496453655.jpg"
                )
            )
            list.add(
                Cartoon(
                    "Олаф и холодное приключение",
                    "Disney",
                    3000,
                    3.2,
                    "Adventure",
                    "http://s3.kinovasek.space/190300/Olaf_i_Holodnoe_Prikljuchenie_2017_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2020-01/1578929406-1552194073.jpg"
                )
            )
            list.add(
                Cartoon(
                    "Белый клык",
                    "Disney",
                    7800,
                    10.0,
                    "Adventure",
                    "http://s2.kinovasek.space/film/720/Bely_Klyk_1991_720-kinovasek.net.mp4",
                    "https://kinovasek.net/uploads/posts/2020-01/1578753591-1497822730.jpg"
                )
            )

            jsonSerializer.serialize(context, list)
            return list
        }
    }
}