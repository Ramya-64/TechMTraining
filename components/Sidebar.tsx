import React, { useState } from "react";
import { Box, VStack, Text, IconButton, Button } from "@chakra-ui/react";
import { FaGamepad, FaFire, FaStar, FaClock } from "react-icons/fa";


interface SidebarProps {
  onSelectCategory: (category: string) => void;
}

const Sidebar: React.FC<SidebarProps> = ({ onSelectCategory }) => {
  const categories = [
    { name: "Popular", icon: FaFire },
    { name: "New Releases", icon: FaClock },
    { name: "Top Rated", icon: FaStar },
    { name: "Indie", icon: FaGamepad },
  ];
  

  return (
    <Box width="200px" padding="10px" bg="black" color="white" minH="100vh">
      <VStack spacing={4} align="start">
        {categories.map((category) => (
          <Button
            key={category.name}
            leftIcon={<category.icon />}
            variant="ghost"
            colorScheme="silver"
            _hover={{ bg: "gray.700" }}
            onClick={() => onSelectCategory(category.name)}
          >
            {category.name}
          </Button>
        ))}
      </VStack>
    </Box>
  );
};

export default Sidebar;
