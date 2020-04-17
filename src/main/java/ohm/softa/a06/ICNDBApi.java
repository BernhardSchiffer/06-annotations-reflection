package ohm.softa.a06;

import ohm.softa.a06.model.Joke;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public interface ICNDBApi {

	@GET("jokes/random")
	Call<Joke> getRandomJoke();

	@GET("jokes/random")
	Call<Joke> getRandomJoke( @Query("limitTo") String[] categoriesToInclude);

	@GET("jokes/random/{count}")
	Call<Joke[]> getRandomJokes(@Path("count") int count);

	@GET("jokes/{id}")
	Call<Joke> getJokeById(@Path("id") int id);

	@GET("jokes")
	Call<Joke[]> getJokesByCategory(@Query("limitTo") String[] categoriesToInclude);

	@GET("jokes")
	Call<Joke[]> getAllJokes();

}
