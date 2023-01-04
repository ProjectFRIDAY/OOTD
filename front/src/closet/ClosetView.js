import {
  View,
  Text,
  FlatList,
  Image,
  ScrollView,
  StyleSheet,
  TouchableOpacity,
} from "react-native";
import ClosetSearchBar from "../input/ClosetSearchBar";
import ClosetFlatList from "./ClosetFlatList";
import { AntDesign } from "@expo/vector-icons";

// 가데이터
const outerFlatListData = [
  // {
  //   // key: "3",
  //   hashTag: ["긴팔", "오리털"],
  //   type: "아우터",
  //   day: 1,
  //   name: "패딩",
  //   imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/baboon.png",
  //   numberOfWear: 7,
  // },
  // {
  //   // key: "4",
  //   hashTag: ["긴팔", "떡볶이"],
  //   type: "아우터",
  //   day: 5,
  //   name: "코트",
  //   imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/frymire.png",
  //   numberOfWear: 2,
  // },
  // {
  //   // key: "1",
  //   hashTag: ["2WAY", "긴팔", "기모"],
  //   type: "아우터",
  //   day: 2,
  //   name: "2WAY 아노락",
  //   imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
  //   numberOfWear: 5,
  // },
  // {
  //   // key: "2",
  //   hashTag: ["2WAY", "긴팔", "기모"],
  //   type: "아우터",
  //   day: 3,
  //   name: "베이직 아노락",
  //   imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
  //   numberOfWear: 4,
  // },
];

const highFlatListData = [
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
];

export default function ClosetView({ navigation }) {
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
          <ClosetFlatList
            flatListData={outerFlatListData}
            navigation={navigation}
          />
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
          <ClosetFlatList
            flatListData={highFlatListData}
            navigation={navigation}
          />
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
          <ClosetFlatList
            flatListData={highFlatListData}
            navigation={navigation}
          />
        </View>
      </ScrollView>
      <TouchableOpacity style={styles.plusBtn}>
        <AntDesign name="plus" size={45} color="white" />
      </TouchableOpacity>
    </>
  );
}

const styles = StyleSheet.create({
  plusBtn: {
    width: 65,
    height: 65,
    backgroundColor: "#2B4036",
    position: "absolute",
    right: 20,
    bottom: 20,
    borderRadius: 50,
    justifyContent: "center",
    alignItems: "center",
  },
});
