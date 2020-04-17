package ohm.softa.a06.adapters;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ohm.softa.a06.model.Joke;

import java.io.IOException;

public class JokeTypeAdapter extends TypeAdapter<Joke> {

	Gson gson = new Gson();

	@Override
	public void write(JsonWriter out, Joke value) throws IOException {

	}

	@Override
	public Joke read(JsonReader in) throws IOException {
		Joke result = null;
		in.beginObject();

		while(in.hasNext()) {
			switch (in.nextName()) {
				case "value":
					result = gson.fromJson(in, Joke.class);
					break;
				case "type":
					if(!in.nextString().equals("success"))
						return null;
					break;
				default:
					throw new IOException("invalid Joke");
			}
		}
		in.endObject();

		return result;
	}
}
