# NgNews

NgNews is a news app that allows users to stay informed with the latest news articles. It leverages the MVVM pattern, clean code principles, and Hilt for dependency injection. The app is designed with offline capabilities, enabling users to access previously read news even without an internet connection and also bookmark a news for easey read later.

## Features

- **MVVM Architecture:** NGNews follows the Model-View-ViewModel architectural pattern, providing a modular and maintainable codebase.
- **Clean Code:** The project adheres to clean code principles, promoting readability, maintainability, and scalability.
- **Offline Capability:** Users can read previously accessed news articles even without an active internet connection.
- **News API Integration:** NgNews utilizes the open news API from [newsapi.org](https://newsapi.org/) to fetch the latest news articles.

## Tech Stack

- **Android Architecture Components:** Leveraging LiveData and ViewModel for a robust and lifecycle-aware architecture.
- **Hilt:** Dependency injection framework for Android that simplifies the setup and maintenance of Dagger.
- **Retrofit:** A type-safe HTTP client for making API calls.
- **Room Database:** Provides an abstraction layer over SQLite, making it easier to work with a local database.
- **Coroutines:** For asynchronous programming and managing background tasks.

## Getting Started

Follow these steps to set up the NgNews project locally:

1. Clone the repository: `git clone https://github.com/muhammadrabilu/NG_News.git`
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.

## Configuration

To use NgNews with your own API key from [newsapi.org](https://newsapi.org/), update the `API_KEY` on the @Headers("x-api-key: YOUR_API_KEY")
 variable in the `NGnewService.kt` file.

