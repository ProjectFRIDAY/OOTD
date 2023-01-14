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
import { useEffect, useState } from "react";
import { MaterialCommunityIcons } from "@expo/vector-icons";
import AsyncStorage from "@react-native-async-storage/async-storage";

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
  const [isHashtag, setIsHashtag] = useState(true);
  const handleHashtag = () => {
    setIsHashtag(!isHashtag);
    const data = !isHashtag;
    AsyncStorage.setItem("isHashtag", data.toString());
  };

  useEffect(() => {
    const getData = async () => {
      try {
        const data = await AsyncStorage.getItem("isHashtag");
        if (data === "true") setIsHashtag(true);
        else setIsHashtag(false);
      } catch (e) {
        // console.log(e);
        console.log("hihihiihihihihih");
        setIsHashtag(true);
      }
    };
    getData();
  }, []);

  return (
    <>
      <View style={{ alignItems: "center", margin: 15 }}>
        <ClosetSearchBar />
      </View>
      <ScrollView>
        <View>
          <View
            style={{
              margin: 15,
              flexDirection: "row",
              justifyContent: "space-between",
            }}
          >
            <Text
              style={{
                fontSize: 17,
                fontWeight: "bold",
                marginBottom: 0,
              }}
            >
              아우터
            </Text>
            <TouchableOpacity
              onPress={() => handleHashtag()}
              style={{ flexDirection: "row", alignItems: "center" }}
            >
              {isHashtag ? (
                <Image
                  source={require("../../assets/images/checkHashtag.png")}
                />
              ) : (
                <MaterialCommunityIcons
                  name="circle-outline"
                  color={"#456A5A"}
                />
              )}
              <Text style={{ color: "#456A5A", marginLeft: 3 }}>
                해쉬태그 포함
              </Text>
            </TouchableOpacity>
          </View>
          <ClosetFlatList
            flatListData={outerFlatListData}
            navigation={navigation}
            isHashtag={isHashtag}
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
            isHashtag={isHashtag}
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
            isHashtag={isHashtag}
          />
        </View>
      </ScrollView>
      <TouchableOpacity
        style={styles.plusBtn}
        onPress={() => navigation.navigate("AddCloth")}
      >
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
