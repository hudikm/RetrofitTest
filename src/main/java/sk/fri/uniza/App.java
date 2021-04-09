package sk.fri.uniza;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();


        ReqresService service = retrofit.create(ReqresService.class);

        final Call<User> userCall = service.getUser(2);

        try {
            final Response<User> userResponse = userCall.execute();
            if(userResponse.isSuccessful()){

                System.out.println(userResponse.body().getData().getFirstName()+ " " + userResponse.body().getData().getLastName());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Hello World!");
    }
}
