import {
  View,
  Text,
  FlatList,
  Image,
  TouchableOpacity,
  StyleSheet,
} from "react-native";
import { AntDesign } from "@expo/vector-icons";

export default function ClosetFlatList({
  flatListData,
  navigation,
  isHashtag,
}) {
  const FlatListItem = ({ item, index }) => {
    return (
      <View
        style={{
          flex: 1,
          margin: 15,
          justifyContent: "center",
        }}
      >
        <TouchableOpacity
          style={{ backgroundColor: "white", borderRadius: 25 }}
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
          <Image
            source={{ uri: item.imageUrl, width: 200, height: 200 }}
          ></Image>
        </TouchableOpacity>
        {isHashtag ? (
          <Text numberOfLines={1} style={styles.hashTag}>
            {item.hashTag.map((value) => (
              <TouchableOpacity>
                <Text style={{ color: "#456A5A" }}>#{value} </Text>
              </TouchableOpacity>
            ))}
          </Text>
        ) : null}
        <Text
          numberOfLines={1}
          style={[styles.itemName, isHashtag ? null : { marginTop: 10 }]}
        >
          {item.name}
        </Text>
        <Text style={styles.lastWearDay}>{item.day}일 전에 입음</Text>
      </View>
    );
  };
  return (
    <>
      {flatListData.length === 0 ? (
        <View
          style={{
            width: "100%",
            height: 200,
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <Text
            style={{
              color: "#456A5A",
            }}
          >
            <AntDesign name="warning" size={15} />
            &nbsp;등록된 옷이 없습니다.
          </Text>
        </View>
      ) : (
        <FlatList
          data={flatListData}
          horizontal={true}
          renderItem={({ item, index }) => {
            return <FlatListItem item={item} index={index} />;
          }}
        ></FlatList>
      )}
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
