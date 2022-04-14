package com.dewatwc.movies.utils


import com.dewatwc.movies.data.source.local.movie.DataMovies
import com.dewatwc.movies.data.source.local.movie.MoviesWithPlayer
import com.dewatwc.movies.data.source.local.movie.PlayerMovies
import com.dewatwc.movies.data.source.remote.response.MoviesResponse
import java.util.ArrayList



object DataDummy {

    fun generateDummyMovies(): ArrayList<DataMovies> {

        val movies = ArrayList<DataMovies>()

        movies.add(DataMovies("a14",
            "Akhir Kisah Cinta Si Doel",
            "Akhir Kisah Cinta Si Doel (dahulunya berjudul Si Doel The Movie 3) adalah film percintaan Indonesia tahun 2020 yang disutradarai dan ditulis Rano Karno sekaligus dibintangi Rano, Cornelia Agatha, serta Maudy Koesnaedi. Film ini adalah sekuel dari Si Doel The Movie 2. Film ini ditayangkan pada 23 Januari 2020.",
            "23 Januari 2020 ",
            false,
            "https://upload.wikimedia.org/wikipedia/id/thumb/5/59/Si_doel_3.jpg/220px-Si_doel_3.jpg"))
        movies.add(DataMovies("a47",
            "Benyamin Biang Kerok 2",
            "Benyamin Biang Kerok 2 adalah sebuah film komedi Indonesia yang disutradarai oleh Hanung Bramantyo. Film ini merupakan sekuel dari film Benyamin Biang Kerok yang ditayangkan tahun 2018. Diperankan kembali oleh Reza Rahadian.",
            "15 September 2020 ",
            false,
            "https://upload.wikimedia.org/wikipedia/id/thumb/f/f6/Benyamin_Biang_Kerok_2.jpg/220px-Benyamin_Biang_Kerok_2.jpg"))
        movies.add(DataMovies("a51",
            "Warkop DKI Reborn 4",
            "Warkop DKI Reborn 4 adalah sebuah film komedi Indonesia yang menjadi instalmen keempat dalam seri film Warkop DKI Reborn. Film tersebut disutradarai oleh Rako Prijanto dan dibintangi oleh Randy Danistha, Adipati Dolken dan Aliando Syarief.",
            "25 September 2020 ",
            false,
            "https://upload.wikimedia.org/wikipedia/id/3/3e/Warkop_DKI_Reborn_4_Poster.jpeg"))
        movies.add(DataMovies("a55",
            "Sabar Ini Ujian",
            "Sabar Ini Ujian adalah sebuah film drama komedi fantasi Indonesia dengan tema time-loop pertama di Indonesia. Film ini di sutradarai oleh Anggy Umbara dan diproduksi oleh MD Pictures bersama Umbara Brothers Film, dibintangi oleh Vino Bastian, Luna Maya, Omesh, Estelle Linden, Rigen, Ananta Rispo, dan Anya Geraldine. Film ini juga merupakan film terakhir yang dibintangi Adi Kurdi sebelum beliau wafat.",
            "5 September 2020 ",
            false,
            "https://upload.wikimedia.org/wikipedia/id/thumb/3/38/Sabar_Ini_Ujian.jpg/220px-Sabar_Ini_Ujian.jpg"))
        movies.add(DataMovies("a74",
            "Mariposa",
            "Mariposa adalah sebuah film drama komedi romantis Indonesia yang disutradarai oleh Fajar Bustomi. Film tersebut diadaptasi dari sebuah novel berjudul sama karya Hidayatul Fajriyah, mahasiswa Universitas Muhammadiyah Malang (UMM), yang terjual sebanyak 17.849 eksemplar.Film tersebut dibintangi oleh Adhisty Zara sebagai Acha dan Angga Yunanda sebagai Iqbal, yang merupakan pemasangan peran terhadap keduanya setelah pemasangan peran dalam film Dua Garis Biru, dimana masing-masing berperan sebagai Dara dan Bima. Film ini digarap oleh dua rumah produksi, Falcon Pictures dan Starvision.",
            "12 Maret 2020 ",
            false,
            "https://upload.wikimedia.org/wikipedia/id/thumb/b/bb/Mariposa_%28poster%29.jpg/220px-Mariposa_%28poster%29.jpg"))
        movies.add(DataMovies(
             "a75",
             "Aku Tahu Kapan Kamu Mati",
             "Aku Tahu Kapan Kamu Mati adalah sebuah film horor Indonesia yang disutradarai oleh Hadrah Daeng Ratu dan diproduksi oleh Unlimited Production. Film tersebut diadaptasi dari karya tulis wattpad buatan Arumi E Novel. Film tersebut dibintangi oleh Al Ghazali sebagai Brama, Natasha Wilona sebagai Siena dan Ria Ricis sebagai Flo. Syuting film tersebut dilakukan di Jawa Barat.",
             "5 Maret 2020 ",
             false,
             "https://cdn.cgv.id/uploads/movie/pictures/20003300.jpg"))
        movies.add(DataMovies(
             "a76",
             "Bloodshot",
             "Bloodshot adalah film pahlawan super Amerika Serikat tahun 2020 yang disutradarai Dave Wilson serta ditulis Jeff Wadlow dan Eric Heisserer berdasarkan karakter Valiant Comics bernama sama. Film ini adalah film pertama Valiant Cinematic Universe (VCU). Film ini dibintangi Vin Diesel, Sam Heughan, Guy Pearce, Eiza González, and Toby Kebbell.",
             "21 Februari 2020 ",
             false,
             "https://cdn.cgv.id/uploads/movie/pictures/20007400.jpg"))
        movies.add(DataMovies(
             "a77",
             "Extraction",
             "Extraction adalah sebuah film laga seru Amerika Serikat tahun 2020 garapan Sam Hargrave (dalam debut fiturnya) dan ditulis oleh Joe Russo, berdasarkan pada novel grafis Ciudad karya Ande Parks, Joe Russo, Anthony Russo, Fernando León González, dan Eric Skillman.Film tersebut menampilkan Chris Hemsworth, Rudhraksh Jaiswal, Randeep Hooda, Golshifteh Farahani, Pankaj Tripathi dan David Harbour",
             "24 April 2020 ",
             false,
             "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRELEr5bWH1Z9ZlYjofDbRoW0ToFJop6YlcJuVU8lAYt2peph_n"))
        movies.add(DataMovies(
             "a78",
             "Bad Boys for Life",
             "Bad Boys for Life adalah film sepasang polisi yang disutradarai Adil El Arbi and Bilall Fallah, diproduksi Jerry Bruckheimer dan Will Smith, dan dibintangi Will Smith dan Martin Lawrence. Bad Boys for Life dijadwalkan ditayangkan pada 17 Januari 2020 oleh Columbia Pictures di Amerika Serikat dan Indonesia.",
             "17 Januari 2020",
             false,
             "https://cdn.cgv.id/uploads/movie/pictures/19046400.jpg"))
        movies.add(DataMovies(
             "a79",
             "Project Power",
             "Project Power adalah sebuah film pahlawan super Amerika Serikat yang disutradarai oleh Ariel Schulman dan Henry Joost, diproduksi oleh Eric Newman dan Bryan Unkeless, dan ditulis oleh Mattson Tomlin. Film tersebut menampilkan Jamie Foxx, Joseph Gordon-Levitt dan Dominique Fishback dalam peran-peran utama bersama dengan Machine Gun Kelly, Rodrigo Santoro, Amy Landecker dan Allen Maldonado.",
             "14 Agustus 2020 ",
             false,
             "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSCuq8CrFWVvUHQdyqMTyIizPy1TR0CnWHQPTwM2PcUI7_bkWN"))
        return movies
    }

