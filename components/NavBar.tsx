import { HStack, Button, Image, Text, Spacer } from "@chakra-ui/react";
import logo from "../assets/joy-games-icon-3d-design-for-application-and-website-presentation-png.png";
import ThemeToggle from "./DarkSwitch";

function NavBar() {
  return (
    <HStack p={4} bg="black" color="white" justifyContent="space-between">
      {/* Logo */}
      <HStack spacing={2} alignItems="center">
        <Image src={logo} boxSize={10} />
        <Text fontSize="xl" fontWeight="bold">GameHub</Text>
      </HStack>

      <Spacer />

      {/* Right Side: Login, Signup, Dark Mode */}
      <HStack spacing={4}>
        <Button colorScheme="teal">Login</Button>
        <Button colorScheme="yellow">Signup</Button>
     <ThemeToggle />
      </HStack>
    </HStack>
  );
}

export default NavBar;
