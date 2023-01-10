import { useEffect, useState } from "react";
import { View, Text, TouchableOpacity, StyleSheet } from "react-native";
import { AntDesign } from "@expo/vector-icons";

export default function Pagination({
  rankingData,
  handlePageNumber,
  pageNumber,
}) {
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

  const handlePressLeft = () => {
    if (pageNumber !== 1) {
      handlePressPage(pageNumber - 1);
    }
  };

  const handlePressRight = () => {
    if (pageNumber !== page.length) {
      handlePressPage(pageNumber + 1);
    }
  };

  return (
    <View
      style={{
        flexDirection: "row",
        alignItems: "center",
      }}
    >
      <TouchableOpacity onPress={() => handlePressLeft()}>
        <AntDesign name="left" size={20} color={"#456A5A"} />
      </TouchableOpacity>
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
      <TouchableOpacity onPress={() => handlePressRight()}>
        <AntDesign name="right" size={20} color={"#456A5A"} />
      </TouchableOpacity>
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
