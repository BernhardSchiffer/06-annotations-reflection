package ohm.softa.a06;

import com.google.gson.GsonBuilder;
import ohm.softa.a06.adapters.JokeArrayTypeAdapter;
import ohm.softa.a06.adapters.JokeTypeAdapter;
import ohm.softa.a06.model.Joke;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) throws IOException {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Joke.class, new JokeTypeAdapter());
		gsonBuilder.registerTypeAdapter(Joke[].class, new JokeArrayTypeAdapter());

		// TODO fetch a random joke and print it to STDOUT
		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("http://api.icndb.com/")
			.addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
			.build();

		ICNDBApi icndb = retrofit.create(ICNDBApi.class);

		Call<Joke[]> call = icndb.getJokesByCategory(new String[] {"nerdy"});
		Response<Joke[]> response = call.execute();
		Joke[] jokes = response.body();
		for (Joke joke : jokes) {
			System.out.println(joke);
		}

		/*
		call = icndb.getAllJokes();
		response = call.execute();
		jokes = response.body();
		for (Joke joke : jokes) {
			System.out.println(joke);
		}
		 */
	}

}
