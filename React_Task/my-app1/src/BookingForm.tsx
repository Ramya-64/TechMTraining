import React, { useState } from "react";
import { Movie } from "./types";

interface BookingFormProps {
    movie: Movie;
    onClose: () => void;
}

const BookingForm: React.FC<BookingFormProps> = ({ movie, onClose }) => {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [selectedShowtime, setSelectedShowtime] = useState(movie.showtimes[0]);

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        alert(`Booking confirmed for ${movie.title} at ${selectedShowtime}`);
        onClose(); // Redirects back to home after submission
    };

    return (
        <div style={{ textAlign: "center", marginTop: "20px", padding: "20px", border: "1px solid #ddd", borderRadius: "8px" }}>
            <h2>Booking for {movie.title}</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="Your Name" value={name} onChange={(e) => setName(e.target.value)} required style={{ display: "block", margin: "10px auto", padding: "8px" }} />
                <input type="email" placeholder="Your Email" value={email} onChange={(e) => setEmail(e.target.value)} required style={{ display: "block", margin: "10px auto", padding: "8px" }} />
                <select value={selectedShowtime} onChange={(e) => setSelectedShowtime(e.target.value)} style={{ display: "block", margin: "10px auto", padding: "8px" }}>
                    {movie.showtimes.map((time) => (
                        <option key={time} value={time}>{time}</option>
                    ))}
                </select>
                <button type="submit" style={{ padding: "10px 20px", backgroundColor: "#28a745", color: "white", border: "none", borderRadius: "5px", cursor: "pointer" }}>
                    Confirm Booking
                </button>
            </form>
        </div>
    );
};

export default BookingForm;
