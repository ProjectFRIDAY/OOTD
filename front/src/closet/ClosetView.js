import {
  View,
  Text,
  FlatList,
  Image,
  ScrollView,
  StyleSheet,
  TouchableOpacity,
} from "react-native";
import AddClothBtn from "../button/closet/AddClothBtn";
import ClosetSearchBar from "../input/ClosetSearchBar";

// 가데이터
const flatListData = [
  {
    // key: "1",
    hashTag: ["2WAY", "긴팔", "기모"],
    day: 2,
    name: "2WAY 아노락",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
  },
  {
    // key: "2",
    hashTag: ["2WAY", "긴팔", "기모"],
    day: 3,
    name: "베이직 아노락",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
  },
  {
    // key: "3",
    hashTag: ["긴팔", "오리털"],
    day: 1,
    name: "패딩",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/baboon.png",
  },
  {
    // key: "4",
    hashTag: ["긴팔", "떡볶이"],
    day: 5,
    name: "코트",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/frymire.png",
  },
];

const FlatListItem = ({ item, index }) => {
  return (
    // <TouchableOpacity>
    <View
      style={{
        flex: 1,
        margin: 15,
        justifyContent: "center",
      }}
    >
      <TouchableOpacity style={{ backgroundColor: "white", borderRadius: 25 }}>
        <Image source={{ uri: item.imageUrl, width: 200, height: 200 }}></Image>
      </TouchableOpacity>
      <Text numberOfLines={1} style={styles.hashTag}>
        {item.hashTag.map((value) => (
          <TouchableOpacity>
            <Text style={{ color: "#456A5A" }}>#{value} </Text>
          </TouchableOpacity>
        ))}
      </Text>
      <Text numberOfLines={1} style={styles.itemName}>
        {item.name}
      </Text>
      <Text style={styles.lastWearDay}>{item.day}일 전에 입음</Text>
    </View>
    // </TouchableOpacity>
  );
};

export default function ClosetView() {
  return (
    <>
      <View style={{ alignItems: "center", margin: 15 }}>
        <ClosetSearchBar />
      </View>
      <ScrollView>
        <View>
          <Text
            style={{
              fontSize: 17,
              fontWeight: "bold",
              margin: 15,
              marginBottom: 0,
            }}
          >
            아우터
          </Text>
          <FlatList
            data={flatListData}
            horizontal={true}
            renderItem={({ item, index }) => {
              return <FlatListItem item={item} index={index} />;
            }}
          ></FlatList>
        </View>
        <View>
          <Text
            style={{
              fontSize: 17,
              fontWeight: "bold",
              margin: 15,
              marginBottom: 0,
            }}
          >
            상의
          </Text>
          <FlatList
            data={flatListData}
            horizontal={true}
            renderItem={({ item, index }) => {
              return <FlatListItem item={item} index={index} />;
            }}
          ></FlatList>
        </View>
        <View>
          <Text
            style={{
              fontSize: 17,
              fontWeight: "bold",
              margin: 15,
              marginBottom: 0,
            }}
          >
            하의
          </Text>
          <FlatList
            data={flatListData}
            horizontal={true}
            renderItem={({ item, index }) => {
              return <FlatListItem item={item} index={index} />;
            }}
          ></FlatList>
        </View>
      </ScrollView>
    </>
  );
}

const styles = StyleSheet.create({
  hashTag: {
    width: 200,
    color: "#456A5A",
    marginTop: 10,
  },
  itemName: {
    width: 200,
    fontSize: 20,
    fontWeight: "bold",
  },
  lastWearDay: {
    color: "#456A5A",
  },
});
