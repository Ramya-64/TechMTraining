import { HStack, IconButton, useColorMode } from "@chakra-ui/react";
import { SunIcon, MoonIcon } from "@chakra-ui/icons";

function DarkSwitch() {
  let { colorMode, toggleColorMode } = useColorMode();

  return (
    <HStack cursor="pointer" _hover={{ transform: "scale(1.1)", transition: "0.2s" }}>
      <IconButton
        aria-label="Toggle dark mode"
        icon={colorMode === "dark" ? <MoonIcon /> : <SunIcon />}
        onClick={toggleColorMode}
        variant="ghost"
        fontSize="xl"
      />
    </HStack>
  );
}

export default DarkSwitch;
