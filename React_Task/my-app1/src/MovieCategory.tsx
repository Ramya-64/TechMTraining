import React from "react";

interface MovieCategoryProps {
    categories: string[];
    onSelectCategory: (category: string) => void;
}

const MovieCategory: React.FC<MovieCategoryProps> = ({ categories, onSelectCategory }) => {
    return (
        <div style={{ marginBottom: "10px" }}>
            <select onChange={(e) => onSelectCategory(e.target.value)} style={{ padding: "8px" }}>
                <option value="">All Categories</option>
                {categories.map((category) => (
                    <option key={category} value={category}>{category}</option>
                ))}
            </select>
        </div>
    );
};

export default MovieCategory;
