import React from "react";
import { Movie } from "./types";

interface MovieListProps {
    movies: Movie[];
    onSelectMovie: (movie: Movie) => void;
}

const MovieList: React.FC<MovieListProps> = ({ movies, onSelectMovie }) => {
    return (
        <div style={{ display: "flex", flexWrap: "wrap", justifyContent: "center" }}>
            {movies.length === 0 ? (
                <p>No movies found.</p>
            ) : (
                movies.map((movie) => (
                    <div key={movie.id} style={{ border: "1px solid #ddd", padding: "10px", margin: "10px", textAlign: "center", borderRadius: "8px" }}>
                        <img src={movie.image} alt={movie.title} style={{ width: "150px", height: "200px", objectFit: "cover", borderRadius: "8px" }} />
                        <h3>{movie.title}</h3>
                        <p>{movie.genre}</p>
                        <p>Showtimes: {movie.showtimes.join(", ")}</p>
                        <button onClick={() => onSelectMovie(movie)} style={{ padding: "8px 16px", marginTop: "8px", cursor: "pointer", backgroundColor: "#28a745", color: "white", border: "none", borderRadius: "5px" }}>
                            Book Show
                        </button>
                    </div>
                ))
            )}
        </div>
    );
};

export default MovieList;
