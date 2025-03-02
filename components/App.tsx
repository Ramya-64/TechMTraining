import { ChakraProvider,ColorModeScript , Flex, Box, useColorMode, useColorModeValue } from "@chakra-ui/react";
import NavBar from "./components/NavBar"
import Sidebar from "./components/Sidebar";
import GameList from "./components/GameCard";
import { useState } from "react";
import Footer from "./components/Footer";
import theme from "./Theme";
import ThemeToggle from "./components/DarkSwitch";


const App: React.FC = () => {
  const [category, setCategory] = useState<string>("Popular");
  const [page, setPage] = useState<number>(1);
  const { colorMode } = useColorMode();
  const [searchQuery, setSearchQuery] = useState<string>("");


  return (
    <ChakraProvider>
    <Box
      bg={useColorModeValue("white", "black")}
      color={useColorModeValue("black", "white")}
      minH="100vh"
    >
        <NavBar onSearch={setSearchQuery} />
        <Flex>
          <Sidebar onSelectCategory={setCategory} />
          <GameList searchQuery={searchQuery}/>
        </Flex>
      </Box>
      <Footer />
    </ChakraProvider>
    
  );
};

export default App;





 