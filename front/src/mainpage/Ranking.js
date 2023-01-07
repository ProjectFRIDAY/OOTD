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
  const [pageNumber, setPageNumber] = useState(4);
  const [page, setPage] = useState(1);

  useEffect(() => {
    if (rankingData.length % 5 === 0)
      setPage(Math.floor(rankingData.length / 5));
    else setPage(Math.floor(rankingData.length / 5) + 1);
  });

  const RankingView = ({ item, index }) => {
    return (
      <TouchableOpacity
        style={{
          margin: 15,
          flexDirection: "row",
          height: 35,
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
          <Text>{item?.numberOfWear}회</Text>
          <Text style={{ marginLeft: 10 }}>3</Text>
        </View>
      </TouchableOpacity>
    );
  };

  return (
    <View style={{ margin: 20, height: "50%" }}>
      <Text>전체</Text>
      <View
        style={{
          //   width: "100%",
          height: "90%",
          backgroundColor: "#FFFFFF",
          borderRadius: 20,
        }}
      >
        <FlatList
          data={rankingData}
          renderItem={({ item, index }) => {
            // if (pageNumber === 1 && index < 5) {
            //   return <RankingView item={item} index={index + 1} />;
            // } else if (
            //   pageNumber !== 1 &&
            //   index >= (pageNumber - 1) * 5 &&
            //   index < pageNumber * 5
            // ) {
            //   return <RankingView item={item} index={index + 1} />;
            // }
            // return null;
            return <RankingView item={item} index={index + 1} />;
          }}
          //   scrollEnabled={false}
        ></FlatList>
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
    fontSize: 17,
    fontWeight: "500",
    color: "#456A5A",
  },
});
