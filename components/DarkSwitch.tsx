import { IconButton, useColorMode, useColorModeValue } from "@chakra-ui/react";
import { MoonIcon, SunIcon } from "@chakra-ui/icons";

const ThemeToggle = () => {
  const { colorMode, toggleColorMode } = useColorMode();

  return (
    <IconButton
      aria-label="Toggle theme"
      icon={colorMode === "light" ? <MoonIcon color="white" /> : <SunIcon color="white" />} // Force icon color to white
      onClick={toggleColorMode}
      color="white" // Set icon color to white
      bg="transparent" // Transparent background
      _hover={{ bg: useColorModeValue("gray.200", "gray.700") }} // Adjust hover color dynamically
    />
  );
};

export default ThemeToggle;
