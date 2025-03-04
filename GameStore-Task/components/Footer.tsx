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
        

        
        </Flex>

      {/* Copyright */}
      <Text textAlign="center" mt={4} fontSize="sm" opacity={0.7}>
        © {new Date().getFullYear()} Game Store. All Rights Reserved.
      </Text>
    </Box>
  );
};

export default Footer;
