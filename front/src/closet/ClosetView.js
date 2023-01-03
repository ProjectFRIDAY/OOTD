import {
  View,
  Text,
  FlatList,
  Image,
  ScrollView,
  StyleSheet,
} from "react-native";
import AddClothBtn from "../button/closet/AddClothBtn";
import ClosetSearchBar from "../input/ClosetSearchBar";

const flatListData = [
  {
    key: "1",
    name: "2WAY 아노락",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
  },
  {
    key: "2",
    name: "베이직 아노락",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
  },
  {
    key: "3",
    name: "패딩",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/baboon.png",
  },
  {
    key: "4",
    name: "코트",
    imageUrl: "https://homepages.cae.wisc.edu/~ece533/images/frymire.png",
  },
];

const FlatListItem = ({ item, index }) => {
  return (
    <View
      style={{
        flex: 1,
        margin: 15,
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <View style={{ backgroundColor: "white", borderRadius: 20 }}>
        <Image source={{ uri: item.imageUrl, width: 200, height: 200 }}></Image>
      </View>
      <Text>#2WAY</Text>
      <Text>{item.name}</Text>
      <Text>5일 전에 입음</Text>
    </View>
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

const styles = StyleSheet.create({});
