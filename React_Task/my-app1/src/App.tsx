import React, { useEffect, useState } from "react";
import MovieList from "./MovieList";
import MovieSearch from "./MovieSearch";
import MovieCategory from "./MovieCategory";
import BookingForm from "./BookingForm";
import { Movie } from "./types";

const App: React.FC = () => {
    const [movies, setMovies] = useState<Movie[]>([]);
    const [searchQuery, setSearchQuery] = useState("");
    const [selectedCategory, setSelectedCategory] = useState("");
    const [selectedMovie, setSelectedMovie] = useState<Movie | null>(null);
    const [showBookingForm, setShowBookingForm] = useState(false);

    useEffect(() => {
        fetch("/api.json")
            .then((res) => res.json())
            .then((data) => setMovies(data))
            .catch((err) => console.error("Error fetching movies:", err));
    }, []);

    const filteredMovies = movies.filter(movie =>
        (movie.title.toLowerCase().includes(searchQuery.toLowerCase())) &&
        (selectedCategory ? movie.genre === selectedCategory : true)
    );

    const categories = Array.from(new Set(movies.map(movie => movie.genre)));

    const handleBookNow = (movie: Movie) => {
        setSelectedMovie(movie);
        setShowBookingForm(true); // Redirect to booking form
    };

    const handleFormSubmit = () => {
        setShowBookingForm(false); // Return to home after submission
        setSelectedMovie(null);
    };

    return (
        <div className="container" style={{ maxWidth: "600px", margin: "auto", textAlign: "center" }}>
            <h1>🎟 Movie Booking</h1>
            {!showBookingForm ? (
                <>
                    <MovieSearch onSearch={setSearchQuery} />
                    <MovieCategory categories={categories} onSelectCategory={setSelectedCategory} />
                    <MovieList movies={filteredMovies} onSelectMovie={handleBookNow} />
                </>
            ) : (
                selectedMovie && <BookingForm movie={selectedMovie} onClose={handleFormSubmit} />
            )}
        </div>
    );
};

export default App;
