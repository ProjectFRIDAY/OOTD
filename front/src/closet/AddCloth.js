import {
  View,
  Text,
  TouchableOpacity,
  TextInput,
  ScrollView,
  StyleSheet,
  Image,
  KeyboardAvoidingView,
} from "react-native";
// import { Picker } from "@react-native-picker/picker";
import { useEffect, useState } from "react";
import * as ImagePicker from "expo-image-picker";
import { AntDesign } from "@expo/vector-icons";
import CategoryPicker from "./CategoryPicker";
import HashTagPicker from "./HashTagPicker";

export default function AddCloth({ navigation }) {
  const [category, setCategory] = useState("");

  const [status, requestPermission] = ImagePicker.useMediaLibraryPermissions();
  const [imageUrl, setImageUrl] = useState("");

  const uploadImage = async () => {
    if (!status?.granted) {
      const permission = await requestPermission();
      if (!permission.granted) {
        return null;
      }
    }
    const result = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
      allowsEditing: true,
      quality: 1,
      aspect: [1, 1],
    });
    if (result.canceled) {
      return null;
    }
    // console.log(result.assets[0].uri);
    setImageUrl(result.assets[0].uri);
  };

  return (
    <ScrollView>
      {/* <Picker
        selectedValue={category}
        onValueChange={(itemValue, itemIndex) => setCategory(itemValue)}
        mode={"dropdown"}
        placeholder={"카테고리"}
      >
        <Picker.Item label="Java" value="java" />
        <Picker.Item label="JavaScript" value="js" />
      </Picker> */}
      <View style={{ margin: 15 }}>
        <View style={{ width: "100%", alignItems: "flex-end", zIndex: 1 }}>
          <View
            style={{
              margin: 10,
              width: 120,
            }}
          >
            <CategoryPicker />
          </View>
        </View>
        {imageUrl ? (
          <View>
            <Image
              source={{ uri: imageUrl }}
              style={{
                width: "100%",
                paddingBottom: "100%",
                borderRadius: 25,
              }}
            />
          </View>
        ) : (
          <View
            style={{
              alignItems: "center",
              width: "100%",
            }}
          >
            <TouchableOpacity
              style={{
                width: "100%",
                paddingTop: "40%",
                paddingBottom: "40%",
                borderStyle: "dashed",
                borderWidth: 2,
                borderRadius: 25,
                borderColor: "#73968B",
                justifyContent: "center",
                alignItems: "center",
              }}
              onPress={uploadImage}
            >
              <AntDesign name="picture" size={40} color={"#73968B"} />
              <Text style={{ fontSize: 15, color: "#73968B" }}>
                사진을 추가해주세요.
              </Text>
            </TouchableOpacity>
          </View>
        )}
        <Text style={styles.inputTitle}>의상 이름</Text>
        <TextInput
          placeholder="이름을 입력해주세요"
          placeholderTextColor={"#A2C3B9"}
          style={styles.textInput}
        ></TextInput>
        <Text style={styles.inputTitle}>해시태그</Text>
        {/* <TextInput
          placeholder="해시태그를 생성해주세요"
          placeholderTextColor={"#A2C3B9"}
          style={styles.textInput}
        ></TextInput> */}
        <HashTagPicker />
        <TouchableOpacity
          style={styles.saveBtn}
          onPress={() => navigation.goBack()}
        >
          <Text style={{ color: "white", fontSize: 17 }}>저장하기</Text>
        </TouchableOpacity>
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  categoryBox: {
    backgroundColor: "white",
    padding: 5,
    paddingRight: 10,
    paddingLeft: 10,
    borderRadius: 10,
  },
  inputTitle: {
    margin: 15,
    fontSize: 17,
    color: "#456A5A",
  },
  textInput: {
    margin: 15,
    marginTop: 0,
    fontSize: 15,
    borderBottomWidth: 1,
    padding: 5,
    borderBottomColor: "#A2C3B9",
  },
  saveBtn: {
    backgroundColor: "#3B5448",
    margin: 25,
    height: 50,
    borderRadius: 25,
    justifyContent: "center",
    alignItems: "center",
  },
});
