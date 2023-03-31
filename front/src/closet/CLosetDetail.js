import {
  View,
  Text,
  Image,
  TouchableOpacity,
  StyleSheet,
  ScrollView,
} from "react-native";
import { MaterialCommunityIcons, AntDesign } from "@expo/vector-icons";
import { deleteDress } from "../api/api";

export default function ClosetDetail({ route, navigation }) {
  return (
    <ScrollView>
      <View style={{ width: "100%", alignItems: "flex-end" }}>
        <Text
          style={{ margin: 10, marginTop: 15, marginRight: 20, fontSize: 15 }}
        >
          총 {route.params.numberOfWear}번 입음, {route.params.day}일 전
        </Text>
      </View>
      <View style={{ margin: 15 }}>
        <View style={{ width: "100%", alignItems: "center" }}>
          <View style={styles.imageBox}>
            {/* <Image source={{ uri: route.params.imageUrl }}></Image> */}
            <Image
              source={{
                uri: route.params.imageUrl,
                width: "100%",
                paddingBottom: "100%",
              }}
              style={{ width: "100%", paddingBottom: "100%", borderRadius: 25 }}
            ></Image>
          </View>
        </View>
        <Text style={styles.typeText}>{route.params.type}</Text>
        <Text style={styles.itemName}>{route.params.name}</Text>
        <View style={styles.sub}>
          <View style={{ width: "75%" }}>
            <Text>
              {route.params.hashTag.map((value) => (
                <TouchableOpacity>
                  <Text style={styles.hashTag}>#{value}</Text>
                </TouchableOpacity>
              ))}
            </Text>
          </View>
          <View style={{ flexDirection: "row" }}>
            <TouchableOpacity style={{ marginRight: 5 }}>
              <MaterialCommunityIcons
                name="square-edit-outline"
                size={35}
                color={"#456A5A"}
              />
            </TouchableOpacity>
            <TouchableOpacity
              onPress={() => {
                deleteDress(navigation, route.params.id);
              }}
            >
              <MaterialCommunityIcons
                name="delete-outline"
                size={35}
                color={"#456A5A"}
              />
            </TouchableOpacity>
          </View>
        </View>
        <View
          style={{
            width: "100%",
            height: 200,
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <Text style={{ fontSize: 17, color: "#456A5A" }}>
            <AntDesign name="warning" size={20} />
            &nbsp;해당 옷에 대한 게시글이 없습니다.
          </Text>
        </View>
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  imageBox: {
    backgroundColor: "white",
    borderRadius: 25,
    width: "100%",
    justifyContent: "center",
    alignItems: "center",
  },
  typeText: {
    fontSize: 20,
    marginTop: 20,
  },
  itemName: {
    fontSize: 30,
    fontWeight: "bold",
    marginTop: 10,
  },
  sub: {
    marginTop: 10,
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
  },
  hashTag: {
    fontSize: 17,
    color: "#456A5A",
    margin: 5,
    marginLeft: 0,
  },
});
