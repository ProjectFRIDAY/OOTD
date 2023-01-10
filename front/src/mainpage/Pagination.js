import { useEffect, useState } from "react";
import { View, Text, TouchableOpacity, StyleSheet } from "react-native";

export default function Pagination({ rankingData, handlePageNumber }) {
  const [page, setPage] = useState([]);

  useEffect(() => {
    const newArr = [];
    for (let i = 0; i < Math.ceil(rankingData?.length / 5) - 1; i++) {
      newArr.push(false);
    }
    newArr.unshift(true);
    setPage([...newArr]);
  }, []);

  const handlePressPage = (pageNumber) => {
    handlePageNumber(pageNumber);
    const newArr = Array(page.length).fill(false);
    page.splice(0);
    newArr[pageNumber - 1] = true;
    newArr.map((isClick) => {
      page.push(isClick);
    });
  };

  return (
    <View
      style={{
        flexDirection: "row",
      }}
    >
      {page.map((isClick, index) => (
        <TouchableOpacity onPress={() => handlePressPage(index + 1)}>
          <Text
            style={[
              styles.paginationText,
              isClick ? { color: "#456A5A" } : { color: "#B4D0C5" },
            ]}
          >
            {index + 1}
          </Text>
        </TouchableOpacity>
      ))}
    </View>
  );
}

const styles = StyleSheet.create({
  paginationText: {
    fontSize: 18,
    textAlign: "center",
    margin: 10,
  },
});
