package sk.fri.uniza;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReqresService {
    @GET("api/users/{id}")
    Call<User> getUser(@Path("id") int userId);
}
