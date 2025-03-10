import React from "react";

interface MovieSearchProps {
    onSearch: (query: string) => void;
}

const MovieSearch: React.FC<MovieSearchProps> = ({ onSearch }) => {
    return (
        <input
            type="text"
            placeholder="Search movies..."
            onChange={(e) => onSearch(e.target.value)}
            style={{ padding: "8px", marginBottom: "10px", width: "100%" }}
        />
    );
};

export default MovieSearch;
