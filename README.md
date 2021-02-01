# TrainMan :: Android App Challenge

** Skills Set : Kotlin, MVVM, Retrofit, Coroutine, Dagger with Hilt

Let’s build a GIF Browser, which talks to giphy’s /trending endpoint and presents the results in a nice grid layout of your choice.
The app should consist of a simple navigation-based animated gif browser and gif detail view. Please create a new app on giphy.com (https://developers.giphy.com/dashboard/?create=true). You will need the generated key to establish a connection to their API from your app. Don’t worry it’s free and the rate limit is enough for testing ;)

You can check the response format here https://developers.giphy.com/explorer/   <br/>
Resource: GIPHY Public API                                                      <br/>
Endpoint: Trending                                                              <br/>
Alternatively, curl https://api.giphy.com/v1/gifs/trending?api_key=YOUR_API_KEY&limit=25

On launch, your app should then fetch the first 10 pages (with a 25 items/page limit) of gifs from giphy’s /trending endpoint in an efficient and performant manner. You can pick any layout of your choice to display the results back to the user. A good cell size might be e.g. 44x44px. When the user taps on a single gif in the grid, it should lead them into a full screen representation of that gif.

Required:

1. Build a simple Android app that uses standard native frameworks to provide a gif browser and detail view.
2. Ensure that your scrolling performance does not drop under 60fps.
3. Focus on a good architecture, performance and test coverage.
4. You can use any third-party library of your choice for the gif rendering layer.
5. Share your solution via github, bitbucket or simply as a zip file with us.
6. Make sure your project compiles and is setup properly.

Stretch (Optional):

1. Implement your own code that handles gif rendering.
2. Apply some nice animations to your gif browser layout on device rotation.
3. Support an offline mode, which stores the gifs on disk, so you can enjoy all fetched gifs while there is no network connection available.


--- Don't forget to comments for more improvement ---
