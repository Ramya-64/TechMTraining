export interface Movie {
    id: number;
    title: string;
    genre: string;
    showtimes: string[]; // ✅ No `undefined`, always an array
    image: string;
}
