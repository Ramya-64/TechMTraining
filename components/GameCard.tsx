import { useEffect, useState } from "react";
import axios from "axios";
import {
  SimpleGrid,
  Spinner,
  Box,
  Text,
  Image,
  Center,
  Badge,
  Button,
} from "@chakra-ui/react";
import { keyframes } from "@emotion/react";

interface Game {
  id: number;
  name: string;
  background_image?: string;
  genres: { name: string }[];
  rating: number;
  released: string;
  metacritic?: number;
  platforms: { platform: { name: string } }[];
}

const API_KEY = "2b989f26a3d84638a8f4501da76a2ae8";
const PAGE_SIZE = 20;

const shineAnimation = keyframes`
  0% { box-shadow: 0 0 10px rgba(255, 255, 255, 0.4); }
  50% { box-shadow: 0 0 20px rgba(255, 255, 255, 0.8); }
  100% { box-shadow: 0 0 10px rgba(255, 255, 255, 0.4); }
`;

const GameList: React.FC<{ searchQuery: string }> = ({ searchQuery }) => {
  const [games, setGames] = useState<Game[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);
  const [page, setPage] = useState<number>(1);
  const [nextPage, setNextPage] = useState<string | null>(null);
  const [prevPage, setPrevPage] = useState<string | null>(null);

  useEffect(() => {
    const fetchGames = async () => {
      setLoading(true);
      setError(null);
      try {
        const response = await axios.get(
          `https://api.rawg.io/api/games?key=${API_KEY}&page=${page}&page_size=${PAGE_SIZE}`
        );
        setGames(response.data.results);
        setNextPage(response.data.next);
        setPrevPage(response.data.previous);
      } catch (error) {
        setError("Failed to load games. Please try again.");
      } finally {
        setLoading(false);
      }
    };

    fetchGames();
  }, [page]);

  // Filter games based on search query
  const filteredGames = games.filter((game) =>
    game.name.toLowerCase().includes(searchQuery.toLowerCase())
  );

  if (loading) {
    return (
      <Center height="100vh">
        <Spinner size="xl" color="yellow.500" />
      </Center>
    );
  }

  if (error) {
    return (
      <Center height="100vh">
        <Text color="red.500">{error}</Text>
      </Center>
    );
  }

  return (
    <Box bg="black" minH="100vh" padding="20px">
      <SimpleGrid columns={[1, 2, 3, 4]} spacing={6}>
        {filteredGames.length > 0 ? (
          filteredGames.map((game) => (
            <Box
              key={game.id}
              borderRadius="lg"
              overflow="hidden"
              p={4}
              bg="gray.900"
              transition="transform 0.3s ease-in-out"
              boxShadow="0 0 15px rgba(255, 255, 255, 0.6)"
              _hover={{
                transform: "scale(1.1)",
                animation: `${shineAnimation} 1s infinite`,
              }}
            >
              <Image
                src={game.background_image || "https://via.placeholder.com/400"}
                alt={game.name}
                borderRadius="md"
              />
              <Text fontSize="lg" fontWeight="bold" mt={2} color="white">
                {game.name}
              </Text>

              <Text fontSize="sm" color="gray.400">
                {game.genres.map((g) => g.name).join(", ") || "No genres available"}
              </Text>

              {/* Game Rating */}
              <Badge colorScheme="yellow" mt={2} fontSize="md">
                ⭐ {game.rating}
              </Badge>

              {/* Release Date */}
              <Text fontSize="sm" color="gray.400" mt={1}>
                Released: {game.released}
              </Text>

              {/* Metacritic Score */}
              {game.metacritic && (
                <Badge colorScheme="pink" fontSize="md" mt={1}>
                  Metacritic: {game.metacritic}
                </Badge>
              )}

              {/* Platforms */}
              <Text fontSize="xs" color="gray.500" mt={2}>
                Platforms: {game.platforms.map((p) => p.platform.name).join(", ")}
              </Text>
            </Box>
          ))
        ) : (
          <Center w="100%">
            <Text fontSize="xl" color="white">
              No games found.
            </Text>
          </Center>
        )}
      </SimpleGrid>

      {/* Pagination Controls */}
      <Center mt={5}>
        <Button
          onClick={() => setPage((prev) => prev - 1)}
          disabled={!prevPage}
          colorScheme="pink"
          mr={3}
        >
          Previous
        </Button>
        <Text fontSize="lg" color="white" mx={3}>
          Page {page}
        </Text>
        <Button
          onClick={() => setPage((prev) => prev + 1)}
          disabled={!nextPage}
          colorScheme="pink"
        >
          Next
        </Button>
      </Center>
    </Box>
  );
};

export default GameList;