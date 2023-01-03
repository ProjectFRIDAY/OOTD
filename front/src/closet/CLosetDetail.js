import {
  View,
  Text,
  Image,
  TouchableOpacity,
  StyleSheet,
  ScrollView,
} from "react-native";
import { MaterialCommunityIcons, AntDesign } from "@expo/vector-icons";

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
          <View style={sytles.imageBox}>
            {/* <Image source={{ uri: route.params.imageUrl }}></Image> */}
            <Image
              source={require("../../assets/images/logotitle.png")}
              style={{ width: "100%", paddingBottom: "100%" }}
            ></Image>
          </View>
        </View>
        <Text style={sytles.typeText}>{route.params.type}</Text>
        <Text style={sytles.itemName}>{route.params.name}</Text>
        <View style={sytles.sub}>
          <View style={{ width: "75%" }}>
            <Text>
              {route.params.hashTag.map((value) => (
                <TouchableOpacity>
                  <Text style={sytles.hashTag}>#{value}</Text>
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
            <TouchableOpacity>
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

const sytles = StyleSheet.create({
  imageBox: {
    backgroundColor: "white",
    borderRadius: 25,
    width: "100%",
    padding: 20,
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
