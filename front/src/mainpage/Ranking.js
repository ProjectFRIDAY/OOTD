import { useEffect, useState } from "react";
import {
  View,
  Text,
  FlatList,
  TouchableOpacity,
  Image,
  StyleSheet,
} from "react-native";

const rankingData = [
  {
    // key: "1",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 2,
    name: "2WAY 아노락dfdfdfdfdfddfdddddddddddd",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
    numberOfWear: 5,
  },
  {
    // key: "1",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 2,
    name: "2WAY 아노락",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
    numberOfWear: 5,
  },
  {
    // key: "1",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 2,
    name: "2WAY 아노락",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
    numberOfWear: 5,
  },
  {
    // key: "1",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 2,
    name: "2WAY 아노락",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
    numberOfWear: 5,
  },
  {
    // key: "1",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 2,
    name: "2WAY 아노락",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
    numberOfWear: 5,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직 아노락",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직 아노락",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직 아노락",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    type: "상의",
    day: 3,
    name: "베이직",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
    numberOfWear: 4,
  },
];

export default function Ranking({ navigation }) {
  const [pageNumber, setPageNumber] = useState(1);
  const [start, setStart] = useState(0);
  const [end, setEnd] = useState(5);

  const [page, setPage] = useState([]);

  useEffect(() => {
    // const newArr = Array(Math.ceil(rankingData?.length / 5) - 1);
    const newArr = [];
    for (let i = 0; i < Math.ceil(rankingData?.length / 5) - 1; i++) {
      newArr.push(false);
    }
    newArr.unshift(true);
    setPage([...newArr]);
  }, []);

  // for (let i = 0; i < Math.ceil(rankingData?.length / 5); i++) {
  //   page.push(false);
  // }

  const handlePressPage = (pageNumber) => {
    setPageNumber(pageNumber);
    const newArr = Array(page.length).fill(false);
    page.splice(0);
    newArr[pageNumber - 1] = true;
    newArr.map((isClick) => {
      page.push(isClick);
      // console.log(isClick);
    });
  };

  useEffect(() => {
    console.log(page);
  });

  useEffect(() => {
    setStart((pageNumber - 1) * 5);
    setEnd(pageNumber * 5);
  }, [pageNumber]);

  const RankingView = ({ item, index }) => {
    return (
      <TouchableOpacity
        style={{
          flexDirection: "row",
          height: "18%",
          justifyContent: "space-between",
          alignItems: "center",
        }}
        onPress={() => {
          navigation.navigate("ClosetDetail", {
            name: item.name,
            hashTag: item.hashTag,
            day: item.day,
            imageUrl: item.imageUrl,
            numberOfWear: item.numberOfWear,
            type: item.type,
          });
        }}
      >
        <View
          style={{
            flexDirection: "row",
            alignItems: "center",
            width: "45%",
          }}
        >
          <View style={styles.rankNumber}>
            <Text style={{ fontSize: 15 }}>{index}</Text>
          </View>
          <View style={styles.imageBackground}>
            <Image source={{ uri: item.imageUrl }}></Image>
          </View>
          <Text style={styles.itemName} numberOfLines={1}>
            {item?.name}
          </Text>
        </View>
        <View
          style={{
            flexDirection: "row",
          }}
        >
          <Text style={{ height: "100%" }}>{item?.numberOfWear}회</Text>
          <Text style={{ marginLeft: 10, height: "100%" }}>3</Text>
        </View>
      </TouchableOpacity>
    );
  };

  const Pagination = () => {
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
  };

  return (
    <View style={{ margin: 20, height: "50%" }}>
      <Text>전체</Text>
      <View
        style={{
          height: "85%",
          backgroundColor: "#FFFFFF",
          borderRadius: 20,
          padding: 15,
        }}
      >
        {rankingData.slice(start, end).map((item, idx) => (
          <RankingView item={item} index={start + idx + 1} />
        ))}
        <View style={{ position: "absolute", bottom: 10, left: 0, right: 0 }}>
          <View
            style={{
              alignItems: "center",
              width: "100%",
            }}
          >
            <Pagination />
          </View>
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  rankNumber: {
    backgroundColor: "#E2E7E4",
    width: 35,
    height: 35,
    justifyContent: "center",
    alignItems: "center",
    borderRadius: 50,
    marginRight: 10,
  },
  imageBackground: {
    width: 35,
    height: 35,
    justifyContent: "center",
    alignItems: "center",
    borderRadius: 50,
    marginRight: 10,
    backgroundColor: "white",
    shadowColor: "#000",
    shadowOpacity: 0.1,
    shadowOffset: {
      width: 2,
      height: 2,
    },
  },
  itemName: {
    width: "100%",
    height: "100%",
    fontSize: 17,
    fontWeight: "500",
    color: "#456A5A",
  },
  paginationText: {
    fontSize: 18,
    textAlign: "center",
    margin: 10,
  },
});
