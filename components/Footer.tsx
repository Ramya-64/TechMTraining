import { Box, Text, Flex, Link, Icon } from "@chakra-ui/react";
import { FaFacebook, FaTwitter, FaInstagram, FaGithub } from "react-icons/fa";

const Footer = () => {
  return (
    <Box bg="gray.900" color="white" py={6} px={4} mt={10}>
      <Flex
        direction={["column", "row"]}
        justify="space-between"
        align="center"
      >
        {/* Navigation Links */}
        <Flex gap={6} mb={[4, 0]}>
          <Link href="/" _hover={{ textDecoration: "underline" }}>
            Home
          </Link>
          <Link href="/games" _hover={{ textDecoration: "underline" }}>
            Games
          </Link>
          <Link href="/about" _hover={{ textDecoration: "underline" }}>
            About
          </Link>
          <Link href="/contact" _hover={{ textDecoration: "underline" }}>
            Contact
          </Link>
        </Flex>

        
        </Flex>

      {/* Copyright */}
      <Text textAlign="center" mt={4} fontSize="sm" opacity={0.7}>
        © {new Date().getFullYear()} Game Store. All Rights Reserved.
      </Text>
    </Box>
  );
};

export default Footer;
