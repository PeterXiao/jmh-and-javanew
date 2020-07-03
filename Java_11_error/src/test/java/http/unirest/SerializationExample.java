/**
 *
 */
package http.unirest;

import java.io.IOException;

/**
 * @author LiY
 * @time 下午5:12:59
 */

import com.fasterxml.jackson.core.JsonProcessingException;

import io.github.openunirest.http.HttpResponse;
import io.github.openunirest.http.JsonNode;
import io.github.openunirest.http.ObjectMapper;
import io.github.openunirest.http.Unirest;
import io.github.openunirest.http.exceptions.UnirestException;

/**
 * Unirest 序列化示例
 *
 * @author biezhi
 * @date 2018/1/15
 */
public class SerializationExample {

	public static void main(String[] args) throws UnirestException {
		// Only one time
		Unirest.setObjectMapper(new ObjectMapper() {
			private final com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

			@Override
			public <T> T readValue(String value, Class<T> valueType) {
				try {
					return jacksonObjectMapper.readValue(value, valueType);
				} catch (final IOException e) {
					throw new RuntimeException(e);
				}
			}

			@Override
			public String writeValue(Object value) {
				try {
					return jacksonObjectMapper.writeValueAsString(value);
				} catch (final JsonProcessingException e) {
					throw new RuntimeException(e);
				}
			}
		});

		// Response to Object
		final HttpResponse<Book> bookResponse = Unirest.get("http://httpbin.org/books/1").asObject(Book.class);
		final Book bookObject = bookResponse.getBody();

		final HttpResponse<Author> authorResponse = Unirest.get("http://httpbin.org/books/{id}/author")
				.routeParam("id", bookObject.getId()).asObject(Author.class);

		final Author authorObject = authorResponse.getBody();

		// Object to Json
		final HttpResponse<JsonNode> postResponse = Unirest.post("http://httpbin.org/authors/post")
				.header("accept", "application/json").header("Content-Type", "application/json").body(authorObject)
				.asJson();

		System.out.println(postResponse.getBody().toString());
	}
}
