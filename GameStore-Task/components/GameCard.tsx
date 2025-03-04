import { useEffect, useState } from "react";
import axios from "axios";
import {
  Box,
  SimpleGrid,
  Spinner,
  Text,
  Image,
  Center,
  Badge,
  Button,
  useColorMode,
  Card,
  CardBody,
} from "@chakra-ui/react";

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

const GameList: React.FC<{ searchQuery: string }> = ({ searchQuery }) => {
  const { colorMode } = useColorMode();
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

  const filteredGames = games.filter((game) =>
    game.name.toLowerCase().includes(searchQuery.toLowerCase())
  );

  if (loading) {
    return (
      <Center height="100vh">
        <Spinner size="xl" color={colorMode === "dark" ? "white" : "black"} />
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
    <Box bg={colorMode === "dark" ? "gray.900" : "gray.100"} minH="100vh" p={5}>
      <SimpleGrid columns={[1, 2, 3, 4]} spacing={6}>
        {filteredGames.length > 0 ? (
          filteredGames.map((game) => (
            <Card
              key={game.id}
              borderRadius="lg"
              overflow="hidden"
              boxShadow="lg"
              bg={colorMode === "dark" ? "gray.800" : "white"}
              color={colorMode === "dark" ? "white" : "black"}
              _hover={{ transform: "scale(1.05)", transition: "0.3s" }}
            >
              <Image
                src={game.background_image || "https://via.placeholder.com/400"}
                alt={game.name}
                borderRadius="md"
              />
              <CardBody>
                <Text fontSize="lg" fontWeight="bold">{game.name}</Text>
                <Text fontSize="sm" color="gray.500">{game.genres.map((g) => g.name).join(", ")}</Text>
                <Badge colorScheme="yellow" mt={2} fontSize="md">⭐ {game.rating}</Badge>
                <Text fontSize="sm" color="gray.400" mt={1}>Released: {game.released}</Text>
                {game.metacritic && (
                  <Badge colorScheme="pink" fontSize="md" mt={1}>Metacritic: {game.metacritic}</Badge>
                )}
                <Text fontSize="xs" color="gray.500" mt={2}>Platforms: {game.platforms.map((p) => p.platform.name).join(", ")}</Text>
              </CardBody>
            </Card>
          ))
        ) : (
          <Center w="100%">
            <Text fontSize="xl" color={colorMode === "dark" ? "white" : "black"}>No games found.</Text>
          </Center>
        )}
      </SimpleGrid>
      <Center mt={5}>
        <Button onClick={() => setPage((prev) => prev - 1)} disabled={!prevPage} colorScheme="gray" mr={3}>Previous</Button>
        <Text fontSize="lg" color={colorMode === "dark" ? "white" : "black"} mx={3}>Page {page}</Text>
        <Button onClick={() => setPage((prev) => prev + 1)} disabled={!nextPage} colorScheme="gray">Next</Button>
      </Center>
    </Box>
  );
};

export default GameList;