    fun generateDummyPlayer(moviesId: String): List<PlayerMovies> {

        val player = ArrayList<PlayerMovies>()

        player.add(PlayerMovies(
            "{$moviesId}m1",
            moviesId,
            "player",
            0))
        return player
    }

    fun generateRemoteDummyMovies(): ArrayList<MoviesResponse> {

        val movies = ArrayList<MoviesResponse>()

        movies.add(
            MoviesResponse("a14",
            "Akhir Kisah Cinta Si Doel",
            "Akhir Kisah Cinta Si Doel (dahulunya berjudul Si Doel The Movie 3) adalah film percintaan Indonesia tahun 2020 yang disutradarai dan ditulis Rano Karno sekaligus dibintangi Rano, Cornelia Agatha, serta Maudy Koesnaedi. Film ini adalah sekuel dari Si Doel The Movie 2. Film ini ditayangkan pada 23 Januari 2020.",
            "23 Januari 2020 ",
            "https://upload.wikimedia.org/wikipedia/id/thumb/5/59/Si_doel_3.jpg/220px-Si_doel_3.jpg"))
        movies.add(MoviesResponse("a47",
            "Benyamin Biang Kerok 2",
            "Benyamin Biang Kerok 2 adalah sebuah film komedi Indonesia yang disutradarai oleh Hanung Bramantyo. Film ini merupakan sekuel dari film Benyamin Biang Kerok yang ditayangkan tahun 2018. Diperankan kembali oleh Reza Rahadian.",
            "15 September 2020 ",
            "https://upload.wikimedia.org/wikipedia/id/thumb/f/f6/Benyamin_Biang_Kerok_2.jpg/220px-Benyamin_Biang_Kerok_2.jpg"))
        movies.add(MoviesResponse("a51",
            "Warkop DKI Reborn 4",
            "Warkop DKI Reborn 4 adalah sebuah film komedi Indonesia yang menjadi instalmen keempat dalam seri film Warkop DKI Reborn. Film tersebut disutradarai oleh Rako Prijanto dan dibintangi oleh Randy Danistha, Adipati Dolken dan Aliando Syarief.",
            "25 September 2020 ",
            "https://upload.wikimedia.org/wikipedia/id/3/3e/Warkop_DKI_Reborn_4_Poster.jpeg"))
        movies.add(MoviesResponse("a55",
            "Sabar Ini Ujian",
            "Sabar Ini Ujian adalah sebuah film drama komedi fantasi Indonesia dengan tema time-loop pertama di Indonesia. Film ini di sutradarai oleh Anggy Umbara dan diproduksi oleh MD Pictures bersama Umbara Brothers Film, dibintangi oleh Vino Bastian, Luna Maya, Omesh, Estelle Linden, Rigen, Ananta Rispo, dan Anya Geraldine. Film ini juga merupakan film terakhir yang dibintangi Adi Kurdi sebelum beliau wafat.",
            "5 September 2020 ",
            "https://upload.wikimedia.org/wikipedia/id/thumb/3/38/Sabar_Ini_Ujian.jpg/220px-Sabar_Ini_Ujian.jpg"))
        movies.add(MoviesResponse("a74",
            "Mariposa",
            "Mariposa adalah sebuah film drama komedi romantis Indonesia yang disutradarai oleh Fajar Bustomi. Film tersebut diadaptasi dari sebuah novel berjudul sama karya Hidayatul Fajriyah, mahasiswa Universitas Muhammadiyah Malang (UMM), yang terjual sebanyak 17.849 eksemplar.Film tersebut dibintangi oleh Adhisty Zara sebagai Acha dan Angga Yunanda sebagai Iqbal, yang merupakan pemasangan peran terhadap keduanya setelah pemasangan peran dalam film Dua Garis Biru, dimana masing-masing berperan sebagai Dara dan Bima. Film ini digarap oleh dua rumah produksi, Falcon Pictures dan Starvision.",
            "12 Maret 2020 ",
            "https://upload.wikimedia.org/wikipedia/id/thumb/b/bb/Mariposa_%28poster%29.jpg/220px-Mariposa_%28poster%29.jpg"))
        movies.add(MoviesResponse(
            "a75",
            "Aku Tahu Kapan Kamu Mati",
            "Aku Tahu Kapan Kamu Mati adalah sebuah film horor Indonesia yang disutradarai oleh Hadrah Daeng Ratu dan diproduksi oleh Unlimited Production. Film tersebut diadaptasi dari karya tulis wattpad buatan Arumi E Novel. Film tersebut dibintangi oleh Al Ghazali sebagai Brama, Natasha Wilona sebagai Siena dan Ria Ricis sebagai Flo. Syuting film tersebut dilakukan di Jawa Barat.",
            "5 Maret 2020 ",
            "https://cdn.cgv.id/uploads/movie/pictures/20003300.jpg"))
        movies.add(MoviesResponse(
            "a76",
            "Bloodshot",
            "Bloodshot adalah film pahlawan super Amerika Serikat tahun 2020 yang disutradarai Dave Wilson serta ditulis Jeff Wadlow dan Eric Heisserer berdasarkan karakter Valiant Comics bernama sama. Film ini adalah film pertama Valiant Cinematic Universe (VCU). Film ini dibintangi Vin Diesel, Sam Heughan, Guy Pearce, Eiza González, and Toby Kebbell.",
            "21 Februari 2020 ",
            "https://cdn.cgv.id/uploads/movie/pictures/20007400.jpg"))
        movies.add(MoviesResponse(
            "a77",
            "Extraction",
            "Extraction adalah sebuah film laga seru Amerika Serikat tahun 2020 garapan Sam Hargrave (dalam debut fiturnya) dan ditulis oleh Joe Russo, berdasarkan pada novel grafis Ciudad karya Ande Parks, Joe Russo, Anthony Russo, Fernando León González, dan Eric Skillman.Film tersebut menampilkan Chris Hemsworth, Rudhraksh Jaiswal, Randeep Hooda, Golshifteh Farahani, Pankaj Tripathi dan David Harbour",
            "24 April 2020 ",
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRELEr5bWH1Z9ZlYjofDbRoW0ToFJop6YlcJuVU8lAYt2peph_n"))
        movies.add(MoviesResponse(
            "a78",
            "Bad Boys for Life",
            "Bad Boys for Life adalah film sepasang polisi yang disutradarai Adil El Arbi and Bilall Fallah, diproduksi Jerry Bruckheimer dan Will Smith, dan dibintangi Will Smith dan Martin Lawrence. Bad Boys for Life dijadwalkan ditayangkan pada 17 Januari 2020 oleh Columbia Pictures di Amerika Serikat dan Indonesia.",
            "17 Januari 2020",
            "https://cdn.cgv.id/uploads/movie/pictures/19046400.jpg"))
        movies.add(MoviesResponse(
            "a79",
            "Project Power",
            "Project Power adalah sebuah film pahlawan super Amerika Serikat yang disutradarai oleh Ariel Schulman dan Henry Joost, diproduksi oleh Eric Newman dan Bryan Unkeless, dan ditulis oleh Mattson Tomlin. Film tersebut menampilkan Jamie Foxx, Joseph Gordon-Levitt dan Dominique Fishback dalam peran-peran utama bersama dengan Machine Gun Kelly, Rodrigo Santoro, Amy Landecker dan Allen Maldonado.",
            "14 Agustus 2020 ",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSCuq8CrFWVvUHQdyqMTyIizPy1TR0CnWHQPTwM2PcUI7_bkWN"))
        return movies
    }

    fun generateRemoteDummyPlayer(moviesId: String): ArrayList<PlayerMovies> {

        val player = ArrayList<PlayerMovies>()

        player.add(PlayerMovies(
            "{$moviesId}m1",
             moviesId,
            "player",
            0))
        return player
    }



    fun generateDummyMoviesWithPlayer(movies: DataMovies, tvshow: Boolean): MoviesWithPlayer {
        movies.tvShow = tvshow
        return MoviesWithPlayer(movies, generateDummyPlayer(movies.movieId))
    }
}
