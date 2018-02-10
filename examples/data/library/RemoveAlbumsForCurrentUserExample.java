package data.library;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.data.library.RemoveAlbumsForCurrentUserRequest;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class RemoveAlbumsForCurrentUserExample {
  private static final String accessToken = "taHZ2SdB-bPA3FsK3D7ZN5npZS47cMy-IEySVEGttOhXmqaVAIo0ESvTCLjLBifhHOHOIuhFUKPW1WMDP7w6dj3MAZdWT8CLI2MkZaXbYLTeoDvXesf2eeiLYPBGdx8tIwQJKgV8XdnzH_DONk";
  private static final String[] ids = new String[]{"5zT1JLIj9E57p3e1rFm9Uq"};

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setAccessToken(accessToken)
          .build();
  private static final RemoveAlbumsForCurrentUserRequest removeAlbumsForCurrentUserRequest = spotifyApi
          .removeAlbumsForCurrentUser(ids)
          .build();

  public static void removeAlbumsForCurrentUser_Sync() {
    try {
      final String string = removeAlbumsForCurrentUserRequest.execute();

      System.out.println("Empty string: " + string);
    } catch (IOException | SpotifyWebApiException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void removeAlbumsForCurrentUser_Async() {
    try {
      final Future<String> stringFuture = removeAlbumsForCurrentUserRequest.executeAsync();

      // ...

      final String string = stringFuture.get();

      System.out.println("Empty string: " + string);
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("Error: " + e.getCause().getMessage());
    }
  }
}